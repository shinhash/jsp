<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 1. import 태그를 사용한 위치에 url에서 반환하는 값을 삽입
	 2. 단 var 속성을 설정하게 되면 url에서 반환하는 값을 var변수에 저장 -->


<!--  2 -->
<!-- taglib는 개별적으로 주석처리해야 한다. -->
<!-- 만약 통합적으로 주석처리 한다면 무한 리로딩이 발생하는 현상이 발생할 수 있다. -->
<!-- 		<c:import var="naver_html" url="https://www.naver.com"></c:import> -->
<%-- 	${naver_html}  --%>

<!-- url="https://www.naver.com?query=covid" -->
<c:import var="naver_html" url="https://search.naver.com/search.naver">
	<c:param name="query" value="hi"></c:param>
</c:import>
${naver_html}<br>