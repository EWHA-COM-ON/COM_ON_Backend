package com.ewhacse.biz.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;

@Setter
public class CounInfoVO {
	@ApiModelProperty(value = "학생회 인삿말", example = "안녕", required = true)
	private String counInfo;
	@ApiModelProperty(value = "학생회 주소", example = "집", required = true)
	private String counAddress;
	@ApiModelProperty(value = "학생회 위치", example = "신공학관", required = true)
	private String counLocation;
	@ApiModelProperty(value = "전화번호", example = "010-1234-1234", required = true)
	private String counPhone;
	@ApiModelProperty(value = "이메일", example = "ewhacse2022@gmail.com", required = true)
	private String counEmail;
	@ApiModelProperty(value = "카카오톡 ", example = "@ewhacse", required = true)
	private String counTalk;
	@ApiModelProperty(value = "인스타그랢", example = "insta", required = true)
	private String counInsta;
	
	public String getCounInfo() {
		return counInfo;
	}

	public String getCounAddress() {
		return counAddress;
	}

	public String getCounLocation() {
		return counLocation;
	}

	public String getCounPhone() {
		return counPhone;
	}

	public String getCounEmail() {
		return counEmail;
	}

	public String getCounTalk() {
		return counTalk;
	}

	public String getCounInsta() {
		return counInsta;
	}

	public void counsilInfoVO(String counInfo, String counAddress, String counLocation, String counPhone, String counEmail, String counTalk, String counInsta) {
		this.counInfo = counInfo;
		this.counAddress = counAddress;
		this.counLocation = counLocation;
		this.counPhone = counPhone;
		this.counEmail = counEmail;
		this.counTalk = counTalk;
		this.counInsta = counInsta;
	}
}
