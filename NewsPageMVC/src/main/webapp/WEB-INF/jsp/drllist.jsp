<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý điểm rèn luyện</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>

	<jsp:include page="_header.jsp" />
	<div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
   <div class="col-md-12 mx-auto">
   
   <div class="bg-light d-flex justify-content-between align-items-center">
   <h4 class="p-3">Quản lý điểm rèn luyện</h4>
   	<div class="search col-4 float-end">
		<input class="btn-sm " id="txt" name="order" type="text" placeholder="Nhập tên SV cần tìm">          
		<input class="btn-sm btn-outline-secondary" id='btn' type="image" src="/NewsPageMVC/resources/img/isearch.png" onclick="location.href='/NewsPageMVC/drl/search/'+document.getElementById('txt').value">
	</div>
   </div>
   <br>
	   <table class="table table-striped border">
		  <thead>
		    <tr>
		      <th scope="col">MSV</th>
		      <th scope="col">Họ Tên</th>
		      <th scope="col">ĐRL tự đánh giá</th>
		      <th scope="col">ĐRL lớp trưởng đánh giá</th>
		      <th scope="col">ĐRL giáo viên đánh giá</th>
		      <th scope="col">Đánh giá</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="drl" items="${list}"> 
		    <tr>
		      <th scope="row">${drl.msv}</th>
		      <td>${drl.sinhvien.hoten}</td>
		      <td>${drl.tongdiem}</td>
		      <td>${drl.lttongdiem}</td>
		      <td>${drl.gvtongdiem}</td>
			   <td>
			   <a class="btn btn-sm btn-outline-primary" href="/NewsPageMVC/drl/drledit/${drl.msv}">Xem</a>
			   </td> 
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		</div>
	</div>
	
	<div class="style="display: inline;">
		<c:forEach var="i" begin="1" end="${numberpage}">
	           <a href="${i}">${i}</a>
	    </c:forEach>
	</div> 
	    
	<jsp:include page="_footer.jsp" />
</body>
</html>