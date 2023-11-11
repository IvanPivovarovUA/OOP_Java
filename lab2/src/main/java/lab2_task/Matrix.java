package lab2_task;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
//  https://www.w3schools.com/java/java_arraylist.asp
//  https://www.baeldung.com/java-multi-dimensional-arraylist
public class Matrix {
    private ArrayList<ArrayList<Double>> Elements;
    private Scanner user_input = new Scanner(System.in);

    public void printElements() {
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
        this.Elements = new ArrayList<ArrayList<Double>>();
    }
    Matrix(int row, int column) {
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
    Matrix(Matrix matrix) {
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

            Elements = new ArrayList<ArrayList<Double>>();
            if (row != 0 && column != 0) {
                for (int c=0; c < column; c++) {
                    Elements.add(new ArrayList<Double>());

                    for (int r=0; r < row; r++) {
                        System.out.print("Set element " + "[" + (r + 1) + "," + (c + 1) + "] :");
                        Double number = Double.parseDouble(
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
    public void setValue(int row, int column, double new_value) {
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

    public ArrayList<Double> getRow(int column) {
        column = Math.abs(column) - 1;
        if (column != -1 && column < Elements.size()) {           
            return (ArrayList<Double>) Elements.get(column).clone();
        }else {
            System.out.println("Value error");
        }
        return new ArrayList<Double>();
    }
    public ArrayList<Double> getColumn(int row) {
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
    public Double getValue(int row, int column) {
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
        ArrayList<ArrayList<Double>> newElements = new ArrayList<ArrayList<Double>>();

        if (getSize()[0] == matrix.getSize()[1]) {
            for (int c = 0; c < getSize()[1]; c++) {
                newElements.add(new ArrayList<Double>());
                for (int r = 0; r < matrix.getSize()[0]; r++) {
                    Double sum = 0.0;

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
        ArrayList<ArrayList<Double>> newElements = new ArrayList<ArrayList<Double>>();
        int row = getSize()[0];
        int column = getSize()[1];


        for (int c = 0; c < row; c++) {
            newElements.add(new ArrayList<Double>());
            for (int r = 0; r < column; r++) {
                newElements.get(c).add(
                    getValue(c+1,r+1)
                );
            }
        }

        this.Elements = newElements;
    }
    
    public void toDiagonal(double[] vector) {
        this.Elements = new ArrayList<ArrayList<Double>>();
        int size = vector.length;

        for (int c = 0; c < size; c++) {
            Elements.add(new ArrayList<Double>());
            for (int r = 0; r < size; r++) {
                if (c == r) {
                    Elements.get(c).add(vector[c]);
                }else {
                    Elements.get(c).add(0.0);
                }
                
            }
        }
    }
    public void toSingle(int size) {
        this.Elements = new ArrayList<ArrayList<Double>>();

        for (int c = 0; c < size; c++) {
            Elements.add(new ArrayList<Double>());
            for (int r = 0; r < size; r++) {
                if (c == r) {
                    Elements.get(c).add(1.0);
                }else {
                    Elements.get(c).add(0.0);
                }    
            }
        }
    }

    public void randomizeRow(int row) {
        row = Math.abs(row - 1);
        Random rand = new Random();

        if (row < getSize()[1]) {
            for (int r = 0; r < getSize()[0]; r++) {
                double number = (double) rand.nextInt(201);
                if (number > 100) {
                    number = 100 - number;
                }

                Elements.get(row).set(
                    r,
                    number
                );
            } 
        }else {
            System.out.println("Value Error");
        }

    }

    public void randomizeColumn(int column) {
        column = Math.abs(column - 1);
        Random rand = new Random();

        if (column < getSize()[0]) {
            for (int c = 0; c < getSize()[1]; c++) {
                double number = (double) rand.nextInt(201);
                if (number > 100) {
                    number = 100 - number;
                }

                Elements.get(c).set(
                    column,
                    number
                );
            } 
        }else {
            System.out.println("Value Error");
        }
    }

    public void makeTriangularUp() {
        printElements();
        int m = 0;
        final int SIZE;
        if (getSize()[0] < getSize()[1]) {
            SIZE = getSize()[0];
        }else {
            SIZE = getSize()[1];
        }

        for (int h = 0; h < SIZE - 1; h++) {
            double head = getValue(h+1 + m,h+1);
            // System.out.println("Zero!!!" + head);

            for (int c = h+1; c < getSize()[1]; c++) {
                head = getValue(h+1 + m,h+1);

                if (-0.001 <= head && head <= 0.001) {
                    System.out.println("Zero!");
                    replaceRows(h,c);
                    printElements();
                }else {
                    break;
                }
            }
            head = getValue(h+1 + m,h+1);
            if (-0.001 <= head && head <= 0.001) {
                System.out.println("END!");
                // continue;
                m +=1;
                head = getValue(h+1 + m, h+1);
            }

            for (int c = h +1; c < getSize()[1]; c++) {
                double cut = getValue(h+1 + m,c+1);

                for (int r2 = 0; r2 < getSize()[0]; r2++) {

                    double number = getValue(r2+1,c+1) - cut * getValue(r2+1,h+1) / head;
                    number *= 1000;
                    number = Math.floor(number);
                    number /= 1000;
                    Elements.get(c).set(
                        r2,
                        number
                    );
                }
            }
            printElements();
            // user_input.nextLine();

        }


    }

    public void replaceRows(int first_index, int second_index) {
        ArrayList<Double> first_row = getRow(first_index + 1);
        ArrayList<Double> second_row = getRow(second_index + 1);

        for (int r=0; r < getSize()[0]; r++) {
            Elements.get(first_index).set(
                r,
                second_row.get(r)
            );
            Elements.get(second_index).set(
                r,
                first_row.get(r)
            );
        }
    }

   public void makeTriangularDown() {
        printElements();
        int m = 0;
        final int SIZE;
        if (getSize()[0] < getSize()[1]) {
            SIZE = getSize()[0];
        }else {
            SIZE = getSize()[1];
        }

        for (int h =  SIZE -1; h > 0; h--) {
            double head = getValue(h+1 + m,h+1);
            // System.out.println("Zero!!!" + head);

            for (int c = h-1; c >= 0; c--) {
                head = getValue(h+1 + m,h+1);

                if (-0.001 <= head && head <= 0.001) {
                    System.out.println("Zero!");
                    replaceRows(h,c);
                    printElements();
                }else {
                    break;
                }
            }
            head = getValue(h+1 + m,h+1);
            if (-0.001 <= head && head <= 0.001) {
                System.out.println("END!");
                // continue;
                m -=1;
                head = getValue(h+1 + m, h+1);
            }

            for (int c = h -1; c >= 0; c--) {
                double cut = getValue(h+1 + m,c+1);

                for (int r2 = getSize()[0]-1; r2 >= 0; r2--) {

                    double number = getValue(r2+1,c+1) - cut * getValue(r2+1,h+1) / head;
                    number *= 1000;
                    number = Math.floor(number);
                    number /= 1000;
                    Elements.get(c).set(
                        r2,
                        number
                    );
                }
            }
            printElements();
            // user_input.nextLine();

        }

    }



}