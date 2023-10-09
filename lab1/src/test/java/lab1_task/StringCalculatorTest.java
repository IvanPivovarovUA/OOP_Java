package lab1_task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    
    @Test
    void BeZeroIfStringEmpty() {
        System.out.println("~TEST BeZeroIfStringEmpty~");
        StringCalculator Calc = new StringCalculator();

        Assertions.assertEquals(0, Calc.add(""));
    }

    @Test
    void NotNumber() {
        System.out.println("~TEST BeZeroIfStringEmpty~");
        StringCalculator Calc = new StringCalculator();

        Assertions.assertEquals(0, Calc.add("fghfh,gtg"));
        Assertions.assertEquals(24, Calc.add("fghfh,24"));
        Assertions.assertEquals(44, Calc.add("44,gtg"));
    }

}