import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Searchbartester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testSearchBar() {
		String name = "Cat Game";
		assertEquals(name, searchBars("Cat Game").getName());
		
		String version = "2.0";
		assertEquals(name, searchBars("Cat Game").getVersion());
	}

	
}
