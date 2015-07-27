/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rumbasolutions.flask.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.rumbasolutions.flask.model.EventClp;
import com.rumbasolutions.flask.model.EventDetailClp;
import com.rumbasolutions.flask.model.EventDetailImageClp;
import com.rumbasolutions.flask.model.EventTypeClp;
import com.rumbasolutions.flask.model.InfoTypeCategoryClp;
import com.rumbasolutions.flask.model.InfoTypeClp;
import com.rumbasolutions.flask.model.UserEventClp;
import com.rumbasolutions.flask.model.VenueClp;
import com.rumbasolutions.flask.model.VenueDetailClp;
import com.rumbasolutions.flask.model.VenueDetailImageClp;
import com.rumbasolutions.flask.model.VenueImageClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashutosh Rai
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"flask-rest-events-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"flask-rest-events-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "flask-rest-events-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(EventClp.class.getName())) {
			return translateInputEvent(oldModel);
		}

		if (oldModelClassName.equals(EventDetailClp.class.getName())) {
			return translateInputEventDetail(oldModel);
		}

		if (oldModelClassName.equals(EventDetailImageClp.class.getName())) {
			return translateInputEventDetailImage(oldModel);
		}

		if (oldModelClassName.equals(EventTypeClp.class.getName())) {
			return translateInputEventType(oldModel);
		}

		if (oldModelClassName.equals(InfoTypeClp.class.getName())) {
			return translateInputInfoType(oldModel);
		}

		if (oldModelClassName.equals(InfoTypeCategoryClp.class.getName())) {
			return translateInputInfoTypeCategory(oldModel);
		}

		if (oldModelClassName.equals(UserEventClp.class.getName())) {
			return translateInputUserEvent(oldModel);
		}

		if (oldModelClassName.equals(VenueClp.class.getName())) {
			return translateInputVenue(oldModel);
		}

		if (oldModelClassName.equals(VenueDetailClp.class.getName())) {
			return translateInputVenueDetail(oldModel);
		}

		if (oldModelClassName.equals(VenueDetailImageClp.class.getName())) {
			return translateInputVenueDetailImage(oldModel);
		}

		if (oldModelClassName.equals(VenueImageClp.class.getName())) {
			return translateInputVenueImage(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputEvent(BaseModel<?> oldModel) {
		EventClp oldClpModel = (EventClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEventRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEventDetail(BaseModel<?> oldModel) {
		EventDetailClp oldClpModel = (EventDetailClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEventDetailRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEventDetailImage(BaseModel<?> oldModel) {
		EventDetailImageClp oldClpModel = (EventDetailImageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEventDetailImageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEventType(BaseModel<?> oldModel) {
		EventTypeClp oldClpModel = (EventTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEventTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInfoType(BaseModel<?> oldModel) {
		InfoTypeClp oldClpModel = (InfoTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInfoTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInfoTypeCategory(BaseModel<?> oldModel) {
		InfoTypeCategoryClp oldClpModel = (InfoTypeCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInfoTypeCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserEvent(BaseModel<?> oldModel) {
		UserEventClp oldClpModel = (UserEventClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserEventRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVenue(BaseModel<?> oldModel) {
		VenueClp oldClpModel = (VenueClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVenueRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVenueDetail(BaseModel<?> oldModel) {
		VenueDetailClp oldClpModel = (VenueDetailClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVenueDetailRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVenueDetailImage(BaseModel<?> oldModel) {
		VenueDetailImageClp oldClpModel = (VenueDetailImageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVenueDetailImageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVenueImage(BaseModel<?> oldModel) {
		VenueImageClp oldClpModel = (VenueImageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVenueImageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.EventImpl")) {
			return translateOutputEvent(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.EventDetailImpl")) {
			return translateOutputEventDetail(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.EventDetailImageImpl")) {
			return translateOutputEventDetailImage(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.EventTypeImpl")) {
			return translateOutputEventType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.InfoTypeImpl")) {
			return translateOutputInfoType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.InfoTypeCategoryImpl")) {
			return translateOutputInfoTypeCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.UserEventImpl")) {
			return translateOutputUserEvent(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.VenueImpl")) {
			return translateOutputVenue(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.VenueDetailImpl")) {
			return translateOutputVenueDetail(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.VenueDetailImageImpl")) {
			return translateOutputVenueDetailImage(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.VenueImageImpl")) {
			return translateOutputVenueImage(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.rumbasolutions.flask.NoSuchEventException")) {
			return new com.rumbasolutions.flask.NoSuchEventException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchEventDetailException")) {
			return new com.rumbasolutions.flask.NoSuchEventDetailException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchEventDetailImageException")) {
			return new com.rumbasolutions.flask.NoSuchEventDetailImageException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchEventTypeException")) {
			return new com.rumbasolutions.flask.NoSuchEventTypeException();
		}

		if (className.equals("com.rumbasolutions.flask.NoSuchInfoTypeException")) {
			return new com.rumbasolutions.flask.NoSuchInfoTypeException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchInfoTypeCategoryException")) {
			return new com.rumbasolutions.flask.NoSuchInfoTypeCategoryException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchUserEventException")) {
			return new com.rumbasolutions.flask.NoSuchUserEventException();
		}

		if (className.equals("com.rumbasolutions.flask.NoSuchVenueException")) {
			return new com.rumbasolutions.flask.NoSuchVenueException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchVenueDetailException")) {
			return new com.rumbasolutions.flask.NoSuchVenueDetailException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchVenueDetailImageException")) {
			return new com.rumbasolutions.flask.NoSuchVenueDetailImageException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchVenueImageException")) {
			return new com.rumbasolutions.flask.NoSuchVenueImageException();
		}

		return throwable;
	}

	public static Object translateOutputEvent(BaseModel<?> oldModel) {
		EventClp newModel = new EventClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEventRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEventDetail(BaseModel<?> oldModel) {
		EventDetailClp newModel = new EventDetailClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEventDetailRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEventDetailImage(BaseModel<?> oldModel) {
		EventDetailImageClp newModel = new EventDetailImageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEventDetailImageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEventType(BaseModel<?> oldModel) {
		EventTypeClp newModel = new EventTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEventTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInfoType(BaseModel<?> oldModel) {
		InfoTypeClp newModel = new InfoTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInfoTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInfoTypeCategory(BaseModel<?> oldModel) {
		InfoTypeCategoryClp newModel = new InfoTypeCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInfoTypeCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserEvent(BaseModel<?> oldModel) {
		UserEventClp newModel = new UserEventClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserEventRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVenue(BaseModel<?> oldModel) {
		VenueClp newModel = new VenueClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVenueRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVenueDetail(BaseModel<?> oldModel) {
		VenueDetailClp newModel = new VenueDetailClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVenueDetailRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVenueDetailImage(BaseModel<?> oldModel) {
		VenueDetailImageClp newModel = new VenueDetailImageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVenueDetailImageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVenueImage(BaseModel<?> oldModel) {
		VenueImageClp newModel = new VenueImageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVenueImageRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}