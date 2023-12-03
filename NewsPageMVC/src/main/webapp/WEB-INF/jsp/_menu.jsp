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
	    	<% if(role==null)  { %>
	    	<a  href="/NewsPageMVC/drl/drledit/<%=max %>">Điểm Rèn Luyện</a>
	    	<% }else if(role.equals("gvcn"))  { %>	    
			<a  href="/NewsPageMVC/drl/drllist/<%=lop %>">Điểm Rèn Luyện</a>
			<% }else { %>
	    	<a  href="/NewsPageMVC/drl/drllist/">Điểm Rèn Luyện</a>
	    	<% } %>	
	    </li>
	    <% } %>
	    <li >
			<a  href="#">TTCN & KLTN</a>
	    	<ul class="sub">
	        	<li><a  href="/NewsPageMVC/detaitt/detaittlist">Đề tài TTCN</a></li>
				<li><a href="/NewsPageMVC/ttcn/ttcnlist">TTCN</a></li>
				<li><a  href="/NewsPageMVC/kltn/kltnlist">Đề tài KLTN</a></li>	
				<li><a  href="/NewsPageMVC/hocki/hockilist">Kì học trước</a></li>
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
