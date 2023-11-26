package com.ewhacse.biz.user;

import io.swagger.annotations.ApiModelProperty;

public class UserLoginVO {
	@ApiModelProperty(value = "id", example = "ewha")
	private String id;
	@ApiModelProperty(value = "password", example = "ewha")
	private String pwd;
	
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	
	public void UserloginVO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
}
