
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa sản phẩm</title>
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

button[type="button1"] {
	background-color: white;
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
	background-color: #f2f2f2;
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
/* Định dạng phần tiêu đề của bảng */
.table th, .table td {
	padding: 10px;
	text-align: center;
}

.table {
	width: calc(100% - 100px); /* 100% - 2 x 30px = 100% - 60px */
	margin: 0 50px; /* Cách lề trái và phải 30px */
	border-collapse: collapse;
}

.red {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<div class="text-center" style="padding-top: 30px">
			<h1>SỬA SẢN PHẨM</h1>
		</div>
		<form class="form" action="suasanphamxong" method="get">
			<input type="hidden" name="sanPhamId" value="${sanPham.getId()}">
			<div class="mb-3">
				<label for="tieude" class="form-label">Tiều đề<span
					class="red">*</span></label> <input type="text" class="form-control"
					id="tieude" name="tieude" required="required">
			</div>
			<div class="mb-3">
				<label for="matKhau" class="form-label">Danh mục</label> <select
					class="form-control" id="danhmuc" name="danhmuc"
					required="required">
					<option></option>
					<c:forEach items="${danhMucList}" var="danhMuc">
						<option value="${danhMuc.getId()}">
							${danhMuc.getTen()}
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3">
				<label for="gia" class="form-label">Giá <span class="red">*</span></label>
				<input type="text" class="form-control" id="gia" name="gia"
					required="required">
			</div>
			<div class="mb-3">
				<label for="giaban" class="form-label">Giá bán<span
					class="red">*</span></label> <input type="text" class="form-control"
					id="giaban" name="giaban" required="required">
			</div>
			<div class="mb-3">
				<label for="giagoc" class="form-label">Giá gốc<span
					class="red">*</span></label> <input type="text" class="form-control"
					id="giagoc" required="required" name="giagoc">
			</div>
			<div class="mb-3">
				<label for="hinhanh" class="form-label">Hình ảnh</label> <select
					class="form-control" id="hinhanh" name="hinhanh">
					<option></option>
					<c:forEach items="${anhList}" var="anh">
						<option value="${anh.getId()}">
							${anh.getHinhAnh()}
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3">
				<label for="motasanpham" class="form-label">Mô tả sản phẩm</label> <input
					type="tel" class="form-control" id="motasanpham" name="motasanpham">
			</div>
			<hr />
			<input class="btn btn-primary form-control" type="submit"
				value="Sửa sản phẩm" name="submit" id="submit" />
		</form>
	</div>
</body>
</html>