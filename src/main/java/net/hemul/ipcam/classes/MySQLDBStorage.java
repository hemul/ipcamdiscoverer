package net.hemul.ipcam.classes;

import java.util.List;

import net.hemul.ipcam.interfaces.*;

public class MySQLDBStorage implements DataStorage {
	
	private String DB_SID;
	private String user;
	private String password;

	public MySQLDBStorage(String DB_SID, String user, String password) {
		
		this.DB_SID = DB_SID;
		this.user = user;
		this.password = password;
		
		createDBConnection();
	}

	private void createDBConnection() {
		
	}

	@Override
	public boolean storeData(List<String> dataToStore) {
		boolean successfully;
		successfully = true;
		return successfully;
	}

}
