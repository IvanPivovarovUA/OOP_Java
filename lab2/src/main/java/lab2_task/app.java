package lab2_task; 

public class app {
    /*
    gradle --console plain run
    - run comand for Scanner
    */
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(30,30);
        // matrix1.setValue(1,3,539);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix(30,30);
        Matrix matrix4 = new Matrix(40,30);
        Matrix matrix5 = new Matrix();

        System.out.println(matrix1.matrixEquals(matrix2));
        System.out.println(matrix1.matrixEquals(matrix3));
        System.out.println(matrix1.matrixEquals(matrix4));
        System.out.println(matrix1.matrixEquals(matrix5));


        
    }
}