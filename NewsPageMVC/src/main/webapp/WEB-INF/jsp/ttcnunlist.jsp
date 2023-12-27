<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thực tập chuyên ngành</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>

<%
	String max = (String)session.getAttribute("max"); 
	String role = (String)session.getAttribute("role");
	String duyet = (String)session.getAttribute("duyet");
%>
	<jsp:include page="_header.jsp" />
	<div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
   <div class="col-md-12 mx-auto">
   
   <div class="bg-light d-flex justify-content-between align-items-center">
   <h4 class="p-3">Danh sách SV đăng kí Thực tập chuyên ngành chưa được duyệt</h4>
   <% if (role!=null && (role.equals("sv")|| role.equals("loptruong")) && duyet!=null) { %>
   <a class="btn btn-primary" href="ttcndelete/<%=max%>">Hủy đăng kí </a>
   <% } %>
   </div>
   <br>
   <br>
	   <table class="table table-striped border">
		  <thead>
		    <tr>
		      <th scope="col">STT</th>
		      <th scope="col">Họ tên</th>
		      <th scope="col">MSV</th>
		      <th scope="col">Lớp</th>
		      <th scope="col">Lí do từ chối</th>
		      <th scope="col">Chức năng</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="ttcn" items="${list}" varStatus="count"> 
		    <tr>
		      <th scope="row">${count.count}</th>
		      <td>${ttcn.sinhvien.hoten}</td>
		      <td>${ttcn.sinhvien.msv}</td>
		      <td>${ttcn.sinhvien.lop}</td>
		      <td>${ttcn.lidotc}</td>
			   <td>
			   <%if(role!=null && role.equals("tldt"))  { %>
			   <a class="btn btn-sm btn-outline-primary" href="ttcnduyet/${ttcn.msv}">Xét duyệt</a>
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