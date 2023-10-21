<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
/* 폰트 1 */
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap');

/* 폰트 2 */
@font-face {
    font-family: 'TmoneyRoundWindRegular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/TmoneyRoundWindRegular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}


html{
  font-family: 'Noto Sans KR', sans-serif;
}

/* 노말라이즈 */
body, ul, li, h1, h2, h3 {
  margin:0;
  padding:0;
  list-style:none;
}
a {
  color:inherit;
  text-decoration:none;
}

input{
/*ios대응*/
appearance: none;
-webkit-appearance: none;
-webkit-border-radius: 0;
}

select{
/*ios대응*/
-webkit-appearance: none;
-moz-appearance: none; 
appearance: none;
}

/* 라이브러리 */
.flex {
  display:flex;
}

.flex-jc-c {
  justify-content:center;
}

.flex-jc-fe {
  justify-content:flex-end;
}

.flex-jc-fs {
  justify-content:flex-start;
}

.flex-jc-sb{
  justify-content:space-between;
}

.flex-jc-sa{
  justify-content:space-around;
}
.flex-ai-c {
  align-items:center;
}

.flex-ai-fe {
  align-items:flex-end;
}

.flex-ai-fs{
  align-items:flex-start;
}

.flex-as-c {
  align-self:center;
}

.flex-wrap {
  flex-wrap:wrap;
}

.flex-column {
  flex-direction:column;

}

.flex-grow-1 {
  flex-grow:1;
}

.flex-1-0-0 {
  flex:1 0 0;
}

.con {
  margin-left:auto;
  margin-right:auto;
}

.min-height-100vh {
  min-height:100vh;
}

.min-height-50vh {
  min-height:50vh;
}

.bd{
  border:3px solid;
}

.bd-w{
  border:3px solid white;
}

.bd-green {
  border:3px solid green;
}

.bd-red {
  border:3px solid red;
}

.bd-purple {
  border:3px solid purple;
}

.bd-blue {
  border:3px solid blue;
}

.bg-pink {
  background-color:pink;
}

.bg-red {
  background-color:red;
}

.bg-blue {
  background-color:blue;
}

.height-100p {
  height:100%;
}

.height-70p{
  height:70%;
}

.height-500px{
  height:500px;
}


.block {
  display:block;
}

.hover-underline:hover{
  text-decoration:underline;
}

@media ( min-width:721px ) {
  .visible-sm-down {
    display:none !important;
  }
}

@media ( max-width:720px ) {
  .visible-md-up {
    display:none !important;
  }
}


/* 커스텀 */
:root {
  --site-width:1200px;
}

body{

}

.con {
  max-width: var(--site-width);
  
}




/* 버튼 시작 */
.btn {
  height: 35px;
  font-size: 0.9rem;
  line-height: 1rem;
  text-shadow: 1px 1px 20px white;
  padding:0 15px;
  color: white;
  background-color: #444;
  border: none;
  border-radius: 10px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  }

.btn:hover {
  background-color:	#222;
  box-shadow:3px 3px 3px gray;
  color: #FFF;
  font-weight:bold;
}

.m-btn {
  height:25px;
  width:65px;
  font-size: 0.9rem;
  line-height: 1rem;
  text-shadow: 1px 1px 20px white;
  padding:0 15px;
  color: white;
  background-color: #444;
  border: none;
  border-radius: 10px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  }
.m-btn:hover {
  background-color:	#222;
  box-shadow:3px 3px 3px gray;
  color: #FFF;
  font-weight:bold;
}


.btn-go {
  background-color: #008B8B;
}

.btn-check {
  background-color: #3c3c3c;
}

.btn-danger {
  background-color: #800000;
}

.btn-back {
  background-color:	#696969;
}

.btn-modify {
  background-color:	#778899;
}
/* 버튼 끝 */

/* 메인 컨텐츠 박스 시작 */
.main-box{
  min-height:1000px;
  
}

.main-box-section{
  

}

/* 메인 컨텐츠 박스 끝 */


/* 푸터 시작 */
.bottom-bar{
  font-size:0.8rem;
  color:black;
  background-color:white;
  border-top:3px solid gray;
  padding:20px;
}

/* 푸터 끝 */

/* 회원가입 페이지 시작 */
.section-join{
  margin-top:100px;
  width:100%;
}
.section-join > form{
  text-align:left;
  width:950px;
  font-size:1rem;
  font-weight:bold;
  border-radius:20px 20px 20px 20px;
  box-shadow:5px 10px 10px 10px gray;
  padding:50px 10px;

  
}
.section-join > form > div{
  padding:10px;
  
}

.section-join > form > div:nth-child(2){
  font-size:2rem;
  text-shadow:3px 3px 5px gray;
}

.section-join > form > div:not(:last-child){
  border-right:4px solid gray;
  padding-right:40px;
}
.section-join > form > div:not(:nth-child(2)){
  padding-left:40px;
  
}

.join_cell__title{
  margin:10px 0;
  
}

.join_cell__title > span{
  padding-bottom:3px;
  border-bottom:3px solid gray;
  
}

.join_cell__body{
  margin:15px 0;
}

.join_cell__body > input{
  font-size:0.9rem;
  
  border:none;
  border-bottom:1.5px solid #333;
  padding:5px;
  margin-top:5px;
  height:25px;
  width:95%;
  min-width:150px;
}
.join_cell__body > .btn-check {
  margin-top:5px;
  margin-left:7px;
  width:95%;
  font-size:0.8rem;
}

.joinInput-cell{
  margin-top:80px;
  text-align:right;
}


/* 회원가입 페이지 끝 */

/* 회원정보 페이지 시작 */
.section-MyPage{
  padding-top:100px;
  padding-bottom:50px;
  
  
}
.section-MyPage > form{
  width:950px;
}

.section-MyPage > form > .section-MyPage-body{
  text-align:left;
  font-size:1rem;
  font-weight:bold;
  border-radius:20px 20px 20px 20px;
  box-shadow:5px 10px 10px 10px gray;
  padding:50px;

}

.section-MyPage-body > div:first-child{
  font-size:2rem;
  padding-right:30px;
  border-right:4px solid gray;
  text-shadow:3px 3px 5px gray;
}

.section-MyPage-body__cell{
  padding:10px 50px;
  width:280px;
}

.section-MyPage-body__cell:nth-child(2){
  padding-right:0px;
}

.section-MyPage-body__cell:last-child{
  border-left:4px solid gray;
}


.MyPage_cell__title{
  margin-bottom:10px;
  font-size:1.1rem;
}
.MyPage_cell__title > span{
  padding-bottom:3px;
  border-bottom:3px solid gray;
}

.MyPage_cell__body{
  font-size:0.9rem;
  font-weight:normal;
  background-color:white;
  height:50px;
  padding-top:10px;
  display:flex;
  align-items:center;
}

.MyPage_cell__body > input{
  font-size:0.9rem;
  height:30px;
  padding-top:10px;
  font-weight:normal;
  border:none;
  border-bottom:1.5px solid #333;
  display:flex;
  align-items:center;
}

.MyPage_cell__body > .btn{
  margin-left:5px;
  font-size:0.7rem;
  width:90px;
}

.section-MyPage-body__option button{
  margin-left:10px;
}

/* 회원정보 페이지 끝 */

/* 맨 위 버튼 시작 */
.top-button{
  display:none;
  position:fixed;
  bottom:80px;
  right:20px;
  width:15px;
  height:25px;
  padding-top:7px;
  background-color:rgba(200, 200, 200, 0.9);
  font-size:1.1rem;
  font-weight:bold;
  z-index:500;
}
.top-button:hover{
  background-color:#222;
  text-shadow: 1px 1px 20px white;
  transform: translateY(-3px);

}

/* 맨 위 버튼 끝 */

/* 맨 아래 버튼 시작 */
.bottom-button{
  display:none;
  position:fixed;
  bottom:40px;
  right:20px;
  width:15px;
  height:25px;
  padding-top:7px;
  background-color:rgba(200, 200, 200, 0.9);
  font-size:1.1rem;
  font-weight:bold;
  z-index:500;
}
.bottom-button:hover{
  background-color:#222;
  text-shadow: 1px 1px 20px white;
  transform: translateY(3px);

}

/* 맨 아래 버튼 끝 */

</style>
<body>
 <main class="main-box flex-grow-1 visible-md-up">
    <section class="main-box-section con">
      <!-- 회원정보 페이지 시작 -->
      <div class="section-MyPage min-height-50vh flex flex-jc-c flex-ai-c ">
        <form name="form" onsubmit="check(this); return false;" action="modify.do" method="POST">
        
          <div class="section-MyPage-body flex flex-jc-c flex-ai-c">
            <div>My Page</div>
              <div class="section-MyPage-body__cell">
               <div class="MyPage_cell__title">
               	 <span>회원ID</span>
                	<div class="MyPage_cell__body">
                 <span>${ID}</span>
                </div>
              </div>

              <div class=MyPage_cell__title>
                <span>Password</span>
                <div class=MyPage_cell__body>
              		<input type="password" name="pw" placeholder="PW 입력">
               	</div>
              </div>

              <div class=MyPage_cell__title>
                <span>Password Check</span>
                <div class=MyPage_cell__body>
                  <input type="password" name="loginPwConfirm" placeholder="PW 확인">
                </div>
              </div>

              <div class="MyPage_cell__title">
                <span>회원이름</span>
                <div class=MyPage_cell__body>
                   <span>${name}</span>
                </div>
              </div>
            </div>

            <div class="section-MyPage-body__cell">
              <div class="MyPage_cell__title">
                <span>닉네임</span>
                <div class="MyPage_cell__body">
                  <span>${nickname}</span>
                </div>
              </div>
              <div class=MyPage_cell__title>
                <span>address</span>
                <div class=MyPage_cell__body>
                  <input type="text" name="address" placeholder="${address}">
                </div>
              </div>

              <div class=MyPage_cell__title>
                <span>연락처</span>
                <div class=MyPage_cell__body>
                  <input type="number" name="phone" placeholder="${phone}">
                </div>
              </div>
              <div class="section-MyPage-body__option flex flex-jc-fe flex-ai-fe">
                <button class="submitModifyBtn btn btn-go" type="submit" onclick="if(confirm('정말 변경하시겠습니까?') == false) {return false;}"><i class="far fa-edit"></i> 변경</button>
                <button class="cleModifyBtn btn btn-back" type="button" onclick="history.back();"><i class="fas fa-undo"></i> 취소</button>
              </div>
            </div>
          </div>
        </form>
      </div>
      <!-- 회원정보 페이지 끝 -->
    </section>
  </main>
</body>
</html>