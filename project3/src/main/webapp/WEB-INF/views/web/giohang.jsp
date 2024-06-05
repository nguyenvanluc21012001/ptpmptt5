<%@page import="com.laptrinhjavaweb.model.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ Hàng</title>
</head>
<body>
	<script>
		function mua() {
			var form = document.getElementById("mua");
			form.submit();
		}
		// Định nghĩa hàm tính tổng tiền
		function calculateTotal() {
			// Lấy danh sách các checkbox đã được chọn
			var checkboxes = document.getElementsByName("selectedItems");

			// Khởi tạo biến tổng tiền
			var total = 0;

			// Lặp qua từng checkbox
			for (var i = 0; i < checkboxes.length; i++) {
				// Nếu checkbox được chọn
				if (checkboxes[i].checked) {
					// Lấy form tinhtien tương ứng
					var form = document.getElementById("tinhtien"
							+ checkboxes[i].value);
					console.log('Tổng tiền: ' + total);
					// Lấy giá bán và số lượng từ form
					var giaban = parseFloat(form
							.querySelector('input[name="giaban"]').value);
					var soluong = parseInt(form
							.querySelector('input[name="soluong"]').value);

					// Tính tổng tiền của sản phẩm và cộng vào tổng tiền chung
					total += giaban * soluong;
				}
			}
			var tongtienElement = document.getElementById("tongtien");
			console.log('Tổng tiền: ' + total);
			tongtienElement.textContent = total;
		}
	</script>
	<%
	Object obj = session.getAttribute("user");
	user user = null;
	if (obj != null)
		user = (user) obj;
	%>
	<div class="container-fluid text-center"
		style="height: 40px; margin: 30px">
		<h3>GIỎ HÀNG</h3>
	</div>
	<!-- giỏ hàng  -->
	<%-- <form action="mua" method="get" id="mua">
		<div class="row">
			<c:forEach items="${gioHangList}" var="gioHang" varStatus="status">
				<div class="row col-lg-6"
					style="padding-top: 20px; padding-bottom: 20px">
					<div class="col-lg-3"></div>
					<div class="col-lg-1">
						<input class="form-check-input" type="checkbox"
							style="height: 40px; width: 40px" name="selectedItems"
							onclick="calculateTotal();">

					</div>
					<div class="col-lg-2">
						<a href="#"><img class="card-img-top"
							src="<c:url value="${gioHang.getSanPham().getAnh().getHinhAnh()}"/>"
							alt=""></a>
					</div>
					<div class="col-lg-3">
						<h4>${gioHang.getSanPham().getTieuDe()}</h4>
						<h6>${gioHang.getSanPham().getGiaBan()}đ</h6>
						<div>
							<form action="" id="tinhtien${status.index}" method="post">
								<input type="hidden" name="giaban"
									value="${gioHang.getSanPham().getGiaBan()}"> <input
									type="hidden" name="soluong" value="${gioHang.getSoLuong()}">
							</form>
						</div>
					</div>

					<div class="row col-lg-6"
						style="padding-top: 20px; padding-bottom: 20px"></div>
				</div>
				<div class="row col-lg-6"
					style="padding-top: 20px; padding-bottom: 20px">
					<div class="row col-lg-2">
						<h5>${gioHang.getSoLuong()}</h5>
					</div>
					<div class="col-lg-1">
						<button type="button" onclick="xoa<%=luc%>()">Xóa</button>
					</div>
				</div>
				<form id="xoa<%=luc%>" method="post" action="xoagiohang">
				<input type="hidden" name="sanpham"
					value="<%=gh[luc].getSanPham().getId()%>" /> <input type="hidden"
					name="user" value="<%=gh[luc].getUser().getId()%>" />
			</form>
			</c:forEach>
		</div>
	</form> --%>

	<form action="mua" method="get" id="mua">
		<input type="hidden" name="user_id" value="<%=user.getUser_id()%>">
		<div class="row">
			<input class="form-check-input" type="checkbox"
				style="height: 0px; width: 0px" name="selectedItems"
				value="" onclick="calculateTotal()">
			<c:forEach items="${gioHangList}" var="gioHang" varStatus="status">
				<div class="row col-lg-6"
					style="padding-top: 20px; padding-bottom: 20px">
					<div class="col-lg-3"></div>
					<div class="col-lg-1">
						<!-- Thêm giá trị duy nhất cho checkbox -->
						<input class="form-check-input" type="checkbox"
							style="height: 40px; width: 40px" name="selectedItems"
							value="${status.index+1}" onclick="calculateTotal()">
							
					</div>
					<div class="col-lg-2">
						<a href="#"><img class="card-img-top"
							src="<c:url value="${gioHang.getSanPham().getAnh().getHinhAnh()}"/>"
							alt=""></a>
					</div>
					<div class="col-lg-3">
						<h4>${gioHang.getSanPham().getTieuDe()}</h4>
						<h6>${gioHang.getSanPham().getGiaBan()}đ</h6>
						<div>
							<form action="" id="tinhtien${status.index+1}" method="get">
								${status.index+1} <input type="hidden" name="giaban"
									value="${gioHang.getSanPham().getGiaBan()}"> <input
									type="hidden" name="soluong" value="${gioHang.getSoLuong()}">
							</form>
						</div>
					</div>
					<div class="row col-lg-6"
						style="padding-top: 20px; padding-bottom: 20px"></div>
				</div>
				<div class="row col-lg-6"
					style="padding-top: 20px; padding-bottom: 20px">
					<div class="row col-lg-2">
						<h5>${gioHang.getSoLuong()}</h5>
					</div>
				</div>
			</c:forEach>
		</div>
	</form>
	<!-- hết giỏ hàng -->
	<!-- tính tiền -->
	<div style="bottom: 0; width: 100%;">
		<div class="row" style="background-color: green">
			<div class="row col-lg-12">
				<div class="row col-lg-2">
					<h3>Tổng tiền :</h3>
				</div>
				<div class="row col-lg-8">
					<div id="tongtien">đ</div>
					<!-- <span id="tongtien">đ</span> -->
				</div>
				<div class="row col-lg-2">
					<button onclick="mua()">MUA</button>
				</div>
			</div>

		</div>
		<!-- hết tính tiền -->
	</div>
</body>
</html>