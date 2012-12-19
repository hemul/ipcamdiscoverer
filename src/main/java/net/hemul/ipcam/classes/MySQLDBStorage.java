package net.hemul.ipcam.classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import net.hemul.ipcam.interfaces.*;

public class MySQLDBStorage implements DataStorage {

	private String DB_SID;
	private String user;
	private String password;
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;

	public MySQLDBStorage(String DB_SID, String user, String password) {

		this.DB_SID = DB_SID;
		this.user = user;
		this.password = password;

		createDBConnection();
	}

	private void createDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = (Connection) DriverManager.getConnection(DB_SID, user,
					password);

			// PreparedStatements can use variables and are more efficient
			preparedStatement = (PreparedStatement) connect
					.prepareStatement("insert into test_db.test_table values (?)");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean storeData(List<String> dataToStore) {

		boolean successfully = false;
		int resultCode;

		for (String str : dataToStore) {
			try {
				preparedStatement.setString(1, str);
				resultCode = preparedStatement.executeUpdate();
				successfully = (resultCode == 1) ? true : false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(!successfully){
				break;
			}
		}
		return successfully;
	}

}
