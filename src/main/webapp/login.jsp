<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<%= request.getContextPath() %>/icon/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%= request.getContextPath() %>/css/signin.css" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/js/js.cookie-2.2.1.min.js"></script>
    
    <script>

		$(function(){
			// remember me cookie 확인
// 			if(getCookieValue("REMEMBERME") == "Y"){
			if(Cookies.get("REMEMBERME") == "Y"){
				$('#inputEmail').val(getCookieValue("USERNM"))
// 				$('input:checkbox').remove('checked')
				$('input[type=checkbox]').prop('checked', true)
			}


			$('#signIn').on('click', function(){

				if($('input[type=checkbox]').prop('checked') == true){
					Cookies.set('REMEMBERME', 'Y');
					Cookies.set('USERNM', $('#inputEmail').val());
					$('#inputEmail').val(Cookies.get("USERNM"));

					
				}else{
// 					$('#inputEmail').val("");
					Cookies.remove('REMEMBERME');
					Cookies.remove('USERNM');
				}

				// submit 처리
				$('#loginForm').submit();
			})






			
		})


		
		// 버튼클릭시 설정된 쿠키들을 console log에 출력하는 함수
		function showCookieInfo(){
			console.log("USERNM = " + getCookieValue("USERNM"));
			console.log("REMEMBERME = " + getCookieValue("REMEMBERME"));
			console.log("TEST = " + getCookieValue("TEST"));
			console.log("NOTEXISTS_COOKIE = " + getCookieValue("NOTEXISTS_COOKIE"));
// 			setCookie("testaddCookie", "shs", 10);
		}



    
		// 쿠키 setting을 하는 함수
		function setCookie(cookieName, cookieValue, expires){
			//"USERNM=brown; path=/; experis=Wed, Oct 07 2020 09:43:14 GMT"
			var today = new Date();
			
			// 현재날짜에서 미래로 + expires만큼 한 날짜 구하기
			today.setDate(today.getDate() + expires);
			
			document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toString(); 
			console.log(document.cookie)
		}


		// 설정된 쿠키의 값들을 반환하는 함수
		function getCookieValue(cookieName){
			var cookies = document.cookie.split("; ");
			for(var info in cookies){
				var cookie = cookies[info].split("=");
				if(cookie[0] == cookieName) return cookie[1];
			}
			return "";
		}

		

		// 해당쿠키의 expires속성을 과거의 날짜로 변경
		function deleteCookie(cookieName){
			setCookie(cookieName, "", (-1))
		}
		

		
		function setSession(){
			sessionStorage.setItem("JSESSIONID", "testCode")
			alert(sessionStorage.getItem("JSESSIONID"))
		}

		function getSession(){
			var session = sessionStorage.key(0)
			alert(session)
		}


		
    </script>
    
    
    
    
    
  </head>

  <body>

    <div class="container">

      <form id="loginForm" class="form-signin" action="<%= request.getContextPath() %>/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="userId" value="brown" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" value="passBrown" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="signIn">Sign in</button>
        <input class="btn btn-lg btn-primary btn-block" type="button" onclick="showCookieInfo()" value="showCookieInfo"/>
      </form>

    </div> <!-- /container -->

  </body>
</html>
