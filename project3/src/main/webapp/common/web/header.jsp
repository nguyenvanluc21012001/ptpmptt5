<%@page import="com.laptrinhjavaweb.model.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">RM shop</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<form class="form-inline ml-auto" action="timkiemsanpham">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search" name="timkiemsanpham">
					<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Tìm
						kiếm</button>
				</form>
				<!-- <li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li> -->
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<form action="trang-chu" method="GET" style="display: inline;">
						<button type="submit" class="highlight1">Home</button>
					</form>
				</div>
				<li class="nav-item">
					<%
					Object obj = session.getAttribute("user");
					user user = null;
					if (obj != null)
						user = (user) obj;

					if (user == null) {
					%> <a class="nav-link" href="<c:url value="/dang-nhap"/>">Đăng
						nhập</a> <%
 } else {
 %>
					<div class="row text-center" style="margin-left: 0.25em">
						<div class="row">
							<b><%=user.getTenDangNhap()%></b>
						</div>
						<div class="row">
							<a class="nav-link" style="white-space: nowrap;"
								href="<c:url value="/dang-xuat"/>"> Đăng xuất </a>
						</div>
					</div> <%
 }
 %>
				</li>
				<%--
				<li class="nav-item"><a class="nav-link" href="<c:url value="/dang-nhap"/>">Đăng nhập</a></li>
				<li ><a class="nav-link" href="#">Services</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Contact</a></li> -->
			</ul>
		</div> 
		<%-- <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <form class="form-inline ml-auto">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Tìm kiếm</button>
                </form>
            </li>
            <li class="nav-item active"><a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a></li>
            <li class="nav-item">
                <%
                Object obj = session.getAttribute("user");
                user user = null;
                if (obj != null)
                    user = (user) obj;

                if (user == null) {
                %>
                <a class="nav-link" href="<c:url value="/dang-nhap"/>">Đăng nhập</a>
                <% } else { %>
                <div class="user-info">
                    <span class="username"><strong><%=user.getTenDangNhap()%></strong></span>
                    <a class="nav-link logout-link" href="dang-xuat">Đăng xuất</a>
                </div>
                <% } %>
            </li>
        </ul>
    </div> --%>
		</div>
</nav>