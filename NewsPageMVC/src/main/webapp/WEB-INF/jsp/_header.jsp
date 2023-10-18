<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="blog-header py-3">
	<div class="row flex-nowrap justify-content-between align-items-center">
		<!-- <div class="col-4 pt-1">
		<a class="text-muted" href="/NewsPageMVC/subscribe">Subscribe</a>
		</div> -->
		
		<div class="col-8 text-start d-flex">
		<img class="" src="/NewsPageMVC/resources/img/vnua.png" alt="hahah" style="width:auto">
		<div class="">
			<a class="blog-header-logo text-white" href="/NewsPageMVC"><b>Trang Hướng Nghiệp</b></a>
			<p class="text-white">Học viện Nông nghiệp Việt Nam</p>
		</div>
		</div>

		
		<div class="col-2 d-flex justify-content-end align-items-center">
		<%-- <a class="text-muted" href="#">
			<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
			stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3">
			<circle cx="10.5" cy="10.5" r="7.5"></circle>
			<line x1="21" y1="21" x2="15.8" y2="15.8"></line>
			</svg>
		</a>
		<p> Welcome ${name} </p> --%>
		   
	<%
        String username = (String)session.getAttribute("username");
        if(username==null)  {
    %>            
		<a class="btn btn-sm btn-outline-secondary me-2" href="/NewsPageMVC/login">Login</a>
		<a class="btn btn-sm btn-secondary" href="/NewsPageMVC/register">Sign up</a>
	<%
        } else {
    %>
		<p  class="text-white"> Welcome <%= session.getAttribute("username") %> </p>
		<a class="btn btn-sm btn-outline-secondary me-2" href="/NewsPageMVC/login">Logout</a>
    <%
        }
    %>
		</div> 
	</div>
	
	<span class="lineleft"></span>
    <span class="lineright"></span>
</header>