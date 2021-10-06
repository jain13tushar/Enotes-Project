package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {

        try
        {
            final HttpSession httpSession = request.getSession();
            httpSession.removeAttribute("userD");

            final HttpSession httpSession2 = request.getSession();
            httpSession2.setAttribute("Logout-msg", "Logout Successfully..");
            response.sendRedirect("login.jsp");
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }
}