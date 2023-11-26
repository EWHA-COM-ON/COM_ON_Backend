package com.ewhacse.biz.user;

import io.swagger.annotations.ApiModelProperty;

public class UserVO {
	@ApiModelProperty(value = "id", example = "ewha")
	private String id;
	@ApiModelProperty(value = "password", example = "ewha")
	private String pwd;
	@ApiModelProperty(value = "이름", example = "윤하영")
	private String name;
	@ApiModelProperty(value = "전화번호", example = "010-1234-1234")
	private String phone;
	@ApiModelProperty(value = "학번", example = "2071033")
	private String num;
	@ApiModelProperty(value = "이메일", example = "ewha@ewhain.net")
	private String email;
	@ApiModelProperty(value = "주소", example = "서울 서대문구 이화여대")
	private String address;
	@ApiModelProperty(value = "사물함 번호", example = "400")
	private int locker;
	@ApiModelProperty(value = "학생회비 납부 여부", example = "0")
	private int fee;
	@ApiModelProperty(value = "학생등급", example = "1(공동대표)")
	private int level;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLocker() {
		return locker;
	}
	public void setLocker(int locker) {
		this.locker = locker;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

}
