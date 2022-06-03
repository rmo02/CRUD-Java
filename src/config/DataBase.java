package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	
	public Connection conect() {
		Connection conn = null;

		try {
			String DB_CONNECTION = "jdbc:mysql://localhost:3306/escola?user=root&password=admin";
			return DriverManager.getConnection(DB_CONNECTION);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
