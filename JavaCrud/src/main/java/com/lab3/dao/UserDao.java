package com.lab3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lab3.bean.User;


public class UserDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/statybos?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_USERS_SQL = "INSERT INTO darbuotojai" + "  (name, lastname, age, salary,objektas, pareigos) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id, name, lastname, age, salary, objektas, pareigos from darbuotojai where id =?";
	private static final String SELECT_ALL_USERS = "select * from darbuotojai";
	private static final String DELETE_USERS_SQL = "delete from darbuotojai where id = ?;";
	private static final String UPDATE_USERS_SQL = "update darbuotojai set name = ?,lastname= ?, age= ?, salary= ?, objektas= ?, pareigos= ? where id = ?;";

	public UserDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getAge());
			preparedStatement.setString(4, user.getSalary());
			preparedStatement.setString(5, user.getObjektas());
			preparedStatement.setString(6, user.getPareigos());
			
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String lastname = rs.getString("lastname");
				String age = rs.getString("age");
				String salary = rs.getString("salary");
				String objektas = rs.getString("objektas");
				String pareigos = rs.getString("pareigos");
				user = new User(id,name,lastname,age,salary,objektas,pareigos);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String lastname = rs.getString("lastname");
				String age = rs.getString("age");
				String salary = rs.getString("salary");
				String objektas = rs.getString("objektas");
				String pareigos = rs.getString("pareigos");
				
				users.add(new User(id,name,lastname,age,salary,objektas,pareigos));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	
	

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated USer:"+statement);
			statement.setString(1, user.getName());
			statement.setString(2, user.getLastname());
			statement.setString(3, user.getAge());
			statement.setString(4, user.getSalary());
			statement.setString(5, user.getObjektas());
			statement.setString(6, user.getPareigos());
			statement.setInt(7, user.getId());
			

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
