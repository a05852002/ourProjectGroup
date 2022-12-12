<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<! DOCTYPE html>
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/assets/css/main.css";
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
<!-- 引入共同的頁首 -->
<%-- <%@ include file="/html/backMVC.jsp" %> --%>
<%-- <jsp:include page="/html/backMVC.jsp" flush="true" /> --%>
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
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
<link rel="shortcut icon" href="<%=basePathimg%>" />
<link rel="bookmark" href="<%=basePathimg%>" />
<link rel="stylesheet" href="<%=basePath%>" />
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
					<a href="backIndex.jsp" class="logo"><strong>後台管理系統</strong></a>
					<!-- 					<ul class="icons"> -->
					<!-- 						<li><a href="#" class="icon brands fa-twitter"><span -->
					<!-- 								class="label">Twitter</span></a></li> -->
					<!-- 						<li><a href="#" class="icon brands fa-facebook-f"><span -->
					<!-- 								class="label">Facebook</span></a></li> -->
					<!-- 						<li><a href="#" class="icon brands fa-snapchat-ghost"><span -->
					<!-- 								class="label">Snapchat</span></a></li> -->
					<!-- 						<li><a href="#" class="icon brands fa-instagram"><span -->
					<!-- 								class="label">Instagram</span></a></li> -->
					<!-- 					</ul> -->
				</header>


				<!-- Content -->
				<section>
					<header class="main">
						<h2>~歡迎使用~</h2>
					</header>
					<!-- Search -->
					<section id="search" class="alt">
						<form method="post" action="#">
							<input type="text" name="query" id="query" placeholder="Search" />
						</form>
					</section>

				</section>
			</div>
		</div>

		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

				<!-- Search -->
				<!-- 				<section id="search" class="alt"> -->
				<!-- 					<form method="post" action="#"> -->
				<!-- 						<input type="text" name="query" id="query" placeholder="Search" /> -->
				<!-- 					</form> -->
				<!-- 				</section> -->

				<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<h2>
							<img src="images/meatball-200.png" alt="" />
						</h2>
					</header>
					<ul>
						<li><a href="index.jsp">首頁 <i class="fa-solid fa-house"></i></a></li>
						<li><a href="backIndex.jsp">後台管理 <i
								class="fa-solid fa-gears"></i></a></li>
						<li><a href="MeetBothMember/admin.jsp">會員資料 <i class="fa-solid fa-users"></i></a></li>
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

	<%
	String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/jquery.min.js";
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
	<script src=<%=basePath1%>></script>
	<script src=<%=basePath2%>></script>
	<script src=<%=basePath3%>></script>
	<script src=<%=basePath4%>></script>
	<script src=<%=basePath5%>></script>
	<script src="https://kit.fontawesome.com/25590258af.js"
		crossorigin="anonymous"></script>
</body>
</html>
<!--      <td> -->
<%--                      <Form  action="<c:url value='/Servlet/searchAllTeacServlet' />"  --%>
<!--                             method="POST"> -->
<!--                                 教師貼文數量: -->
<!--                         <select name='qty'> -->
<!--                            <option value="1">1</option> -->
<!--                            <option value="2">2</option> -->
<!--                            <option value="3">3</option> -->
<!--                            <option value="4">4</option> -->
<!--                            <option value="5">5</option> -->
<!--                            <option value="6">6</option> -->
<!--                            <option value="7">7</option> -->
<!--                            <option value="8">8</option> -->
<!--                            <option value="9">9</option> -->
<!--                            <option value="10">10</option> -->
<!--                        </select> -->
<!--                        這些隱藏欄位都會送到後端 -->
<%--                        <Input type='hidden' name='bookId' value='${entry.value.bookId}'> --%>
<%--                        <Input type='hidden' name='pageNo' value='${param.pageNo}'> --%>
<!--                        <label><i class="fa-solid fa-cart-shopping"></i><Input type='submit' value='加入購物車'> -->
<!--                        </label> -->
<!--                      </Form> -->
<!--     </td> -->