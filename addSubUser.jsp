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
</head>
<script>
	function AllowAlphabet() {
		if (!ureg.fname.value.match(/^[a-zA-Z]+$/) && ureg.fname.value != "") {
			ureg.fname.value = "";
			ureg.fname.focus();
			alert("Please Enter only alphabet in First Name");
		}

		if (!ureg.lname.value.match(/^[a-zA-Z]+$/) && ureg.lname.value != "") {
			ureg.lname.value = "";
			ureg.lname.focus();
			alert("Please Enter only alphabets in Last Name");
		}

	}

	function validEmail() {
		var mail = document.ureg.email.value;
		if (mail == "") {
			ureg.email.value = "";
			alert("Please insert Email Address");

			return false;
		}
		if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
		} else {
			ureg.email.value = "";
			alert("Email Address is Not Valid");

			return false;
		}
	}
	function Validate() {
		var y = document.ureg.mnumber.value;

		if (y.charAt(0) != "7" && y.charAt(0) != "8" && y.charAt(0) != "9") {
			ureg.mnumber.value = "";
			alert("Invalide Start Digit");
			return false;
		}

		if (isNaN(y) || y.indexOf(" ") != -1) {

			ureg.mnumber.value = "";
			alert("Enter Only Numeric value");
			return false;
		}
		if (y.length != 10) {
			ureg.mnumber.value = "";
			alert("Enter 10 Number");
			return false;
		}

		if (!y.match(/^[0-9]+$/) && y != "") {
			y = "";

			ureg.mnumber.value = "";
			ureg.mnumber.focus();
			alert("Enter only Digits");
		}

	}
	function validuaernameandpass() {
		var pass = document.ureg.password.value;
		if (pass != "") {
			if (pass.length < 6) {
				ureg.password.value = "";
				alert("Password must contain at least 6 characters!");

				return false;
			}
		}
	}
</script>
<%
	if (request.getParameter("suspect") != null) {
		out.print("<script>alert('Suspect Detect Alert Send To Neares Police Station..! Be Safe..!')</script>");
	}
	if (request.getParameter("normal") != null) {
		out.print("<script>alert('Normal Person Detected..!')</script>");
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
								<jsp:include page="header/userHeader.jsp"></jsp:include>
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

				<div align="center" class="col-lg-12">
					<font style="font-size: 30px; color: blue;"><u>Add New
							Sub User </u></font>
					<div class="row pdn-top-30"></div>
					<div class="container">
						<form action="AddSubUser" method="POST" name="ureg">
							<table class="table">
								<tr>
									<td><label for="fname"><b>First Name</b></label></td>
									<td><input type="text" placeholder="Enter Full Name"
										name="fname" onblur="return AllowAlphabet()" required></td>
									<td>Last Name</td>
									<td><input type="text" placeholder="Enter Last Name"
										name="lname" onblur="return AllowAlphabet()" required></td>
								</tr>
								<tr>
									<td><label for="email"><b>UID Number</b></label></td>
									<td><input type="number" placeholder="Enter UID Number"
										name="uid" required></td>
									<td><label for="email"><b>Gender</b></label></td>
									<td><select name="gender">
											<option value="Male">Male</option>
											<option value="Female">Female</option>
									</select></td>
								</tr>
								<tr>
									<td><label for="email"><b>Reference By</b></label></td>
									<td><input type="text" placeholder="Enter Refernce Name"
										name="ref_name" required></td>
									<td><label for="email"><b>Reletive</b></label></td>
									<td><input type="text" placeholder="Enter Relation"
										name="relation" required></td>
			
								</tr>
								<tr>
									<td><label for="email"><b>Perment Address</b></label></td>
									<td><textarea rows="3" cols="30" required="required"
											name="p_address"></textarea></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td><label for="email"><b>Current Address</b></label></td>
									<td><textarea rows="3" cols="30" required="required" name="c_address"></textarea></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Create New Account" style="color: blue;"></td>
									<td></td>
									<td></td>
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
						<p>Criminal / Suspected Identification using Face</p>
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