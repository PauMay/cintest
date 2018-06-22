package at.technikumwien;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

@Category(IntegrationTest.class)
public class CalculatorServletTest
{
	private ServletRunner runner;
	private ServletUnitClient client;
	
	@Before
	public void setUp() {
		runner = new ServletRunner();
		runner.registerServlet("calculator", CalculatorServlet.class.getName());
		client = runner.newClient();
	}
	
	@Test
	public void testWith2Ints() throws Exception{
		WebRequest request = new GetMethodWebRequest("http://test.meterware.com/calculator");
		request.setParameter("operand1", "1");
		request.setParameter("operand2", "2");
		WebResponse response = client.getResponse(request);
		assertEquals("Summe: 3", response.getText());
	}
	
	@Test(expected=NumberFormatException.class)
	public void testWith2Strings() throws Exception {
		WebRequest request = new GetMethodWebRequest("http://test.meterware.com/calculator");
		request.setParameter("operand1", "hallo");
		request.setParameter("operand2", "welt");
		client.getResponse(request);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testWithEmptyOperands() throws Exception{
		WebRequest request = new GetMethodWebRequest("http://test.meterware.com/calculator");
		request.setParameter("operand1", "");
		request.setParameter("operand2", "");
		WebResponse response = client.getResponse(request);
		assertEquals("Summe: 0", response.getText());
	}
	
	@After
	public void tearDown() {
		runner.shutDown();
	}
}
