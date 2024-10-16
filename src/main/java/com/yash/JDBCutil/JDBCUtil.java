package com.yash.JDBCutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil 
{
    private static final String url = "jdbc:mysql://localhost:3306/donations";
    private static final String username = "root";
    private static final String password = "root";

    public Connection getConnection() 
    {
        try 
        {
            return DriverManager.getConnection(url, username, password);
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException("Error connecting to database: " + e.getMessage(), e);
        }
    }

    public void closeConnection(Connection conn) 
    {
        if (conn != null) 
        {
            try 
            {
                conn.close();
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Error closing database connection: " + e.getMessage(), e);
            }
        }
    }
}