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
public class AdCampaignServiceClp implements AdCampaignService {
	public AdCampaignServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getAllCampaign";

		_methodParameterTypes3 = new String[] {  };

		_methodName4 = "getCampaign";

		_methodParameterTypes4 = new String[] { "long" };

		_methodName5 = "addCampaign";

		_methodParameterTypes5 = new String[] {
				"java.lang.String", "long", "boolean", "boolean", "boolean",
				"boolean", "long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName6 = "updateCampaign";

		_methodParameterTypes6 = new String[] {
				"long", "java.lang.String", "long", "boolean", "boolean",
				"boolean", "boolean", "long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName7 = "deleteCampaign";

		_methodParameterTypes7 = new String[] { "long" };

		_methodName8 = "deleteCampaigns";

		_methodParameterTypes8 = new String[] { "java.lang.String" };

		_methodName9 = "addCampaignImage";

		_methodParameterTypes9 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName10 = "updateCampaignImage";

		_methodParameterTypes10 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName11 = "getCampaignImage";

		_methodParameterTypes11 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName12 = "getCampaignImages";

		_methodParameterTypes12 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName13 = "deleteCampaignImage";

		_methodParameterTypes13 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName14 = "getCampaignWithImages";

		_methodParameterTypes14 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
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
	public com.liferay.portal.kernel.json.JSONArray getAllCampaign() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3, new Object[] {  });
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.AdCampaign getCampaign(
		long campaignId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] { campaignId });
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

		return (com.rumbasolutions.flask.model.AdCampaign)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.AdCampaign addCampaign(
		java.lang.String campaignName, long customerId, boolean displayGeneral,
		boolean displayPreEvent, boolean displayDuringEvent,
		boolean displayPostEvent, long frequencyPerHour,
		java.lang.String events,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						ClpSerializer.translateInput(campaignName),
						
					customerId,
						
					displayGeneral,
						
					displayPreEvent,
						
					displayDuringEvent,
						
					displayPostEvent,
						
					frequencyPerHour,
						
					ClpSerializer.translateInput(events),
						
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

		return (com.rumbasolutions.flask.model.AdCampaign)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.AdCampaign updateCampaign(
		long campaignId, java.lang.String campaignName, long customerId,
		boolean displayGeneral, boolean displayPreEvent,
		boolean displayDuringEvent, boolean displayPostEvent,
		long frequencyPerHour, java.lang.String events,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						campaignId,
						
					ClpSerializer.translateInput(campaignName),
						
					customerId,
						
					displayGeneral,
						
					displayPreEvent,
						
					displayDuringEvent,
						
					displayPostEvent,
						
					frequencyPerHour,
						
					ClpSerializer.translateInput(events),
						
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

		return (com.rumbasolutions.flask.model.AdCampaign)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteCampaign(long campaignId) {
		try {
			_invokableService.invokeMethod(_methodName7,
				_methodParameterTypes7, new Object[] { campaignId });
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
	public void deleteCampaigns(java.lang.String campaignList) {
		try {
			_invokableService.invokeMethod(_methodName8,
				_methodParameterTypes8,
				new Object[] { ClpSerializer.translateInput(campaignList) });
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
	public com.rumbasolutions.flask.model.CampaignImage addCampaignImage(
		long campaignId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID,
		long imageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						campaignId,
						
					ClpSerializer.translateInput(imageTitle),
						
					ClpSerializer.translateInput(imageDesc),
						
					ClpSerializer.translateInput(imageUUID),
						
					imageGroupId,
						
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

		return (com.rumbasolutions.flask.model.CampaignImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignImage updateCampaignImage(
		long campaignImageId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID,
		long imageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] {
						campaignImageId,
						
					ClpSerializer.translateInput(imageTitle),
						
					ClpSerializer.translateInput(imageDesc),
						
					ClpSerializer.translateInput(imageUUID),
						
					imageGroupId,
						
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

		return (com.rumbasolutions.flask.model.CampaignImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignImage getCampaignImage(
		long campaignImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] {
						campaignImageId,
						
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

		return (com.rumbasolutions.flask.model.CampaignImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.CampaignImage> getCampaignImages(
		long campaignId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] {
						campaignId,
						
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

		return (java.util.List<com.rumbasolutions.flask.model.CampaignImage>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteCampaignImage(long campaignImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName13,
				_methodParameterTypes13,
				new Object[] {
					campaignImageId,
					
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
	public com.liferay.portal.kernel.json.JSONObject getCampaignWithImages(
		long campaignId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] {
						campaignId,
						
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
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
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
}