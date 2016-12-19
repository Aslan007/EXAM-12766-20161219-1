package com.hand.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil
{
	public static final String DBURL = 
		"jdbc:mysql://localhost:3306/sakila";
	public static final String USER = "lxtest";
	public static final String PASSWORD = "admin";
	public static Connection conn = null;
	private DbUtil()
	{
	}
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DBURL, USER, PASSWORD);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close()
	{
		if(conn != null)
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		
		//测试是否可以连接
		System.out.println(DbUtil.getConnection());
	}
}
