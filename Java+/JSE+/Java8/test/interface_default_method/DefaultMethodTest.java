package interface_default_method;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Вызов default метода интерфейса.
 */
public class DefaultMethodTest {
    @Test
    public void defaultMethod() {
        Car car = new CarImpl("BMW", 270);
        assertEquals("Car[BMW,270]", car.carInfo());
    }
}
