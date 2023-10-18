<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đánh giá điểm rèn luyện</title>

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
   <h4 class="p-3">Manage Posts</h4>
   <a class="btn btn-primary" href="pageaddform">+ Add New Posts</a>
   </div>
   <br>
   <br>
	   <table class="table table-striped border">
		  <thead>
		    <tr>
		      <th scope="col">Hạng mục</th>
		      <th scope="col">ĐRL tự chấm</th>
		      <th scope="col">ĐRL lớp trưởng chấm</th>
		      <th scope="col">ĐRL giáo viên chấm</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<form:form method="post" action="/NewsPageMVC/drl/editsave" class="p-3">
		    <tr>
		      <td>1. Ý thức và thái độ học tập: </td>
		      <td></td>
		      <td></td>
		      <td>
		      	<form:select class="form-control" placeholder="Gvythuc" path="gvythuc">
				  	<form:option value="4"></form:option>
    				<form:option value="2"></form:option>
    				<form:option value="0"></form:option>    				
				</form:select>
		      </td>
		    </tr>
			</form:form>
		  </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>
</html>