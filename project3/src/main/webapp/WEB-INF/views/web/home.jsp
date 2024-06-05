<%@page import="com.laptrinhjavaweb.service.IsanPhamService"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.laptrinhjavaweb.model.sanPham"%>
<%@ page import="com.laptrinhjavaweb.service.impl.sanPhamService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
</script>
<style type="text/css">
.list-group-item {
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #f8f9fa;
	transition: background-color 0.3s;
}

.list-group-item:hover {
	background-color: #e2e6ea;
}

.nav-link {
	color: #007bff;
	text-decoration: none;
	display: block;
}

.nav-link:hover {
	color: #0056b3;
	text-decoration: underline;
}
</style>
</head>
<body>

	<div class="row">
		<h1></h1>
		<div class="col-lg-3">

			<h1 class="my-4">Shop Name</h1>
			<div class="list-group">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<c:forEach items="${danhMucList}" var="danhMuc">
						<li class="nav-item list-group-item">
							<form action="timKiemDanhMuc" method="get" style="margin: 0;">
								<input type="hidden" name="data" value="${danhMuc.getId()}" />
								<input type="submit" value="${danhMuc.getTen()}"
									style="border: none; background: none; padding: 0; width: 100%; color: #007bff; text-align: left;"
									class="nav-link active highlight">
							</form>
						</li>
					</c:forEach>
				</ul>
			</div>

		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">

			<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>

				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<img class="d-block img-fluid w-100"
							src="<c:url value='img/slider/1.png' />" alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid w-100"
							src="<c:url value='img/slider/2.png/' />" alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid w-100"
							src="<c:url value='img/slider/3.png/' />" alt="Third slide">
					</div>

				</div>

				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

			<div class="row">

				<c:forEach items="${sanPhamList}" var="sanPham">
					<div class="col-lg-4 col-md-6 mb-4">

						<form action="chiTietSanPham" method="get">
							<button type="submit"
								style="border: none; background: none; padding: 0;">
								<div class="card h-100">
									<a href="#"><img class="card-img-top"
										src="<c:url value="${sanPham.getAnh().getHinhAnh()}"/>" alt=""></a>
									<div class="card-body">
										<h4 class="card-title">
											<a href="#">${sanPham.getTieuDe()}</a>
										</h4>
										<h5>${sanPham.getGiaBan()}</h5>
										<p class="card-text">${sanPham.getMoTaSanPham()}!</p>
									</div>
									<div class="card-footer">
										<small class="text-muted">&#9733; &#9733; &#9733;
											&#9733; &#9734;</small>
									</div>

								</div>

							</button>
							<input type="hidden" name="data" value="${sanPham.getId()}" />
						</form>
					</div>
				</c:forEach>

			</div>


		</div>
		<!-- /.col-lg-9 -->
	</div>
	<!-- /.row -->
</body>
</html>