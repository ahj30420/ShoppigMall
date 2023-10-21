package com.sw.command;

import com.sw.dto.*;
import com.sw.dao.*;

public class ShoppingServiceImpl implements ShoppingService {

	public void register(SLDto dto) {
		SDao dao = new SDaoImpl();
		dao.register(dto);
	}
	
	public int login(SLDto dto) {
		int result = 0;
		SDao dao = new SDaoImpl();
		result = dao.login(dto);
		return result;
	}
	
	public SLDto getDto(String id, String pw) {
		SDao dao = new SDaoImpl();
		SLDto dto = dao.getDto(id, pw);
		return dto;
	}
	
	public void modify(String pw, String address, int phone, String id) {
		SDao dao = new SDaoImpl();
		dao.modify(pw,address,phone,id);
	}

	public void delete(String id) {
		SDao dao = new SDaoImpl();
		dao.delete(id);
	}
	
	public void viewup(String pname) {
		SDao dao = new SDaoImpl();
		dao.viewup(pname);
	}
	
	public void home(ProductDto pdto, String kind) {
		SDao dao = new SDaoImpl();
		dao.homepage(pdto,kind);
	}
	
	public ProductDto getproduct(String pn) {
		SDao dao = new SDaoImpl();
		ProductDto pdto = dao.getproduct(pn);
		return pdto;
	}
	
	public int count(ProductDto pdto, String kind, String search) {
	     SDao sdao = new SDaoImpl();
	     int ret = sdao.count(pdto, kind, search);
	     return ret;
	}
	
    public void ProductInfo(ProductDto pdto, String kind, int offset, String search) {
	     SDao sdao = new SDaoImpl();
	     sdao.productInfo(pdto, kind, offset, search);
	}
    
	public void product(ProductDto pdto, String name) {
	     SDao sdao = new SDaoImpl();
	     sdao.product(pdto, name);
	}
	
    public int payment(ProductDto pdto, String pname, String nickname, int count, String address, int phone) {
	     SDao sdao = new SDaoImpl();
	     int ret = sdao.payment(pdto, pname, nickname, count,address, phone);
	     if(ret >=0) {
	        
	     }else {
	        ret = 0;
	     }  
	     return ret;
	}
    
	public void cart(ProductDto pdto, String pname, String nickname) {
	     SDao sdao = new SDaoImpl();
	     sdao.cart(pdto, pname, nickname);
	}
	
	public void viewcart(ProductDto pdto, String nickname,int cartcount) {
	     SDao sdao = new SDaoImpl();
	     sdao.viewcart(pdto, nickname,cartcount);
	}
	
	public int cartcount(ProductDto pdto, String nickname) {
	     SDao sdao = new SDaoImpl();
	     int ret = sdao.cartcount(pdto,  nickname);    
	     return ret;
	}
	
	public void comment(CommentDto cdto) {
		SDao sdao = new SDaoImpl();
		sdao.comment(cdto);
	}
	
	public void commentupdate(int id, String newcomment) {
		SDao sdao = new SDaoImpl();
		sdao.commentupdate(id,newcomment);
	}
	
	public void commentdelete(int id) {
		SDao sdao = new SDaoImpl();
		sdao.commentdelete(id);
	}
	public void cartdelete( String pname, String nickname) {
	    SDao sdao = new SDaoImpl();
	    sdao.cartdelete(pname, nickname);
    }
	public int ordercount(ProductDto pdto, String nickname) {
		 SDao sdao = new SDaoImpl();
	     int ret = sdao.ordercount(pdto,  nickname);    
	     return ret;
	}
	public void vieworder(ProductDto pdto, String nickname,int cartcount) {
		 SDao sdao = new SDaoImpl();
	     sdao.vieworder(pdto, nickname,cartcount);
	}
	public void order(OrderDto odto, String nickname,int ordercount) {
		 SDao sdao = new SDaoImpl();
	     sdao.order(odto, nickname,ordercount);
	}
	public void orderdelete(String pname, String nickname) {
		 SDao sdao = new SDaoImpl();
	     sdao.orderdelete(pname,nickname);
	}

}
