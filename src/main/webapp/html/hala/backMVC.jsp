<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='debug' value='true' scope='application' />


<!DOCTYPE html>

<html lang="zh-hant-TW">
<head>
<%
String path1 = request.getContextPath();
String imgPath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path1
		+ "/html/images/meatball-icon.png";
%>
<%
String imgPath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path1
		+ "/html/images/meatball-200.png";
%>
<title>肉丸家教網 MEET BOTH</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="robots" content="index,follow" />
<meta name="description" content="全台最優質最快速方便的家教網" />
<meta name="author" content="EEIT56-MEETBOTH" />
<meta name="keywords" content="最棒最優質的家教網" />
<meta name="copyright" content="肉丸家教網" />
<link rel="shortcut icon" href="<%=imgPath1%>" />
<link rel="bookmark" href="<%=imgPath2%>" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<div id="main"></div>

		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

				<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<h2>
							<img src="<%=imgPath2%>" alt="" />
						</h2>
					</header>
					<ul>
						<li><a href="topic-home.jsp">首頁</a></li>
						<li><a href="generic.html">會員資料</a></li>
						<li><a href="elements.html">科目地區資料</a></li>
						<li><a href="elements.html">商品資料</a></li>
						<li><a href="elements.html">訂單資料</a></li>
						<li><span class="opener">老師學生資料</span>
							<ul>
								<li><a href="#">老師貼文資料</a></li>
								<li><a href="#">學生貼文資料</a></li>
							</ul></li>
						<li><span class="opener">哈拉區</span>
							<ul>
								<li><a href="#">討論公告區</a></li>
								<li><a href="#">問題討論區</a></li>
							</ul></li>
					</ul>
				</nav>


				<!-- Section -->
				<section>
					<header class="major">
						<h2>聯絡我們</h2>
					</header>
					<p>肉丸家教網是一個希望不管是學生還是老師，都能在這裡精進自己，花最少的時間，找到最棒的老師/學生。</p>
					<ul class="contact">
						<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a>
						</li>
						<li class="icon solid fa-phone">(000) 000-0000</li>
						<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
							Nashville, TN 00000-0000
						</li>
					</ul>
				</section>

				<!-- Footer -->
				<footer id="footer">
					<p class="copyright">
						&copy; Untitled. All rights reserved. Demo Images: <a
							href="https://unsplash.com">Unsplash</a>. Design: <a
							href="https://html5up.net">HTML5 UP</a>.
					</p>
				</footer>
			</div>
		</div>
	</div>

	<!-- Scripts -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>
