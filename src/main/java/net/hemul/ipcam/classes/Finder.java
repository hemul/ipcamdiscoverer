package net.hemul.ipcam.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.ms.wsdiscovery.WsDiscoveryConstants;
import com.ms.wsdiscovery.WsDiscoveryFinder;
import com.ms.wsdiscovery.exception.WsDiscoveryException;
import com.ms.wsdiscovery.network.exception.WsDiscoveryNetworkException;
import com.ms.wsdiscovery.servicedirectory.WsDiscoveryService;
import com.ms.wsdiscovery.servicedirectory.interfaces.IWsDiscoveryServiceCollection;

public class Finder {

	private WsDiscoveryFinder finder;
	private IWsDiscoveryServiceCollection result;
	private List<String> foundServices;

	public Finder() {

		foundServices = new ArrayList<>();

		WsDiscoveryConstants.loggerLevel = Level.OFF;

		try {
			finder = new WsDiscoveryFinder();
		} catch (WsDiscoveryNetworkException e) {
			e.printStackTrace();
		}

	}

	public void probe() {

		try {
			result = finder.findAll(2000);
			finder.done();
		} catch (InterruptedException | WsDiscoveryException e) {
			e.printStackTrace();
		}
	}

	public List<String> getResultList() {

		for (WsDiscoveryService service : result) {
			foundServices.add(service.getXAddrs().get(0));
		}

		return foundServices;

	}
}
