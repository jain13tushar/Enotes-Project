<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.back-img {
	background: url("image/note.jpg");
	background-size: 1950px 950px;
	width: 100%;
	height: 80vh;
}
</style>
<title>Login Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid back-img">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-5">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-sign-in fa-3x" aria-hidden="true"></i>
						<h4>Login Page</h4>
					</div>

					<%
					    String invalidMessage = (String) session.getAttribute("login-failed");
					    if (invalidMessage != null)
					    {
					%>

					<div class="alert alert-danger" role="alert"><%=invalidMessage%></div>
					<%
					    session.removeAttribute("login-failed");
					    }
					%>
					
					<%
						String withoutLogin = (String) session.getAttribute("Login-error");
						if(withoutLogin != null)
						{
						    
					%>
					
					<div class="alert alert-danger" role="alert"><%=withoutLogin%></div>
						    
					<%
						session.removeAttribute("Login-error");    
						}
					%>
					
					<%
						String logoutMessage = (String)session.getAttribute("Logout-msg");
					
						if(logoutMessage != null)
						{
					%>
					
					<div class="alert alert-success" role="alert"><%=logoutMessage%></div>
					
					<%
						session.removeAttribute("Logout-msg");
						}
					%>

					<div class="card-body">
						<form action="loginServlet" method="post">
							<div class="mb-5">
								<label>Enter Email</label> <input type="email"
									class="form-control" id="exampleInputEmail"
									aria-describedby="emailHelp" name="uemail">
							</div>
							<div class="mb-5">
								<label>Enter Password</label><input type="password"
									class="form-control" id="exampleInputPassword" name="upassword">
							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>