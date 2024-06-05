<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="center" style="display: flex; justify-content: center; align-items: center; height: 100vh;">
		<form class="d-flex" action="suadanhmucxong" method="get">
		    <input type="hidden" name="danhMucId" value="${danhMuc.getId()}">
			<input class="form-control" type="text" name="suaDanhMuc"
				id="suadanhmuc" placeholder="${danhMuc.getTen()}">
			<button class="btn btn-outline-success" type="submit">Sửa</button>
		</form>
	</div>
</body>
</html>