<%@page import="com.User.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.Database.DbConnection"%>
<%@page import="com.DAO.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
    UserDetails userDetails3 = (UserDetails) session.getAttribute("userD");

    if (userDetails3 == null)
    {
        response.sendRedirect("login.jsp");
        session.setAttribute("Login-error", "Please Login..");
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<%
	    String updateMsg = (String) session.getAttribute("updateMsg");
	    if (updateMsg != null)
	    {
	%>
	<div class="alert alert-success" role="alert"><%=updateMsg%></div>
	<%
	    session.removeAttribute("updateMsg");
	    }
	%>

	<%
	    String wrongMsg = (String) session.getAttribute("wrongMsg");
	    if (wrongMsg != null)
	    {
	%>
	<div class="alert alert-danger" role="alert"><%=wrongMsg%></div>
	<%
	    session.removeAttribute("wrongMsg");
	    }
	%>
	<div class="container">
		<h2 class="text-center">All Notes:</h2>
		<div class="row">
			<div class="col-md-12">
				<%
				    if (userDetails3 != null)
				    {
				        PostDAO postDAO = new PostDAO(DbConnection.getConn());
				        List<Post> postLists = postDAO.getData(userDetails3.getId());
				        for (Post postList : postLists)
				        {
				%>
				<div class="card mt-3">
					<img alt="" src="image/paper.jpg" class="card-img-top mt-2 mx-auto"
						style="max-width: 100px;">

					<div class="card-body p-4">
						<h5 class="card-title"><%=postList.getTitle()%></h5>
						<p><%=postList.getContent()%></p>

						<p>
							<b class="text-success">Published By: <%=userDetails3.getName()%>
							</b></br> <b class="text-primary"></b>
						</p>

						<p>
							<b class="text-success">Published Date: <%=postList.getNotesDate()%>
							</b></br> <b class="text-success"></b>
						</p>

						<div class="container text-center mt-2">
							<a href="DeleteServlet?note_id=<%=postList.getnId()%>"
								class="btn btn-danger">Delete</a> <a
								href="edit.jsp?note_id=<%=postList.getnId()%>"
								class="btn btn-primary">Edit</a>
						</div>
					</div>
				</div>
				<%
				    }
				    }
				%>
			</div>
		</div>
	</div>
</body>
</html>