package lab2_task;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
//  https://www.w3schools.com/java/java_arraylist.asp
//  https://www.baeldung.com/java-multi-dimensional-arraylist
public final class ImmutMatrix extends Matrix{
    private ArrayList<ArrayList<Double>> Elements;
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
    
}