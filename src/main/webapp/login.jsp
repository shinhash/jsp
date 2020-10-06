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
    
    
    
    <script>
		function getCookieValue(cookieName){
			var cookies = document.cookie.split("; ")
			
			for(var i in cookies){
				var cookieInfo = cookies[i].split("=")
				if(cookieInfo[0] == cookieName){
					return cookieInfo[1];
				}
			}
			return ""
		}

		
		function showCookieInfo(){
			var userName = getCookieValue("USERNM");
			var remember = getCookieValue("REMEMBERME");
			var undefind = getCookieValue("NOTEXISTS_COOKIE");

			console.log("USERNM = " + userName)
			console.log("REMEMBERME = " + remember)
			console.log("NOTEXISTS_COOKIE = " + undefind)
		}


		
    </script>
    
    
    
    
    
  </head>

  <body>

    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <input class="btn btn-lg btn-primary btn-block" type="button" onclick="showCookieInfo()" value="showCookieInfo"/>
      </form>

    </div> <!-- /container -->

  </body>
</html>
