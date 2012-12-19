package net.hemul.ipcam.classes;

import java.util.List;

import net.hemul.ipcam.interfaces.*;

public class MySQLDBStorage implements DataStorage {

	public MySQLDBStorage(String DBSID, String user, String password) {

	}

	@Override
	public boolean storeData(List<String> dataToStore) {
		return true;
	}

}
