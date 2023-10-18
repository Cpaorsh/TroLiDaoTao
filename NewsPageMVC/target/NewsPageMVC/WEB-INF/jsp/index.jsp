<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Trang Hướng Nghiệp</title>

	<!-- Bootstrap core CSS -->
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	
	<!-- 
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	-->
	
</head>

<body>
<jsp:include page="_header.jsp" />
<div class="container">
<jsp:include page="_menu.jsp" />

		<div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
		<div class="col-md-6 px-0">
			<h1 class="display-4 font-italic">Hướng Nghiệp<span class=""><b></span></h1>
			<h2 class="text-warning">Học viện Nông nghiệp Việt Nam</h2>
			<p class="my-3" style="color: rgb(213,213,213);">
				Find any news you want.
			</p>
		</div>
		</div>
		<br>
		<h5>Faculties</h5>
		<hr>
		<div class="d-flex justify-content-between">
			<a class="tag col-2" href="category/CNTT">Công Nghệ Thông Tin</a>
			<a class="tag col-2" href="category/QTKD">Quản Trị Kinh Doanh</a>
			<a class="tag col-2" href="category/KHDL">Khoa Học Dữ Liệu</a>
			<a class="tag col-2" href="category/TY">THÚ Y</a>
			<a class="tag col-2" href="category/KTCK">Kĩ Thuật Cơ Khí</a>
			<!-- <a href="#">All genres</a> -->
		</div>
	
		<br><br>
		<h5>Latest News</h5>
		<hr>
		<div class="row mb-2 py-5">
 		<c:forEach var="page" items="${liss}"> 
			<div class="col-md-6">
				<div class="card flex-md-row mb-4 box-shadow h-md-250">
					<div class="card-body d-flex flex-column align-items-start">
						<a class="text-dark" href="page/detailpage/${page.id}"><strong class="d-inline-block mb-2 text-success">
							<h2>${page.title}</h2>
						</strong></a>
						<p class="noidung card-text mb-auto">${page.content}</p>
						<p class="ngay mb-auto">${page.datec}</p>
					</div>
					<img class="card-img-right flex-auto d-none d-md-block" 
					src="<c:url value="/resources/img/memories-of-a-geisha.jpg"/>"  alt="Card image cap">
				</div>
			</div>
		</c:forEach>
		</div>
		
	
	<main role="main" class="container">
		<div class="row">
		<div class="col-md-8 blog-main">
			<h3 class="pb-3 mb-4 font-italic border-bottom">Recommendations</h3>
		</div>
		
	
		<aside class="col-md-4 blog-sidebar">
			<div class="p-3 mb-3 bg-light rounded">
			<h4 class="font-italic">About</h4>
			<p class="mb-0"><em>Vietnam National University of Agriculture (VNUA)</em> 
			is a key and leading national university in human resource training and scientific research in agriculture and rural development, 
			becoming more and more diversified in fields of study with ever increasing prestige among the higher education system of Vietnam.</p>
			</div>
	
			<div class="p-3">
			<h4 class="font-italic">Oldest</h4>
			<ol class="list-unstyled mb-0">
				<li><a href="#">The Alchemist</a></li>
				<li><a href="#">The Subtile art of not giving a f*ck</a></li>
				<li><a href="#">Who's Adil</a></li>
				<li><a href="#">The Alchemist</a></li>
				<li><a href="#">The Subtile art of not giving a f*ck</a></li>
				<li><a href="#">Who's Adil</a></li>
				<li><a href="#">The Alchemist</a></li>
				<li><a href="#">The Subtile art of not giving a f*ck</a></li>
				<li><a href="#">Who's Adil</a></li>
			</ol>
			</div>
		</aside>
		</div>
	</main>
</div>
	
<jsp:include page="_footer.jsp" />
</body>
</html>