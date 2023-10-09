package lab1_task; 
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        /*
        gradle --console plain run
        - cmd run comand for Scanner
        - Vs code plugin run it in git bush
        */
        Scanner inputObj = new Scanner(System.in);
        StringCalculator Calc = new StringCalculator();
        boolean exit = false;
        String text;

        System.out.println("[       Lab 1       ]");

        while (!exit) {
            //Get string for test task
            System.out.println("[       Task 1      ]");
            System.out.print("Enter string:");
            text = inputObj.nextLine();
            System.out.println("Sum = " + Calc.add(text));

            //End. Exit or try again
            System.out.println("\n");
            System.out.print("Enter \"e\" for exit:");
            text = inputObj.nextLine();
            System.out.println("\n\n\n");
            if (text.equals("e")) {
                exit = true;
                System.out.println("good by...");
            }
            
        }
    }
}