import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	Calculator c = new Calculator();

	@Test 
	public void testAdd() {
		System.out.println ("Adding");
		int sum = c.add(1,2);
		//expedcted, actual
		Assertions.assertEquals (3, sum);
	}

	@Test 
	public void testSubtract() {
		System.out.println ("Subtracting");
		int difference = c.subtract(2,1);
		//expedcted, actual
		Assertions.assertEquals (1, difference);
	}

	@Test 
	public void testMultiply() {
		System.out.println ("Multiplying");
		int product = c.multiply(1,2);
		//expedcted, actual
		Assertions.assertEquals (2, product);
	}

	@Test 
	public void testDivide() {
		System.out.println ("Dividing");
		int quotient = c.divide(2,2);
		//expedcted, actual
		Assertions.assertEquals (1, quotient);
	}
}
