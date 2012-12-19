package net.hemul.ipcam.app;

import java.util.List;

import net.hemul.ipcam.classes.Finder;
import net.hemul.ipcam.classes.MySQLDBStorage;
import net.hemul.ipcam.interfaces.DataStorage;

public class Discoverer {

	private Finder finder;
	private List<String> foundServices;
	private DataStorage dataStorage;

	
	
	public static void main(String[] args) {

		Discoverer discoverer = new Discoverer();

		discoverer.startProbeing();
		discoverer.getResults();
		discoverer.printResults();
		discoverer.writeResults();

	}

	public Discoverer() {
		finder = new Finder();
		dataStorage = new MySQLDBStorage("jdbc:mysql://localhost/test_db", "test_user", "test_db");
	}

	private void startProbeing() {
		finder.probe();

	}

	private void getResults() {
		foundServices = finder.getResultList();
	}
	
	private void printResults() {
		for (String result : foundServices) {
			System.out.println(result);
		}
	}
	
	private void writeResults() {
		dataStorage.storeData(foundServices);
	}


}
