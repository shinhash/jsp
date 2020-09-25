<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


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
	
	<!-- action : 요청을 보낼 경로
		 method : 요청 방식 (form 에서는 GET, POST 두가지만 가능하며 DEFAULT는 GET) 
	-->
	<form action="/jsp/request/getRequestResponse.jsp" method="GET">

		user id : <input type="text" id="inputId1" name="userId" value="brown">
		<br>
		user id : <input type="text" id="inputId2" name="userId" value="sally">
		<br>
		password : <input type="password" id="inputPass" name="inputPass" value="pass1234">
		<br>
		
		<input type="submit" value="전송">

	</form>
	
	
	
	
</body>
</html>