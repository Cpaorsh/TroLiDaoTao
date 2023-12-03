<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Học Kì</title>

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
   <h4 class="p-3">Danh sách học kì</h4>
   <a class="btn btn-primary" href="hkadd">Thêm học kì mới</a>
   </div>
   <br>
   <br>
	   <table class="table table-striped border">
		  <thead>
		    <tr>
		      <th scope="col">STT</th>
		      <th scope="col">Học kì</th>
		      <th scope="col">Chức năng</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="hocki" items="${list}" > 
		    <tr>
		      <th scope="row">${hocki.id}</th>
		      <td class="tdot">${hocki.tenhk}</td>
			   <td>
			   <a class="btn btn-sm btn-outline-primary" href="/NewsPageMVC/ttcn/ttcnlist/${hocki.id}">TTCN</a>
			   <a class="btn btn-sm btn-outline-danger" href="/NewsPageMVC/kltn/kltnlist/${hocki.id}">KLTN</a>
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