package at.technikumwien;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import at.technikumwien.Calculator;

public class CalculatorTest {
	private Calculator calculator;
	
	@Before
	public void setUp() {
		calculator = new Calculator();		
	}
	
	@Test
	public void testSumWithoutParams() {
		assertEquals(0, calculator.sum());
	}
	
	@Test
	public void testWithArray()	{
		int[] numbers = {4, 5, 6};
		assertEquals(15, calculator.sum(numbers));
	}
	
	@Test
	public void TestWithNull() {
		assertEquals(0, calculator.sum(null));
	}
}