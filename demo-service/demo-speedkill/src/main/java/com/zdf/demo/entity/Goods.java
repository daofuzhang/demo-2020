package com.zdf.demo.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Goods {

	@Id
	private String goodId;
	private String name;
	private int num;

	

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
