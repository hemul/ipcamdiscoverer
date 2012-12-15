package net.hemul.ipcam.app;

import com.ms.wsdiscovery.WsDiscoveryFinder;
import com.ms.wsdiscovery.exception.WsDiscoveryException;
import com.ms.wsdiscovery.servicedirectory.WsDiscoveryService;
import com.ms.wsdiscovery.servicedirectory.interfaces.IWsDiscoveryServiceCollection;

/**
 * Hello world!
 * 
 */
public class Discoverer {
	public static void main(String[] args) throws InterruptedException, WsDiscoveryException{
		 // Create new finder instance. 
        System.out.println("Creating new finder-instance...");

        WsDiscoveryFinder finder = new WsDiscoveryFinder();
        
        System.out.println("Searching for all services (2 sec).");
        IWsDiscoveryServiceCollection result = finder.findAll(2000);
        
    
        // Display the results.
        System.out.println("** Discovered services: **");

        for (WsDiscoveryService service : result) {
            // Print service info
            System.out.println(service.getXAddrs().get(0));

            System.out.println("---");
        }
    
    
    // Stop finder 
    finder.done();
	}
}
