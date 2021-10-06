package com.Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Description.
 * @author INSERT USERNAME
 */
public class DbConnection
{

    private static Connection connection;

    /**
     * @return connection
     */
    public static Connection getConn()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes", "root", "root");

        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
        return connection;

    }

}
