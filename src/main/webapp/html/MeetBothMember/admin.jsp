<%@page import="meetbothmember.model.UserLoginData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	UserLoginData user = (UserLoginData)session.getAttribute("user");
	if(user == null )
	{
	  response.sendRedirect("Login.jsp");
	return;
	} 
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/assets/css/main.css";
System.out.println(basePath);
%>
<%
String pathimg = request.getContextPath();
String basePathimg = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pathimg
		+ "/html/images/meatball-icon.png";
%>
<%
String basePathimg2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/images/meatball-200.png";
%>
<! DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

<head>
	<title>會員管理</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="<%=basePath%>" />
	<link rel="shortcut icon" href="<%=basePathimg%>" />
	<script src="https://kit.fontawesome.com/2688683da7.js" crossorigin="anonymous"></script>
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>會員管理</strong></a>
					<ul class="icons">
						<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a>
						</li>
						<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
					</ul>
				</header>

				<!-- Content -->
				<section>
					<header class="main">
						<h3>會員管理列表</h3>
						<form method="post" action="<c:url value='/meetbothmember/SeachMem.do' />">
						<input type="text" name="value" value="${value}" required>
						<input type="submit" name="selectByAccount" value="以帳號查詢"/>
						<input type="submit" name="selectByName" value="以姓名查詢"/>
						</form>
						
						<form method="post" action="<c:url value='/meetbothmember/AdminMember.do' />">
						<button name="register">新增會員</button>
						<button name="selectAll" value="getAllMember">取得所有會員資料</button>
						</form>
						
						<div class="table-wrapper">
								<table class="alt">
									<thead>
										<tr>
											<th>會員編號</th>
											<th>帳號</th>
											<th>密碼</th>
											<th>身分證字號</th>
											<th>姓名</th>
											<th>年齡</th>
											<th>生日</th>
											<th>性別</th>
											<th>電子郵件</th>
											<th>電話號碼</th>
											<th>地址</th>
											<th>註冊時間</th>
											<th>修改</th>
											<th>移除</th>
										</tr>
									</thead>
								<c:forEach var="Member" items="${Member}">
									<tbody>
										<tr>
											<td>${Member.memberID}</td>
     										<td>${Member.account}</td>
         									<td>${Member.password}</td>
         									<td>${Member.idNumber}</td>
     										<td>${Member.memName}</td>
     										<td>${Member.memOld}</td>
     										<td>${Member.memBirth}</td>
     										<td>${Member.memGender}</td>
     										<td>${Member.eMail}</td>
     										<td>${Member.phone}</td>
     										<td>${Member.address}</td>
     										<td>${Member.registime}</td>
     										<td><form method="post" action="<c:url value='/meetbothmember/AdminMember.do' />"><button name="preupdate" value="${Member.memberID}"><i class="fa-solid fa-user"></i></button></form></td>
     										<td><form method="post" action="<c:url value='/meetbothmember/AdminMember.do' />"><button name="delete" value="${Member.memberID}"><i class="fa-solid fa-xmark"></i></button></form></td>
										</tr>
									</tbody>
									</c:forEach>
									</table>
							</div>
					</header>

					<span class="image main"><img src="../images/pic11.jpg" alt="" /></span>


				</section>

			</div>
		</div>

		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

<!-- 				Search -->
<!-- 				<section id="search" class="alt"> -->
<!-- 					<form method="post" action="#"> -->
<!-- 						<input type="text" name="query" id="query" placeholder="Search" /> -->
<!-- 					</form> -->
<!-- 				</section> -->

				<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<h2>
							<img src="<%=basePathimg2%>" alt="" />
						</h2>
					</header>
					<ul>
						<li><a href="../index.jsp">首頁 <i class="fa-solid fa-house"></i></a></li>
						<li><a href="../backIndex.jsp">後台管理 <i
								class="fa-solid fa-gears"></i></a></li>
						<li><a href="../MeetBothMember/admin.jsp">會員資料 <i class="fa-solid fa-users"></i></a></li>
						<li><a href="elements.html">找老師 <i
								class="fa-solid fa-person-chalkboard"></i></a></li>
						<li><a href="elements.html">找學生 <i
								class="fa-solid fa-child"></i></a></li>
						<li><span class="opener">科目搜尋 <i
								class="fa-solid fa-book-open"></i></span>
							<ul>
								<li><a href="#">國文</a></li>
								<li><a href="#">英文</a></li>
								<li><a href="#">數學</a></li>
								<li><a href="#">物理</a></li>
								<li><a href="#">化學</a></li>
								<li><a href="#">生物</a></li>
								<li><a href="#">地理</a></li>
								<li><a href="#">歷史</a></li>
								<li><a href="#">公民</a></li>
								<li><a href="#">健康教育</a></li>
							</ul></li>
						<li><span class="opener">教學地點搜尋 <i
								class="fa-solid fa-map-location-dot"></i></span>
							<ul>
								<li><a href="#">台北市</a></li>
								<li><a href="#">新北市</a></li>
								<li><a href="#">基隆市</a></li>
								<li><a href="#">桃園市</a></li>
								<li><a href="#">新竹縣</a></li>
								<li><a href="#">苗栗縣</a></li>
								<li><a href="#">台中市</a></li>
								<li><a href="#">彰化縣</a></li>
								<li><a href="#">台南市</a></li>
								<li><a href="#">南投縣</a></li>
								<li><a href="#">嘉義縣</a></li>
								<li><a href="#">雲林縣</a></li>
								<li><a href="#">高雄市</a></li>
								<li><a href="#">屏東縣</a></li>
								<li><a href="#">宜蘭縣</a></li>
								<li><a href="#">花蓮縣</a></li>
								<li><a href="#">台東縣</a></li>
								<li><a href="#">澎湖、金門、馬祖、外島地區</a></li>
							</ul></li>
						<li><a href="#">討論區 <i class="fa-regular fa-comments"></i></a></li>
					</ul>
				</nav>
				<!-- Section -->
				<section>
					<header class="major">
						<h2>Ante interdum</h2>
					</header>
					<div class="mini-posts">
						<article>
							<a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
							<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
							<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
							<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
						</article>
					</div>
					<ul class="actions">
						<li><a href="#" class="button">More</a></li>
					</ul>
				</section>

				<!-- Section -->
				<section>
					<header class="major">
						<h2>Get in touch</h2>
					</header>
					<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem
						ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
						tempus aliquam.</p>
					<ul class="contact">
						<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
						<li class="icon solid fa-phone">(000) 000-0000</li>
						<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
							Nashville, TN 00000-0000</li>
					</ul>
				</section>

				<!-- Footer -->
				<footer id="footer">
					<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a
							href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5
							UP</a>.</p>
				</footer>

			</div>
		</div>

	</div>

	<!-- Scripts -->

	<%
	String basePath6 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/app.js";
	%>
	
	<%
	String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/jquery.min.js";
	log(basePath1);
	%>

	<%
	String basePath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/browser.min.js";
	%>

	<%
	String basePath3 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/breakpoints.min.js";
	%>

	<%
	String basePath4 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/util.js";
	%>

	<%
	String basePath5 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/main.js";
	%>
	<script src=<%=basePath6%>></script>
	<script src=<%=basePath1%>></script>
	<script src=<%=basePath2%>></script>
	<script src=<%=basePath3%>></script>
	<script src=<%=basePath4%>></script>
	<script src=<%=basePath5%>></script>
	<script src="https://kit.fontawesome.com/25590258af.js"
		crossorigin="anonymous"></script>

</body>

</html>