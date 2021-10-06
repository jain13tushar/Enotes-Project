package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PostDAO;
import com.Database.DbConnection;

/**
 * Servlet implementation class EditNotesServlet
 */
@WebServlet("/EditNotesServlet")
public class EditNotesServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            final Integer noteId = Integer.parseInt(request.getParameter("noteid"));
            final String title = request.getParameter("title");
            final String content = request.getParameter("content");

            final PostDAO postDAO = new PostDAO(DbConnection.getConn());
            final boolean f = postDAO.PostUpdate(noteId, title, content);

            if (f)
            {
                System.out.println("Data update Successfully");
                final HttpSession session = request.getSession();
                session.setAttribute("updateMsg", "Notes Updated Successfully");
                response.sendRedirect("shownotes.jsp");
            }
            else
            {
                System.out.println("Data not updated Successfully");
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }

}
