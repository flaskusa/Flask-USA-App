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

package com.rumbasolutions.flask.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TailgateMessageBoard}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMessageBoard
 * @generated
 */
public class TailgateMessageBoardWrapper implements TailgateMessageBoard,
	ModelWrapper<TailgateMessageBoard> {
	public TailgateMessageBoardWrapper(
		TailgateMessageBoard tailgateMessageBoard) {
		_tailgateMessageBoard = tailgateMessageBoard;
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateMessageBoard.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateMessageBoard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateMessageId", getTailgateMessageId());
		attributes.put("messageText", getMessageText());
		attributes.put("tailgateId", getTailgateId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateMessageId = (Long)attributes.get("tailgateMessageId");

		if (tailgateMessageId != null) {
			setTailgateMessageId(tailgateMessageId);
		}

		String messageText = (String)attributes.get("messageText");

		if (messageText != null) {
			setMessageText(messageText);
		}

		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this tailgate message board.
	*
	* @return the primary key of this tailgate message board
	*/
	@Override
	public long getPrimaryKey() {
		return _tailgateMessageBoard.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tailgate message board.
	*
	* @param primaryKey the primary key of this tailgate message board
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tailgateMessageBoard.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tailgate message ID of this tailgate message board.
	*
	* @return the tailgate message ID of this tailgate message board
	*/
	@Override
	public long getTailgateMessageId() {
		return _tailgateMessageBoard.getTailgateMessageId();
	}

	/**
	* Sets the tailgate message ID of this tailgate message board.
	*
	* @param tailgateMessageId the tailgate message ID of this tailgate message board
	*/
	@Override
	public void setTailgateMessageId(long tailgateMessageId) {
		_tailgateMessageBoard.setTailgateMessageId(tailgateMessageId);
	}

	/**
	* Returns the message text of this tailgate message board.
	*
	* @return the message text of this tailgate message board
	*/
	@Override
	public java.lang.String getMessageText() {
		return _tailgateMessageBoard.getMessageText();
	}

	/**
	* Sets the message text of this tailgate message board.
	*
	* @param messageText the message text of this tailgate message board
	*/
	@Override
	public void setMessageText(java.lang.String messageText) {
		_tailgateMessageBoard.setMessageText(messageText);
	}

	/**
	* Returns the tailgate ID of this tailgate message board.
	*
	* @return the tailgate ID of this tailgate message board
	*/
	@Override
	public long getTailgateId() {
		return _tailgateMessageBoard.getTailgateId();
	}

	/**
	* Sets the tailgate ID of this tailgate message board.
	*
	* @param tailgateId the tailgate ID of this tailgate message board
	*/
	@Override
	public void setTailgateId(long tailgateId) {
		_tailgateMessageBoard.setTailgateId(tailgateId);
	}

	/**
	* Returns the company ID of this tailgate message board.
	*
	* @return the company ID of this tailgate message board
	*/
	@Override
	public long getCompanyId() {
		return _tailgateMessageBoard.getCompanyId();
	}

	/**
	* Sets the company ID of this tailgate message board.
	*
	* @param companyId the company ID of this tailgate message board
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tailgateMessageBoard.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this tailgate message board.
	*
	* @return the user ID of this tailgate message board
	*/
	@Override
	public long getUserId() {
		return _tailgateMessageBoard.getUserId();
	}

	/**
	* Sets the user ID of this tailgate message board.
	*
	* @param userId the user ID of this tailgate message board
	*/
	@Override
	public void setUserId(long userId) {
		_tailgateMessageBoard.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tailgate message board.
	*
	* @return the user uuid of this tailgate message board
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateMessageBoard.getUserUuid();
	}

	/**
	* Sets the user uuid of this tailgate message board.
	*
	* @param userUuid the user uuid of this tailgate message board
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tailgateMessageBoard.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this tailgate message board.
	*
	* @return the created date of this tailgate message board
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _tailgateMessageBoard.getCreatedDate();
	}

	/**
	* Sets the created date of this tailgate message board.
	*
	* @param createdDate the created date of this tailgate message board
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_tailgateMessageBoard.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this tailgate message board.
	*
	* @return the modified date of this tailgate message board
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tailgateMessageBoard.getModifiedDate();
	}

	/**
	* Sets the modified date of this tailgate message board.
	*
	* @param modifiedDate the modified date of this tailgate message board
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tailgateMessageBoard.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _tailgateMessageBoard.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tailgateMessageBoard.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tailgateMessageBoard.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tailgateMessageBoard.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tailgateMessageBoard.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tailgateMessageBoard.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tailgateMessageBoard.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tailgateMessageBoard.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tailgateMessageBoard.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tailgateMessageBoard.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateMessageBoard.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TailgateMessageBoardWrapper((TailgateMessageBoard)_tailgateMessageBoard.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.TailgateMessageBoard tailgateMessageBoard) {
		return _tailgateMessageBoard.compareTo(tailgateMessageBoard);
	}

	@Override
	public int hashCode() {
		return _tailgateMessageBoard.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.TailgateMessageBoard> toCacheModel() {
		return _tailgateMessageBoard.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateMessageBoard toEscapedModel() {
		return new TailgateMessageBoardWrapper(_tailgateMessageBoard.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateMessageBoard toUnescapedModel() {
		return new TailgateMessageBoardWrapper(_tailgateMessageBoard.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tailgateMessageBoard.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tailgateMessageBoard.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tailgateMessageBoard.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TailgateMessageBoardWrapper)) {
			return false;
		}

		TailgateMessageBoardWrapper tailgateMessageBoardWrapper = (TailgateMessageBoardWrapper)obj;

		if (Validator.equals(_tailgateMessageBoard,
					tailgateMessageBoardWrapper._tailgateMessageBoard)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TailgateMessageBoard getWrappedTailgateMessageBoard() {
		return _tailgateMessageBoard;
	}

	@Override
	public TailgateMessageBoard getWrappedModel() {
		return _tailgateMessageBoard;
	}

	@Override
	public void resetOriginalValues() {
		_tailgateMessageBoard.resetOriginalValues();
	}

	private TailgateMessageBoard _tailgateMessageBoard;
}