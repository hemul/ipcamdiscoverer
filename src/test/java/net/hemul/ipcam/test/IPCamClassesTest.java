package net.hemul.ipcam.test;

import static org.junit.Assert.*;

import net.hemul.ipcam.classes.Finder;

import org.junit.Test;

import com.ms.wsdiscovery.exception.WsDiscoveryException;

public class IPCamClassesTest {
	private Finder finder;

	@Test
	public void finderCreatetest() {
		
		finder = new Finder();
		assertNotNull(finder);
	}

}
