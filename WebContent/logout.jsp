<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<%
  //1.session scope에 "id"라는 키값으로 저장된 값을 삭제한다.
   session.removeAttribute("ID");
   session.removeAttribute("pw");
   session.removeAttribute("nickname");
   session.removeAttribute("address");
   session.removeAttribute("phone");
   session.removeAttribute("name");

   session.removeAttribute("pname1");
   session.removeAttribute("price1");
   session.removeAttribute("img1");
   session.removeAttribute("views1");
   
   session.removeAttribute("pname2");
   session.removeAttribute("price2");
   session.removeAttribute("img2");
   session.removeAttribute("views2");
   
   session.removeAttribute("pname3");
   session.removeAttribute("price3");
   session.removeAttribute("img3");
   session.removeAttribute("views3");
   
   session.removeAttribute("pname4");
   session.removeAttribute("price4");
   session.removeAttribute("img4");
   session.removeAttribute("views4");
   
   session.removeAttribute("pname5");
   session.removeAttribute("price5");
   session.removeAttribute("img5");
   session.removeAttribute("views5");
   
   session.removeAttribute("pname6");
   session.removeAttribute("price6");
   session.removeAttribute("img6");
   session.removeAttribute("views6");
   
    //2. 응답(특정페이지로 요청을 다시 하라는 리다이렉트로 응답)
    String cPath = request.getContextPath();
    response.sendRedirect(cPath+"/HomePage.jsp");
%>