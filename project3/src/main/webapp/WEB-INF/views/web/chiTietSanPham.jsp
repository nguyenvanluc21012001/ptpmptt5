<%@page import="com.laptrinhjavaweb.model.user"%>
<%@page import="com.laptrinhjavaweb.model.sanPham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
	integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
	crossorigin="anonymous"></script>
<style type="text/css">
#dam {
	background-color: red;
}
.large-img {
    width: 100%; /* or a specific value like 300px */
    height: auto; /* maintains aspect ratio */
}
</style>
</head>
<body>
	<script>
		var maxValue = parseInt("${kho.getSoLuong()}");
		function decreaseValue() {
			var numberInput = document.getElementById("numberInput");
			var currentValue = parseInt(numberInput.value);
			var newValue = Math.max(currentValue - 1, 0); // Giá trị mới là giá trị hiện tại trừ 1, nhưng không nhỏ hơn 0
			numberInput.value = newValue;
		}

		function increaseValue() {
			var numberInput = document.getElementById("numberInput");
			var currentValue = parseInt(numberInput.value);
			var newValue = Math.min(currentValue + 1, maxValue); // Giá trị mới là giá trị hiện tại cộng 1
			numberInput.value = newValue;
		}
	</script>
	<%
	Object obj = session.getAttribute("user");
	user user = null;
	if (obj != null)
		user = (user) obj;
	%>
	<input type="hidden" name="soluongtoida" value="${kho.getSoLuong()}" />
	<form action="themvaogiohang" method="get">
		<div class="container-fluid text-center" style="margin: 20px">
			<h1>CHI TIẾT SẢN PHẨM</h1>
		</div>
		<div class="row">
			<div class="row col-lg-6">
				<div class="row col-lg-3"></div>
				<div class="row col-lg-8" style="padding-bottom: 20px">
					<a href="#"><img class="card-img-top"
						src="${sanPham.getAnh().getHinhAnh()}" alt=""></a>
				</div>
			</div>
			<div class="row col-lg-4">
				<div class="row col-lg-12">
					<div>
						<h2>${sanPham.getTieuDe()}</h2>
					</div>
				</div>

				<div class="row col-lg-1"></div>
				<div class="row col-lg-6">${sanPham.getGiaBan()}đ</div>
				<div class="row col-lg-5"></div>
				<div>
					<h5>SIZE</h5>
					<div class="btn-group" role="group" aria-label="Basic example">
						<form action="size" method="get">
							<input type="hidden" name="sanpham" value="${sanPham.getId()}" />
							<button type="submit" class="btn btn-primary" value="1"
								name="size">S</button>

						</form>
						<form action="size" method="get">
							<input type="hidden" name="sanpham" value="${sanPham.getId()}" />
							<button type="submit" class="btn btn-primary" value="2"
								name="size">M</button>
						</form>
						<form action="size" method="get">
							<input type="hidden" name="sanpham" value="${sanPham.getId()}" />
							<button type="submit" class="btn btn-primary" value="3"
								name="size">L</button>
						</form>
						<form action="size" method="get">
							<input type="hidden" name="sanpham" value="${sanPham.getId()}" />
							<button type="submit" class="btn btn-primary" value="4"
								name="size">XL</button>
						</form>
						<form action="size" method="get">
							<input type="hidden" name="sanpham" value="${sanPham.getId()}" />
							<button type="submit" class="btn btn-primary" value="5"
								name="size">XXL</button>
						</form>
					</div>
				</div>



				<div class="row col-lg-9">
					<h5>Số lượng còn hàng</h5>
				</div>
				<div class="row col-lg-3">${kho.getSoLuong()}</div>
				<div>
					<h5>Mô tả sản phẩm</h5>
				</div>
				<div style="border: 2px; border-color: black">
					<label>${sanPham.getMoTaSanPham()}</label>
				</div>
				<div class="row col-lg-3"></div>
				<div class="row col-lg-9">
					<div class="container mt-5">
						<div class="row" style="padding-top: -10px; padding-bottom: 20px">
							<div class="col-lg-12 input-group-custom">
								<span>Số lượng:</span>
								<div class="input-group ml-3">
									<div class="input-group-prepend">
										<button class="btn btn-outline-secondary" type="button"
											id="decreaseButton" onclick="decreaseValue()">-</button>
									</div>
									<input type="text" class="form-control text-center" value="0"
										style="height: 40px;" name="soluong" id="numberInput">
									<div class="input-group-append">
										<button class="btn btn-outline-secondary" type="button"
											id="increaseButton" onclick="increaseValue()">+</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div>
						<%
						if (user == null) {
						%>
						<button style="background-color: green;" type="submit">
							<h3>THÊM VÀO GIỎ HÀNG</h3>
						</button>
						<div style="color: red" id="baoLoi">
							bạn cần đăng nhập tài khoản
						</div>
						<%
						} else {
						%>
						<input type="hidden" name="user_id" value="<%=user.getUser_id()%>">
						<input type="hidden" name="sanpham_id" value="${sanPham.getId()}">
						<button style="background-color: green;" type="submit">
							<h4>THÊM VÀO GIỎ HÀNG</h4>
						</button>
						<%
						}
						%>


					</div>
				</div>

			</div>
			<div class="row col-lg-2"></div>
			<hr />
		</div>
	</form>
	<div class=row>
		<div class="row col-lg-6"></div>
		<div class="row col-lg-6">
			<form action="guinhanxet" method="get">
				<label for="exampleFormControlTextarea1" class="form-label"><h6>Bạn
						có thể đánh giá sản phẩm</h6></label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3" placeholder="đánh giá sản phẩm" name=nhanxet></textarea>
				<%
				if (user == null) {
				%>
				<div class="row col-lg-1"
					style="padding-top: 20px; padding-left: 15px">
					<button type="submit" style="background: blue">Gửi</button>
				</div>
				<div style="color: red" id="baoLoi">bạn cần đăng nhập tài
					khoản</div>
				<%
				} else {
				%>
				<input type="hidden" name="user_id" value="<%=user.getUser_id()%>">
				<input type="hidden" name="sanpham_id" value="${sanPham.getId()}">
				<div class="row col-lg-1" style="padding-top: 20px">
					<button type="submit" style="background: blue">Gửi</button>
				</div>
				<%
				}
				%>
				<div class="row col-lg-11"></div>
			</form>
			<div class="row col-lg-3"></div>
			<div class="row col-lg-6" style="padding-bottom: 20px">ĐÁNH GIÁ
				SẢN PHẨM</div>
			<div class="row col-lg-3"></div>
			<c:forEach items="${feedbackList}" var="feedback">
				<div class="row col-lg-12" style="color: red;">
					${feedback.getUser().getTenDangNhap()} :</div>
				<div class="row col-lg-12">${feedback.getNoiDung()}</div>
			</c:forEach>
		</div>
	</div>
	<div style="height: 20px"></div>
</body>
</html>