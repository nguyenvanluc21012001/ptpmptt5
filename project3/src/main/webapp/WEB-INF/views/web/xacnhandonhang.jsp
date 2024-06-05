<%@page import="com.laptrinhjavaweb.model.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
	Object obj = session.getAttribute("user");
	user user = null;
	if (obj != null)
		user = (user) obj;
	%>
	<div class="container-fluid text-center"
		style="height: 40px; margin: 30px">
		<h3>ĐƠN HÀNG</h3>
	</div>
	<!-- giỏ hàng  -->
	<form action="hoanthanh" method="get" id="hoanthanh">
		<input type="hidden" name="user_id" value="<%=user.getUser_id()%>">
		<div class="row">
			<c:forEach items="${ctdh}" var="chitietdonhang">
				<div class="row col-lg-6"
					style="padding-top: 20px; padding-bottom: 20px">
					<div class="col-lg-3"></div>
					<div class="col-lg-2">
						<a href="#"><img class="card-img-top"
							src="${chitietdonhang.getSanPham().getAnh().getHinhAnh()}" alt=""></a>
					</div>
					<div class="col-lg-3">
						<h4>${chitietdonhang.getSanPham().getTieuDe()}</h4>
						<h6>${chitietdonhang.getSanPham().getGiaBan()}</h6>
					</div>

					<div class="row col-lg-6"
						style="padding-top: 20px; padding-bottom: 20px"></div>
				</div>
				<div class="row col-lg-6"
					style="padding-top: 20px; padding-bottom: 20px">
					<div class="row col-lg-2">
						<h5>${chitietdonhang.getSoLuong()}</h5>
					</div>

				</div>
			</c:forEach>
			<div class="row col-lg-6"
				style="padding-top: 20px; padding-bottom: 20px">
				<div class="col-lg-6"></div>
				<div class="col-lg-4">
					<h4>Tổng tiền :</h4>
				</div>
				<div class="col-lg-1"></div>
				<div class="row col-lg-1"
					style="padding-top: 20px; padding-bottom: 20px"></div>
			</div>
			<div class="row col-lg-6"
				style="padding-top: 20px; padding-bottom: 20px">
				<div class="row col-lg-2">
					<h4>${tongtien}đ</h4>
				</div>

			</div>
			<div class="row col-lg-4"
				style="padding-top: 20px; padding-bottom: 20px"></div>
			<div class="text-center ">

				<button type="submit">
					<!--<a href="https://sandbox.vnpayment.vn/merchantv2/Users/Login.htm">Thanh toán</a>-->
					Thanh toán
				</button>
			</div>
		</div>
	</form>
	<div style="height: 200px"></div>
</body>
</html>