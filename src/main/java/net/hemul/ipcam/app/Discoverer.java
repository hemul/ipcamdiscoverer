package net.hemul.ipcam.app;

import com.ms.wsdiscovery.exception.WsDiscoveryException;

import net.hemul.ipcam.classes.Finder;

public class Discoverer {
	@SuppressWarnings("unused")
	public static void main(String[] args){
		try {
			Finder finder = new Finder();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WsDiscoveryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
