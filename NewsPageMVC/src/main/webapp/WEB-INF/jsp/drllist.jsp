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
   </div>
   <br>
	   <table class="table table-striped border">
		  <thead>
		    <tr>
		      <th scope="col">MSV</th>
		      <th scope="col">Tên</th>
		      <th scope="col">ĐRL tự chấm</th>
		      <th scope="col">ĐRL lớp trưởng chấm</th>
		      <th scope="col">ĐRL giáo viên chấm</th>
		      <th scope="col">Actions</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="drl" items="${dlist}"> 
		    <tr>
		      <th scope="row">${drl.msv}</th>
		      <td>${drl.sinhvien.hoten}</td>
		      <td>${drl.tongdiem}</td>
		      <td>${drl.lttongdiem}</td>
		      <td>${drl.gvtongdiem}</td>
			   <td>
			   <a class="btn btn-sm btn-outline-primary" href="drledit/${drl.msv}">Edit</a>
			   </td> 
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>
</html>