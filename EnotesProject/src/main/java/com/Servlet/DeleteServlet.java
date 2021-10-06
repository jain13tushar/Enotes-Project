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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {
        final Integer notesId = Integer.parseInt(request.getParameter("note_id"));
        final PostDAO postDAO = new PostDAO(DbConnection.getConn());
        final boolean f = postDAO.DeleteNotes(notesId);
        HttpSession session = null;
        if (f)
        {
            System.out.println("Data deleted Successfully");
            session = request.getSession();
            session.setAttribute("updateMsg", "Notes Deleted Successfully");
            response.sendRedirect("shownotes.jsp");
        }
        else
        {
            System.out.println("Data not deleted Successfully");
            session = request.getSession();
            session.setAttribute("wrongMsg", "Something went wrong on server..");
            response.sendRedirect("shownotes.jsp");
        }
    }
}