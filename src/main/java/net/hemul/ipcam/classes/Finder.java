package net.hemul.ipcam.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.ms.wsdiscovery.WsDiscoveryConstants;
import com.ms.wsdiscovery.WsDiscoveryFinder;
import com.ms.wsdiscovery.exception.WsDiscoveryException;
import com.ms.wsdiscovery.network.exception.WsDiscoveryNetworkException;
import com.ms.wsdiscovery.servicedirectory.WsDiscoveryService;
import com.ms.wsdiscovery.servicedirectory.exception.WsDiscoveryServiceDirectoryException;
import com.ms.wsdiscovery.servicedirectory.interfaces.IWsDiscoveryServiceCollection;

public class Finder {

	private WsDiscoveryFinder finder;
	private IWsDiscoveryServiceCollection result;
	private List<String> foundServices;

	public Finder() {

		// Create new finder instance.
//		System.out.println("Creating new finder-instance...");

		foundServices = new ArrayList<>();

		WsDiscoveryConstants.loggerLevel = Level.OFF;

		try {
			finder = new WsDiscoveryFinder();
		} catch (WsDiscoveryNetworkException e) {
			e.printStackTrace();
		}

	}

	public void probe() {

//		System.out.println("Searching for all services (2 sec).");

		try {
			result = finder.findAll(2000);
		} catch (WsDiscoveryServiceDirectoryException | InterruptedException e) {
			e.printStackTrace();
		}

		// Stop finder
		try {
			finder.done();
		} catch (InterruptedException | WsDiscoveryException e) {
			e.printStackTrace();
		}
	}

	public List<String> getResultList() {
		// Display the results.
		// System.out.println("** Discovered services: **");

		for (WsDiscoveryService service : result) {
			// Print service info
			foundServices.add(service.getXAddrs().get(0));

			// System.out.println("---");
		}
		return foundServices;

	}

}
