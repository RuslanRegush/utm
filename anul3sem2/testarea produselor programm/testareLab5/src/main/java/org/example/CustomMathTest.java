package org.example;
import java.util.Arrays;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class CustomMathTest {
    @Parameters
    public static Collection<Object[]> divisionValues() {
        return Arrays.asList(new Object[][]{
                {10, 0, IllegalArgumentException.class}, // împărțire la 0
                {10, 2, null}                            // împărțire normală
        });}
    private int x;
    private int y;
    private Class<? extends Exception> expectedException;
    public CustomMathTest(int x, int y, Class<? extends Exception> expectedException) {
        this.x = x;
        this.y = y;
        this.expectedException = expectedException;    }
    @BeforeClass
    public static void setUpClass() {        // Setup if needed
    }
    @AfterClass
    public static void tearDownClass() {        // Teardown if needed
    }
    @Test
    public void testSum() {
        System.out.println("sum");
        int x = 0;
        int y = 0;
        int expResult = 0;
        int result = CustomMath.sum(x, y);
        assertEquals(expResult, result);    }
    @Test
    public void testDivisionByZero() {
        System.out.println("division");
        if (expectedException != null) {
            try {
                CustomMath.division(x, y);
                fail("Expected exception: " + expectedException.getName());
            } catch (Exception e) {
                assertTrue(expectedException.isInstance(e));
            }
        } else {
            int result = CustomMath.division(x, y);
            int expResult = x / y;
            assertEquals(expResult, result);        }    }
    @Test
    public void testIsPositive() {
        System.out.println("testIsPositive");
        int num = 5;
        assertTrue(num > 0);    }
    @Test
    public void testIsNegative() {
        System.out.println("testIsNegative");
        int num = -5;
        assertFalse(num > 0);    }}
