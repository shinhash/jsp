<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="${cp }/js/jquery-3.5.1.min.js"></script>
<link href="${cp }/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="${cp }/css/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="${cp }/css/dashboard.css" rel="stylesheet">
<link href="${cp }/css/blog.css" rel="stylesheet">


<style type="text/css">
	img{
		width: 300px;
		height: 300px;
	}
</style>


<script type="text/javascript">
	$(document).ready(function(){

		$("#updateBtn").on("click", function(){
// 			var userid = $("#userid").text();
// 			document.location = "/memberUpdate?userid=" + userid;
			document.location = "/memberUpdate/view?userid=${memVO.userid}";			
		});



		$("#downBtn").on("click", function(){
// 			var userid = $(this).data("userid");
// 			document.location = "/profileDownload?userid=" + userid;
			document.location = "/profileDownload/down?userid=${memVO.userid}";			
		})
		
		

	});


</script>




</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		
		<%@ include file="/WEB-INF/views/layout/header.jsp" %>
		
	</nav>
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/WEB-INF/views/layout/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form class="form-horizontal" role="form">

					<div class="form-group">
						<label for="req_dt" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
<%-- 							<label class="control-label"><img src="${cp }/profile/${memVO.filename }" alt="사진"/></label> --%>
							<label class="control-label"><img src="${cp }/profileImg/view?userid=${memVO.userid }" /></label><br><br>
							<button type="button" class="btn btn-default" id="downBtn" data-userid="${memVO.userid }">다운로드</button>
						</div>
					</div>
					
					

					<div class="form-group">
						<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label class="control-label" id="userid">${memVO.userid }</label>
						</div>
					</div>



					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${memVO.usernm }</label>
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label">${memVO.alias }</label>
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<label class="control-label">********</label>
						</div>
					</div>
					
					
					
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label">${memVO.addr1 }</label>
						</div>
					</div>




					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label">${memVO.addr2 }</label>
						</div>
					</div>
					
					
					
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${memVO.zipcode }</label>
						</div>
					</div>
					
					
					
					<div class="form-group">
						<label for="req_dt" class="col-sm-2 control-label">등록일자</label>
						<div class="col-sm-10">
							<label class="control-label"><fmt:formatDate value="${memVO.reg_dt }" pattern="yyyy-MM-dd"/> </label>
						</div>
					</div>
					
					
					
					
					
					
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default" id="updateBtn">사용자 정보수정</button>
						</div>
					</div>




				</form>
			</div>
		</div>
	</div>
</body>
</html>
    