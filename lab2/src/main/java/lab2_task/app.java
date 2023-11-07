package lab2_task; 

public class app {
    /*
    gradle --console plain run
    - run comand for Scanner
    */
    public static void main(String[] args) {
 
        Matrix matrix1 = new Matrix(10,20);
        Matrix matrix2 = new Matrix(10,20);
        
        
        matrix2.setValue(3,4,3);
        matrix2.setValue(9,14,34);

        matrix1.setValue(3,4,100);
        matrix1.plusMatrix(matrix2);
        matrix1.multScalar(-2);

        matrix1.printElements();

        // matrix1.setValue(4,4,4);
        
    }
}