import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Application_JUnit {

	Application[] applications;
	String str;
	static final int NUMBER_TEST_APPS = 5;
	
	public Application_JUnit() {
		applications = new Application[NUMBER_TEST_APPS];
		
		
		str = "Cat Game	a fun game with cats	Catgame Studios	2.0	www.cat.com	29.01	Switch	Xbox";
		applications[0] = new Application(str);
		
		str = "Bob's Ringy Adventure	A ring collecting game	Shadowhunters Studios	2.0.1	www.shadowhunters.com	999.99	Gamersystem";
		applications[1] = new Application(str);
		
		str = "Cat Game Collectors Edition	a fun game with  prestige cats	Catgame Studios	1.2	www.cat.com	29.02	Switch	Xbox360";
		applications[2] = new Application(str);
		
	}

	@Test
	void testCompareTo() {
		assertTrue( applications[0].compareTo( new Application("Cat Game	a fun game with cats	Catgame Studios	2.0	www.cat.com	29.01	Switch	Xbox")) == 0);
		
		// False Case
		assertFalse( applications[1].compareTo( new Application("Cat Game	a fun game with cats	Catgame Studios	2.0	www.cat.com	29.01	Switch	Xbox")) == 0);
	}

	@Test
	void testToString() {
		String str = "Cat Game - a fun game with cats - Catgame Studios - 2.0 - www.cat.com - 29.01 - [Switch, Xbox]";
		assertEquals(str, applications[0].toString());
	}

	@Test
	void testGetName() {
		String str = "Test Get";
		applications[1].setName("Test Get");
		assertEquals(str, applications[1].getName());
	}

	@Test
	void testSetName() {
		String str = "Test Set";
		applications[1].setName("Test Set");
		assertEquals(str, applications[1].getName());
	}

	@Test
	void testGetDescription() {
		String str = "Test Get";
		applications[1].setDescription("Test Get");
		assertEquals(str, applications[1].getDescription());
	}

	@Test
	void testSetDescription() {
		String str = "Test Set";
		applications[1].setDescription("Test Set");
		assertEquals(str, applications[1].getDescription());
	}

	@Test
	void testGetOrigin() {
		String str = "Test Get";
		applications[1].setOrigin("Test Get");
		assertEquals(str, applications[1].getOrigin());
	}

	@Test
	void testSetOrigin() {
		String str = "Test Set";
		applications[1].setOrigin("Test Set");
		assertEquals(str, applications[1].getOrigin());
	}

	@Test
	void testGetVersion() {
		String str = "Test Get";
		applications[1].setVersion("Test Get");
		assertEquals(str, applications[1].getVersion());
	}

	@Test
	void testSetVersion() {
		String str = "Test Set";
		applications[1].setVersion("Test Set");
		assertEquals(str, applications[1].getVersion());
	}

	@Test
	void testGetStorehl() {
		String str = "Test Get";
		applications[1].setStorehl("Test Get");
		assertEquals(str, applications[1].getStorehl());
	}

	@Test
	void testSetStorehl() {
		String str = "Test Set";
		applications[1].setStorehl("Test Set");
		assertEquals(str, applications[1].getStorehl());
	}

	@Test
	void testGetPrice() {
		double num = 19.99;
		applications[1].setPrice(19.99);
		assertEquals(num, applications[1].getPrice());
	}

	@Test
	void testSetPrice() {
		double num = 19.99;
		applications[1].setPrice(19.99);
		assertEquals(num, applications[1].getPrice());
	}

	@Test
	void testGetPlatforms() {
		ArrayList<String> strArr1 = new ArrayList<String>();
		strArr1.add("Test Plat1");
		strArr1.add("Test Plat2");
		applications[1].setPlatforms(strArr1);
		
		assertEquals(strArr1, applications[1].getPlatforms());
	}

	@Test
	void testSetPlatforms() {
		ArrayList<String> strArr1 = new ArrayList<String>();
		strArr1.add("Test Plat1");
		strArr1.add("Test Plat2");
		applications[1].setPlatforms(strArr1);
		
		assertEquals(strArr1, applications[1].getPlatforms());
	}

	@Test
	void testGetPlatsize() {
		ArrayList<String> strArr1 = new ArrayList<String>();
		strArr1.add("Test Plat1");
		strArr1.add("Test Plat2");
		applications[1].setPlatforms(strArr1);
		
		assertEquals(2, applications[1].getPlatsize());
	}

}
