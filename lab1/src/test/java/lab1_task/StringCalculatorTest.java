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

    @Test
    void TwoSeparators() {
        System.out.println("~TEST TwoSeparator~");
        StringCalculator Calc = new StringCalculator();

        Assertions.assertEquals(144, Calc.add("100\\n44"));
        Assertions.assertEquals(204, Calc.add("100\\n44,60"));
    }

    @Test
    void NewSeparator() {
        System.out.println("~TEST NewSeparator~");
        StringCalculator Calc = new StringCalculator();

        Assertions.assertEquals(27, Calc.add("//[#]\\n4#23"));
        Assertions.assertEquals(70, Calc.add("//[#]\\n4#23,43"));
        Assertions.assertEquals(39, Calc.add("//435,34,5"));
    }

    @Test
    void NegativeNumbersNotAllowed() {
        System.out.println("~TEST NegativeNumbersNotAllowed~");
        StringCalculator Calc = new StringCalculator();

        Assertions.assertEquals(8, Calc.add("-4554,3,-5,---3,35t,5"));

    }
    @Test
    void LessThanThousand() {
        System.out.println("~TEST LessThanThousand~");
        StringCalculator Calc = new StringCalculator();

        Assertions.assertEquals(40, Calc.add("13232,40"));

    }

}