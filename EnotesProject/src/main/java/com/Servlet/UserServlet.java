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
 * Description.
 * @author INSERT USERNAME
 */

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet
{
    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {
        final String name = request.getParameter("fname");
        final String email = request.getParameter("uemail");
        final String password = request.getParameter("upassword");

        final UserDetails userDetails = new UserDetails();
        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setPassword(password);

        final UserDAO userDAO = new UserDAO(DbConnection.getConn());
        final boolean f = userDAO.addUser(userDetails);
        HttpSession httpSession;
        httpSession = request.getSession();

        if (f)
        {
            httpSession.setAttribute("reg-success", "Registeration Successfull..");
        }
        else
        {
            httpSession.setAttribute("reg-failed", "Something went wrong on server..");
        }

        response.sendRedirect("register.jsp");
    }
}
