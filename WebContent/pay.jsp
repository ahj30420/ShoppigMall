<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
   <div class="container col-12" align="center">
         <div class="jumbotron" style="padding-top: 50px;">            
            <h1><br>결제</h1>
            <h3> <b> 최종 결제 금액 : </b> ${price}</h3></br>
            <form name = pay>   
               <input name="qua" id="qua" type="number" class="id"  placeholder="수량">  </br></br>
                 <input name="name" id="name" type="text" class="id" placeholder="받는 사람" > </br></br>
                 <input name="address" id="address" type="text" class="id" placeholder="배송지 입력"></br></br>
               <input type="button" onclick="send()" value="결제">
 
               <br></br>
            </form>
         
      </div>
      
   </div>
</body>
<script>
 
   function send(){
         var p;
         var qua = document.getElementById('qua').value;
         var name = document.getElementById('name').value;
         var address = document.getElementById('address').value;
         
         p = "payment.do?how="+"결제"+ "&qua="+qua + "&name="+name+ "&address="+address;
         window.opener.location.href= p;
         window.close();
      }
</script>
</html>