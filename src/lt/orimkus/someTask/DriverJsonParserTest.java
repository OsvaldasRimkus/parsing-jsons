package lt.orimkus.someTask;
/**
 * @author Osvaldas Rimkus
 * @since 2018-10-21
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class DriverJsonParserTest {

	@Test
	public void shouldParseWithCars() {
		DriverJsonParser parser = new DriverJsonParser();
		
		DriverInfo result = parser.resolveDriver("{\"name\":\"John\", \"age\":30, \"car\":2}");
		
		assertEquals("John", result.getName());
		assertEquals(30, result.getAge());
		assertEquals(2, result.getNumberOfCars());
	}
	
	@Test
	public void shouldParseWithoutCars() {
		DriverJsonParser parser = new DriverJsonParser();
		
		DriverInfo result = parser.resolveDriver("{\"name\":\"Mike\", \"age\":26, \"car\":}");
		
		assertEquals("Mike", result.getName());
		assertEquals(26, result.getAge());
		assertEquals(0, result.getNumberOfCars());
	}

}
