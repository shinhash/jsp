<%@page import="kr.or.ddit.member.model.JobVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<JobVO> jobList = (List<JobVO>) request.getAttribute("jobList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>JOB_ID</th>
			<th>JOB_TITLE</th>
			<th>MIN_SALARY</th>
			<th>MAX_SALARY</th>
			<th>CREATE_DATE</th>
			<th>UPDATE_DATE</th>
		</tr>
	<%
		if(jobList != null || jobList.size() > 0){
			for(int i=0; i<jobList.size(); i++){
			%>
			
			<tr>
				<td><%= jobList.get(i).getJOB_ID() %></td>
				<td><%= jobList.get(i).getJOB_TITLE() %></td>
				<td><%= jobList.get(i).getMIN_SALARY() %></td>
				<td><%= jobList.get(i).getMAX_SALARY() %></td>
				<td><%= jobList.get(i).getCREATE_DATE() %></td>
				<td><%= jobList.get(i).getUPDATE_DATE() %></td>
			</tr>
			<%
			}	
		}
	%>
	</table>

</body>
</html>