<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Khóa Luận Tốt Nghiệp</title>

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
   <h4 class="p-3">Danh sách SV đăng kí Khóa luận tốt nghiệp chưa được duyệt</h4>
   <% if (role!=null && (role.equals("sv")|| role.equals("loptruong")) && duyet!=null) { %>
   <a class="btn btn-primary" href="kltndelete/<%=max%>">Hủy đăng kí </a>
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
		  <c:forEach var="kltn" items="${list}" varStatus="count"> 
		    <tr>
		      <th scope="row">${count.count}</th>
		      <td>${kltn.sinhvien.hoten}</td>
		      <td>${kltn.sinhvien.msv}</td>
		      <td>${kltn.sinhvien.lop}</td>
		      <td>${kltn.lidotc}</td>
			   <td>
			   <%if(role!=null && role.equals("tldt"))  { %>
			   <a class="btn btn-sm btn-outline-primary" href="kltnduyet/${kltn.msv}">Xét duyệt</a>
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