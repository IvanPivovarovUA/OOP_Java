package lab1_task;

public class StringCalculator {

    public int add(String numbers) {
        int sum = 0;

        String new_sep = "";
        String new_num = numbers;
        if (numbers.length() > 2 && numbers.indexOf("\\n") > 2)
        {
            if (numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {
                new_sep = cut_separato(numbers);
                new_num = cut_number(numbers);
            }
        }
        // System.out.println("{" + new_sep + "}~{" + new_num + "}");

        String string_numbers[] = new_num.split(",|\\\\n" + new_sep);
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


    String cut_separato(String user_string) {
        String new_sep = user_string.substring(
            2,
            user_string.indexOf("\\n")
        );
        new_sep = "|\\Q" + new_sep + "\\E";
        return new_sep;
    }
    String cut_number(String user_string) {
        String new_num = user_string.substring(
            user_string.indexOf("\\n") + 2,
            user_string.length()
        );
        return new_num;
    }
}