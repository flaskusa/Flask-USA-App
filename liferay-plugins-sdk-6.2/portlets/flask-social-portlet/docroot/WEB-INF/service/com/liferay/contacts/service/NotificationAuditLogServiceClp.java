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
public class NotificationAuditLogServiceClp
	implements NotificationAuditLogService {
	public NotificationAuditLogServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "addNotificationAuditLog";

		_methodParameterTypes3 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date"
			};

		_methodName4 = "getAllNotificationAuditLog";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "getNotificationAuditLog";

		_methodParameterTypes5 = new String[] { "long" };

		_methodName6 = "getAllNotificationAuditLogBySenderEmail";

		_methodParameterTypes6 = new String[] { "java.lang.String" };

		_methodName7 = "getAllNotificationAuditLogByReceiverEmail";

		_methodParameterTypes7 = new String[] { "java.lang.String" };

		_methodName8 = "updateNotificationAuditLog";

		_methodParameterTypes8 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date"
			};

		_methodName9 = "deleteNotificationAuditLog";

		_methodParameterTypes9 = new String[] { "long" };
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
	public com.liferay.contacts.model.NotificationAuditLog addNotificationAuditLog(
		java.lang.String senderEmail, java.lang.String receiverEmail,
		java.lang.String messageReason, java.lang.String message,
		java.util.Date notificationTime) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(senderEmail),
						
					ClpSerializer.translateInput(receiverEmail),
						
					ClpSerializer.translateInput(messageReason),
						
					ClpSerializer.translateInput(message),
						
					ClpSerializer.translateInput(notificationTime)
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

		return (com.liferay.contacts.model.NotificationAuditLog)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLog() {
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

		return (java.util.List<com.liferay.contacts.model.NotificationAuditLog>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.contacts.model.NotificationAuditLog getNotificationAuditLog(
		long notificationAuditLogId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { notificationAuditLogId });
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

		return (com.liferay.contacts.model.NotificationAuditLog)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLogBySenderEmail(
		java.lang.String senderEmail) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] { ClpSerializer.translateInput(senderEmail) });
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

		return (java.util.List<com.liferay.contacts.model.NotificationAuditLog>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLogByReceiverEmail(
		java.lang.String receiverEmail) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] { ClpSerializer.translateInput(receiverEmail) });
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

		return (java.util.List<com.liferay.contacts.model.NotificationAuditLog>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.contacts.model.NotificationAuditLog updateNotificationAuditLog(
		long notificationAuditLogId, java.lang.String senderEmail,
		java.lang.String receiverEmail, java.lang.String messageReason,
		java.lang.String message, java.util.Date notificationTime) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						notificationAuditLogId,
						
					ClpSerializer.translateInput(senderEmail),
						
					ClpSerializer.translateInput(receiverEmail),
						
					ClpSerializer.translateInput(messageReason),
						
					ClpSerializer.translateInput(message),
						
					ClpSerializer.translateInput(notificationTime)
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

		return (com.liferay.contacts.model.NotificationAuditLog)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteNotificationAuditLog(long notificationAuditLogId) {
		try {
			_invokableService.invokeMethod(_methodName9,
				_methodParameterTypes9, new Object[] { notificationAuditLogId });
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
}