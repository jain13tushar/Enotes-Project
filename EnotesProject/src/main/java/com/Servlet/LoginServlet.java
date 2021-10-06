package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Database.DbConnection;
import com.User.UserDetails;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet
{

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {
        final String email = request.getParameter("uemail");
        final String password = request.getParameter("upassword");

        final UserDetails userDetails = new UserDetails();
        userDetails.setEmail(email);
        userDetails.setPassword(password);

        final UserDAO userDAO = new UserDAO(DbConnection.getConn());
        final UserDetails userDetail = userDAO.loginUser(userDetails);

        final HttpSession httpSession = request.getSession();

        if (userDetail != null)
        {
            httpSession.setAttribute("userD", userDetail);
            response.sendRedirect("home.jsp");
        }
        else
        {
            httpSession.setAttribute("login-failed", "Invalid Username and Password");
            response.sendRedirect("login.jsp");
        }

    }

}
