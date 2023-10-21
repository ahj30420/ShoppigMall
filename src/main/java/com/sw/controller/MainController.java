package com.sw.controller;

import java.io.IOException;
import java.sql.Date;

import com.sw.command.*;
import com.sw.dto.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainController
 */
@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		String viewPage = null;
		ShoppingService service = new ShoppingServiceImpl();
		HttpSession session = request.getSession();
		
		System.out.println("actionDo - "+com);
		  if(com.equals("/home.do")) {
			  String pname;
			  int price;
			  String img;
			  int views;
			  String kind = null;
			  
			  ProductDto pdto = new ProductDto();
			  
			  for(int i = 1; i <=6; i++) {
				  if(i <= 2) {
					  kind = "도서";
					  service.home(pdto,kind);
					  
					  pname = pdto.getPname();
					  price = pdto.getPrice();
					  img = pdto.getImg();
					  views = pdto.getViews();
					  session.setAttribute("pname1", pname);
					  session.setAttribute("price1", price);
					  session.setAttribute("img1", img);
					  session.setAttribute("views1", views);
					  
					  pname = pdto.getPname2();
		              price = pdto.getPrice2();
		              img = pdto.getImg2();
		              views = pdto.getViews2();
		              session.setAttribute("pname2", pname);
		              session.setAttribute("price2", price);
		              session.setAttribute("img2", img);
		              session.setAttribute("views2", views);
				  }
				  else if(i<=4) {
		               kind = "의류";
		               service.home(pdto, kind);
		               
		               pname = pdto.getPname();
		               price = pdto.getPrice();
		               img = pdto.getImg();
		               views = pdto.getViews();
		               session.setAttribute("pname3", pname);
		               session.setAttribute("price3", price);
		               session.setAttribute("img3", img);
		               session.setAttribute("views3", views);
		            
		               pname = pdto.getPname2();
		               price = pdto.getPrice2();
		               img = pdto.getImg2();
		               views = pdto.getViews2();
		               session.setAttribute("pname4", pname);
		               session.setAttribute("price4", price);
		               session.setAttribute("img4", img);
		               session.setAttribute("views4", views);
		            }
		            else {
		               kind = "음식";
		               service.home(pdto, kind);
		               
		               pname = pdto.getPname();
		               price = pdto.getPrice();
		               img = pdto.getImg();
		               views = pdto.getViews();
		               session.setAttribute("pname5", pname);
		               session.setAttribute("price5", price);
		               session.setAttribute("img5", img);
		               session.setAttribute("views5", views);
		            
		               pname = pdto.getPname2();
		               price = pdto.getPrice2();
		               img = pdto.getImg2();
		               views = pdto.getViews2();
		               session.setAttribute("pname6", pname);
		               session.setAttribute("price6", price);
		               session.setAttribute("img6", img);
		               session.setAttribute("views6", views);
		            }
			  }
			  
		      viewPage = "HomePage.jsp";
		  }
		  else if(com.equals("/login.do")) {
		      viewPage = "Login.jsp";
		  }
		  else if(com.equals("/login_confirm.do")) {
			  String id = request.getParameter("id");
			  String pw = request.getParameter("pw");
			  int result = 0;
			  SLDto dto = service.getDto(id,pw);
			  
			  result = service.login(dto);
			  if(result == 1) {
				  String nickname = dto.getNickname();
		    	  String name = dto.getName();
		    	  String address = dto.getAddress();
		    	  int phone = dto.getPnum();
				  session.setAttribute("ID", id);
				  session.setAttribute("nickname", nickname);
				  session.setAttribute("pw", pw);
		    	  session.setAttribute("name", name);
		    	  session.setAttribute("address", address);
		    	  session.setAttribute("phone", phone);
				  viewPage = "HomePage.jsp";
			  }
			  else {
				  viewPage = "Login.jsp";
			  }
		  }
	      else if(com.equals("/join.do")) {
		      viewPage = "Register.jsp";
	      }
	      else if(com.equals("/mypage.do")) {
	    	  viewPage = "MyPage.jsp";
	      }
	      else if(com.equals("/register.do")) {
	    	  String id = request.getParameter("loginId");
	    	  String pw = request.getParameter("loginPw");
	    	  String name = request.getParameter("name");
	    	  String address = request.getParameter("address");
	    	  String nickname = request.getParameter("nickname");
	    	  int pnum = Integer.parseInt(request.getParameter("cellphoneNo"));
	    	  
	    	  SLDto dto = new SLDto(id, pw, name, address, nickname, pnum);
	    	  service.register(dto);
	    	  viewPage = "Login.jsp";
	      }
	      else if (com.equals("/modify.do")) {
	    	  String pw = request.getParameter("pw");
	    	  String address = request.getParameter("address");
	    	  int phone = Integer.parseInt(request.getParameter("phone"));
	    	  String id = (String) session.getAttribute("ID");
	    	  service.modify(pw,address,phone,id);
	    	  
	    	  session.removeAttribute("pw");
	    	  session.removeAttribute("address");
	    	  session.removeAttribute("phone");
	    	  
	    	  session.setAttribute("adress", address);
	    	  session.setAttribute("pw", pw);
	    	  session.setAttribute("phone", phone);
	    	  
	    	  viewPage = "MyPage.jsp";
	      }
	      else if (com.equals("/delete.do")) {
	    	 String conpw = request.getParameter("password");
	    	 String realpw = (String) session.getAttribute("pw");
	    	 
	    	 if(conpw.equals(realpw)) {
	    	 String id = (String) session.getAttribute("ID");
	    	 service.delete(id); 
	    	 viewPage = "logout.jsp";
	    	 }
	    	 
	    	 else
	    		 viewPage = "Delete.jsp";
	      }
	      else if(com.equals("/item.do")) {
	    	  String pn = request.getParameter("pname");
	    	  service.viewup(pn);
	    	  ProductDto pdto = service.getproduct(pn);
	    	  String kind = pdto.getKind();
	    	  int price = pdto.getPrice();
	    	  int count = pdto.getCount();
	    	  String size = pdto.getSize();
	    	  int views = pdto.getViews();
	    	  String img = pdto.getImg();
	    	  
	    	  session.setAttribute("pn", pn);
	    	  session.setAttribute("kind", kind);
	    	  session.setAttribute("price", price);
	    	  session.setAttribute("count2", count);
	    	  session.setAttribute("views", views);
	    	  session.setAttribute("img", img);
	    	  session.setAttribute("size", size);
	    	  viewPage = "Item.jsp";
	      }
	      else if(com.equals("/book.do")) {   //도서 카테고리 웹페이지
	          int cartcount;
	          ProductDto pdto = new ProductDto();
	          String nickname = (String) session.getAttribute("nickname");
	          cartcount = service.cartcount(pdto, nickname);
	          session.setAttribute("quantity", cartcount);
	          
	          int i = 0;
	          String product_name = "bname";    //setAttribute()를 상품 갯수만큼 반복해야하기 때문에 속성값의 공통적인 부분을 변수화함.
	          String product_price = "bprice";
	          String product_img = "bimg";
	          String product_bviews = "bviews";
	          
	          String bname = null;
	          int bprice;
	          String bimg = null;
	          int bviews;
	         
	          i = service.count(pdto, "도서","");   //도서 카테고리의 상품의 전체 갯수
	          session.setAttribute("count", i);
	          for(int j = 1; j<= i; j++) {
	             service.ProductInfo(pdto, "도서", j-1,"");
	             
	             bname = pdto.getPname();
	             bprice = pdto.getPrice();
	             bimg = pdto.getImg();
	             bviews = pdto.getViews();
	             
	             session.setAttribute(product_name+j, bname);  //속성값의 공통적인 부분을 변수화하고, 갯수만큼 세션에 저장되게함.
	             session.setAttribute(product_price+j, bprice);
	             session.setAttribute(product_img+j, bimg);
	             session.setAttribute(product_bviews+j, bviews);
	          }

              viewPage="book.jsp";
	      }
          else if(com.equals("/cloth.do")) {
              int cartcount;
              ProductDto pdto = new ProductDto();
              String nickname = (String) session.getAttribute("nickname");
              cartcount = service.cartcount(pdto, nickname);
              session.setAttribute("quantity", cartcount);
              
              int i = 0;
              String product_name = "cname";
              String product_price = "cprice";
              String product_img = "cimg";
              String product_bviews = "cviews";
              
              String cname = null;
              int cprice;
              String cimg = null;
              int cviews;
              
              i = service.count(pdto, "의류","");
              session.setAttribute("count", i);
              for(int j = 1; j<= i; j++) {
            	 service.ProductInfo(pdto, "의류", j-1,"");
                 
                 cname = pdto.getPname();
                 cprice = pdto.getPrice();
                 cimg = pdto.getImg();
                 cviews = pdto.getViews();
                 
                 session.setAttribute(product_name+j, cname);
                 session.setAttribute(product_price+j, cprice);
                 session.setAttribute(product_img+j, cimg);
                 session.setAttribute(product_bviews+j, cviews);
                 
              }
        
              viewPage="cloth.jsp";
           }
           else if(com.equals("/food.do")) {
              int cartcount;
              ProductDto pdto = new ProductDto();
              String nickname = (String) session.getAttribute("nickname");
              cartcount = service.cartcount(pdto, nickname);
              session.setAttribute("quantity", cartcount);
              
              int i = 0;
              String product_name = "fname";
              String product_price = "fprice";
              String product_img = "fimg";
              String product_bviews = "fviews";
              
              String fname = null;
              int fprice;
              String fimg = null;
              int fviews;
              
              i = service.count(pdto, "음식","");
              session.setAttribute("count", i);
              for(int j = 1; j<= i; j++) {
                 service.ProductInfo(pdto, "음식", j-1,"");
                 
                 fname = pdto.getPname();
                 fprice = pdto.getPrice();
                 fimg = pdto.getImg();
                 fviews = pdto.getViews();
                 
                 session.setAttribute(product_name+j, fname);
                 session.setAttribute(product_price+j, fprice);
                 session.setAttribute(product_img+j, fimg);
                 session.setAttribute(product_bviews+j, fviews);
                 
              }
           
              viewPage="food.jsp";
           }
           else if(com.equals("/search.do")) {
               int cartcount;
               ProductDto pdto = new ProductDto();
               String nickname = (String) session.getAttribute("nickname");
               cartcount = service.cartcount(pdto, nickname);
               session.setAttribute("quantity", cartcount);
               
               String search_text = request.getParameter("search");
               session.setAttribute("search", search_text);
               int i = 0;
               String product_name = "sname";
               String product_price = "sprice";
               String product_img = "simg";
               String product_bviews = "sviews";
               
               String sname = null;
               int sprice;
               String simg = null;
               int sviews;
               
               i = service.count(pdto, "*", search_text);
               session.setAttribute("count", i);
               if(i != 0) {
                  for(int j = 1; j<= i; j++) {
                     service.ProductInfo(pdto, "*", j-1,search_text);
                     
                     sname = pdto.getPname();
                     sprice = pdto.getPrice();
                     simg = pdto.getImg();
                     sviews = pdto.getViews();
                     System.out.println(sname);
                     session.setAttribute(product_name+j, sname);
                     session.setAttribute(product_price+j, sprice);
                     session.setAttribute(product_img+j, simg);
                     session.setAttribute(product_bviews+j, sviews);
                     
                  }
                  viewPage="Searchresult.jsp";
               }
               else {
                  viewPage="SearchNotFound.jsp";
               }
               
            }
           	else if(com.equals("/payment.do")) {
               int ret;
               String alert= null;
               int cartcount;
               ProductDto pdto = new ProductDto();
               String nickname = (String) session.getAttribute("nickname");
               cartcount = service.cartcount(pdto, nickname);
               session.setAttribute("quantity", cartcount);
               
               if(request.getParameter("how").equals("결제")) {
                  String pname = (String) session.getAttribute("pn");
                  int count = Integer.parseInt(request.getParameter("qua"));
                  String address = request.getParameter("address");
                  int phone = (int) session.getAttribute("phone");
                  
                  ret = service.payment(pdto, pname, nickname, count, address, phone);
                  if(ret != 0) {
                     alert ="결제가 완료되었습니다.";
                     session.setAttribute("count", ret);
                  }
                  else {
                     alert = "수량을 다시 확인해주세요.";
                  }
                  session.setAttribute("alert", alert);
               }
               else {
            	  String pname = (String) session.getAttribute("pn");
                  nickname = (String) session.getAttribute("nickname");
                  
                  service.cart(pdto, pname, nickname);
                  
                  cartcount = service.cartcount(pdto, nickname);
                  session.setAttribute("quantity", cartcount);
                  
               }
               
               viewPage="HomePage.jsp";
               
            }
           	else if(com.equals("/cart.do")) {
                int cartcount=0;
                String nickname = (String) session.getAttribute("nickname");
                String product_name = "name";
                String product_price = "price";
                String product_img = "img";
                String product_views = "count";
                ProductDto pdto = new ProductDto();
                
                cartcount = service.cartcount(pdto, nickname);
                session.setAttribute("quantity", cartcount);
                
                for(int j = 1; j<= cartcount; j++) {
                   
                   service.viewcart(pdto, nickname, j-1);
                   
                   String name = pdto.getPname();
                   int price = pdto.getPrice();
                   String img = pdto.getImg();
                   int count = pdto.getCount();
                   
                   session.setAttribute(product_name+j, name);
                   session.setAttribute(product_price+j, price);
                   session.setAttribute(product_img+j, img);
                   session.setAttribute(product_views+j, count);
                   System.out.println(name);
                }
                
                viewPage="cart.jsp";
             }
           	else if(com.equals("/order.do")) {
           		int ordercount=0;
                String nickname = (String) session.getAttribute("nickname");
                String p_name = "p_name";
                String p_price = "p_price";
                String p_img = "p_img";
                String o_quantity = "o_quantity";
                String o_date = "o_date";
                String o_address = "o_address";
                ProductDto pdto = new ProductDto();
                OrderDto odto = new OrderDto();
                
                ordercount = service.ordercount(pdto, nickname);
                session.setAttribute("ordercount", ordercount);
                
                for(int j = 1; j<= ordercount; j++) {
                   
                   service.vieworder(pdto, nickname, j-1);
                   service.order(odto, nickname, j-1);
                   
                   String name = pdto.getPname();
                   int price = pdto.getPrice();
                   String img = pdto.getImg();
                   int q = odto.getQuantity();
                   Date d = odto.getDate();
                   String ad = odto.getShipping();
                   
                   session.setAttribute(p_name+j, name);
                   session.setAttribute(p_price+j, price);
                   session.setAttribute(p_img+j, img);
                   session.setAttribute(o_quantity+j, q);
                   session.setAttribute(o_date+j, d);
                   session.setAttribute(o_address+j, ad);
                }
                
                viewPage="Order.jsp";
           	}
           	else if(com.equals("/comment.do")) {
           		String cid = (String) session.getAttribute("ID");
           		String pname = (String) session.getAttribute("pn");
           		String comment = request.getParameter("commentText");
           		
           		CommentDto cdto = new CommentDto(0, comment, cid, pname, null);
           		service.comment(cdto);
           		
           		viewPage = "Item.jsp";
           	}
           	else if(com.equals("/commentUpdate.do")) {
           		int id = (int) session.getAttribute("CommentUpdate_id");
           		String newcom = request.getParameter("upcom");
           		
           		service.commentupdate(id,newcom);
           		
           		viewPage = "Item.jsp";
           	}
           	else if(com.equals("/commentDelete.do")) {
           		int id = (int) session.getAttribute("CommentUpdate_id");
           		
           		service.commentdelete(id);
           		
           		viewPage = "Item.jsp";
           	}
           	else if(com.equals("/cartdelete.do")) {
                String nickname = (String) session.getAttribute("nickname");
                String pname = request.getParameter("ppname");
                ProductDto pdto = new ProductDto();
                
                service.cartdelete(pname, nickname);
              
                int cartcount = service.cartcount(pdto, nickname);
                session.setAttribute("quantity", cartcount);
                 
                viewPage = "cart.do";
            }
           	else if(com.equals("/orderdelete.do")) {
                String nickname = (String) session.getAttribute("nickname");
                String pname = request.getParameter("p_name");
                ProductDto pdto = new ProductDto();
                
                service.orderdelete(pname, nickname);
              
                int ordercount = service.ordercount(pdto, nickname);
                session.setAttribute("ordercount", ordercount);
                 
                viewPage = "order.do";
            }
		
		response.sendRedirect(viewPage);
	}

}
