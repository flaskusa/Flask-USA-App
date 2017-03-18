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

package com.liferay.contacts.service;

import com.liferay.contacts.model.DeviceAwsEndpointClp;
import com.liferay.contacts.model.EntryClp;
import com.liferay.contacts.model.FlaskGroupMessagesClp;
import com.liferay.contacts.model.FlaskGroupRecipientsClp;
import com.liferay.contacts.model.FlaskMessagesClp;
import com.liferay.contacts.model.FlaskRecipientsClp;
import com.liferay.contacts.model.FlaskUserDeviceRegistrationClp;
import com.liferay.contacts.model.NotificationAuditLogClp;

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

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
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
						"flask-social-portlet-deployment-context");

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
							"flask-social-portlet-deployment-context");

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
				_servletContextName = "flask-social-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(DeviceAwsEndpointClp.class.getName())) {
			return translateInputDeviceAwsEndpoint(oldModel);
		}

		if (oldModelClassName.equals(EntryClp.class.getName())) {
			return translateInputEntry(oldModel);
		}

		if (oldModelClassName.equals(FlaskGroupMessagesClp.class.getName())) {
			return translateInputFlaskGroupMessages(oldModel);
		}

		if (oldModelClassName.equals(FlaskGroupRecipientsClp.class.getName())) {
			return translateInputFlaskGroupRecipients(oldModel);
		}

		if (oldModelClassName.equals(FlaskMessagesClp.class.getName())) {
			return translateInputFlaskMessages(oldModel);
		}

		if (oldModelClassName.equals(FlaskRecipientsClp.class.getName())) {
			return translateInputFlaskRecipients(oldModel);
		}

		if (oldModelClassName.equals(
					FlaskUserDeviceRegistrationClp.class.getName())) {
			return translateInputFlaskUserDeviceRegistration(oldModel);
		}

		if (oldModelClassName.equals(NotificationAuditLogClp.class.getName())) {
			return translateInputNotificationAuditLog(oldModel);
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

	public static Object translateInputDeviceAwsEndpoint(BaseModel<?> oldModel) {
		DeviceAwsEndpointClp oldClpModel = (DeviceAwsEndpointClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDeviceAwsEndpointRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEntry(BaseModel<?> oldModel) {
		EntryClp oldClpModel = (EntryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEntryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFlaskGroupMessages(BaseModel<?> oldModel) {
		FlaskGroupMessagesClp oldClpModel = (FlaskGroupMessagesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFlaskGroupMessagesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFlaskGroupRecipients(
		BaseModel<?> oldModel) {
		FlaskGroupRecipientsClp oldClpModel = (FlaskGroupRecipientsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFlaskGroupRecipientsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFlaskMessages(BaseModel<?> oldModel) {
		FlaskMessagesClp oldClpModel = (FlaskMessagesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFlaskMessagesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFlaskRecipients(BaseModel<?> oldModel) {
		FlaskRecipientsClp oldClpModel = (FlaskRecipientsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFlaskRecipientsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFlaskUserDeviceRegistration(
		BaseModel<?> oldModel) {
		FlaskUserDeviceRegistrationClp oldClpModel = (FlaskUserDeviceRegistrationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFlaskUserDeviceRegistrationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNotificationAuditLog(
		BaseModel<?> oldModel) {
		NotificationAuditLogClp oldClpModel = (NotificationAuditLogClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNotificationAuditLogRemoteModel();

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
					"com.liferay.contacts.model.impl.DeviceAwsEndpointImpl")) {
			return translateOutputDeviceAwsEndpoint(oldModel);
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
					"com.liferay.contacts.model.impl.EntryImpl")) {
			return translateOutputEntry(oldModel);
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
					"com.liferay.contacts.model.impl.FlaskGroupMessagesImpl")) {
			return translateOutputFlaskGroupMessages(oldModel);
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
					"com.liferay.contacts.model.impl.FlaskGroupRecipientsImpl")) {
			return translateOutputFlaskGroupRecipients(oldModel);
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
					"com.liferay.contacts.model.impl.FlaskMessagesImpl")) {
			return translateOutputFlaskMessages(oldModel);
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
					"com.liferay.contacts.model.impl.FlaskRecipientsImpl")) {
			return translateOutputFlaskRecipients(oldModel);
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
					"com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationImpl")) {
			return translateOutputFlaskUserDeviceRegistration(oldModel);
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
					"com.liferay.contacts.model.impl.NotificationAuditLogImpl")) {
			return translateOutputNotificationAuditLog(oldModel);
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

		if (className.equals(
					"com.liferay.contacts.NoSuchDeviceAwsEndpointException")) {
			return new com.liferay.contacts.NoSuchDeviceAwsEndpointException();
		}

		if (className.equals("com.liferay.contacts.NoSuchEntryException")) {
			return new com.liferay.contacts.NoSuchEntryException();
		}

		if (className.equals(
					"com.liferay.contacts.NoSuchFlaskGroupMessagesException")) {
			return new com.liferay.contacts.NoSuchFlaskGroupMessagesException();
		}

		if (className.equals(
					"com.liferay.contacts.NoSuchFlaskGroupRecipientsException")) {
			return new com.liferay.contacts.NoSuchFlaskGroupRecipientsException();
		}

		if (className.equals(
					"com.liferay.contacts.NoSuchFlaskMessagesException")) {
			return new com.liferay.contacts.NoSuchFlaskMessagesException();
		}

		if (className.equals(
					"com.liferay.contacts.NoSuchFlaskRecipientsException")) {
			return new com.liferay.contacts.NoSuchFlaskRecipientsException();
		}

		if (className.equals(
					"com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException")) {
			return new com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException();
		}

		if (className.equals(
					"com.liferay.contacts.NoSuchNotificationAuditLogException")) {
			return new com.liferay.contacts.NoSuchNotificationAuditLogException();
		}

		return throwable;
	}

	public static Object translateOutputDeviceAwsEndpoint(BaseModel<?> oldModel) {
		DeviceAwsEndpointClp newModel = new DeviceAwsEndpointClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDeviceAwsEndpointRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEntry(BaseModel<?> oldModel) {
		EntryClp newModel = new EntryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEntryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFlaskGroupMessages(
		BaseModel<?> oldModel) {
		FlaskGroupMessagesClp newModel = new FlaskGroupMessagesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFlaskGroupMessagesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFlaskGroupRecipients(
		BaseModel<?> oldModel) {
		FlaskGroupRecipientsClp newModel = new FlaskGroupRecipientsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFlaskGroupRecipientsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFlaskMessages(BaseModel<?> oldModel) {
		FlaskMessagesClp newModel = new FlaskMessagesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFlaskMessagesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFlaskRecipients(BaseModel<?> oldModel) {
		FlaskRecipientsClp newModel = new FlaskRecipientsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFlaskRecipientsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFlaskUserDeviceRegistration(
		BaseModel<?> oldModel) {
		FlaskUserDeviceRegistrationClp newModel = new FlaskUserDeviceRegistrationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFlaskUserDeviceRegistrationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNotificationAuditLog(
		BaseModel<?> oldModel) {
		NotificationAuditLogClp newModel = new NotificationAuditLogClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNotificationAuditLogRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}