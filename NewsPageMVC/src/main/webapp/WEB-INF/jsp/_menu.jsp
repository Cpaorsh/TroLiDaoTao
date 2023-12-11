<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 	
		<a class="text-dark" href="/NewsPageMVC/drl/drllist">Điểm Rèn Luyện</a>
		<% String role = (String)session.getAttribute("role"); if(role!=null && (role.equals("gvcn") || role.equals("tldt")))  { %>
		<a class="text-dark" href="/NewsPageMVC/importAcc">Import Account</a>
    	<% } %>		
 --%>
<%
	String max = (String)session.getAttribute("max"); 
	String role = (String)session.getAttribute("role");
	String lop = (String)session.getAttribute("lop");
%>
<div>

	<div class="wrap">
	<nav class="nav-scroller">
	  <ul class="primary">
	    <li >
			<a href="/NewsPageMVC">Trang chủ</a>
	    </li>
	    <li >
			<a  href="/NewsPageMVC/list/1">Tin tức</a>
			<ul class="sub">
				<li><a href="/NewsPageMVC/doc/docmana">Quản Lí Tin Tức</a></li>
	      	</ul> 
	    </li>
	    <%if(max!=null)  { %>
	    <li>
	    	<% if(role.equals("sv")) { %>
	    	<a  href="/NewsPageMVC/drl/drledit/<%=max %>">Điểm Rèn Luyện</a>
	    	<% }else if(role.equals("gv") || (role.equals("loptruong")))  { %>	    
			<a  href="/NewsPageMVC/drl/drllist/<%=lop %>">Điểm Rèn Luyện</a>
			<% }else { %>
	    	<a  href="/NewsPageMVC/drl/drllist/">Điểm Rèn Luyện</a>
	    	<% } %>	
	    </li>
	    <% } %>
	    <li >
			<a  href="#">TTCN</a>
	    	<ul class="sub">
	    		<li><a  href="/NewsPageMVC/dttt/dtttlist">Đề tài TTCN</a></li>
	        	<li><a  href="/NewsPageMVC/ttcn/ttcnlist">SV đã đăng kí TTCN</a></li>
				<li><a  href="/NewsPageMVC/dttt/dtttlistcd">Đề tài chờ duyệt</a></li>
				<li><a  href="/NewsPageMVC/ttcn/ttcnlistcd">Đăng kí chờ duyệt</a></li>
				<li><a  href="/NewsPageMVC/dttt/dtttlistkd">Đề tài không được duyệt</a></li>
				<li><a  href="/NewsPageMVC/ttcn/ttcnlistkd">Đăng kí không được duyệt</a></li>
	    		<li><a  href="/NewsPageMVC/hocki/hockilist">Đề tài từ các kì trước</a></li>
	      	</ul>  
	    </li>
	    <li >
			<a  href="#">KLTN</a>
	    	<ul class="sub">
	        	<li><a  href="#">Đề tài KLTN</a></li>
				<li><a  href="#">Đề tài chưa duyệt</a></li>
				<li><a  href="#">Đăng kí KLTN</a></li>	
				<li><a  href="#">Đăng kí chờ duyệt</a></li>
	      	</ul>  
	    </li>
	    <%if(role!=null && (role.equals("gvcn") || role.equals("tldt")))  { %>
	    <li >
			<a  href="/NewsPageMVC/importAcc">Nhập DS SV</a>	
	    </li>
	    <% } %>
	  </ul>
	</nav>
	</div>
</div>
