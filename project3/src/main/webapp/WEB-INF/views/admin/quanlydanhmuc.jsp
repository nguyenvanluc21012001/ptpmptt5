<%@page import="com.laptrinhjavaweb.model.danhMuc"%>
<%@page import="com.laptrinhjavaweb.model.user"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý danh mục</title>
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
<script>
	function them() {
		var form = document.getElementById("them");
		form.submit();
	}
</script>
<style>
.highlight:hover {
	color: red;
}

.row {
	margin-bottom: 15px;
}

/* Ẩn viền đường bao quanh các ô input */
input[type="text"] {
	border: none;
	border-bottom: 1px solid #ccc;
	padding: 5px;
	width: 100%;
}

/* Định dạng phông chữ cho tiêu đề "TÊN DANH MỤC" */
h4 {
	font-size: 24px;
	font-weight: bold;
	color: #333;
}

/* Tạo nút "THÊM" hấp dẫn hơn */
button[type="button"] {
	padding: 5px 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

/* Tạo hiệu ứng khi di chuột vào các nút */
button[type="button"]:hover {
	background-color: #0056b3;
}

/* Tạo viền xung quanh bảng */
.table {
	border: 1px solid #ccc;
	border-collapse: collapse;
	width: 100%;
}

/* Định dạng cho tiêu đề của bảng */
.table th {
	background-color: #cccccc;
	padding: 10px;
	text-align: left;
}

/* Định dạng cho các ô dữ liệu trong bảng */
.table td {
	padding: 8px;
	border-bottom: 1px solid #ccc;
}

/* Tạo hiệu ứng khi di chuột vào các dòng của bảng */
.table tbody tr:hover {
	background-color: #f2f2f2;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	border: 2px solid #007bff; /* Màu viền */
	border-radius: 4px;
	outline: none; /* Loại bỏ viền xung quanh khi focus */
	transition: border-color 0.3s ease-in-out;
	/* Hiệu ứng chuyển đổi màu viền */
}

/* Định dạng khi di chuột vào ô tìm kiếm */
input[type="text"]:hover {
	border-color: #0056b3; /* Màu viền khi di chuột vào */
}

/* Định dạng khi ô tìm kiếm được focus */
input[type="text"]:focus {
	border-color: #00ccff; /* Màu viền khi focus */
	box-shadow: 0 0 8px rgba(0, 123, 255, 0.5); /* Đổ bóng khi focus */
}

body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0; /* Set your desired background color here */
}
</style>
</head>
<body>
	<div class="row">
		<div class="dropdown col-lg-5"
			style="padding-left: 160px; padding-top: 30px">
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-bs-toggle="dropdown">Thư mục</button>
			<ul class="dropdown-menu">
				<li>
					<form action="quanlysanpham" method="GET" style="display: inline;">
						<button type="submit" class="dropdown-item highlight">QUẢN
							LÝ SẢN PHẨM</button>
					</form>
				</li>
				<li>
					<form action="quanlydonhang" method="GET" style="display: inline;">
						<button type="submit" class="dropdown-item highlight">QUẢN
							LÝ ĐƠN HÀNG</button>
					</form>
				</li>
				<li>
					<form action="quanlyphanhoi" method="GET" style="display: inline;">
						<button type="submit" class="dropdown-item highlight">QUẢN
							LÝ PHẢN HỒI</button>
					</form>
				</li>
				<li>
					<form action="home" method="GET" style="display: inline;">
						<button type="submit" class="dropdown-item highlight">QUAY
							LẠI</button>
					</form>
				</li>
			</ul>
		</div>
		<div class="danhmuc col-lg-6" style="padding-top: 30px">
			<h3>QUẢN LÝ DANH MỤC</h3>
		</div>
		<div class="col-lg-1" style="padding-top: 30px">
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
				<div class="container-fluid">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<form action="trang-chu" method="GET" style="display: inline;">
							<button type="submit" class="highlight1">Thoát</button>
						</form>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<div class="row">
		<div class="row col-lg-6" style="max-height: 170px; overflow-y: auto;">
			<div class="row col-lg-12" style="padding-top: 5px">
				<div class="col-lg-2"></div>
				<div class="col-lg-10">
					<h4>TÊN DANH MỤC</h4>
				</div>
			</div>

			<div class="row col-lg-12" style="padding-top: 10px">
				<div class="col-lg-2"></div>
				<div class="col-lg-10">
					<form id="them" method="get" action="themdanhmuc">
						<input type="text" style="padding-right: 100px" name="themdanhmuc">
					</form>
				</div>
			</div>

			<div class="row col-lg-12" style="padding-top: 10px">
				<div class="col-lg-2"></div>
				<div class="col-lg-3">
					<button type="button" onclick="them();">
						<h6>THÊM</h6>
					</button>
				</div>
			</div>


		</div>

		<div class="row col-lg-6">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">STT</th>
						<th scope="col">Tên danh muc</th>
						<th scope="col">Sửa</th>
						<th scope="col">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<%
					int luc = 1;
					%>
					<c:forEach items="${danhMucList}" var="danhMuc">

						<tr>
							<th scope="row"><%=luc++%></th>
							<td class="highlight">${danhMuc.getTen()}</td>
							<td>
								<form action="suadanhmuc" method="GET" style="display: inline;">
									<input type="hidden" name="danhMucId"
										value="${danhMuc.getId()}" />
									<button type="submit" class="highlight1">Sửa</button>
								</form>
							</td>
							<td>
								<form action="xoadanhmuc" method="GET" style="display: inline;">
									<input type="hidden" name="danhMucId"
										value="${danhMuc.getId()}" />
									<button type="submit" class="highlight1">Xóa</button>
								</form>
							</td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>