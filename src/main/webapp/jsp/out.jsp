<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<String> rangers = (List<String>) request.getAttribute("rangers");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<%
			if(rangers.size() > 0){
				for(String ranger : rangers){
					out.println(ranger);
			%>
<%-- 				<%= ranger %> --%>
				<br>				
				
			<%
				}
			}
			
		%>
	
	</div>



</body>
</html>