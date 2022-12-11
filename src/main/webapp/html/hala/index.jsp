<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='debug' value='true' scope='application' />

<!DOCTYPE HTML>
<html lang="zh-hant-TW">
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/assets/css/main.css";
%>
<%
String imgPath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/images/meatball-icon.png";
%>
<%
String imgPath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/images/meatball-200.png";
%>
<head>
<link rel="stylesheet" href="<%=basePath%>" />
<link rel="shortcut icon" href="<%=imgPath1%>" />
<link rel="bookmark" href="<%=imgPath2%>" />
<title>肉丸家教網 MEET BOTH</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="topic-home.html" class="logo"><strong>肉丸家教網
							MEET BOTH</strong></a>

				</header>



				<!-- Section -->
				<section>
					<header class="major">
						<h2>家教推薦</h2>
					</header>
					<div class="posts">
						<article>
							<a href="#" class="image"><img src="images/潘宣翰.jpg" alt="" /></a>
							<h3>潘宣翰</h3>
							<p>頂大高材生，精通物理數社自，擅長教國中女生，保證讓他學好不學壞。</p>
							<ul class="icons">
								<li><a href="https://www.instagram.com/flower19980102/"
									class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="https://www.facebook.com/pan.x.hua"
									class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							</ul>
							<ul class="actions">
								<li><a href="#" class="button">查看更多</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/李政儒.jpg" alt="" /></a>
							<h3>李政儒 有夠帥</h3>
							<p>私立大學畢業，專長是健康教育，特長是特長，能讓您的學生健康有活力。</p>
							<ul class="icons">
								<li><a href="https://www.instagram.com/eric12341231/"
									class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a
									href="https://www.facebook.com/profile.php?id=100000534099261&sk=photos"
									class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							</ul>
							<ul class="actions">
								<li><a href="#" class="button">查看更多</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/楊晨.jpg" alt="" /></a>
							<h3>楊晨</h3>
							<p>清華高材生，第五組的救星，家教網的神</p>
							<ul class="icons">
								<!-- <li><a href="https://www.instagram.com/eric12341231/"
										class="icon brands fa-instagram"><span class="label">Instagram</span></a></li> -->
								<li><a
									href="https://www.facebook.com/profile.php?id=100000334310875"
									class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							</ul>
							<ul class="actions">
								<li><a href="#" class="button">查看更多</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/陳奕均.jpg" alt="" /></a>
							<h3>陳奕均</h3>
							<p>台大清純系女神，一小500，棋琴書畫樣樣精通，另有特戰英豪陪玩，一小1200</p>
							<ul class="icons">
								<li><a href="https://www.instagram.com/chen_1chun/"
									class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="https://www.facebook.com/chen1jean"
									class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							</ul>
							<ul class="actions">
								<li><a href="#" class="button">查看更多</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/黃凱莉.jpg" alt="" /></a>
							<h3>黃凱莉</h3>
							<p>我是本丸，第五組唯一棟樑，一小600，肉丸家教網創辦人</p>
							<ul class="icons">
								<li><a href="https://www.instagram.com4/li.how.ma/"
									class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a
									href="https://www.facebook.com/groups/775198470403444/user/1837193312"
									class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							</ul>
							<ul class="actions">
								<li><a href="#" class="button">查看更多</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/翁茂軒.jpg" alt="" /></a>
							<h3>翁茂軒</h3>
							<p>口袋怪獸最喜歡吃媽媽做的蛋糕，人傑御用口袋，中原物理系最喜歡幫學妹物理治療</p>
							<ul class="icons">
								<li><a href="https://www.instagram.com/wengmaoxuan/"
									class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a
									href="https://www.facebook.com/profile.php?id=100002682807006"
									class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							</ul>
							<ul class="actions">
								<li><a href="#" class="button">查看更多</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/呂介棠.jpg" alt="" /></a>
							<h3>呂介棠</h3>
							<p>永和渣男，Java五條老師，教你領域展開，下棋放鳥兩個月，媽的</p>
							<ul class="icons">
								<!-- <li><a href="https://www.instagram.com/wengmaoxuan/"
										class="icon brands fa-instagram"><span class="label">Instagram</span></a></li> -->
								<li><a
									href="https://www.facebook.com/profile.php?id=100000342310612"
									class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							</ul>
							<ul class="actions">
								<li><a href="#" class="button">查看更多</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/范凱玟.jpg" alt="" /></a>
							<h3>范凱玟</h3>
							<p>東華歷史大神，能把你的歷史到背如流，黑歷史也是</p>
							<ul class="icons">
								<li><a href="https://www.instagram.com/hcc8462/"
									class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a
									href="https://www.facebook.com/profile.php?id=100002334559565"
									class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							</ul>
							<ul class="actions">
								<li><a href="#" class="button">查看更多</a></li>
							</ul>
						</article>
					</div>
				</section>

			</div>
		</div>

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
						<li><a href="topic-home.html">首頁</a></li>
						<li><a href="generic.html">會員資料</a></li>
						<li><a href="elements.html">找老師</a></li>
						<li><a href="elements.html">找學生</a></li>
						<li><span class="opener">科目搜尋</span>
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
						<li><span class="opener">教學地點搜尋</span>
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
						<li><span class="opener">討論區</span>
							<ul>
								<li><a href="<c:url value='/halaservlet/crudservlet' />">文章</a></li>
								<li><a href="<c:url value='/qaservlet/qacrud' />">Q&A解答區</a></li>
							</ul></li>
						<li><span class="opener">Another Submenu</span>
							<ul> 
								<li><a href="#">Lorem Dolor</a></li>
								<li><a href="#">Ipsum Adipiscing</a></li>
								<li><a href="#">Tempus Magna</a></li>
								<li><a href="#">Feugiat Veroeros</a></li>
							</ul></li>
						<li><a href="#">Maximus Erat</a></li>
						<li><a href="#">Sapien Mauris</a></li>
						<li><a href="#">Amet Lacinia</a></li>
					</ul>
				</nav>



				<!-- Section -->
				<section>
					<header class="major">
						<h2>聯絡我們</h2>
					</header>
					<p>肉丸家教網是一個希望不管是學生還是老師，都能在這裡精進自己，花最少的時間，找到最棒的老師/學生。</p>
					<ul class="contact">
						<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
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