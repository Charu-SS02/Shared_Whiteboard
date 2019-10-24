package model.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.State;

public class DataBase
{
	// For now we will use the SQLite for the DB

	public final static String dbName = "Database.db";

	public static Boolean Login(String id, String pwd)
	{
		//CreateTables();
		//AddLogin("demo","demo");
		Connection connection = null;

		try
		{
			if(!DBAvailable(dbName)) return null;

			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:"+dbName);

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String searchQuery = "SELECT * from login WHERE id='"+id+"' AND pwd='"+pwd+"'";

			ResultSet resultSet = statement.executeQuery(searchQuery);


			if(resultSet.next())
			{
				connection.close();
				return true;
			}
			connection.close();
			return false;
		}

		catch(SQLException e)
		{
			State.ErrorLog(e.getMessage());
			return false;
		}
		finally
		{
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(SQLException e)
			{
				State.ErrorLog(e.getMessage());
				return false;
			}
		}
	}

	public static Boolean AddLogin(String id,String pwd)
	{
		Connection connection = null;

		try
		{
			if(!DBAvailable(dbName)) return false;

			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:"+dbName);

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);



			String query = "INSERT INTO login VALUES ('"+id+"', '"+pwd+"')";

			//System.out.println(query);
			statement.execute(query);

			connection.close();
		}

		catch(SQLException e)
		{
			State.ErrorLog(e.getMessage());
		}
		return true;
	}


	private static Boolean DBAvailable(String db)
	{
		File dbfile = new File(db);
		return dbfile.exists();
	}

	private static void CreateTables()
	{
		Connection connection = null;

		try
		{
			//if(!DBAvailable(dbName)) return;

			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:"+dbName);

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String searchQuery = "CREATE TABLE login (" +
					"    id int,\n" +
					"    pwd varchar(255)" +
					");";

			statement.executeQuery(searchQuery);
		}
		catch(SQLException e)
		{
			State.ErrorLog(e.getMessage());
		}
	}
}
