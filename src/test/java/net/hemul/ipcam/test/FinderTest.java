package net.hemul.ipcam.test;

import static org.junit.Assert.*;

import net.hemul.ipcam.classes.Finder;

import org.junit.Test;

public class FinderTest {
	private Finder finder;

	@Test
	public void finderCreateTest() {
		
		finder = new Finder();
		assertNotNull(finder);
	}
	
	public void finderProbeTest() {
		finder.probe();
		assertNotNull(finder.getResultList());
	}
	
	public void finderGetResultListTest() {
		assertNotNull(finder.getResultList());
	}

}
