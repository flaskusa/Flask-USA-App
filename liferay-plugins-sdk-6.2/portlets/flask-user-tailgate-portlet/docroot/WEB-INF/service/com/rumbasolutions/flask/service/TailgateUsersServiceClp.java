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

import com.liferay.portal.service.InvokableService;

/**
 * @author rajeshj
 * @generated
 */
public class TailgateUsersServiceClp implements TailgateUsersService {
	public TailgateUsersServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getTailgateMembers";

		_methodParameterTypes3 = new String[] { "long" };

		_methodName4 = "getTailgateGroups";

		_methodParameterTypes4 = new String[] { "long", "long" };

		_methodName5 = "checkTailgateUserExist";

		_methodParameterTypes5 = new String[] { "long", "long" };

		_methodName6 = "addTailgateUser";

		_methodParameterTypes6 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "int",
				"boolean", "java.lang.String", "int"
			};

		_methodName7 = "updateTailgateUser";

		_methodParameterTypes7 = new String[] {
				"long", "long", "long", "java.lang.String", "int", "boolean",
				"java.lang.String", "int"
			};

		_methodName8 = "deleteTailgateUser";

		_methodParameterTypes8 = new String[] { "long", "long" };
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
	public java.util.List<com.rumbasolutions.flask.model.TailgateUsers> getTailgateMembers(
		long tailgateId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3, new Object[] { tailgateId });
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

		return (java.util.List<com.rumbasolutions.flask.model.TailgateUsers>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateUsers> getTailgateGroups(
		long tailgateId, long groupId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] { tailgateId, groupId });
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

		return (java.util.List<com.rumbasolutions.flask.model.TailgateUsers>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean checkTailgateUserExist(long tailgateId, long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5, new Object[] { tailgateId, userId });
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
	public com.rumbasolutions.flask.model.TailgateUsers addTailgateUser(
		long tailgateId, long userId, java.lang.String userName,
		java.lang.String emailAddress, int isAdmin, boolean isPaid,
		java.lang.String paymentMode, int groupId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						tailgateId,
						
					userId,
						
					ClpSerializer.translateInput(userName),
						
					ClpSerializer.translateInput(emailAddress),
						
					isAdmin,
						
					isPaid,
						
					ClpSerializer.translateInput(paymentMode),
						
					groupId
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

		return (com.rumbasolutions.flask.model.TailgateUsers)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateUsers updateTailgateUser(
		long tailgateUserId, long tailgateId, long userId,
		java.lang.String userName, int isAdmin, boolean isPaid,
		java.lang.String paymentMode, int groupId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						tailgateUserId,
						
					tailgateId,
						
					userId,
						
					ClpSerializer.translateInput(userName),
						
					isAdmin,
						
					isPaid,
						
					ClpSerializer.translateInput(paymentMode),
						
					groupId
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

		return (com.rumbasolutions.flask.model.TailgateUsers)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteTailgateUser(long tailgateId, long userId) {
		try {
			_invokableService.invokeMethod(_methodName8,
				_methodParameterTypes8, new Object[] { tailgateId, userId });
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
}