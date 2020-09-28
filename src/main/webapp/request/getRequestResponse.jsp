<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	request.setCharacterEncoding("UTF-8");
	String comWay = request.getParameter("posable");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>



</head>
<body>

	<h1><%= request.getMethod() %></h1>
	userId 파라미터는 brown, sally 두개를 보내지만 getParamater를 호출하면
	첫번째 파라미터 값을 반환 <br>
	request.getParameter("userId") : <%= request.getParameter("userId") %>

	request.getParameterValues("userId") : 
	<%
		String[] userIds = request.getParameterValues("userId");
		for(int i=0; i<userIds.length; i++){
			String temp = userIds[i];
		%>
		
		<%= temp %>
		<%	
		}
	%><br><br>
	
	request.getParameterMap("userId") : <%= request.getParameterMap() %><br>
	
	
	요청에 존재하는 파라미터 이름 출력하기<br>
	
	request.getParameterNames() : <br>
	<%
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()){
			%>
			
			<%= paramNames.nextElement() %>
			<br>
			<%
		}
	
	%>	
	
	
	요청 방식
	<br>
	<%= comWay.toUpperCase() %>
		

</body>
</html>