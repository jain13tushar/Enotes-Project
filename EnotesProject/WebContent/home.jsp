<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
    UserDetails userDetails = (UserDetails) session.getAttribute("userD");

    if (userDetails == null)
    {
        response.sendRedirect("login.jsp");
		session.setAttribute("Login-error","Please Login..");
    }
%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>home page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<div class="container-fluid p-0">
		<%@include file="all_component/navbar.jsp"%>
		<div class="card py-5">
			<div class="card-body text-center">
				<img alt="" src="image/paper.jpg" class="img-fluid mx-auto"
					style="width: 450px;">
				<h1>START TAKING YOUR NOTES</h1>
				<a href="addnotes.jsp" class="btn btn-outline-primary">Start Here</a>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>