<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>

		$(function(){

				$('#sendTest').on('click', function(){
	
	
					way = $('.doGetOrPost:checked').val()
					
					$('#formTest').attr('action', '<%= request.getContextPath() %>/request/getFormWayTest.jsp');
					$('#formTest').attr('method', way);
					$('#formTest').submit();
					
				})




				$('#sendView').on('click', function(){

					way = $('#formView1 :checked').val()
					
					$('#formView1').attr('action', '<%= request.getContextPath() %>/request/getRequestResponse.jsp');
					$('#formView1').attr('method', way);
					$('#formView1').submit();
				
				})

		})
	
	</script>

</head>
<body>
	<!-- 파라미터 : client가 서버로 요청을 보낸때 추가적으로 보낸 값
				ex : 로그인 요청시 : 사용자 id, 비밀번호 
		파라미터는 내부적으로 Map<String, String[]> 객체로 관르를 한다.
							파라미터이름, 파라미터값들 
							==> 동일한 이름의 파라미터를 여러개 보낼수 있다.
		
		request 겍체에 있는 파라미터 관련 메서드 4가지
		
		getParamater(String param) : param에 해당하는 파라미터 값을 조회한다.
									 파라미터 맵에서 첫번째 값을 변환
		
		String[] getParamaterValues(String param) : param에 해당하는 모든 파라미터 값을 반환한다.
		
		Map<String, String[]> getParamaterMap() : request 객체에 생성된 파라미터 맵을 반환
		
		Enumeration<String> getParamaterNames() : request 객체에 답긴 모든 파라미터 이름을 반환						
							
							
							
						
	-->
	
	
	<!-- 한글 파라미터 설정
		get : server.xml <Connector URIEncoding="utf-8"
		post : request.setCharacterEncoding("utf-8")
				requset.getParameter() 메서드를 호출하기 전에 설정 해야함 -->
	
	<!-- action : 요청을 보낼 경로
		 method : 요청 방식 (form 에서는 GET, POST 두가지만 가능하며 DEFAULT는 GET) 
	-->
	<form id="formView1" action="<%= request.getContextPath() %>/request/getRequestResponse.jsp" method="">
	
		<input type="radio" value="get" name="posable" checked>get
		<input type="radio" value="post" name="posable">post
		<br>

		user id : <input type="text" id="inputId1" name="userId" value="브라운">
		<br>
		user id : <input type="text" id="inputId2" name="userId" value="셀리">
		<br>
		password : <input type="password" id="inputPass" name="inputPass" value="pass1234">
		<br>
		
		<input type="button" value="전송" id="sendView">

	</form>
	
	<br><br>
	<br><br>
	<br><br>
	GET POST 두가지를 선택할 수 있는 라디오 버튼 생성
	FORM 전송시 사용자가 GET, POST 방식을 지정할수 있도록 바꿔주는 기능
	
	<br><br>
	<form id="formTest">
	
	
		<input class="doGetOrPost" type="radio" value="get" name="posable" checked>get
		<input class="doGetOrPost" type="radio" value="post" name="posable">post
	
		<br>
		<input type="button" value="send" id="sendTest">
		
	</form>
	
	
	
</body>
</html>