package com.ewhacse.biz.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;

@Setter
public class CounPromVO {
	@ApiModelProperty(value = "공약", example = "행복한 학생회", required = true)
	private String counPromise;

	public String getCounPromise() {
		return counPromise;
	}
	
	public void counsilPromVO (String counPromise) {
		this.counPromise = counPromise;
	}
	
}
