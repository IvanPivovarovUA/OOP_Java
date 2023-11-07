package lab2_task; 

public class app {
    /*
    gradle --console plain run
    - run comand for Scanner
    */
    public static void main(String[] args) {
 
        Matrix matrix1 = new Matrix(3,5);
        Matrix matrix2 = new Matrix(7,3);
        
        
        matrix1.setValue(1,4,3);
        matrix1.setValue(2,3,34);
        matrix1.setValue(3,5,36);
        matrix1.setValue(1,3,3);
        matrix1.setValue(2,6,3);
        matrix1.setValue(3,7,34);

        matrix2.setValue(1,2,11);
        matrix2.setValue(2,2,2);
        matrix2.setValue(3,2,8);
        matrix2.setValue(4,3,14);
        matrix2.setValue(2,1,43);
        matrix2.setValue(7,2,1);

        // matrix1.setMatrix();
        // matrix2.setMatrix();

        matrix1.printElements();
        matrix2.printElements();

        matrix1.multMatrix(matrix2);
        matrix1.printElements();


        
        Matrix matrix4 = new Matrix(24,5);
        Matrix matrix5 = new Matrix(47,3);
        matrix4.multMatrix(matrix5);
        
    }
}