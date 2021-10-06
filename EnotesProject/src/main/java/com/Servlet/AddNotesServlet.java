package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.PostDAO;
import com.Database.DbConnection;

/**
 * Servlet implementation class AddNotesServlet
 */
@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet
{

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {
        final int userID = Integer.parseInt(request.getParameter("userID"));
        final String title = request.getParameter("title");
        final String content = request.getParameter("content");

        final PostDAO postDAO = new PostDAO(DbConnection.getConn());
        final boolean f = postDAO.AddNotes(title, content, userID);

        if (f)
        {
            System.out.println("Data inserted successfully..");
            response.sendRedirect("shownotes.jsp");
        }
        else
        {
            System.out.println("Data not inserted");
        }
    }

}
