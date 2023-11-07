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

    public int[] getSize() {
        int[] X = {0,0};
        if (Elements.size() != 0) {
            X[0] = Elements.get(0).size();
            X[1] = Elements.size();
        }
        return X;  
    }

    public boolean matrixEquals(Matrix matrix) {
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


    Matrix() {
        this.Elements = new ArrayList<ArrayList<Integer>>();
    }
    Matrix(int row, int column) {
        this.Elements = new ArrayList<ArrayList<Integer>>();

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
        this.Elements = new ArrayList<ArrayList<Integer>>();

        if (matrix.getSize()[1] != 0) {
            int row = matrix.getSize()[0];
            int column = matrix.getSize()[1];

            for (int c=0; c < column; c++) {
                Elements.add(new ArrayList<Integer>());

                for (int r=0; r < row; r++) {
                    Elements.get(c).add(
                        matrix.getValue(r+1,c+1)
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
            if (row != 0 && column != 0) {
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

    public ArrayList<Integer> getColumn(int column) {
        column = Math.abs(column) - 1;
        if (column != -1 && column < Elements.size()) {           
            return (ArrayList<Integer>) Elements.get(column).clone();
        }else {
            System.out.println("Value error");
        }
        return new ArrayList<Integer>();
    }
    public ArrayList<Integer> getRow(int row) {
        ArrayList<Integer> new_column = new ArrayList<Integer>();
        row = Math.abs(row) - 1;

        if (Elements.size() != 0) {
            if (row != -1 && row < Elements.get(0).size()) {
                for (ArrayList<Integer> column: Elements) {
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
    public Integer getValue(int row, int column) {
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
        return 0;
    }

    public void plusMatrix(Matrix matrix) {

        if (getSize()[0] == matrix.getSize()[0] && getSize()[1] == matrix.getSize()[1]) {
            for (int c = 0; c < getSize()[1]; c++) {
                for (int r = 0; r < getSize()[0]; r++) {
                    Elements.get(c).set(
                        r,
                        getValue(r + 1,c + 1) + matrix.getValue(r + 1,c + 1)
                    );
                }
            }
        }
    
    }
    public void multScalar(int number) {
        for (int c = 0; c < getSize()[1]; c++) {
            for (int r = 0; r < getSize()[0]; r++) {
                Elements.get(c).set(
                    r,
                    getValue(r + 1,c + 1) * number
                );
            }
        }
    }

    /*
            m
    C(ij) = E A(ik) * B(kj)
            k=1
    */
    public void multMatrix(Matrix matrix) {
        ArrayList<ArrayList<Integer>> newElements = new ArrayList<ArrayList<Integer>>();

        if (getSize()[0] == matrix.getSize()[1]) {
            for (int c = 0; c < getSize()[1]; c++) {
                newElements.add(new ArrayList<Integer>());
                for (int r = 0; r < matrix.getSize()[0]; r++) {
                    int sum = 0;

                    for (int rp = 0; rp < getSize()[0]; rp++) {
                        sum += getValue(rp+1,c+1) * matrix.getValue(r+1,rp+1);
                    }

                    newElements.get(c).add(sum);
                }
            }
            this.Elements = newElements;
        }else {
            System.out.println("Error. A row != B column");
        }
    }
    public void toTranspose(){
        ArrayList<ArrayList<Integer>> newElements = new ArrayList<ArrayList<Integer>>();
        int row = getSize()[0];
        int column = getSize()[1];


        for (int c = 0; c < row; c++) {
            newElements.add(new ArrayList<Integer>());
            for (int r = 0; r < column; r++) {
                newElements.get(c).add(
                    getValue(c+1,r+1)
                );
            }
        }

        this.Elements = newElements;
    }
    
    public void toDiagonal(int[] vector) {
        this.Elements = new ArrayList<ArrayList<Integer>>();
        int size = vector.length;

        for (int c = 0; c < size; c++) {
            Elements.add(new ArrayList<Integer>());
            for (int r = 0; r < size; r++) {
                if (c == r) {
                    Elements.get(c).add(vector[c]);
                }else {
                    Elements.get(c).add(0);
                }
                
            }
        }
    }
} 



