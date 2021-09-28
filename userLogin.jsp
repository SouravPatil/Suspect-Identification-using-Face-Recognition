<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title><jsp:include page="header/projectTitle.jsp"></jsp:include>
</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<!-- bootstrap css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" href="css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<!-- owl stylesheets -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->

<script>
	var x = document.getElementById("demo");
	var lt = document.getElementById("lt");
	var lng = document.getElementById("lng");

	function getLocation() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(showPosition);
		} else {
			x.innerHTML = "Geolocation is not supported by this browser.";
		}
	}

	function showPosition(position) {
		/*  x.innerHTML = "Latitude: " + position.coords.latitude + 
		 "<br>Longitude: " + position.coords.longitude;
		 */
		var lt = position.coords.latitude;
		var lng = position.coords.longitude;

		document.getElementById("lt").value = lt;
		document.getElementById("lng").value = lng;
		;

		var latlng = new google.maps.LatLng(lt, lng);
		var geocoder = geocoder = new google.maps.Geocoder();
		geocoder.geocode({
			'latLng' : latlng
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[1]) {
					alert("Location: " + results[1].formatted_address);
				}
			}
		});

	}
</script>

</head>

<%

if(request.getParameter("already")!=null)
{
	out.print("<script>alert('UID or Email ID Alredy Exist..')</script>");
}
if(request.getParameter("login")!=null)
{
	out.print("<script>alert('Incorrect Login Credintials..')</script>");
}
if(request.getParameter("reg")!=null)
{
	out.print("<script>alert('Registration Done..')</script>s");
}
%>

<!-- body -->
<body class="main-layout">
	<!-- loader  -->
	<div class="loader_bg">
		<div class="loader">
			<img src="images/loading.gif" alt="#" />
		</div>
	</div>
	<!-- end loader -->
	<!-- header -->
	<header>
		<!-- header inner -->
		<div class="header">
			<div class="header_white_section">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="header_information">
								<jsp:include page="header/subHeader.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
						<div class="full">
							<div class="center-desk">
								<h3 style="font-size: 18px; color: white;">
									<jsp:include page="header/projectTitle.jsp"></jsp:include></h3>
							</div>
						</div>
					</div>
					<div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
						<div class="menu-area">
							<div class="limit-box">
								<jsp:include page="header/mainHeader.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end header inner -->
	</header>
	<!-- end header -->
	<div class="row pdn-top-30"></div>
	<section>
		<div class="container">
			<div class="row">
				<div align="center" class="col-lg-6">
					<img src="image/img0.jpg" style="width: 100%">
				</div>
				<div align="center" class="col-lg-6">
					<div class="row pdn-top-30"></div>
					<font style="font-size:30px; color: blue;"><u>Login</u> / <u>SignUp</u></font>
					<div class="row pdn-top-30"></div>
					<div class="container">
					<form action="UserLogin" method="POST">
						<table class="table">
							<tr>
								<td><label for="uname"><b>Email ID</b></label></td>
								<td><input type="text" placeholder="Enter Email ID"
									name="email" required></td>
							</tr>
							<tr>
								<td><label for="psw"><b>Password</b></label></td>
								<td><input type="password" placeholder="Enter Password"
									name="password" required></td>
							</tr>
							<tr>
								<td></td>
								<td><button type="submit" class="btn btn-primary" onclick="getLocation()">Login Account</button></td>
							</tr>
							<tr>
									<th>Location(AutoRetrvie)</th>
									<td><input type="text" id="lt" style="width: 120px;" name="lt" required>
									 &nbsp;<input type="text" id="lng" style="width: 120px;" name="lng" required></td>
							</tr>
							<tr>
								<td></td>
								<td><a href="userRegistration.jsp" style="color: blue;"><u>Create New User / Sign Up</u></a></td>
							</tr>
						</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- footer -->
	<footer>
		<div id="contact" class="footer">
			<div class="container">
				<div class="row pdn-top-30"></div>
				<div class="copyright">
					<div class="container">
						<p>
							Criminal / Suspected Identification using Face
						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- end footer -->
	<!-- Javascript files-->
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.0.0.min.js"></script>
	<script src="js/plugin.js"></script>
	<!-- sidebar -->
	<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="js/custom.js"></script>
	<!-- javascript -->
	<script src="js/owl.carousel.js"></script>

</body>
</html>