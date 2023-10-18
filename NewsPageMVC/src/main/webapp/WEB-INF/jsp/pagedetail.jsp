<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Posts | News Page</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>

	<jsp:include page="_header.jsp" />
	<div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br><br><br>
	
	   <div class="col-md-12 mx-auto">
			<div class="card mb-4 box-shadow ">
				<div class="card-body d-flex flex-column align-items-start">
					<strong class="d-inline-block mb-2 text-success">
						<h2>${page.title}</h2>
					</strong>
					<div class="flex-row d-flex col-12">
						<p class="ngay text-muted text-start col-6" >${page.datec}</p>
						<p class="ngay text-muted text-end col-6" >${page.category}</p>
					</div>
					<p class=" card-text mb-auto" >${page.content}</p>
					
				</div>
				<img class="card-img-center mx-auto" 
				src="<c:url value="/resources/img/memories-of-a-geisha.jpg" />" alt="Card image cap">
			</div>
		</div> 
	</div>
	
	<jsp:include page="_footer.jsp" />
</body>
</html>