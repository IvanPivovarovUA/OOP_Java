package lab2_task;

import java.util.Scanner;
import java.util.ArrayList;
//  https://www.w3schools.com/java/java_arraylist.asp
//  https://www.baeldung.com/java-multi-dimensional-arraylist
public final class ImmutMatrix {
    
    private final Scanner user_input = new Scanner(System.in);
    private ArrayList<ArrayList<Double>> Elements;

    public final void printElements() {
        if (Elements.size() != 0) {
            System.out.println("\n[");
            for (ArrayList<Double> elem: Elements){
                System.out.println(elem);
            }
            System.out.println("]\n");
        }else {
            System.out.println("\n[]\n");
        }
    }

    public final int[] getSize() {
        int[] X = {0,0};
        if (Elements.size() != 0) {
            X[0] = Elements.get(0).size();
            X[1] = Elements.size();
        }
        return X;  
    }

    public boolean matrixEquals(Matrix matrix){
        return false;
    }
    public boolean matrixEquals(ImmutMatrix matrix) {
        boolean answer = true;
 
        if (getSize()[1] == matrix.getSize()[1]) {
            if (getSize()[1] != 0) {
                if (getSize()[0] == matrix.getSize()[0]) {
                    int row = getSize()[0];
                    int column = getSize()[1] ;

                    for (int c=0; c < column; c++) {
                        for (int r=0; r < row; r++) {
                            if (getValue(r+1,c+1) != matrix.getValue(r+1,c+1)) {
                                answer = false;
                            }
                        }
                    }
                }else {
                    answer = false;
                }
            }
        }else {
            answer = false;
        }

        return answer;
    }

    ImmutMatrix() {
        this.Elements = new ArrayList<ArrayList<Double>>();
    }
    ImmutMatrix(int row, int column) {
        this.Elements = new ArrayList<ArrayList<Double>>();

        row = Math.abs(row);
        column = Math.abs(column);
        if (row != 0 && column != 0) {
            for (int c=0; c < column; c++) {
                Elements.add(new ArrayList<Double>());

                for (int r=0; r < row; r++) {
                    Elements.get(c).add(0.0);
                }
            } 
        }
    }
    ImmutMatrix(ImmutMatrix matrix) {
        this.Elements = new ArrayList<ArrayList<Double>>();

        if (matrix.getSize()[1] != 0) {
            int row = matrix.getSize()[0];
            int column = matrix.getSize()[1];

            for (int c=0; c < column; c++) {
                Elements.add(new ArrayList<Double>());

                for (int r=0; r < row; r++) {
                    Elements.get(c).add(
                        matrix.getValue(r+1,c+1)
                    );
                }
            }
        }
    }
    ImmutMatrix(Matrix matrix) {
        this.Elements = new ArrayList<ArrayList<Double>>();

        if (matrix.getSize()[1] != 0) {
            int row = matrix.getSize()[0];
            int column = matrix.getSize()[1];

            for (int c=0; c < column; c++) {
                Elements.add(new ArrayList<Double>());

                for (int r=0; r < row; r++) {
                    Elements.get(c).add(
                        matrix.getValue(r+1,c+1)
                    );
                }
            }
        }
    }

    private final void setMatrix() {
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

            Elements = new ArrayList<ArrayList<Double>>();
            if (row != 0 && column != 0) {
                for (int c=0; c < column; c++) {
                    Elements.add(new ArrayList<Double>());

                    for (int r=0; r < row; r++) {
                        System.out.print("Set element " + "[" + (r + 1) + "," + (c + 1) + "] :");
                        double number = Double.parseDouble(
                            user_input.nextLine()
                        );
                        Elements.get(c).add(number);
                    }
                }     
            }

        }
        catch(Exception e) {
            System.out.println(e);
            Elements = new ArrayList<ArrayList<Double>>();
        }
    }
    private final void setValue(int row, int column, double new_value) {
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

    public final ArrayList<Double> getColumn(int column) {
        column = Math.abs(column) - 1;
        if (column != -1 && column < Elements.size()) {           
            return (ArrayList<Double>) Elements.get(column).clone();
        }else {
            System.out.println("Value error");
        }
        return new ArrayList<Double>();
    }
    public final ArrayList<Double> getRow(int row) {
        ArrayList<Double> new_column = new ArrayList<Double>();
        row = Math.abs(row) - 1;

        if (Elements.size() != 0) {
            if (row != -1 && row < Elements.get(0).size()) {
                for (ArrayList<Double> column: Elements) {
                    new_column.add(
                        column.get(row)
                    );
                }
            }else {
                System.out.println("Value error");
            }
        }else {
            System.out.println("Value error");
        }

        return new_column;
    }
    public final Double getValue(int row, int column) {
        row = Math.abs(row) - 1;
        column = Math.abs(column) - 1;
        
        if (row != -1 && column != -1 && Elements.size() != 0) {
            if (row < Elements.get(0).size() && column < Elements.size()) {
                return Elements.get(column).get(row);
            }else {
                System.out.println("Value error");
            }
        }else {
            System.out.println("Value error");
        }
        return 0.0;
    }
}