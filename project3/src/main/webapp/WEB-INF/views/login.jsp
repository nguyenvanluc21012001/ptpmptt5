<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<h1 class="form-heading">login Form</h1>
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Login</h2>
					<p>Please enter your email and password</p>
				</div>
				<form action="login" method="get" id="Login" >

					<div class="form-group">


						<input type="text" class="form-control" id="inputEmail" name="tenDangNhap"
							placeholder="Tài khoản">

					</div>

					<div class="form-group">

						<input type="password" class="form-control" id="inputPassword" name="matKhau"
							placeholder="Mật khẩu">

					</div>
					<button type="submit" class="btn btn-primary">Login</button>
					
				</form>
				<a href="dangKy.jsp" class="text-center">Đăng ký tài khoản mới</a>
			</div>
			<p class="botto-text">Designed by Sunil Rajput</p>
			
		</div>
	</div>
</body>
</html>