<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import = "com.sw.dao.*"%>
<%@ page import = "com.sw.dto.*"%>
<%@ page import = "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	 <meta charset="utf-8" />
	 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	 <meta name="description" content="" />
	 <meta name="author" content="" />
	 <title>Shop Item - Start Bootstrap Template</title>
	 <!-- Favicon-->
	 <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	 <!-- Bootstrap icons-->
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
	 <!-- Core theme CSS (includes Bootstrap)-->
	 <link href="css/styles.css" rel="stylesheet" />
	 <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- Navigation-->
       <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="home.do">Hallym Shop</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    	  <c:set var = "id" value = "${ID}" />
                          <c:if test = "${id == null}">
	                          <li class="nav-item"><a class="nav-link active" aria-current="page" href="home.do">홈</a></li>        
	                          <li class="nav-item"><a class="nav-link" href="login.do">로그인</a></li>
	                          <li class="nav-item"><a class="nav-link" href="join.do">회원가입</a></li> 
           				  </c:if>
           				  <c:if test = "${id != null}">
           				  	  <li class="nav-item"><a class="nav-link active" aria-current="page" href="home.do">홈</a></li>
	                          <li class="nav-item"><a class="nav-link" href="mypage.do"><%=(String) session.getAttribute("ID")%> 님</a></li>      
	                          <li class="nav-item"><a class="nav-link" href="logout.jsp">로그아웃</a></li>
           				  </c:if>
                        
                         <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">카테고리</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="book.do">도서</a></li>
                                <li><a class="dropdown-item" href="cloth.do">의류</a></li>
                                <li><a class="dropdown-item" href="food.do">식품</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- Navbar Search-->
		            <form action = "search.do" class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
		                <div class="input-group">
		                    <input name="search" class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                          <button  type="submit" style="background-color: #ff4261; border: none; color: white;">검색</button>
		                </div>
		            </form>
		            
 	               <c:if test = "${ID == null}">    
	                    <form class="d-flex" action = "login.do">
	                        <button class="btn btn-outline-dark" type="submit">
	                            <i class="bi-cart-fill me-1"></i>
	                            장바구니
	                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
	                        </button>
	                    </form>
  					</c:if>
  					<c:if test = "${ID != null}">    
	                    <form class="d-flex" action = "cart.do">
	                        <button class="btn btn-outline-dark" type="submit">
	                            <i class="bi-cart-fill me-1"></i>
	                            장바구니
	                            <span class="badge bg-dark text-white ms-1 rounded-pill"><%=(Integer) session.getAttribute("quantity")%></span>
	                        </button>
	                    </form>
  					</c:if>
  					
                </div>
            </div>
        </nav>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src=<%= (String)session.getAttribute("img")%> width = "600", height = "700"/></div>
                    <div class="col-md-6">
                        <h1 class="display-5 fw-bolder">${pn}</h1>
                            </br><p> <b> 상품 카테고리 : </b> ${kind}
                            <p> <b> 상품 가격 : </b> ${price}
                            <div class="d-flex small text-warning mb-2">
                              <p> <b> 남은 물량 : </b> ${count2}   
                            </div>
                        <div class="d-flex">
	                        <form action = 'payment.do'>	
                               <button class="btn btn-outline-dark flex-shrink-0" type="submit" name = "how" value = "장바구니" onclick="alert('장바구니에 담았습니다.')">
                                   <i class="bi-cart-fill me-1"></i>
                                   Add to cart
                               </button>
                           </form>
                           </div>
                           </br>
                           <div class="d-flex">
                           <form name = "pay">
                               <button class="btn btn-outline-dark flex-shrink-0" onclick="window.open('pay.jsp','pay','width=400,height=500,left=300')">
                                   결제
                               </button>
                           </form>    
                        </div>
                    </div>
                </div>
            </div>
        <section class="py-5 bg-light">
     	   <div class="container">
			<div class="row">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<tbody>
						<tr>
							<td align="left" bgcolor="beige">댓글</td>
						</tr>
						<tr>
						<%
							String cid = (String) session.getAttribute("ID");
							String pname = (String) session.getAttribute("pn");
							SDao sdao = new SDaoImpl();
							ArrayList<CommentDto> list = sdao.getList(pname);
								for(int i=0; i<list.size(); i++){
						%>
								<div class="container">
									<div class="row">
										<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
											<tbody>
												<tr>						
													<td align="left"><%= list.get(i).getCustomer_id() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= list.get(i).getPorder()%></td>		
													<td colspan="2"></td>
													<td align="right">
														<%
														if(list.get(i).getCustomer_id() != null && list.get(i).getCustomer_id().equals(cid)){   //댓글 쓴사람과 지금 유저가 같을 때 수정과 삭제를 가능하게 함
														%>
															<form name = "p_search">
																<a type = "button" onclick="window.open('CommentUpdate.jsp','CommentUpdate','width=600,height=230,left=300')" class="btn-primary">수정</a>
																<%  
																	int id = list.get(i).getId();
																	String comment = list.get(i).getComment();
																	session.setAttribute("cm", comment);
																	session.setAttribute("CommentUpdate_id", id);
																%>
															</form>	
																<a onclick="return confirm('정말로 삭제하시겠습니까?')" href = "commentDelete.do?" class="btn-primary">삭제</a>																	
														<%
														}
														%>	
													</td>
												</tr>
												<tr>
													<td colspan="5" align="left"><%= list.get(i).getComment() %></td>
												</tr>
											</tbody>
										</table>			
									</div>
								</div>
								<%}%>
						</tr>
				</table>
			</div>
		</div>
        <div class="container">
			<div class="form-group">
				<c:set var = "id" value = "${ID}" />
	                <c:if test = "${id != null}">
						<form method="post" action="comment.do">
							<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
								<tr>
										<td style="border-bottom:none;" valign="middle"><br><br></td>
										<td><input type="text" style="height:100px;" class="form-control" placeholder="여러분의 소중한 댓글을 입력하세요." name = "commentText"></td>
										<td><br><br><input type="submit" class="btn-primary pull" value="댓글 작성"></td>
								</tr>
							</table>
						</form>
					</c:if>	
					<c:if test = "${id == null}">
						<form method="post" action="login.do">
							<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
								<tr>
										<td style="border-bottom:none;" valign="middle"><br><br></td>
										<td><input type="text" style="height:100px;" class="form-control" placeholder="여러분의 소중한 댓글을 입력하세요."></td>
										<td><br><br><input type="submit" class="btn-primary pull" value="댓글 작성"></td>
								</tr>
							</table>
						</form>
					</c:if>	
			</div>
		</div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
	</body>
</html>	

