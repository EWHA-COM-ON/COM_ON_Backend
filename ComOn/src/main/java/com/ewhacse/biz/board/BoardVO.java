package com.ewhacse.biz.board;

public class BoardVO {
	private int counNum;
	private String counName;
	private String counInfo;
	private String counAddress;
	private String counLocation;
	private String counPhone;
	private String counEmail;
	private String counTalk;
	private String counInsta;
	
	
	
	public int getCounNum() {
		return counNum;
	}
	public void setCounNum(int counNum) {
		this.counNum = counNum;
	}
	public String getCounName() {
		return counName;
	}
	public void setCounName(String counName) {
		this.counName = counName;
	}
	public String getCounInfo() {
		return counInfo;
	}
	public void setCounInfo(String counInfo) {
		this.counInfo = counInfo;
	}
	public String getCounAddress() {
		return counAddress;
	}
	public void setCounAddress(String counAddress) {
		this.counAddress = counAddress;
	}
	public String getCounLocation() {
		return counLocation;
	}
	public void setCounLocation(String counLocation) {
		this.counLocation = counLocation;
	}
	public String getCounPhone() {
		return counPhone;
	}
	public void setCounPhone(String counPhone) {
		this.counPhone = counPhone;
	}
	public String getCounEmail() {
		return counEmail;
	}
	public void setCounEmail(String counEmail) {
		this.counEmail = counEmail;
	}
	public String getCounTalk() {
		return counTalk;
	}
	public void setCounTalk(String counTalk) {
		this.counTalk = counTalk;
	}
	public String getCounInsta() {
		return counInsta;
	}
	public void setCounInsta(String counInsta) {
		this.counInsta = counInsta;
	}
	
	public String toString() {
		return "BoardVO [info=" + counInfo + ", loc="+ counLocation + ", address="
				+ counAddress + ", phone=" + counPhone + ",email=" + counEmail + ", talk=" + counTalk+ "]";
	}
}
