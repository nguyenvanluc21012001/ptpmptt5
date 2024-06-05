<%@page import="com.laptrinhjavaweb.model.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Object obj = session.getAttribute("user");
	user user = null;
	if (obj != null)
		user = (user) obj;
	%>
	<!-- End Navbar -->
	<div class="container">
		<div class="text-center">
			<h1>THÔNG TIN ĐƠN HÀNG</h1>
		</div>
		<form class="form" action="dangkydonhang" method="get">
			<input type="hidden" name="user_id" value="<%=user.getUser_id()%>">
			<c:forEach items="${selectedLucValues}" var="selectedLucValue">
				<input type="hidden" name="listParam" value="${selectedLucValue}">
			</c:forEach>
			<div class="mb-3">
				<label for="ten" class="form-label">Tên<span class="red">*</span></label>
				<input type="text" class="form-control" id="ten" name="ten"
					required="required">
			</div>
			<div class="mb-3">
				<label for="sdt" class="form-label">Số điện thoại<span
					class="red">*</span></label> <input type="text" class="form-control"
					id="sdt" name="sdt">
			</div>
			<div class="mb-3">
				<label for="diachi" class="form-label">Địa chỉ<span
					class="red">*</span></label> <input type="text" class="form-control"
					id="diachi" name="diachi">
			</div>
			<hr />
			<input class="btn btn-primary form-control" type="submit"
				value="Đăng ký" name="submit" id="submit" />
		</form>
	</div>
	<div style="height: 350px"></div>
</body>
</html>