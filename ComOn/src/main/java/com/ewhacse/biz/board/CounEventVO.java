package com.ewhacse.biz.board;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;


public class CounEventVO {
	@ApiModelProperty(value = "행사 번호 (자동으로 + 1)", example = "1", required = true)
	public int seq;
	@ApiModelProperty(value = "기수", example = "40", required = true)
	public int counnum;
	@ApiModelProperty(value = "행사 이름", example = "1", required = true)
	public String name;
	@ApiModelProperty(value = "행사 정보", example = "새내기 오티", required = true)
	public String info;
	@ApiModelProperty(value = "행사 날짜", example = "2023-01-12", required = true)
	public Date date;
	
	
	
	public int getSeq() {
		return seq;
	}



	public int getCounnum() {
		return counnum;
	}



	public String getName() {
		return name;
	}



	public String getInfo() {
		return info;
	}



	public Date getDate() {
		return date;
	}



	public void CounEventVO(int seq, int counnum, String name, String info, Date date){
		this.seq = seq;
		this.counnum = counnum;
		this.name = name;
		this.info = info;
		this.date = date;
	}
}
