<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dbconnection.DatabaseConnection"%>
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
								<jsp:include page="header/policeHeader.jsp"></jsp:include>
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
		<div class="container" align="center">
			<h1>View All User Details</h1>
			<hr/>
			<table class="table">
				<tr>
					<th>Sr.No</th>
					<th>Full Name</th>
					<th>UID </th>
					<th>Email ID</th>
				</tr>
			
			
			<%
					
					Connection con =DatabaseConnection.getConnection();
					
					PreparedStatement pst = con.prepareStatement("SELECT * FROM `user_details`");
					ResultSet rs = pst.executeQuery();
					int i=0;
					while(rs.next())
					{
						i++;
					%>
						<tr>
							<th><%=i %></th>
							<td><%=rs.getString("fname") %></td>
							<td><%=rs.getString("uid") %></td>
							<td><%=rs.getString("email") %></td>
						</tr>					
					<%} %>
			</table>		
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