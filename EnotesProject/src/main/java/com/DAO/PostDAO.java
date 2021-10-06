package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.User.Post;

/**
 * Description.
 * @author INSERT USERNAME
 */
public class PostDAO
{

    private final Connection connection;

    /**
     *
     */
    public PostDAO(final Connection connection)
    {
        super();
        this.connection = connection;
    }

    /**
     * @param title
     * @param content
     * @param uid
     * @return
     */
    public boolean AddNotes(final String title, final String content, final int uid)
    {
        boolean f = false;

        try
        {
            final String query = "insert into post(title, content, userID) values(?,?,?)";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setInt(3, uid);

            final int count = preparedStatement.executeUpdate();

            if (count == 1)
            {
                f = true;
            }

        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        return f;
    }

    /**
     * @param id
     * @return
     */
    public List<Post> getData(final int id)
    {
        final List<Post> list = new ArrayList<Post>();
        Post post = null;
        try
        {
            final String query = "Select * from post where userID = ? order by notesID desc";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                post = new Post();
                post.setnId(resultSet.getInt(1));
                post.setTitle(resultSet.getString(2));
                post.setContent(resultSet.getString(3));
                post.setNotesDate(resultSet.getTimestamp(4));
                list.add(post);
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
        return list;

    }

    /**
     * @param noteID
     * @return
     */
    public Post getDataById(final int notesID)
    {
        Post post = null;
        try
        {
            final String query = "Select * from post where notesID = ?";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, notesID);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                post = new Post();
                post.setnId(resultSet.getInt(1));
                post.setTitle(resultSet.getString(2));
                post.setContent(resultSet.getString(3));
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
        return post;

    }

    /**
     * @param notesId
     * @param title
     * @param content
     * @return
     */
    public boolean PostUpdate(final int notesId, final String title, final String content)
    {
        boolean f = false;

        try
        {
            final String query = "update post set title = ?, content = ? where notesID = ?";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setInt(3, notesId);
            final int i = preparedStatement.executeUpdate();
            if (i == 1)
            {
                f = true;
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }

    /**
     * @param notesId
     * @return
     */
    public boolean DeleteNotes(final int notesId)
    {
        boolean f = false;
        try
        {
            final String query = "delete from post where notesID = ?";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, notesId);
            final int i = preparedStatement.executeUpdate();
            if (i == 1)
            {
                f = true;
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
        return f;

    }

}
