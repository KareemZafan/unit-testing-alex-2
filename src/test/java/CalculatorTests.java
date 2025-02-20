import org.iti.mobile.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTests {
    private static Calculator calc;

    @BeforeEach
    void beforeEachTestCase() {
        System.out.println("This  will be run before each test");
    }

    @AfterEach
    void afterEachTestCase() {
        System.out.println("This  will be run after each test");
    }

    @AfterAll
    static void afterAllTestCases() {
        System.out.println("This  will be run after all tests");
    }

    @BeforeAll
    static void beforeAllTestCases() {
        System.out.println("This  will be run before all tests");
        calc = new Calculator(); //1
    }


    @DisplayName("Add Functionality")
    @Order(1)
    @Tag("MAY_RELEASE")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testAdd(String input1, String input2, String result) {
        System.out.println("Testcase-1 Add Functionality");
        assertEquals(Double.parseDouble(result), calc.add(Double.parseDouble(input1), Double.parseDouble(input2)));

    }

    @Test
    @DisplayName("Subtract Functionality")
    @Order(2)
    @Tag("MAY_RELEASE")
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
    void testSub() {
        // Arrange
        System.out.println("Testcase-2 Subtraction Functionality");

        // Act
        // Assert
        assertEquals(-2, calc.sub(2, 4));
        assertEquals(2, calc.sub(-2, -4));
        assertEquals(-6, calc.sub(-2, 4));
        assertEquals(6, calc.sub(2, -4));
        assertEquals(-4, calc.sub(0, 4));
    }

    @Test
    @DisplayName("Multiplication Functionality")
    @Order(3)
    @EnabledOnOs(OS.LINUX)
    void testMul() {
        // Arrange
        System.out.println("Testcase-3 Multiplication Functionality");

        // Act
        // Assert
        assertEquals(8, calc.mul(2, 4));
        assertEquals(8, calc.mul(-2, -4));
        assertEquals(-8, calc.mul(-2, 4));
        assertEquals(-8, calc.mul(2, -4));
        assertEquals(0, calc.mul(0, 4));
    }

    @RepeatedTest(3)
    @DisplayName("Division Functionality")
    void testDiv() {
        // Arrange
        System.out.println("Testcase-4 Division Functionality");

        // Act
        // Assert
        assertEquals(0.50, calc.div(2, 4));
        assertEquals(0.50, calc.div(-2, -4));
        assertEquals(-0.50, calc.div(-2, 4));
        assertEquals(-2, calc.div(4, -2));
        assertEquals(0, calc.div(0, 4));

        Exception ex = assertThrowsExactly(IllegalArgumentException.class, () -> calc.div(9, 0));
        assertEquals("Dividing by zero", ex.getMessage(), "Exception message is not correct!");
    }

    @Test
    @DisplayName("Square Root Functionality")
    @Tag("MAY_RELEASE")
    @Timeout(unit = TimeUnit.SECONDS, value = 1)
    void testSquareRoot() {
        // Arrange
        System.out.println("Testcase-5 Square Root Functionality");


        // Act
        // Assert
        assertEquals(5, calc.getSquareRoot(25));
        assertEquals(13, calc.getSquareRoot(169));
        assertEquals(12, calc.getSquareRoot(144));
        assertEquals(25, calc.getSquareRoot(625));
        assertEquals(0, calc.getSquareRoot(0));

    }

    @Test
    @DisplayName("Absolute Functionality")
    void testAbs() {
        // Arrange
        System.out.println("Testcase-6 Absolute Functionality");

        // Act
        // Assert
        assertEquals(5, calc.abs(-5));
        assertEquals(0, calc.abs(0));
        assertEquals(9, calc.abs(9));
    }
}
