package net.hemul.ipcam.app;

import java.util.List;

import com.ms.wsdiscovery.exception.WsDiscoveryException;

import net.hemul.ipcam.classes.Finder;

@SuppressWarnings("unused")
public class Discoverer {

	private Finder finder;
	private List<String> foundServices;

	
	
	public static void main(String[] args) {

		Discoverer discoverer = new Discoverer();

		discoverer.startProbeing();
		discoverer.getResults();
		discoverer.printResults();

	}

	public Discoverer() {
		finder = new Finder();
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

}
