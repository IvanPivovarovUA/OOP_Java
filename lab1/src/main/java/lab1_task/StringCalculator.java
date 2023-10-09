package lab1_task;

public class StringCalculator {

    public int add(String numbers) {
        int sum = 0;
        String string_numbers[] = numbers.split(",");

        int first_task_limit = 2;
        if (string_numbers.length > 2) {
            System.out.println("Work only with two numbers");
        }

        for (String i: string_numbers) {
            try
            {
                sum += Integer.parseInt(i);
                first_task_limit -= 1;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
            if (first_task_limit <= 0) {
                break;
            }
        }

        return sum;
    }

}