<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/js.cookie-2.2.1.min.js"></script>
<script>
	$(function(){


		if(Cookies.get("lang") == null){
			Cookies.set("lang", "ko")
			$("#selectBox option[id=ko]").prop("selected", true)
		}else{
			$("#selectBox option[id="+Cookies.get("lang")+"]").prop("selected", true)
		}

		$("#selectBox").on("change", function(){

			lang = $("#selectBox option:selected").attr("id");
			Cookies.set("lang", lang)
			url = "<%= request.getContextPath() %>/jstl/jstl_fmt.jsp?";
			document.location.href = url + "lang=" + lang;

// 			$("#langForm").attr("action", "/jstl/jstl_fmt.jsp");
// 			$("#langForm").attr("method", "post");
// 			$("#langForm").submit();
		})


	})
</script>


</head>
<body>


	<%-- 
		1. jquery 라이브러리 추가
		2. select box 생성
				option 3가지 언어(ko, en, ja) 선택가능
		3. 페이지가 로딩이 되었을 때 사용자가 요청한 언어로
			option 태그가 선택이 된 상태로 표현
		4. 만약에 사용자가 언어 설정 파라미터를 보내지 않았을 경우 기본값으로 한국어가 설정되게 끔
		5. option 태그가 바뀌면 자동으로 jstl_fmt.jsp로 재요청
	
	 --%>



	<% 
		String param = request.getParameter("lang");
		System.out.println(param);
	%>
	<!-- locale 정보를 변경 -->
	<fmt:setLocale value="${param.lang}"/>
	
	
	
	<!-- 사용할 리소스 번들 설정(리소스번들명_로케일.properties) -->
	<fmt:bundle basename="kr.or.ddit.resource.message">
		<fmt:message key="GREETING" var="greeting" />[ ${greeting} ]<br>
		
		<%
			request.setAttribute("userId", "koko");
		%>
		<fmt:message key="LOGIN_MSG">
			<fmt:param value="[ ${userId} ]" />
		</fmt:message>
	</fmt:bundle>
	
	<h3>setBundle</h3>
	
	
	<!-- set bundle : 번들 메시지를 변수에 저장하여 message 태그에서 사용하게끔 하는 태그 -->
	<fmt:setBundle basename="kr.or.ddit.resource.message" var="msg"/>
	
	
	
	<fmt:message key="GREETING" bundle="${msg}"/><br>
	
	
	<fmt:message key="LOGIN_MSG" bundle="${msg}">
		<fmt:param value="${userId}" />
	</fmt:message>
	<br>
	
	
	
	<form id="langForm">
	select language :
		<select id="selectBox" name="lang">
		
			
			<option id="ko">korea</option>
			<option id="en">english</option>
			<option id="ja">japan</option>
			
		</select>
	
	</form>
	
	
	
	
	
</body>
</html>