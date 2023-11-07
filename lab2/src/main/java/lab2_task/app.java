package lab2_task; 

public class app {
    /*
    gradle --console plain run
    - run comand for Scanner
    */
    public static void main(String[] args) {
        ImmutMatrix matrix1 = new ImmutMatrix(30,30);
        ImmutMatrix matrix2 = new ImmutMatrix(30,30);
        
        Matrix matrix3 = new Matrix(30,30);
        Matrix matrix4 = new Matrix(30,30);

        System.out.println(
            matrix3.matrixEquals(matrix4) + "|" +
            matrix2.matrixEquals(matrix1)
        );

        // matrix1.setValue(4,4,4);
        
    }
}