package lab2_task;

import java.util.Scanner;
import java.util.ArrayList;
//  https://www.w3schools.com/java/java_arraylist.asp
//  https://www.baeldung.com/java-multi-dimensional-arraylist
public class Matrix {
    private ArrayList<ArrayList<Integer>> Elements;
    private Scanner user_input = new Scanner(System.in);

    public void printElements() {
        if (Elements.size() != 0) {
            System.out.println("\n[");
            for (ArrayList<Integer> elem: Elements){
                System.out.println(elem);
            }
            System.out.println("]\n");
        }else {
            System.out.println("\n[]\n");
        }

    }

    Matrix() {
        Elements = new ArrayList<ArrayList<Integer>>();
    }
    Matrix(int row, int column) {
        Elements = new ArrayList<ArrayList<Integer>>();

        row = Math.abs(row);
        column = Math.abs(column);
        if (row != 0 && column != 0) {
            for (int c=0; c < column; c++) {
                Elements.add(new ArrayList<Integer>());

                for (int r=0; r < row; r++) {
                    Elements.get(c).add(0);
                }
            }   
        }
    }
    Matrix(Matrix matrix) {
        Elements = new ArrayList<ArrayList<Integer>>();

        if (matrix.Elements.size() != 0) {
            int row = matrix.Elements.get(0).size();
            int column = matrix.Elements.size();

            for (int c=0; c < column; c++) {
                Elements.add(new ArrayList<Integer>());

                for (int r=0; r < row; r++) {
                    Elements.get(c).add(
                        matrix.Elements.get(c).get(r)
                    );
                }
            }
        }
    }

    public void setMatrix() {
        try {
            System.out.print("Set matrix Rows size:");
            int row = Math.abs(
                Integer.parseInt( 
                    user_input.nextLine()
                )
            );
            System.out.print("Set matrix Columns size:");
            int column = Math.abs(
                Integer.parseInt(
                    user_input.nextLine()
                )
            );

            if (row > 100) {
                System.out.println("100 is too much for ROW");
                row = 100;
            }
            if (column > 100) {
                System.out.println("100 is too much for COLUMN");
                column = 100;
            }

            Elements = new ArrayList<ArrayList<Integer>>();

            for (int c=0; c < column; c++) {
                Elements.add(new ArrayList<Integer>());

                for (int r=0; r < row; r++) {
                    System.out.print("Set element " + "[" + (r + 1) + "," + (c + 1) + "] :");
                    int number = Integer.parseInt(
                        user_input.nextLine()
                    );
                    Elements.get(c).add(number);
                }
            }
        }
        catch(Exception e) {
            System.out.println(e);
            Elements = new ArrayList<ArrayList<Integer>>();
        }
    }
    public void setValue(int row, int column, int new_value) {
        row = Math.abs(row) - 1;
        column = Math.abs(column) - 1;
        if (row != -1 && column != -1 && Elements.size() != 0) {
            if (row < Elements.get(0).size() && column < Elements.size()) {
                Elements.get(column).set(row,new_value);
            }else {
                System.out.println("Value error");
            }       
        }else {
            System.out.println("Value error");
        }
    }
}



