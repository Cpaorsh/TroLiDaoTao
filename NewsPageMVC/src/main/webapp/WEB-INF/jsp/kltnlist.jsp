<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>khóa luận tốt nghiệp</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<%
	String role = (String)session.getAttribute("role");
	String max = (String)session.getAttribute("max");
%>
</head>
<body>

	<jsp:include page="_header.jsp" />
	<div class="container">
	<jsp:include page="_menu.jsp" />
	
	<br><br>
	
   <div class="col-md-12 mx-auto">
   
   <div class="bg-light d-flex justify-content-between align-items-center">
	<h4 class="p-3">Danh sách đề tài khóa luận tốt nghiệp</h4>
	<a class="btn btn-primary" href="/NewsPageMVC/kltn/kltnadd">Thêm đề tài mới</a>
   </div>
   <br>
   <br>
	   <table class="table table-striped border">
		  <thead>
		    <tr>
		      <th scope="col">STT</th>
		      <th scope="col">Tên đề tài</th>
		      <th scope="col">Giảng viên hướng dẫn</th>
		      <th scope="col">Bộ môn</th>
		      <th scope="col">Sinh viên đăng kí</th>
		      <th scope="col">Mã SV</th>
		      <th scope="col">Lớp</th>
		      <th scope="col">Chức năng</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="kltn" items="${list}" varStatus="count"> 
		    <tr>
		      <th scope="row">${count.count}</th>
		      <td class="tdot">${kltn.detai}</td>
		      <td class="tdot">${kltn.giangvien.hoten}</td>
		      <td>${kltn.giangvien.bomon}</td>
		      <td>${kltn.sinhvien.hoten}</td>
		      <td>${kltn.sinhvien.msv}</td>
		      <td>${kltn.sinhvien.lop}</td>
			   <td>
				<%if(role!=null && role.equals("tldt")){ %>
			   		<a class="btn btn-sm btn-outline-primary" href="/NewsPageMVC/kltn/kltnedit/${kltn.mkl}">Sửa</a>
			   		<a class="btn btn-sm btn-outline-danger" href="/NewsPageMVC/kltn/kltndelete/${kltn.mkl}">Xóa</a>
			  	<%}else if(role==null && max!=null){ %>
			  	<c:if test="${kltn.msv == null}">
			   		<a class="btn btn-sm btn-outline-success" href="/NewsPageMVC/kltn/kltnregi/${kltn.mkl}">Đăng kí</a>
			   	</c:if>
			   	<%} %>
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