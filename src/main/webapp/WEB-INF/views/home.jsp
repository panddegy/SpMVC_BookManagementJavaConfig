<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/include-head.jspf" %>
</head>
<style>

</style>
<body>
<header>
	<%@include file="/WEB-INF/views/include/include-header.jspf" %>
</header>
<section>
	<c:choose>
		<c:when test="${BODY=='LOGIN'}">
			<%@include file="/WEB-INF/views/bodies/login.jspf" %>
		</c:when>
		<c:when test="${BODY=='HOME'}">
			<%@include file="/WEB-INF/views/bodies/home.jspf" %>
		</c:when>
		<c:when test="${BODY=='STATUS'}">
			<%@include file="/WEB-INF/views/bodies/status.jspf" %>
		</c:when>
		<c:when test="${BODY=='BOOKLIST'}">
			<%@include file="/WEB-INF/views/bodies/book/book-list.jspf" %>
		</c:when>
		<c:when test="${BODY=='BOOKINSERT'}">
			<%@include file="/WEB-INF/views/bodies/book/book-insert.jspf" %>
		</c:when>
		<c:when test="${BODY=='BOOKUPDATE'}">
			<%@include file="/WEB-INF/views/bodies/book/book-insert.jspf" %>
		</c:when>
		<c:when test="${BODY=='BOOKINFO'}">
			<%@include file="/WEB-INF/views/bodies/book/book-info.jspf" %>
		</c:when>
		<c:when test="${BODY=='USERLIST'}">
			<%@include file="/WEB-INF/views/bodies/user/user-list.jspf" %>
		</c:when>
		<c:when test="${BODY=='USERINSERT'}">
			<%@include file="/WEB-INF/views/bodies/user/user-insert.jspf" %>
		</c:when>
		<c:when test="${BODY=='USERUPDATE'}">
			<%@include file="/WEB-INF/views/bodies/user/user-insert.jspf" %>
		</c:when>
		<c:when test="${BODY=='USERINFO'}">
			<%@include file="/WEB-INF/views/bodies/user/user-info.jspf" %>
		</c:when>
		<c:when test="${BODY=='RENTLIST'}">
			<%@include file="/WEB-INF/views/bodies/rent/rent-list.jspf" %>
		</c:when>
		<c:when test="${BODY=='RETURNLIST'}">
			<%@include file="/WEB-INF/views/bodies/rent/rent-list.jspf" %>
		</c:when>
		<c:when test="${BODY=='RENTINSERT'}">
			<%@include file="/WEB-INF/views/bodies/rent/rent-insert.jspf" %>
		</c:when>
		<c:when test="${BODY=='RENTUPDATE'}">
			<%@include file="/WEB-INF/views/bodies/rent/rent-insert.jspf" %>
		</c:when>
		<c:when test="${BODY=='RENTINFO'}">
			<%@include file="/WEB-INF/views/bodies/rent/rent-info.jspf" %>
		</c:when>
	</c:choose>
</section>
</body>
</html>






























