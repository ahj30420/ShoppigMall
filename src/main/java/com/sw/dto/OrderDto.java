package com.sw.dto;

import java.sql.Date;

public class OrderDto {
	
	String id;
	String cid;
	int pid;
	Date date;
	String orderstate;
	String shipping;
	int quantity;
	String phone;
	
	public OrderDto() {}
	
	public OrderDto(String id, String cid, int pid, Date date, String orderstate, String shipping, int quantity, String phone) {
		this.id = id;
		this.cid = cid;
		this.pid = pid;
		this.date = date;
		this.orderstate = orderstate;
		this.shipping = shipping;
		this.quantity = quantity;
		this.phone = phone;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getShipping() {
		return shipping;
	}

}
