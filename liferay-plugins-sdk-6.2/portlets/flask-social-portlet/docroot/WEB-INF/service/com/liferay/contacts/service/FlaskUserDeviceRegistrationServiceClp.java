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

import com.liferay.portal.service.InvokableService;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FlaskUserDeviceRegistrationServiceClp
	implements FlaskUserDeviceRegistrationService {
	public FlaskUserDeviceRegistrationServiceClp(
		InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "addUserDevice";

		_methodParameterTypes3 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.Boolean", "java.util.Date", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName4 = "getAllUserDevices";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "getUserDevice";

		_methodParameterTypes5 = new String[] { "long" };

		_methodName6 = "getUserDevicesByUserId";

		_methodParameterTypes6 = new String[] { "long" };

		_methodName7 = "getUserDevicesByUserEmail";

		_methodParameterTypes7 = new String[] { "java.lang.String" };

		_methodName8 = "getUserDevicesByDeviceToken";

		_methodParameterTypes8 = new String[] { "java.lang.String" };

		_methodName9 = "updateUserDevices";

		_methodParameterTypes9 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.Boolean", "java.util.Date", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName10 = "deleteUserDevice";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "deactivateUserForUserDevice";

		_methodParameterTypes11 = new String[] { "long", "java.lang.String" };

		_methodName12 = "activateUserForUserDevice";

		_methodParameterTypes12 = new String[] { "long" };
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public com.liferay.contacts.model.FlaskUserDeviceRegistration addUserDevice(
		long userId, java.lang.String userEmail,
		java.lang.String devicePlatform, java.lang.String deviceDetails,
		java.lang.String deviceToken, java.util.Date registrationTime,
		java.lang.Boolean active, java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(userEmail),
						
					ClpSerializer.translateInput(devicePlatform),
						
					ClpSerializer.translateInput(deviceDetails),
						
					ClpSerializer.translateInput(deviceToken),
						
					ClpSerializer.translateInput(registrationTime),
						
					ClpSerializer.translateInput(active),
						
					ClpSerializer.translateInput(lastNotificationTime),
						
					ClpSerializer.translateInput(lastNotificationMsg),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.contacts.model.FlaskUserDeviceRegistration)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getAllUserDevices() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.contacts.model.FlaskUserDeviceRegistration getUserDevice(
		long userDeviceRegistrationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { userDeviceRegistrationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.contacts.model.FlaskUserDeviceRegistration)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByUserId(
		long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByUserEmail(
		java.lang.String userEmail) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] { ClpSerializer.translateInput(userEmail) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByDeviceToken(
		java.lang.String deviceToken) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(deviceToken) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.contacts.model.FlaskUserDeviceRegistration updateUserDevices(
		long userDeviceRegistrationId, long userId, java.lang.String userEmail,
		java.lang.String devicePlatform, java.lang.String deviceDetails,
		java.lang.String deviceToken, java.util.Date registrationTime,
		java.lang.Boolean active, java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						userDeviceRegistrationId,
						
					userId,
						
					ClpSerializer.translateInput(userEmail),
						
					ClpSerializer.translateInput(devicePlatform),
						
					ClpSerializer.translateInput(deviceDetails),
						
					ClpSerializer.translateInput(deviceToken),
						
					ClpSerializer.translateInput(registrationTime),
						
					ClpSerializer.translateInput(active),
						
					ClpSerializer.translateInput(lastNotificationTime),
						
					ClpSerializer.translateInput(lastNotificationMsg),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.contacts.model.FlaskUserDeviceRegistration)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteUserDevice(long userDeviceRegistrationId) {
		try {
			_invokableService.invokeMethod(_methodName10,
				_methodParameterTypes10,
				new Object[] { userDeviceRegistrationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public boolean deactivateUserForUserDevice(long userId,
		java.lang.String deviceToken) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(deviceToken)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public boolean activateUserForUserDevice(long userDeviceRegistrationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { userDeviceRegistrationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
}