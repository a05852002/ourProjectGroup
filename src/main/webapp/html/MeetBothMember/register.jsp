<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<title>會員管理</title>
			<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
			<link rel="stylesheet" href="../html/assets/css/main.css" />
			<script src="https://kit.fontawesome.com/2688683da7.js" crossorigin="anonymous"></script>
			<script type="text/javascript">
				function checkpwd()
				{
					if(pas1check.value != pas2check.value){
						alert("密碼不一致");
						pas2check.value="";
					}
				}
			</script>
			
			<script type="text/javascript">
				function checkID() 
				{
		            let check = String(idNumber.value);
		            check = check.toUpperCase();
		            let firstCheck = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		            if (check.length == 10) {
		                if (firstCheck.indexOf(check[0]) != "-1") {//這邊有問題
		                    if (check[1] == 1 || check[1] == 2) {
		                        let numberCheck = "0123456789"
		                        for (let i = 2; i < check.length; i++) {
		                            if (numberCheck.indexOf(check[i]) == (-1)) {
		                                alert("身分證數字列出現非數字！");
		                                idNumber.value="";
		                                return;
		                            }
		                        }
		                    } else {
		                        alert("性別數字不合規範！");
		                        idNumber.value="";
		                        return;
		                    }
		                } else {
		                    alert("首字不是英文！");
		                    idNumber.value="";
		                    return;
		                }
		            } else {
		                alert("身分證長度不符！");
		                idNumber.value="";
		                return;
		            }
		            let lastchar = check[9];
		            let firstChar = 0;
		            let num1 = 0, num2 = 0;
		            // 取出第一個字轉換成對應數字
		            for (let i = 0; i < 26; i++) {
		                if (check[0] == firstCheck[i]) {
		                    firstChar = i + 10;
		                    num1 = parseInt(Math.floor(firstChar / 10));
		                    num2 = firstChar - (num1 * 10);
		                    break;
		                }
		            }
		            let total = 0;
		            for (let i = 1; i < check.length - 1; i++) {
		                total += parseInt(check[i]) * (9 - i);
		            }
		            total = total + num1 * 1 + num2 * 9;
		            let checknumber = 10 - (total % 10);
		            if (lastchar != checknumber) {
		            	alert("身分證檢查碼錯誤");
		            	idNumber.value="";
		            }
		        }
				</script>
				<script type="text/javascript">
				function pasvalid()
				{
					let password = pas1check.value;
					var regex = new RegExp(/^((?=.{8,}$)(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).*|(?=.{8,}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!\u0022#$%&'\''()*+,./:;<=>?@[\]\^_`{|}~-]).*)/, "g");
					if(password.length<6 || password.length>12){
						alert("密碼過長或過短");
					}else if( password.match(regex)==null)
						{
							alert("密碼不符合規範！");
							pas1check.value = "";
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
							<a href="register.jsp" class="logo"><strong>會員註冊</strong></a>
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

								<form method="post" action="<c:url value='/meetbothmember/register.do' />" enctype='multipart/form-data'>

									<div class="table-wrapper">
										<table class="alt">
											<tr>
												<td style="width: 150px;">
													<label>帳號：</label>
												</td>
												<td>
													<input type="text" placeholder="請輸入帳號" name="account" value="${param.account}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>密碼：</label>
												</td>
												<td>
													<input type="password" onblur="pasvalid()" placeholder="請輸入6 - 12位密碼，且須包含英文大寫、小寫、數字、特殊符號。" id="pas1check" name="password" value="${param.password}"  required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>確認密碼：</label>
												</td>
												<td>
													<input type="password" placeholder="請再輸入一次。" id="pas2check" onblur="checkpwd()" name="passwordcheck" value="${param.passwordcheck}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>身分證字號：</label>
												</td>
												<td>
													<input type="text" placeholder="請輸入中華民國身分證字號" id="idNumber" name="idNumber" onblur="checkID()" value="${param.idNumber}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>姓名：</label>
												</td>
												<td>
													<input type="text" placeholder="請輸入真實姓名" name="memName" value="${param.memname}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>暱稱：</label>
												</td>
												<td>
													<input type="text" placeholder="請輸入暱稱" name="memNickName" value="${param.memNickname}">
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>年齡：</label>
												</td>
												<td>
													<input type="text" name="memOld" oninput = "value=value.replace(/[^\d]/g,'')" value="${param.memOld}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>生日：</label>
												</td>
												<td>
													<input type="Date" name="memBirth" value="${param.memBirth}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;">
													<label>性別：</label>
												</td>
												<td>
													<select name="memGender" style="width: 150px;" required>
														<option value="">請選擇</option>
														<option value="男">男</option>
														<option value="女">女</option>
													</select>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;" >
													<label>電子郵件：</label>
												</td>
												<td>
													<input type="text" name="email" value="${param.email}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;" >
													<label>手機：</label>
												</td>
												<td>
													<input type="text" name="phone" oninput = "value=value.replace(/[^\d]/g,'')" value="${param.phone}" required>
												</td>
											</tr>
											<tr>
												<td style="width: 150px;" >
													<label>地址：</label>
												</td>
												<td>
													<input type="text" name="address" value="${param.address}" required>
												</td>
											</tr>
											<tr>
											<td>
												<label class="fontSize">照片：</label><br>&nbsp;
											</td>
											<td>
												<input name='photo' type='file' accept="imagr/jpg" placeholder="請使用jpg檔案" ><br>&nbsp;
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
			<script src="../html/assets/js/jquery.min.js"></script>
			<script src="../html/assets/js/browser.min.js"></script>
			<script src="../html/assets/js/breakpoints.min.js"></script>
			<script src="../html/assets/js/util.js"></script>
			<script src="../html/assets/js/main.js"></script>

		</body>

		</html>