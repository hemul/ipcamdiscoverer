package net.hemul.ipcam.test;

import static org.junit.Assert.*;

import net.hemul.ipcam.classes.MySQLDBStorage;
import net.hemul.ipcam.interfaces.DataStorage;

import org.junit.Test;

public class MySQLDBStorageTest {
	
	private DataStorage dataStorage;

	@Test
	public void create() {
		dataStorage = new MySQLDBStorage("localhost:3306\testdb" , "test" , "test");
		assertNotNull(dataStorage);
	}

}
