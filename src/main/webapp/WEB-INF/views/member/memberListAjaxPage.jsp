<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link href="${cp}/css/bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<link href="${cp}/css/dashboard.css" rel="stylesheet">
<link href="${cp}/css/blog.css?v=2" rel="stylesheet">


<script>

	// 해당 html이 로딩이 완료 되었을 때 실행되는 이벤트 핸들러 함수
	$(document).ready(function(){

// 		memberListAjax(1);
		memberListAjaxHTML(1);


		$("#memberInfo").on("click", "tr", function(){
			var userid = $(this).data("userid")
			console.log("userid = " + userid)
			document.location = "/memberInfo/ajaxView?userid=" + userid;
		});


		$("#memberRegistButton").on("click", function(){
			document.location = "/memberRegist/view"
		});

	})
	
	
	
	
	
	// json으로 데이터를 반환받는 Ajax
	function memberListAjax(p){
		// ajax call을 통해 1페이지에 해당하는 사용자정보를 json으로 받는다.
		// ajax는 클라이언트 사이드이기 때문에 tag라이브러리(jstl)를 적용할 수 없다.(jstl의 적용 사이드는 서버 사이드 이다.)
		$.ajax({
			url			: "/memberList/listAjax",
			data		: {pageNum : p, pageSize : 5}, // form 형태 타입
			//data		: "pageNum=1&pageSize=5", // query string 형태 타입
			//data		: JSON.stringify({pageNum : 1, pageSize : 5}), // json 형태 타입 
							// ==> controller에서 requestBody를 사용해야한다. JSON <---> JAVA OBJECT(마샬링 or 언마샬링)
			method		: "get",
			success		: function(res){
				
				var temp = 1;

				// list navigation
				var pagination = "";
				for(var i=1; i<=res.pageCnt; i++){
					if(res.pageVO.pageNum == i){
						pagination += "<li class='active'><span>"+i+"</span></li>";
					}else{
// 						pagination += "<li><a href='${pageContext.request.contextPath}/memberList/listAjaxPage?pageNum="+i+"'>"+i+"</a></li>";
// 						pagination += "<li><a href='javascript:memberListAjax("+i+")'>"+i+"</a></li>";
						pagination += "<li><a href='javascript:memberListAjaxHTML("+i+")'>"+i+"</a></li>";
					}
				}
				

				// memberList tbody 영역에 들어갈 html문자열 생성
				var tbody = "";
				for(var i=0; i<res.memList.length; i++){
					var member = res.memList[i];
					tbody += "<tr data-userid='"+member.userid+"'>";
					tbody += "	<td>"+member.userid+"</td>";
					tbody += "	<td>"+member.usernm+"</td>";
					tbody += "	<td>"+member.alias+"</td>";
					tbody += "	<td>"+member.fmtReg_dt+"</td>";
					tbody += "</tr>";
				}

				
				$("#memberInfo").html(tbody);
				$(".pagination").html(pagination);
				
			}
		});
	}








	// jsp의 html로 데이터를 반환받는 Ajax
	function memberListAjaxHTML(p){
		
		// ajax call을 통해 1페이지에 해당하는 사용자정보를 json으로 받는다.
		// ajax는 클라이언트 사이드이기 때문에 tag라이브러리(jstl)를 적용할 수 없다.(jstl의 적용 사이드는 서버 사이드 이다.)
		$.ajax({
			url			: "/memberList/listAjaxHTML",
			data		: {pageNum : p, pageSize : 5}, // form 형태 타입
			//data		: "pageNum=1&pageSize=5", // query string 형태 타입
			//data		: JSON.stringify({pageNum : 1, pageSize : 5}), // json 형태 타입 
							// ==> controller에서 requestBody를 사용해야한다. JSON <---> JAVA OBJECT(마샬링 or 언마샬링)
			method		: "get",
			success		: function(res){
				var temp = 1;
				var textHTML = res.split("$$$$$$$$$$$$$$$$$$$$CHAPTER$$$$$$$$$$$$$$$$$$$$")

				// memberList tbody 영역에 들어갈 html문자열 생성
				$("#memberInfo").html(textHTML[0]);
				$(".pagination").html(textHTML[1]);
				
			}
		});
	}
	
</script>

tiles : memberListAjax.jsp

<div class="row">
	<div class="col-sm-8 blog-main">
	
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				
				<tbody id="memberInfo">
				
				</tbody>
				
				
			</table>
		</div>

		<a class="btn btn-default pull-right" id="memberRegistButton">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
			
			</ul>
		</div>
		
	</div>
</div>