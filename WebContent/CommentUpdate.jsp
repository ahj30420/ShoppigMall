<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<div class="col-lg-10">
			<div class="jumbotron" style="padding-top: 1px;">				
				<h3><br>댓글수정창</h3>
				<form name = c_commentUpdate>
					<input type="text" id="update" style="width:400px;height:50px;" maxlength=1024 value="${cm}">
					<input type="button" onclick="send()" value="수정">
					<br><br>
				</form>
			</div>
		</div>
		<div class="col-lg-10"></div>
	</div>
</body>
<script>
	function send(){
		var sb;
		var commentText = document.c_commentUpdate.update.value;
		sb = "commentUpdate.do?upcom="+commentText;
		window.opener.location.href= sb;
		window.close();
	}
</script>
</html>