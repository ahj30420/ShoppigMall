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
    background-image: url("https://img.freepik.com/free-vector/template-banner-for-online-store-with-shopping-cart-with-purchases-boxes-delivery-from-a-supermarket-vector-illustration_548887-104.jpg");
    background-size: 565px;
}

</style>
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
                    <h1 class="display-4 fw-bolder">Hallym Shop</h1>
                    <p class="lead fw-normal text-white-50 mb-0"></p>
                </div>
            </div>
        </header>
        <!-- Section-->
            <section class="py-5">
            <h3 class="text-center">검색하신 "<%=(String) session.getAttribute("search")%>" 에 대한 검색결과가 없습니다.</h3>
            <div class="container px-4 px-lg-5 mt-5">
            </div>
            
            
           </section>
        <!-- Footer-->
        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
</body>
</html>