import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SubmissionTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		SubmissionPage p = new SubmissionPage();
		p.tfname.setText("example1");
		assertEquals(p.tfname.getText(), "example1");
		
		p.tfdesc.setText("example2");
		assertEquals(p.tfdesc.getText(), "example2");
		
		p.tfori.setText("example3");
		assertEquals(p.tfori.getText(), "example3");
		
		p.tfver.setText("example4");
		assertEquals(p.tfver.getText(), "example4");
		
		p.tfstore.setText("example5");
		assertEquals(p.tfstore.getText(), "example5");
		
		p.tfprice.setText("6");
		assertEquals(p.tfprice.getText(), "6");
		
		assertTrue(p.requestW(p.tfname.getText(), p.tfdesc.getText(), p.tfori.getText(),
				p.tfver.getText(), p.tfstore.getText(), p.tfprice.getText()));
	}

}
