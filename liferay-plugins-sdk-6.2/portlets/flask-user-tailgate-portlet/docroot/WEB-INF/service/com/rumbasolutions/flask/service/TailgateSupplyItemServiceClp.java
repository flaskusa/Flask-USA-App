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
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TailgateSupplyItemServiceClp implements TailgateSupplyItemService {
	public TailgateSupplyItemServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "addTailgateSupplyItem";

		_methodParameterTypes3 = new String[] {
				"java.lang.String", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName4 = "updateTailgateSupplyItem";

		_methodParameterTypes4 = new String[] {
				"long", "java.lang.String", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName5 = "getTailgateSupplyItem";

		_methodParameterTypes5 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName6 = "getItemsByTailgateId";

		_methodParameterTypes6 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName7 = "getMyTailgateSupplyItems";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName8 = "getAllTailgateSupplyItems";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName9 = "deleteTailgateSupplyItem";

		_methodParameterTypes9 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName10 = "deleteItemsByTailgateId";

		_methodParameterTypes10 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName11 = "deleteMyItems";

		_methodParameterTypes11 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};
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
	public com.rumbasolutions.flask.model.TailgateSupplyItem addTailgateSupplyItem(
		java.lang.String supplyListItemName, long tailgateId,
		long itemAssignedUserId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(supplyListItemName),
						
					tailgateId,
						
					itemAssignedUserId,
						
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

		return (com.rumbasolutions.flask.model.TailgateSupplyItem)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem updateTailgateSupplyItem(
		long tailgateSupplyItemId, java.lang.String supplyListItemName,
		long tailgateId, long itemAssignedUserId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						tailgateSupplyItemId,
						
					ClpSerializer.translateInput(supplyListItemName),
						
					tailgateId,
						
					itemAssignedUserId,
						
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

		return (com.rumbasolutions.flask.model.TailgateSupplyItem)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem getTailgateSupplyItem(
		long tailgateSupplyItemId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						tailgateSupplyItemId,
						
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

		return (com.rumbasolutions.flask.model.TailgateSupplyItem)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> getItemsByTailgateId(
		long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						tailgateId,
						
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

		return (java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> getMyTailgateSupplyItems(
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] { ClpSerializer.translateInput(serviceContext) });
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

		return (java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> getAllTailgateSupplyItems(
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(serviceContext) });
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

		return (java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteTailgateSupplyItem(long tailgateSupplyItemId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName9,
				_methodParameterTypes9,
				new Object[] {
					tailgateSupplyItemId,
					
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
	}

	@Override
	public void deleteItemsByTailgateId(long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName10,
				_methodParameterTypes10,
				new Object[] {
					tailgateId,
					
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
	}

	@Override
	public void deleteMyItems(
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName11,
				_methodParameterTypes11,
				new Object[] { ClpSerializer.translateInput(serviceContext) });
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
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
}