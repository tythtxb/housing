package com.housings.util;

public enum ResponseConstant {

	OK("200", "system.response.code.ok", "ok"),
	URL_NOT_FOUND("404", "system.response.code.url.not.found", "fail"),
	INVALID_METHOD("405", "system.response.code.invalid.method", "fail"),
	REQUEST_TIMEOUT("408", "system.response.code.timeout", "fail"),
	INTERNAL_ERROR("500", "system.response.code.internal.error", "fail"),
	ERROR(null, null, "fail"),
	WARNING("200", "system.response.code.warning", "warn"),
	AUTH_ERROR("-103","system.code.autherror","fail"),
	PARAM_ERROR("-101","system.code.paramerror","fail"),
	REQUEST_ERROR("-102","system.code.requesterror","fail"),
	EXCEPTION_ERROR("-100","system.code.exception","fail"),
	PERMISSION_ERROR("-403","system.code.permission","fail");
	
	private final String code;
	private String messageKey;
	private final String status;
	
	ResponseConstant(String code, String messageKey, String status) {
		this.code = code;
		this.messageKey = messageKey;
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public String getMessageKey() {
		return messageKey;
	}
	
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getStatus() {
		return status;
	}
	
}
