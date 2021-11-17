import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserBean_JUnit {

	UserBean[] beans;
	String str, str2;
	static final int NUMBER_TEST_BEANS = 5;
	
	public UserBean_JUnit() {
		beans = new UserBean[NUMBER_TEST_BEANS];
		
		
		str = "user1	pass1	false";
		beans[0] = new UserBean(str);
		
		str = "user2	pass2	false";
		beans[1] = new UserBean(str);
		
		str = "user3";
		str2 = "pass3";
		beans[2] = new UserBean(str, str2, false);
		
	}
	
	@Test
	void testGetUsername() {
		String str = "Test Get";
		beans[1].setUsername("Test Get");
		assertEquals(str, beans[1].getUsername());
	}

	@Test
	void testSetUsername() {
		String str = "Test Set";
		beans[1].setUsername("Test Set");
		assertEquals(str, beans[1].getUsername());
	}

	@Test
	void testGetPassword() {
		String str = "Test Get";
		beans[1].setPassword("Test Get");
		assertEquals(str, beans[1].getPassword());
	}

	@Test
	void testSetPassword() {
		String str = "Test Set";
		beans[1].setPassword("Test Set");
		assertEquals(str, beans[1].getPassword());
	}

	@Test
	void testGetAdmin() {
		beans[1].setAdmin(true);
		assertTrue(beans[1].getAdmin());
	}

	@Test
	void testSetAdmin() {
		beans[1].setAdmin(false);
		assertFalse(beans[1].getAdmin());
	}
	
	@Test
	void testToString() {
		String str = "UserBean [username= user1, password= pass1]";
		assertEquals(str, beans[0].toString());
	}

}
