package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;

/**
 * Description.
 * @author INSERT USERNAME
 */
public class UserDAO
{

    private final Connection connection;

    /**
     * @param connection
     */
    public UserDAO(final Connection connection)
    {
        super();
        this.connection = connection;
    }

    /**
     * @param userDetails
     * @return true/false
     */
    public boolean addUser(final UserDetails userDetails)
    {
        boolean f = false;
        try
        {
            final String query = "insert into user(fullName,email_ID,password) values(?,?,?)";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userDetails.getName());
            preparedStatement.setString(2, userDetails.getEmail());
            preparedStatement.setString(3, userDetails.getPassword());
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
     * @param userDetails
     * @return userDetail
     */
    public UserDetails loginUser(final UserDetails userDetails)
    {
        UserDetails userDetail = null;
        try
        {
            final String query = "select * from user where email_ID=? and password=?";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userDetails.getEmail());
            preparedStatement.setString(2, userDetails.getPassword());
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {
                userDetail = new UserDetails();
                userDetail.setId(resultSet.getInt("user_ID"));
                userDetail.setName(resultSet.getString("fullName"));
                userDetail.setEmail(resultSet.getString("email_ID"));
                userDetail.setPassword("password");
            }

        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        return userDetail;
    }
}