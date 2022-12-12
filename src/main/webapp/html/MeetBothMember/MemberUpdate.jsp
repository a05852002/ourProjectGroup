<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String photoPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/MeetBothMember/photo.jpg";
%>
<%
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/assets/css/main.css";
%>
		<! DOCTYPE html>
		<html lang="en">

		<head>
			<title>會員管理</title>
			<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
			<link rel="stylesheet" href="<%=basePath%>" />
			<script src="https://kit.fontawesome.com/2688683da7.js" crossorigin="anonymous"></script>
			<script type="text/javascript">
				function checkpwd(){
					if(pas1check.value != pas2check.value){
						alert("密碼不一致");
						pas2check.value="";
					}
				}
			</script>
		</head>

		<body class="is-preload">

			<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
				<div id="main">
					<div class="inner">

						<!-- Header -->
						<header id="header">
							<a href="index.html" class="logo"><strong>會員資料修改</strong></a>
							<ul class="icons">
								<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a>
								</li>
								<li><a href="#" class="icon brands fa-facebook-f"><span
											class="label">Facebook</span></a></li>
								<li><a href="#" class="icon brands fa-snapchat-ghost"><span
											class="label">Snapchat</span></a>
								</li>
								<li><a href="#" class="icon brands fa-instagram"><span
											class="label">Instagram</span></a></li>
								<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a>
								</li>
							</ul>
						</header>

						<!-- Content -->
						<section>
							<header class="main">

								<form method="post" action="<c:url value='/meetbothmember/update.do' />" enctype='multipart/form-data'>

									<div class="table-wrapper">
										<table class="alt">
										<c:forEach var="Member" items="${Member}">
											<tr>
												<td style="width: 150px;">
													<label>帳號：</label>
												</td>
												<td>
													<input type="text" style="background-color:	#D0D0D0" name="account" value="${Member.account}" readonly="readonly" required>
												</td>
												<td rowspan="4" style="width:250px; height:250px">
												<div style="float:center;">
												<img src="photo.jpg">
												<input name='photo' type='file' /><br>&nbsp;
												</div>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>密碼：</label>
												</td>
												<td>
													<input type="password" id="pas1check" name="password" value="${Member.password}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>確認密碼：</label>
												</td>
												<td>
													<input type="password" id="pas2check" onblur="checkpwd()" name="passwordcheck" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>身分證字號：</label>
												</td>
												<td>
													<input type="text" style="background-color:	#D0D0D0" name="idNumber" value="${Member.idNumber}" readonly="readonly" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>姓名：</label>
												</td>
												<td colspan="2">
													<input type="text" name="memName" value="${Member.memName}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>暱稱：</label>
												</td>
												<td colspan="2">
													<input type="text" name="memNickName" value="${Member.memNickName}">
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>年齡：</label>
												</td>
												<td colspan="2">
													<input type="text" name="memOld" oninput = "value=value.replace(/[^\d]/g,'')" value='${Member.memOld}' required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>生日：</label>
												</td>
												<td colspan="2">
													<input type="Date" style="background-color:	#D0D0D0" name="memBirth" value="${Member.memBirth}" readonly="readonly" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>性別：</label>
												</td>
												<td colspan="2">
													<input type="text" style="background-color:	#D0D0D0" name="memGender" value="${Member.memGender}" readonly="readonly" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;" >
													<label>電子郵件：</label>
												</td>
												<td colspan="2">
													<input type="text" name="email" value="${Member.eMail}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;" >
													<label>手機：</label>
												</td>
												<td colspan="2">
													<input type="text" name="phone" oninput = "value=value.replace(/[^\d]/g,'')" value="${Member.phone}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;" >
													<label>地址：</label>
												</td>
												<td colspan="2">
													<input type="text" name="address" value="${Member.address}" required>
												</td>
											</tr>
											
											<tr height="42">
      											<td colspan='4'>
      												<div align="center">
        	 											<input type="submit" name="submit" id="submit" value="儲存"/>
         												<input type="reset" name="cancel" id="cancel" value="重填">
      												</div>
												</td>
											</tr>
											</c:forEach>
										</table>
								</form>
					</div>
					</header>

					<span class="image main"><img src="images/pic11.jpg" alt="" /></span>


					</section>

				</div>
			</div>

			<!-- Sidebar -->
			<div id="sidebar">
				<div class="inner">

					<!-- Search -->
					<section id="search" class="alt">
						<form method="post" action="#">
							<input type="text" name="query" id="query" placeholder="Search" />
						</form>
					</section>

					<!-- Menu -->
					<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<h2>選單</h2>
					</header>
					<ul>
						<li><a href="topic-home.html">首頁</a></li>
						<li><a href="admin.jsp">會員資料</a></li>
						<li><a href="<c:url value='/Servlet/searchAllTeacServlet' />">找老師</a></li>
						<li><a href="elements.html">找學生</a></li>
						<li>
							<span class="opener">科目搜尋</span>
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
							</ul>
						</li>
						<li>
							<span class="opener">教學地點搜尋</span>
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
							</ul>
						</li>
						<li><a href="#">討論區</a></li>
						<li>
							<span class="opener">Another Submenu</span>
							<ul>
								<li><a href="#">Lorem Dolor</a></li>
								<li><a href="#">Ipsum Adipiscing</a></li>
								<li><a href="#">Tempus Magna</a></li>
								<li><a href="#">Feugiat Veroeros</a></li>
							</ul>
						</li>
						<li><a href="#">Maximus Erat</a></li>
						<li><a href="#">Sapien Mauris</a></li>
						<li><a href="#">Amet Lacinia</a></li>
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
						<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim
							lorem
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
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/browser.min.js"></script>
			<script src="../assets/js/breakpoints.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<script src="../assets/js/main.js"></script>

		</body>

		</html>