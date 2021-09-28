
<%
	String u_type=session.getAttribute("u_type").toString();
	if(u_type.equals("Geust"))
	{
	%>

<ul>
	<li><img src="images/1.png" alt="#" /> Address</li>
	<li><img src="images/2.png" alt="#" /> 100 &nbsp;&nbsp; 24/7
		Available</li>
	<li><img src="images/3.png" alt="#" /> help@police.com</li>
</ul>

<%}
	else if(u_type.equals("Police"))
	{
		String email=session.getAttribute("email").toString();
		String pname=session.getAttribute("pname").toString();
		
%>
<ul>
	<li><button type="button" class="btn btn-primary"> <a href="userHome.jsp">HOME PAGE</a></button></li>
	<li><img src="images/2.png" alt="#" /> 100 &nbsp;&nbsp; 24/7
		Available</li>
	<li><img src="images/3.png" alt="#" />help@police.com</li>
</ul>

<%
		%>
<ul>
	<li><img src="images/1.png" alt="#" /></li>
	<li><img src="images/2.png" alt="#" /> 100 &nbsp;&nbsp; 24/7
		Available</li>
	<li><img src="images/3.png" alt="#" /></li>
</ul>

<%		
	}
%>