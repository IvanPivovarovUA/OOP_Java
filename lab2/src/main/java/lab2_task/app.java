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

        // Matrix matrix2 = new Matrix();
        // Matrix matrix3 = new Matrix();
        // matrix2.plusMatrix(matrix3);

        matrix1.printElements();
        matrix1.randomizeRow(5);
        matrix1.printElements();

        
        matrix1.printElements();
        matrix1.randomizeColumn(3);
        matrix1.printElements();
    }
}