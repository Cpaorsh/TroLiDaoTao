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
   <a class="btn btn-primary" href="docadd">+ Add New Posts</a>
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
		  <c:forEach var="doc" items="${list}"> 
		    <tr>
		      <th scope="row">${doc.id}</th>
		      <td class="tdot">${doc.title}</td>
		      <td class="tdot">${doc.content}</td>
		      <td>${doc.category}</td>
		      <td>${doc.datec}</td>
			   <td>
			   <a class="btn btn-sm btn-outline-success" href="docdetail/${doc.id}">View</a>
			   <a class="btn btn-sm btn-outline-primary" href="docedit/${doc.id}">Edit</a>
			   <a class="btn btn-sm btn-outline-danger" href="docdelete/${doc.id}">Delete</a>
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