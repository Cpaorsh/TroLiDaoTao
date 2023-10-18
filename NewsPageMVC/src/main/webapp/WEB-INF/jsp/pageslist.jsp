<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý tin tức</title>

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
		      <th scope="col">ID</th>
		      <th scope="col">Title</th>
		      <th scope="col">Content</th>
		      <th scope="col">Category</th>
		      <th scope="col">Date Created</th>
		      <th scope="col">Actions</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="page" items="${list}"> 
		    <tr>
		      <th scope="row">${page.id}</th>
		      <td>${page.title}</td>
		      <td >${page.content}</td>
		      <td>${page.category}</td>
		      <td>${page.datec}</td>
			   <td>
			   <a class="btn btn-sm btn-outline-success" href="detailpage/${page.id}">View</a>
			   <a class="btn btn-sm btn-outline-primary" href="editpage/${page.id}">Edit</a>
			   <a class="btn btn-sm btn-outline-danger" href="deletepage/${page.id}">Delete</a>
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