package lab2_task; 

public class app {
    /*
    gradle --console plain run
    - run comand for Scanner
    */
    public static void main(String[] args) { 
        Matrix matrix1 = new Matrix(3,5);

        matrix1.setValue(1,4,3);
        matrix1.setValue(2,3,34);
        matrix1.setValue(3,5,36);
        matrix1.setValue(1,3,3);
        matrix1.setValue(2,6,3);
        matrix1.setValue(3,7,34);


        matrix1.printElements();
        int[] vector = {4,24,6,8,1};
        matrix1.toDiagonal(vector);
        matrix1.printElements();
    }
}