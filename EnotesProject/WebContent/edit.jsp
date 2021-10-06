<%@page import="com.User.Post"%>
<%@page import="com.Database.DbConnection"%>
<%@page import="com.DAO.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
    UserDetails userDetailsLogout = (UserDetails) session.getAttribute("userD");

    if (userDetailsLogout == null)
    {
        response.sendRedirect("login.jsp");
        session.setAttribute("Login-error", "Please Login..");
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>

	<%
	    Integer notesID = Integer.parseInt(request.getParameter("note_id"));
		PostDAO postDAO = new PostDAO(DbConnection.getConn());
		Post post = postDAO.getDataById(notesID);
		
	%>

	<div class="container-fluid p-0">
		<%@include file="all_component/navbar.jsp"%>
		<br></br>
		<h1 class="text-center">Edit Your Notes</h1>
		<br></br>
		<div class="container">
			<div class="row">
				<div class="col-md-14"></div>
				<form action="EditNotesServlet" method="post">
					<input type="hidden" value="<%=notesID%>" name="noteid">
					<div class="form-group">
						<label for="exampleInputEmail1">Enter Title</label> <input
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="title" required="required" value="<%=post.getTitle()%>">
					</div>
					<div class="form-group">
						<br></br> <label for="exampleInputEmail1">Enter Contents</label>
						<textarea rows="9" cols="" class="form-control" name="content"
							required="required" style="width: 1150px"><%=post.getContent() %></textarea>
					</div>
					<div class="container text-center">
						<br></br>
						<button type="submit" class="btn btn-primary">Add Notes</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>