<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tài liệu</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<script>
function myFunction() {
    var a = confirm("Xác nhận xóa tài liệu này?");
    console.log(a)
}
</script>
<%
	String role = (String)session.getAttribute("role");
%>
</head>
<body>

	<jsp:include page="_header.jsp" />
	<div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
   <div class="col-md-12 mx-auto">
   
   <div class="bg-light d-flex justify-content-between align-items-center">
   <h4 class="p-3">Danh sách tài liệu, văn bản mẫu</h4>
   <% if( role!=null && role.equals("tldt"))  { %>
   		<a class="btn btn-primary" href="docadd">Thêm tài liệu</a>
   <% } %>
   </div>
   <br>
   <br>
	   <table class="table table-striped border">
		  <thead>
		    <tr>
		      <th scope="col">STT</th>
		      <th scope="col">Tên tài liệu</th>
		      <th scope="col">Link download</th>
		      <th scope="col">Chức năng</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="doc" items="${list}" varStatus="count"> 
		    <tr>
		      <th>${count.count}</th>
		      <td>${doc.title}</td>
		      <td><a class="text-dark" href="down/${doc.id}">${doc.namefi}</a></td>
			   <td>
			   	<% if( role!=null && role.equals("tldt"))  { %>
			   		<a class="btn btn-sm btn-outline-primary" href="docedit/${doc.id}">Edit</a>
			   		<a onclick="myFunction()" class="btn btn-sm btn-outline-danger" href="docdelete/${doc.id}">Delete</a>
			   	<% } %>
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