<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
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
</head>
<body>
	<div class="container" style="border: 2px; margin-top: 100px">
		<div class="row">
			<div class="container-fluid text-center" style="margin: 20px">
				<h1>RM FASHION</h1>
			</div>
			<!--QUẢN LÝ DANH MỤC-->
			<div class="row col-lg-12 quanLyDanhMuc" style="padding: 10px">
				<div class="col-lg-5"></div>
				<div class="col-lg-1">
					<svg xmlns="http://www.w3.org/2000/svg" width="30px" height="30px"
						fill="currentColor" class="bi bi-folder2-open" viewBox="0 0 16 16">
					<path
						d="M1 3.5A1.5 1.5 0 0 1 2.5 2h2.764c.958 0 1.76.56 2.311 1.184C7.985 3.648 8.48 4 9 4h4.5A1.5 1.5 0 0 1 15 5.5v.64c.57.265.94.876.856 1.546l-.64 5.124A2.5 2.5 0 0 1 12.733 15H3.266a2.5 2.5 0 0 1-2.481-2.19l-.64-5.124A1.5 1.5 0 0 1 1 6.14V3.5zM2 6h12v-.5a.5.5 0 0 0-.5-.5H9c-.964 0-1.71-.629-2.174-1.154C6.374 3.334 5.82 3 5.264 3H2.5a.5.5 0 0 0-.5.5V6zm-.367 1a.5.5 0 0 0-.496.562l.64 5.124A1.5 1.5 0 0 0 3.266 14h9.468a1.5 1.5 0 0 0 1.489-1.314l.64-5.124A.5.5 0 0 0 14.367 7H1.633z" />
					</svg>
				</div>
				<div class="col-lg-6">
					<form action="quanlydanhmuc" method="get">
						<button type="submit"
							style="background: none; border: none; color: inherit; cursor: pointer; text-decoration: underline; font: inherit;">
							QUẢN LÝ DANH MỤC</button>
					</form>
				</div>
			</div>


			<!--QUẢN LÝ SẢN PHẨM-->
			<div class="row col-lg-12 quanLySanPham" style="padding: 10px">
				<div class="col-lg-5"></div>
				<div class="col-lg-1">
					<svg xmlns="http://www.w3.org/2000/svg" width="30px" height="30px"
						fill="currentColor" class="bi bi-bag" viewBox="0 0 16 16"> <path
						d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z" />
					</svg>
				</div>
				<div class="col-lg-6">
					<form action="quanlysanpham" method="get">
						<button type="submit"
							style="background: none; border: none; color: inherit; cursor: pointer; text-decoration: underline; font: inherit;">
							QUẢN LÝ SẢN PHẨM</button>
					</form>
				</div>
			</div>


			<!-- QUẢN LÝ ĐƠN HÀNG -->
			<div class="row col-lg-12 quanLyDonHang" style="padding: 10px">
				<div class="col-lg-5"></div>
				<div class="col-lg-1">
					<svg xmlns="http://www.w3.org/2000/svg" width="30px" height="30px"
						fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
					<path
						d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
					</svg>
				</div>
				<div class="col-lg-6">
					<form action="quanlydonhang" method="get">
						<button type="submit"
							style="background: none; border: none; color: inherit; cursor: pointer; text-decoration: underline; font: inherit;">
							QUẢN LÝ ĐƠN HÀNG</button>
					</form>
				</div>
			</div>

			<!-- QUẢN LÝ PHẢN HỒI -->
			<div class="row col-lg-12 quanLyPhanHoi" style="padding: 10px">
				<div class="col-lg-5"></div>
				<div class="col-lg-1">
					<svg xmlns="http://www.w3.org/2000/svg" width="30px" height="30px"
						fill="currentColor" class="bi bi-question-octagon"
						viewBox="0 0 16 16"> <path
						d="M4.54.146A.5.5 0 0 1 4.893 0h6.214a.5.5 0 0 1 .353.146l4.394 4.394a.5.5 0 0 1 .146.353v6.214a.5.5 0 0 1-.146.353l-4.394 4.394a.5.5 0 0 1-.353.146H4.893a.5.5 0 0 1-.353-.146L.146 11.46A.5.5 0 0 1 0 11.107V4.893a.5.5 0 0 1 .146-.353L4.54.146zM5.1 1 1 5.1v5.8L5.1 15h5.8l4.1-4.1V5.1L10.9 1H5.1z" />
					<path
						d="M5.255 5.786a.237.237 0 0 0 .241.247h.825c.138 0 .248-.113.266-.25.09-.656.54-1.134 1.342-1.134.686 0 1.314.343 1.314 1.168 0 .635-.374.927-.965 1.371-.673.489-1.206 1.06-1.168 1.987l.003.217a.25.25 0 0 0 .25.246h.811a.25.25 0 0 0 .25-.25v-.105c0-.718.273-.927 1.01-1.486.609-.463 1.244-.977 1.244-2.056 0-1.511-1.276-2.241-2.673-2.241-1.267 0-2.655.59-2.75 2.286zm1.557 5.763c0 .533.425.927 1.01.927.609 0 1.028-.394 1.028-.927 0-.552-.42-.94-1.029-.94-.584 0-1.009.388-1.009.94z" />
					</svg>
				</div>
				<div class="col-lg-6">
					<form action="quanlyphanhoi" method="get">
						<button type="submit"
							style="background: none; border: none; color: inherit; cursor: pointer; text-decoration: underline; font: inherit;">
							QUẢN LÝ PHẢN HỒI</button>
					</form>
				</div>
			</div>

		</div>
	</div>
	<div style="height: 310px"></div>
</body>
</html>