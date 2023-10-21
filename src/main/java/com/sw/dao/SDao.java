package com.sw.dao;

import com.sw.dto.*;
import java.util.ArrayList;

public interface SDao {

	public void register(SLDto dto);
	public int login(SLDto dto);
	public SLDto getDto(String id, String pw);
	public void modify(String pw, String address, int phone, String id);
	public void delete(String id);
	public void homepage(ProductDto pdto, String kind);
	public void viewup(String pname);
	public ProductDto getproduct(String pn);
	public int count(ProductDto pdto, String kind, String search);      //카테고리별 상품의 전체 갯수를 가져오는 메소드
    public void productInfo(ProductDto pdto, String kind, int offset,String search); //상품정보를 가져오는 메소드
    public void product(ProductDto pdto, String name);
    public int payment(ProductDto pdto, String pname, String nickname, int count, String address, int phone);
    public void cart(ProductDto pdto, String pname, String nickname);
    public void viewcart(ProductDto pdto, String nickname,int cartcount);
    public int cartcount(ProductDto pdto, String nickname);
    public void comment(CommentDto cdto);
    public ArrayList<CommentDto> getList(String pname);
    public void commentupdate(int id, String newcom);
    public void commentdelete(int id);
    public void cartdelete( String pname, String nickname);
    public int ordercount(ProductDto pdto, String nickname);
    public void vieworder(ProductDto pdto, String nickname,int cartcount);
    public void order(OrderDto odto, String nickname,int ordercount);
    public void orderdelete(String pname, String nickname);
    
}
