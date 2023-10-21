package com.sw.dto;

import java.sql.Timestamp;

public class CommentDto {
	
	public int id;
	public String comment;
	public String customer_id;
	public String product_name;
	public Timestamp porder;
	
	public CommentDto() {}
	
	public CommentDto(int id, String comment, String cid, String pname, Timestamp porder) {
		this.id = id;
		this.comment = comment;
		this.customer_id = cid;
		this.product_name = pname;
		this.porder = porder;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Timestamp getPorder() {
		return porder;
	}
	public void setPorder(Timestamp porder) {
		this.porder = porder;
	}

}
