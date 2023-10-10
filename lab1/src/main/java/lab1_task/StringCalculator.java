package lab1_task;

public class StringCalculator {

    public int add(String numbers) {
        int sum = 0;
        int neg_numb[];
        if (numbers.length() < 30) {
            neg_numb = new int[numbers.length()];
        }
        else {
            neg_numb = new int[30];
        }
        
        int list_cur = 0;

        String new_sep = "";
        String new_num = numbers;
        if (numbers.length() > 2 && numbers.indexOf("\\n") > 2)
        {
            if (numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {
                new_sep = cut_separato(numbers);
                new_num = cut_number(numbers);
            }
        }
        System.out.println("{" + ",|\\\\n" + new_sep + "}~{" + new_num + "}");

        String string_numbers[] = new_num.split(",|\\\\n" + new_sep);
        for (String i: string_numbers) {
            try
            {
                if (Integer.parseInt(i) >= 0) {
                    if (Integer.parseInt(i) <= 1000) {
                        sum += Integer.parseInt(i);
                    }
                    else {
                        System.out.println(Integer.parseInt(i) + " > 1000");
                    }
                }
                else {
                    neg_numb[list_cur] = Integer.parseInt(i);
                    list_cur += 1;
                    System.out.println("Negative numbers are not allowed:" + Integer.parseInt(i));
                }
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }
        
        if (list_cur != 0) {
            System.out.print("Negative numbers: (");
            for (int i = 0 ;i < list_cur-1; i++) {
                System.out.print(neg_numb[i] + ",");
            }
            System.out.println(neg_numb[list_cur-1] + ")");
        }
        return sum;
    }


    String cut_separato(String user_string) {
        String new_sep = "";
        String sep_blocks = user_string.substring(
            2,
            user_string.indexOf("\\n")
        );
        String string_sep[] = sep_blocks.split("\\Q[\\E");


        if (string_sep[0].equals("")) {
            System.out.println("You made mistake here: \"[" + string_sep[0] + "\" - i will not use it.");
        }
        for (int i = 1; i < string_sep.length; i++) {
            if (string_sep[i].equals("]") || string_sep[i].equals("")){
                System.out.println("You made mistake here: \"[" + string_sep[i] + "\" - i will not use it.");
            }
            else {
                if (string_sep[i].charAt(string_sep[i].length()-1) == ']') {
                    new_sep = new_sep + "|\\Q" + string_sep[i].substring(0,string_sep[i].length()-1) + "\\E";
                }
                else {
                    System.out.println("You made mistake here: \"[" + string_sep[i] + "\" - i will not use it."); 
                } 
            }
     

        }

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