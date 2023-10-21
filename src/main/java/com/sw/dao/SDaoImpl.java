package com.sw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.sw.dto.*;

public class SDaoImpl implements SDao {

	public void register(SLDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int r = 0;
		
		String id = dto.getId();
		String pw = dto.getPw();
		String name = dto.getName();
		String address = dto.getAddress();
		String nickname = dto.getNickname();
		int pnum = dto.getPnum();
		
		try {
			con = getConnection();
			String sql = "insert into customer values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pw);
			pstmt.setString(4, nickname);
			pstmt.setInt(5, pnum);
			pstmt.setString(6, address);
			r = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(rs, pstmt, con);
		}
		
	}
	
	public int login(SLDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = getConnection();
			String sql = "select customer_id, pw from customer where customer_id = ? and pw = ?";
			pstmt = con.prepareStatement(sql);
			
			String id = dto.getId();
			String pw = dto.getPw();
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String Cid = rs.getString("customer_id");
				String Cpw = rs.getString("pw");
				
				if(Cid == null) {}
				else if(Cid.equals(id)) {
					if(Cpw.equals(pw)) {
						result = 1;
					}
					else {}
				}
				else {}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(rs,pstmt,con);
		}
		
		return result;
	}
	
	public SLDto getDto(String id, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SLDto dto = null;
		
		try {
			con = getConnection();
			String sql = "select * from customer where customer_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				int phone = rs.getInt("phone");
				String address = rs.getString("address");
				
				dto = new SLDto(id, pw, name, address, nickname, phone);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(rs, pstmt, con);
		}
		
		return dto;
	}
	
	public void modify(String pw, String address, int phone, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = getConnection();
			String sql = "update customer set pw = ?, address = ?, phone = ? where customer_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, pw);
			pstmt.setString(2, address);
			pstmt.setInt(3, phone);
			pstmt.setString(4, id);
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("modify success!!");
			}
			else {
				System.out.println("modify fail!!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(rs, pstmt, con);
		}
	}
	
	public void delete(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = getConnection();
			String sql = "delete from customer where customer_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
	
			if(result == 1) {
				System.out.println("delete success!!");
			}
			else {
				System.out.println("delete fail!!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(rs, pstmt, con);
		}
	}
	
	public void homepage(ProductDto pdto, String kind) {
		  Connection conn = getConnection();
	      ResultSet rs = null;
	      PreparedStatement pstmt = null;
	      String sql = "SELECT product_name,price,views, img FROM product  where kind =? ORDER BY views desc LIMIT 1;";
	      String sql2 = "SELECT product_name,price,views, img FROM product  where kind =? ORDER BY views desc LIMIT 1 OFFSET 1;";
	      
	      String pname = null;
	      int price;
	      String img = null;
	      int views;
	         
	      
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, kind);
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            pname = rs.getString("product_name");
	            price = rs.getInt("price");
	            img = rs.getString("img");
	            views = rs.getInt("views");
	            
	            pdto.setPname(pname);
	            pdto.setPrice(price);
	            pdto.setImg(img);
	            pdto.setViews(views);
	            System.out.println(pdto.getImg());
	            
	         }
	         
	         pstmt = conn.prepareStatement(sql2);
	         pstmt.setString(1, kind);
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            pname = rs.getString("product_name");
	            price = rs.getInt("price");
	            img = rs.getString("img");
	            views = rs.getInt("views");
	            
	            pdto.setPname2(pname);
	            pdto.setPrice2(price);
	            pdto.setImg2(img);
	            pdto.setViews2(views);
	            System.out.println(pdto.getImg2());
	            
	         }
	         
	         
	      }catch (SQLException e){
	         System.out.println("SQLException error.");
	         e.printStackTrace();
	      }finally {
	         closeConnection(rs, pstmt, conn);
	      }
	}
	
	public void viewup(String pname) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Update product set views = views + 1 where product_name = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pname);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(rs,pstmt,con);
		}
	}
	
	public ProductDto getproduct(String pn) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDto pdto = null;
		
		String sql = "select * from product where product_name = ?";
		String img = null;
		String kind = null;
		String name = null;
		String size = null;
		int id = 0;
		int price = 0;
		int count = 0;
		int views = 0;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pn);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				img = rs.getString("img");
				kind = rs.getString("kind");
				id = rs.getInt("product_id");
				name = rs.getString("product_name");
				price = rs.getInt("price");
				count = rs.getInt("count");
				size = rs.getString("size");
				views = rs.getInt("views");
			}
			pdto = new ProductDto(id, name, price, count, kind, size, img, views);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(rs, pstmt, con);
		}
		return pdto;
	}


	public int count(ProductDto pdto,String kind, String search) {
	      int ret = 0;;
	      Connection conn = getConnection();
	      ResultSet rs = null;
	      PreparedStatement pstmt = null;
	      String sql = "Select count(*) as count from product where kind = ?;";
	      if(kind.equals("*")) {
	         sql = "Select count(*) as count from product where product_name LIKE ?;";
	      }
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         if(kind.equals("*")){
	            pstmt.setString(1, "%"+search+"%");
	         }
	         else {
	            pstmt.setString(1, kind);
	         }
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            ret = rs.getInt("count");
	            
	         }
	            
	         
	      }catch (SQLException e){
	         System.out.println("SQLException error.");
	         e.printStackTrace();
	      }finally {
	         closeConnection(rs, pstmt, conn);
	      }
	      
	      return ret;
	   }
	   public void productInfo(ProductDto pdto, String kind, int offset, String search) {
		      Connection conn = getConnection();
		      ResultSet rs = null;
		      PreparedStatement pstmt = null;
		      String sql = "SELECT product_name,price,views, img FROM product  where kind =? order by views desc LIMIT 1 OFFSET ?;";
		      if(kind.equals("*")) {
		         sql = "SELECT product_name,price,views, img FROM product  where product_name LIKE ? order by views desc LIMIT 1 OFFSET ?;";
		      }
		      String pname = null;
		      int price;
		      String img = null;
		      int views;
		         
		      
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         if(kind.equals("*")){
		            pstmt.setString(1, "%"+search+"%");
		         }
		         else {
		            pstmt.setString(1, kind);
		         }
		         pstmt.setInt(2, offset);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		            pname = rs.getString("product_name");
		            price = rs.getInt("price");
		            img = rs.getString("img");
		            views = rs.getInt("views");
		            pdto.setPname(pname);
		            pdto.setPrice(price);
		            pdto.setImg(img);
		            pdto.setViews(views);
		            
		            
		         }         
		         
		      }catch (SQLException e){
		         System.out.println("SQLException error.");
		         e.printStackTrace();
		      }finally {
		         closeConnection(rs, pstmt, conn);
		         
		      }	   
		   }
	   	   public void product(ProductDto pdto, String name) {
		      Connection conn = getConnection();
		      ResultSet rs = null;
		      PreparedStatement pstmt = null;
		      String sql = "SELECT product_name,price,count,kind ,size,views, img FROM product  where product_name = ?;";
		      String sql2 = "Update product Set views = views +1 Where product_name = ? ;";
		      String pname = null;
		      int price;
		      int count;
		      String category = null;
		      String size = null;
		      String img = null;
		      int views;
		         
		      
		      
		      try {
		         pstmt = conn.prepareStatement(sql2);
		         pstmt.setString(1, name);
		         pstmt.executeUpdate();
		         
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, name);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		            pname = rs.getString("product_name");
		            price = rs.getInt("price");
		            count = rs.getInt("count");
		            size = rs.getString("size");
		            img = rs.getString("img");
		            category = rs.getString("kind");
		            views = rs.getInt("views");
		            pdto.setPname(pname);
		            pdto.setPrice(price);
		            pdto.setImg(img);
		            pdto.setViews(views);
		            pdto.setCount(count);
		            pdto.setKind(category);
		            pdto.setSize(size);
		            
		            
		            
		         }         
		         
		      }catch (SQLException e){
		         System.out.println("SQLException error.");
		         e.printStackTrace();
		      }finally {
		         closeConnection(rs, pstmt, conn);
		         
		      }
		   }
		   public int payment(ProductDto pdto, String pname, String nickname, int count, String address, int phone) {
		      Connection conn = getConnection();
		      ResultSet rs = null;
		      PreparedStatement pstmt = null;
		      String sql = "INSERT INTO orders VALUES(? ,?, ?, ? ,?, ?, ?,?)";
		      String sql2 = "Update product Set count = count - ?  Where product_name = ? ";
		      String sql3 = "SELECT customer_id FROM customer where nickname = ?";
		      String sql4 = "SELECT product_id ,count FROM product where product_name = ?";
		      
		      String cid=null;
		      String pid = null;
		      String oid=null;
		      LocalDate now = LocalDate.now();
		      int quantity=0;

		      
		      try {   
		         pstmt = conn.prepareStatement(sql4);
		         pstmt.setString(1, pname);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		            pid = rs.getString("product_id");
		            quantity = rs.getInt("count");
		         
		         }
		         
		            
		         if((quantity - count)>=0) {
		            pstmt = conn.prepareStatement(sql2);
		            pstmt.setInt(1, count);
		            pstmt.setString(2, pname);
		            pstmt.executeUpdate();
		            
		            
		            pstmt = conn.prepareStatement(sql3);
		            pstmt.setString(1, nickname);
		            rs = pstmt.executeQuery();
		            
		            while(rs.next()) {
		               cid = rs.getString("customer_id");
		               oid = cid+pid+String.valueOf((int)(Math.random()*100));
		            }
		            
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, oid);
		            pstmt.setString(2, cid);
		            pstmt.setString(3, pid);
		            pstmt.setString(4, String.valueOf(now));
		            pstmt.setString(5, "결제완료");
		            pstmt.setString(6, address);
		            pstmt.setInt(7, count);
		            pstmt.setInt(8, phone);
		            
		            pstmt.executeUpdate();
		         }

		      }catch (SQLException e){
		         System.out.println("SQLException error.");
		         e.printStackTrace();
		      }finally {
		         closeConnection(rs, pstmt, conn);
		         
		      }
		      
		      return (quantity - count);
		   }
		   public void cart(ProductDto pdto, String pname, String nickname) {
		      Connection conn = getConnection();
		      ResultSet rs = null;
		      PreparedStatement pstmt = null;
		      String sql = "INSERT INTO cart VALUES(? ,?, ?)";
		      String sql2 = "SELECT customer_id FROM customer where nickname = ?";
		      String sql3 = "SELECT product_id FROM product where product_name = ?";
		      String pid=null;
		      String cid=null;
		      String cartId=null;
		      try {   
		         pstmt = conn.prepareStatement(sql2);
		         pstmt.setString(1, nickname);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		            cid = rs.getString("customer_id");
		         }
		         
		         pstmt = conn.prepareStatement(sql3);
		         pstmt.setString(1, pname);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		            pid = rs.getString("product_id");
		            cartId = cid+pid+String.valueOf((int)(Math.random()*100));
		         }
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, cartId);
		         pstmt.setString(2, cid);
		         pstmt.setString(3, pid);
		         pstmt.executeUpdate();
		            
		         

		      }catch (SQLException e){
		         System.out.println("SQLException error.");
		         e.printStackTrace();
		      }finally {
		         closeConnection(rs, pstmt, conn);
		         
		      }
		   }
		   public void viewcart(ProductDto pdto, String nickname,int cartcount) {
		      Connection conn = getConnection();
		      ResultSet rs = null;
		      PreparedStatement pstmt = null;
		      String sql = "SELECT customer_id FROM customer where nickname = ?;";
		      String sql2 = "SELECT product_id FROM cart where customer_id = ? LIMIT 1 OFFSET ?;";
		      String sql3 = "SELECT product_name, count, img, price FROM product where product_id = ?;";
		      String pname=null;
		      String img=null;
		      int count;
		      int price;
		      String pid=null;
		      String cid=null;
		      
		      
		      try {   
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, nickname);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		            cid = rs.getString("customer_id");
		         }

		         pstmt = conn.prepareStatement(sql2);
		         pstmt.setString(1, cid);
		         pstmt.setInt(2, cartcount);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		            pid = rs.getString("product_id");
		         }
		         
		         pstmt = conn.prepareStatement(sql3);
		         pstmt.setString(1, pid);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		            pname = rs.getString("product_name");
		            img = rs.getString("img");
		            count = rs.getInt("count");
		            price = rs.getInt("price");
		            
		            pdto.setPname(pname);
		            pdto.setImg(img);
		            pdto.setCount(count);
		            pdto.setPrice(price); 
		         }
		         

		      }catch (SQLException e){
		         System.out.println("SQLException error.");
		         e.printStackTrace();
		      }finally {
		         closeConnection(rs, pstmt, conn);
		         
		      }
		   }
		   public int cartcount(ProductDto pdto, String nickname) {
		      int count=0;
		      Connection conn = getConnection();
		      ResultSet rs = null;
		      PreparedStatement pstmt = null;
		      String sql = "SELECT customer_id FROM customer where nickname = ?";
		      String sql2 = "SELECT count(*) as count FROM cart where customer_id = ?";
		      int price;
		      String cid=null;
		      
		      
		      try {   
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, nickname);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		            cid = rs.getString("customer_id");
		         }
		         
		         pstmt = conn.prepareStatement(sql2);
		         pstmt.setString(1, cid);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		            count = rs.getInt("count");
		         }

		      }catch (SQLException e){
		         System.out.println("SQLException error.");
		         e.printStackTrace();
		      }finally {
		         closeConnection(rs, pstmt, conn);
		         
		      }
		      return count;
		   }
		   
		   public void comment(CommentDto cdto) {
			   Connection con = null;
			   PreparedStatement pstmt = null;
			   ResultSet rs = null;
			   String sql = "insert into comment(comment, customer_id, product_name, porder) value(?, ?, ?, ?)";
			   String sql2 = "select now()";
			   String comment = cdto.getComment();
			   String cid = cdto.getCustomer_id();
			   String pname = cdto.getProduct_name();
			   Timestamp d = null;
			   
			   
			   
			   try {
				   con = getConnection();
				   pstmt = con.prepareStatement(sql2);
				   rs = pstmt.executeQuery();
				   
				   while(rs.next()) {
					   d = rs.getTimestamp("now()");
				   }
				   
				   pstmt = con.prepareStatement(sql);
				   pstmt.setString(1, comment);
				   pstmt.setString(2, cid);
				   pstmt.setString(3, pname);
				   pstmt.setTimestamp(4, d);
				   pstmt.executeUpdate();
			   }
			   catch(Exception e) {
				   
			   }
			   finally {
				   closeConnection(rs, pstmt, con);
			   }
		   }
		   
		   public ArrayList<CommentDto> getList(String pname){
			   Connection con = null;
			   PreparedStatement pstmt = null;
			   ResultSet rs = null;
			   ArrayList<CommentDto> lcom = new ArrayList<CommentDto>();
			   String sql = "select * from comment where product_name = ? order by porder";
			   
			   try {
				   con = getConnection();
				   pstmt = con.prepareStatement(sql);
				   pstmt.setString(1, pname);
				   rs = pstmt.executeQuery();
				   
				   while(rs.next()) {
					   int id = rs.getInt("id");
					   String comment = rs.getString("comment");
					   String cid = rs.getString("customer_id");
					   String pn = rs.getString("product_name");
					   Timestamp porder = rs.getTimestamp("porder");
					   
					   CommentDto cdto = new CommentDto(id, comment, cid, pn, porder);
					   lcom.add(cdto);   
				   }
				   
			   }
			   catch(Exception e){
				   e.printStackTrace();
			   }
			   finally {
				   closeConnection(rs, pstmt, con);
			   }			   
			   return lcom;
		   }
		   
		   public void commentupdate(int id, String newcom) {
			   Connection con = null;
			   PreparedStatement pstmt = null;
			   ResultSet rs = null;
			   
			   String sql = "update comment set comment = ?, porder = ? where id = ?";
			   String sql2 = "select now()";
			   Timestamp d = null;
			   
			   try {
				   con = getConnection();
				   pstmt = con.prepareStatement(sql2);
				   rs = pstmt.executeQuery();
				   
				   while(rs.next()) {
					   d = rs.getTimestamp("now()");
				   }
				   
				   pstmt = con.prepareStatement(sql);
				   pstmt.setString(1, newcom);
				   pstmt.setTimestamp(2, d);
				   pstmt.setInt(3, id);
				   pstmt.executeUpdate();
			   }
			   catch(Exception e) {
				   
			   }
			   finally {
				   closeConnection(rs, pstmt, con);
			   }
		   }
		   
		   public void commentdelete(int id) {
			   Connection con = null;
			   PreparedStatement pstmt = null;
			   ResultSet rs = null;
			   String sql = "delete from comment where id = ?";
			   
			   try {
				   con = getConnection();
				   pstmt = con.prepareStatement(sql);
				   pstmt.setInt(1, id);
				   pstmt.executeUpdate(); 
			   }
			   catch(Exception e) {
				   e.printStackTrace();
			   }
			   finally {
				   closeConnection(rs, pstmt, con);
			   }
		   }
		   
		   public void cartdelete(String pname, String nickname) {
			      int count=0;
			      Connection conn = getConnection();
			      ResultSet rs = null;
			      PreparedStatement pstmt = null;
			      String sql = "select cart_id FROM cart join customer ON cart.customer_id = customer.customer_id  join product ON cart.product_id = product.product_id WHERE customer.nickname= ? and product.product_name = ? LIMIT 1;";
			      String cart_id=null;
			      String sql2 = "delete from cart where cart_id = ?;";
			      
			      try {   
			         pstmt = conn.prepareStatement(sql);
			         pstmt.setString(1, nickname);
			         pstmt.setString(2, pname);
			         rs = pstmt.executeQuery();
			         
			         while(rs.next()) {
			            cart_id = rs.getString("cart_id");
			         }
			         
			         pstmt = conn.prepareStatement(sql2);
			         pstmt.setString(1, cart_id);
			         pstmt.executeUpdate();

			      }catch (SQLException e){
			         System.out.println("SQLException error.");
			         e.printStackTrace();
			      }finally {
			         closeConnection(rs, pstmt, conn);
			         
			      }
			      
			   }
		    public void orderdelete(String pname, String nickname) {
		    	  int count=0;
			      Connection conn = getConnection();
			      ResultSet rs = null;
			      PreparedStatement pstmt = null;
			      String sql = "select order_id FROM orders join customer ON orders.customer_id = customer.customer_id  join product ON orders.product_id = product.product_id WHERE customer.nickname= ? and product.product_name = ? LIMIT 1;";
			      String order_id=null;
			      String sql2 = "delete from orders where order_id = ?";
			      
			      try {   
			         pstmt = conn.prepareStatement(sql);
			         pstmt.setString(1, nickname);
			         pstmt.setString(2, pname);
			         rs = pstmt.executeQuery();
			         
			         while(rs.next()) {
			            order_id = rs.getString("order_id");
			         }
			         
			         pstmt = conn.prepareStatement(sql2);
			         pstmt.setString(1, order_id);
			         pstmt.executeUpdate();

			      }catch (SQLException e){
			         System.out.println("SQLException error.");
			         e.printStackTrace();
			      }finally {
			         closeConnection(rs, pstmt, conn);
			         
			      }
		    }
		    public int ordercount(ProductDto pdto, String nickname) {
		    	Connection con = null;
		    	PreparedStatement pstmt = null;
		    	ResultSet rs = null;
		    	int count = 0;
		    	int price;
			    String cid = null;
		    	String sql = "SELECT customer_id FROM customer where nickname = ?";
			    String sql2 = "SELECT count(*) as count FROM orders where customer_id = ?";
		    	
		    	try {
		    		con = getConnection();
		    		pstmt = con.prepareStatement(sql);
		    		pstmt.setString(1, nickname);
		    		rs = pstmt.executeQuery();
		    		
		    		while(rs.next()) {
			            cid = rs.getString("customer_id");
			        }
		    		
		    		pstmt = con.prepareStatement(sql2);
		    		pstmt.setString(1, cid);
		    		rs = pstmt.executeQuery();
		    		
		    		while(rs.next()) {
		    			count = rs.getInt("count");
		    		}
		    	}
		    	catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	finally {
		    		closeConnection(rs,pstmt,con);
		    	}
		    	return count;
		    }
		    public void vieworder(ProductDto pdto, String nickname,int ordercount) {
		    	Connection con = null;
		    	PreparedStatement pstmt = null;
		    	ResultSet rs = null;
		    	String sql = "SELECT customer_id FROM customer where nickname = ?;";
			    String sql2 = "SELECT product_id FROM orders where customer_id = ? LIMIT 1 OFFSET ?;";
			    String sql3 = "SELECT product_name, count, img, price FROM product where product_id = ?";
			    String pname=null;
			    String img=null;
			    int count;
			    int price;
			    String pid=null;
			    String cid=null;
		    	try {
		    		con = getConnection();
		    		 pstmt = con.prepareStatement(sql);
			         pstmt.setString(1, nickname);
			         rs = pstmt.executeQuery();
			         
			         while(rs.next()) {
			            cid = rs.getString("customer_id");
			         }

			         pstmt = con.prepareStatement(sql2);
			         pstmt.setString(1, cid);
			         pstmt.setInt(2, ordercount);
			         rs = pstmt.executeQuery();
			         
			         while(rs.next()) {
			            pid = rs.getString("product_id");
			         }
			         
			         pstmt = con.prepareStatement(sql3);
			         pstmt.setString(1, pid);
			         rs = pstmt.executeQuery();
			         
			         while(rs.next()) {
			            pname = rs.getString("product_name");
			            img = rs.getString("img");
			            count = rs.getInt("count");
			            price = rs.getInt("price");
			            
			            pdto.setPname(pname);
			            pdto.setImg(img);
			            pdto.setCount(count);
			            pdto.setPrice(price); 
			         }
		    	}
		    	catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	finally {
		    		closeConnection(rs,pstmt,con);
		    	}
		    }
		    
		    public void order(OrderDto odto, String nickname,int ordercount) {
		    	Connection con = null;
		    	PreparedStatement pstmt = null;
		    	ResultSet rs = null;
		    	String sql = "SELECT customer_id FROM customer where nickname = ?;";
			    String sql2 = "SELECT product_id FROM orders where customer_id = ? LIMIT 1 OFFSET ?;";
			    String sql3 = "SELECT date, shipping, quantity FROM orders where product_id = ?";
			    String shipping=null;
			    int quantity = 0;
			    Date date = null;
			    int count;
			    int price;
			    String pid=null;
			    String cid=null;
		    	try {
		    		con = getConnection();
		    		 pstmt = con.prepareStatement(sql);
			         pstmt.setString(1, nickname);
			         rs = pstmt.executeQuery();
			         
			         while(rs.next()) {
			            cid = rs.getString("customer_id");
			         }

			         pstmt = con.prepareStatement(sql2);
			         pstmt.setString(1, cid);
			         pstmt.setInt(2, ordercount);
			         rs = pstmt.executeQuery();
			         
			         while(rs.next()) {
			            pid = rs.getString("product_id");
			         }
			         
			         pstmt = con.prepareStatement(sql3);
			         pstmt.setString(1, pid);
			         rs = pstmt.executeQuery();
			         
			         while(rs.next()) {
			            quantity = rs.getInt("quantity");
			            date = rs.getDate("date");
			            shipping = rs.getString("shipping");
			            
			            odto.setQuantity(quantity);
			            odto.setDate(date);
			            odto.setShipping(shipping); 
			         }
		    	}
		    	catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	finally {
		    		closeConnection(rs,pstmt,con);
		    	}
			}
		   
			public Connection getConnection() {
				Connection con = null;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("JDBC driver load success");
				}
				catch(ClassNotFoundException e) {
					 e.printStackTrace();
			         System.out.println("JDBC driver load fail");
				}
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db?useSSL=false", 
					          "root","z30420qwas");
					System.out.println("DB connect success");
				}
				catch(SQLException e) {
					System.out.println("connect fail");
					e.printStackTrace();
				}
				
				return con;
			}
			
			public void closeConnection(ResultSet set, PreparedStatement pstmt, Connection conn) {
				if(set!=null)
				{
					try {
						set.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				if(pstmt!=null)
				{
					try {
						pstmt.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				if(conn!=null)
				{
					try {
						conn.close();
					} catch (Exception e2) {
					e2.printStackTrace();
					}
				}
			}
	   
	
}
