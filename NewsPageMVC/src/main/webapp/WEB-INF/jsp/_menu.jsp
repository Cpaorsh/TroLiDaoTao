<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
			<a  href="/NewsPageMVC/ttcn/ttcnlist">Thực Tập Chuyên Ngành</a>
	    	<ul class="sub">
	    		<li><a  href="/NewsPageMVC/dttt/dtttlist">Đề tài TTCN</a></li>
				<li><a  href="/NewsPageMVC/ttcn/ttcnlistcd">Đăng kí chờ duyệt</a></li>
				<li><a  href="/NewsPageMVC/ttcn/ttcnlistkd">Đăng kí không được duyệt</a></li>
	    		<li><a  href="/NewsPageMVC/hocki/hockilist">Đề tài từ các kì trước</a></li>
	      	</ul>  
	    </li>
	    <li >
			<a  href="/NewsPageMVC/kltn/kltnlist">Khóa Luận Tốt Nghiệp</a>
	    	<ul class="sub">
	    		<li><a  href="/NewsPageMVC/dtkl/dtkllist">Đề tài KLTN</a></li>
				<li><a  href="/NewsPageMVC/kltn/kltnlistcd">Đăng kí chờ duyệt</a></li>
				<li><a  href="/NewsPageMVC/kltn/kltnlistkd">Đăng kí không được duyệt</a></li>
	      	</ul>  
	    </li>
	    <%if(role!=null && (role.equals("gv") || role.equals("tldt")))  { %>
	    <li >
			<a  href="/NewsPageMVC/importAcc">Nhập DS SV</a>	
	    </li>
	    <% } %>
	    <li >
			<a href="/NewsPageMVC/doc/doclist">Tài liệu</a>
	    </li>
	  </ul>
	</nav>
	</div>
</div>
