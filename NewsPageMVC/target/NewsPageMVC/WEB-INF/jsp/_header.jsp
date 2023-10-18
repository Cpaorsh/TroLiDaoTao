<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="blog-header py-3">
	<div class="row flex-nowrap justify-content-between align-items-center">
		<!-- <div class="col-4 pt-1">
		<a class="text-muted" href="/NewsPageMVC/subscribe">Subscribe</a>
		</div> -->
		
		<div class="col-8 text-start">
		<img src="/NewsPageMVC/resources/img/vnua.png" alt="hahah" style="width:auto">
		<a class="blog-header-logo text-white" href="/NewsPageMVC"><b>Trang Hướng Nghiệp</b></a>
		</div>

		<div class="search col-3">
			<input class="searchTerm" id="txt" name="order" type="text" placeholder="Nhập tù khóa tìm kiếm">          
			<input class="searchButton" id='btn' type="submit" value="&#128270;" onclick="location.href='/NewsPageMVC/search/'+document.getElementById('txt').value">
		</div>

		
		<!-- <div class="col-4 d-flex justify-content-end align-items-center">
		<a class="text-muted" href="#">
			<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
			stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3">
			<circle cx="10.5" cy="10.5" r="7.5"></circle>
			<line x1="21" y1="21" x2="15.8" y2="15.8"></line>
			</svg>
		</a>
		<a class="btn btn-sm btn-outline-secondary me-2" href="/NewsPageMVC/login">Login</a>
		<a class="btn btn-sm btn-secondary" href="/NewsPageMVC/register">Sign up</a>
		</div> -->
	</div>
	
	<span class="lineleft"></span>
    <span class="lineright"></span>
</header>