<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="nav-scroller bg-white text-light mb-2">
	<nav class="nav d-flex ">
		<a class="text-dark" href="/NewsPageMVC">Trang chủ</a>
		<a class="text-dark" href="/NewsPageMVC/page/pageslist">Quản Lí Tin Tức</a>
		<a class="text-dark" href="/NewsPageMVC/list/1">Tin tức</a>
		
		<a class="text-dark" href="/NewsPageMVC/drl/drllist">Điểm Rèn Luyện</a>
		<% String role = (String)session.getAttribute("role"); if(role!=null && (role.equals("gvcn") || role.equals("tldt")))  { %>
		<a class="text-dark" href="/NewsPageMVC/importAcc">Import Account</a>
    	<% } %>		
		<!-- <a class="text-dark" href="/NewsPageMVC/feedback/viewfeedbacks">Manage Feedbacks</a> -->
	</nav>
</div>
