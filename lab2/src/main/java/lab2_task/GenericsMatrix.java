package lab2_task;

import java.util.Scanner;
import java.util.ArrayList;
//  https://www.w3schools.com/java/java_arraylist.asp
//  https://www.baeldung.com/java-multi-dimensional-arraylist
public class GenericsMatrix<T> {
    private ArrayList<ArrayList<T>> Elements;
    public T default_type_value;

    // private final Scanner user_input = new Scanner(System.in);

    public void printElements() {
        if (Elements.size() != 0) {
            System.out.println("\n[");
            for (ArrayList<T> elem: Elements){
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

    public ArrayList<T> getRow(int column) {
        column = Math.abs(column) - 1;
        if (column != -1 && column < Elements.size()) {           
            return (ArrayList<T>) Elements.get(column).clone();
        }else {
            System.out.println("Value error");
        }
        return new ArrayList<T>();
    }
    public ArrayList<T> getColumn(int row) {
        ArrayList<T> new_column = new ArrayList<T>();
        row = Math.abs(row) - 1;

        if (Elements.size() != 0) {
            if (row != -1 && row < Elements.get(0).size()) {
                for (ArrayList<T> column: Elements) {
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
    public T getValue(int row, int column) {
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
        return default_type_value;
    }

    public void setValue(int row, int column, T new_value) {
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
    

    GenericsMatrix(T def_val) {
        this.default_type_value = def_val;
        this.Elements = new ArrayList<ArrayList<T>>();
    }
    GenericsMatrix(T def_val, int row, int column) {
        this.default_type_value = def_val;
        this.Elements = new ArrayList<ArrayList<T>>();

        row = Math.abs(row);
        column = Math.abs(column);
        if (row != 0 && column != 0) {
            for (int c=0; c < column; c++) {
                Elements.add(new ArrayList<T>());

                for (int r=0; r < row; r++) {
                    Elements.get(c).add(def_val);
                }
            } 
        }
    }
    GenericsMatrix(T def_val, GenericsMatrix matrix) {
        this.Elements = new ArrayList<ArrayList<T>>();

        if (matrix.getSize()[1] != 0) {
            int row = matrix.getSize()[0];
            int column = matrix.getSize()[1];

            for (int c=0; c < column; c++) {
                this.Elements.add(new ArrayList<T>());

                for (int r=0; r < row; r++) {
                    this.Elements.get(c).add(def_val);
                }
            }
        }
    }

}