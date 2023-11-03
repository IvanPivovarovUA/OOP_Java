package lab2_task;

import java.util.Scanner;
import java.util.ArrayList;
//  https://www.w3schools.com/java/java_arraylist.asp
//  https://www.baeldung.com/java-multi-dimensional-arraylist
public class Matrix {
    private ArrayList<ArrayList<Integer>> Elements;

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
}



