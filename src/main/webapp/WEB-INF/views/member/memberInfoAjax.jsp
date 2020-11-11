<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link href="${cp}/css/bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<link href="${cp}/css/dashboard.css" rel="stylesheet">
<link href="${cp}/css/blog.css?v=2" rel="stylesheet">


<style type="text/css">
	img{
		width: 300px;
		height: 300px;
	}
</style>


<script type="text/javascript">

	// client side에서는 서버사이드 변수나 값을 사용가능


	$(document).ready(function(){

		ajaxView("${param.userid}");

// 		$("#updateBtn").on("click", function(){
// 			document.location = "/memberUpdate/view?userid=${memVO.userid}";			
// 		});

		$("#downBtn").on("click", function(){
			
			document.location = "/profileDownload/down?userid=${param.userid}";			
		})

	});


	// ajax는 클라이언트 사이드의 스크립트이다.
	function ajaxView(id){

		$.ajax({
			url		: "/memberInfo/ajaxRes",
			data	: {userid : id},
			method	: "post",
			success	: function(res){

				var dump = 1;
				
				$("#profileImg").attr("src", "${cp }/profileImg/view?userid=${param.userid }");
				$("#userid").text(res.memVO.userid);
				$("#usernm").text(res.memVO.usernm);
				$("#alias").text(res.memVO.alias);
				$("#addr1").text(res.memVO.addr1);
				$("#addr2").text(res.memVO.addr2);
				$("#zipcode").text(res.memVO.zipcode);
				$("#reg_dt").text(res.memVO.reg_dt);
			}
		});
	}


</script>




<div class="col-sm-9 blog-main">


	<form class="form-horizontal" role="form">

		<div class="form-group">
			<label for="req_dt" class="col-sm-2 control-label">사용자 사진</label>
			<div class="col-sm-10">
				<label class="control-label"><img id="profileImg"/></label><br><br>
				<button type="button" class="btn btn-default" id="downBtn">다운로드</button>
			</div>
		</div>
		
		

		<div class="form-group">
			<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
			<div class="col-sm-10">
				<label class="control-label" id="userid"></label>
			</div>
		</div>



		<div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
			<div class="col-sm-10">
				<label class="control-label" id="usernm"></label>
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">별명</label>
			<div class="col-sm-10">
				<label class="control-label" id="alias"></label>
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
				<label class="control-label" id="addr1"></label>
			</div>
		</div>




		<div class="form-group">
			<label for="addr2" class="col-sm-2 control-label">상세주소</label>
			<div class="col-sm-10">
				<label class="control-label" id="addr2"></label>
			</div>
		</div>
		
		
		
		<div class="form-group">
			<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
			<div class="col-sm-10">
				<label class="control-label" id="zipcode"></label>
			</div>
		</div>

		
		
		<div class="form-group">
			<label for="req_dt" class="col-sm-2 control-label">등록일자</label>
			<div class="col-sm-10">
				<label class="control-label" id="reg_dt"></label>
			</div>
		</div>
		
<%-- 		<fmt:formatDate value="${memVO.reg_dt }" pattern="yyyy-MM-dd"/> --%>
		
		
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="btn btn-default" id="updateBtn">사용자 정보수정</button>
			</div>
		</div>
		
		
	</form>	
</div>

		


    