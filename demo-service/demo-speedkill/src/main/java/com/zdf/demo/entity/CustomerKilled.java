package com.zdf.demo.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class CustomerKilled {
	
	@Id
	private String id;
	
	private String goodId;
	private String phone;
	private int state;
	
	private Date createtime;

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



}
