<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Post</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>

<body>
    <jsp:include page="_header.jsp" />
    <div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
    <div class="col-md-8 mx-auto border">
	    <div class="bg-light p-3 mb-3"><h4>Add New Post</h4></div>
	    
		    <form:form method="post" action="save" class="p-3">

			    <div class="mb-3">
				  <label for="title" class="form-label">title</label>
				  <form:input class="form-control" placeholder="Page Title" path="title" />
				</div>
			    <div class="mb-3">
				  <label for="content" class="form-label">Content</label>
				  <form:textarea class="form-control" placeholder="Content" path="content" />
				</div>
				<div class="mb-3">
				  <label for="category" class="form-label">Category</label>
				  <form:select class="form-control" placeholder="Category" path="category">
				  	<form:option value="QTKD"></form:option>
    				<form:option value="CNTT"></form:option>
    				<form:option value="KHDL"></form:option>    				
				  </form:select>
				</div>
				<button type="submit" class="btn btn-primary">Add Post</button>
				
			</form:form>
			
		</div>
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>
</html>