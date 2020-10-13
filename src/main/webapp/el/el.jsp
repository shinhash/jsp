<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	el.jsp
	
	<form action="<%= request.getContextPath() %>/el" method="post">
		<% 
			String scope = request.getParameter("scope");
		
			String requestVal= "";
			String sessionVal = "";
			String applicationVal = "";
			
			if(scope == null || scope.equals("requestValue")){
				requestVal = "checked";
			}
			else if(scope.equals("sessionValue")){
				sessionVal = "checked";
			}
			else if(scope.equals("applicationValue")){
				applicationVal = "checked";
			}
		%>		
		<br>
	
		request (request)		: <input type="radio" name="scope" value="requestValue" <%= requestVal %>/> <br>
		session	(request, session)	: <input type="radio" name="scope" value="sessionValue" <%= sessionVal %>/> <br>
		application (request, session, application)	: <input type="radio" name="scope" value="applicationValue" <%= applicationVal %>/> <br>
		<button type="submit">전송</button>
	</form>
	
	attr = ${attr} (page -> request -> session -> application)<br>
	
	requestScope : ${requestScope.attr}<br>
	sessionScope : ${sessionScope.attr}<br>
	applicationScope : ${applicationScope.attr}<br>
	<br>
	<br>
	scope parameter : <%= request.getParameter("scope") %><br>
	scope parameter : ${param.scope}<br>
	<br>
	<br>
	Cookie : <%= request.getCookies()[0].getName() %><br>
	Cookie : ${cookie.USERID.value}<br>
	<br>
	<br>
	map.key<br>
	map.brown : ${map.brown}<br>
	map.sally : ${map.sally}<br>
	<br>
	<br>
	list[인덱스] ==> MemberVO, list[인덱스].필드명<br>
	rangerslist[0] : ${rangerslist[0].userid}<br>
	rangerslist[1] : ${rangerslist[1].userid}<br>
	
</body>
</html>