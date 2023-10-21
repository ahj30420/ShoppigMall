<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>

</head>
<style>
.my_div {
    width: 100%;
    height: 250px;
    border: solid;
    display : flex;
  justify-content : center;
  align-items : center;
}
 
.my_bg {
    background-image: url("https://t.pimg.jp/061/144/542/5/61144542.jpg");
}</style>
<body>
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
        <!-- Header-->
        <header class="my_div my_bg">
            
            <div class="my_div my_bg">
                <div class="text-center">
                    <h1 class="display-4 fw-bolder">Clothes</h1>
                    <p class="lead fw-normal text-white-50 mb-0"></p>
                </div>
            </div>
        </header>
        <!-- Section-->
                <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                 
               <%
                    int count= 0;
               %> 
                    
                  <c:forEach var="cnt" begin="1" end="${count}" step="1">  
                       <% count++; %> 
                  
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <a href="item.do?pname=<%=(String) session.getAttribute("cname"+ String.valueOf(count))%>">
                            <img class="card-img-top" src=<%=(String) session.getAttribute("cimg"+ String.valueOf(count))%> width="350", height="400" />
                            <!-- Product details--></a>
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">조회수 Top <%= count %>. </br></br><a href="item.do?pname=<%=(String) session.getAttribute("cname"+ String.valueOf(count))%>" style="color: black; font-weight: 100; text-decoration: none;"><%=(String) session.getAttribute("cname"+ String.valueOf(count))%></a></h5>
                                     <!-- Product price-->
                                    
                                    </br><font size="4em"><b><%=(Integer) session.getAttribute("cprice"+ String.valueOf(count)) %>원</b></font></br>
                                    
                                </div>
                                 <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class></br>조회수 <%=(Integer) session.getAttribute("cviews"+ String.valueOf(count)) %> 회</div>
                                        
                                    </div>
                            </div>
                            <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                           
                            </div>
                            
                        </div>
                    </div>
                    </c:forEach>
                    
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