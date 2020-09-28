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

	dispacherView.jsp
	
	<table border="1">
		<tr>
			<th>순번</th>
			<th>이름</th>
		</tr>



		<%
		if(rangers.size() > 0){
			
			for(int i=0; i<rangers.size(); i++){
			%>
				<tr>
					<td><%= i %></td>				
					<td><%= rangers.get(i) %></td>				
				</tr>
			<%
			}
		}
		%>
		<!-- request 객체에 저장된 rangers속성을 이용하여 tr, td 그리고 ranger 이름 출력 -->
	</table>

</body>
</html>