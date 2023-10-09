package lab1_task;

public class StringCalculator {

    public int add(String numbers) {
        int sum = 0;
        String string_numbers[] = numbers.split(",|\\\\n");

        for (String i: string_numbers) {
            try
            {
                sum += Integer.parseInt(i);
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }

        return sum;
    }

}