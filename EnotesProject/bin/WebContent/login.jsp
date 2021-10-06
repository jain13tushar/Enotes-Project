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
					<div class="card-body">
						<form>
							<div class="mb-5">
								<label>Enter Email</label> <input type="email"
									class="form-control" id="exampleInputEmail"
									aria-describedby="emailHelp">
							</div>
							<div class="mb-5">
								<label>Enter Password</label><input type="password"
									class="form-control" id="exampleInputPassword">
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