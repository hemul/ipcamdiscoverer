package net.hemul.ipcam.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void testStoreMethod() {
		dataStorage = new MySQLDBStorage("localhost:3306\testdb" , "test" , "test");
		List<String> listToStore = new ArrayList<>();
		fillListWithTestData(listToStore);
		boolean successfully = dataStorage.storeData(listToStore);
		assertTrue(successfully);
		
	}

	private void fillListWithTestData(List<String> listToStore) {
		listToStore.add("url1");
		listToStore.add("url2");
		listToStore.add("url3");
		listToStore.add("url4");
		
	}

}
