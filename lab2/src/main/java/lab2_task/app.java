package lab2_task; 

public class app {
    /*
    gradle --console plain run
    - run comand for Scanner
    */
    public static void main(String[] args) { 
        // Matrix matrix1 = new Matrix(3,4);

        // for (int i = 0; i < matrix1.getSize()[1]; i++) {
        //     matrix1.randomizeRow(i);
        // }
        // matrix1.printElements();

        // Matrix matrix2 = new Matrix(matrix1);
        // Matrix matrix3 = matrix1.plusMatrix(matrix2);

        // matrix1.printElements();
        // matrix2.printElements();
        // matrix3.printElements();    
        
        Matrix matrix1 = new ImmutMatrix(3,4);
        matrix1.setMatrix();
        ImmutMatrix matrix2 = new ImmutMatrix(matrix1);
        Matrix matrix3 = matrix1.plusMatrix(matrix2);

        System.out.print(matrix1.getColumn(1));

        GenericsMatrix matrix4 = new GenericsMatrix(7,3,4);
        matrix4.printElements();
        GenericsMatrix matrix5 = new GenericsMatrix(4);
        matrix5.printElements();
        GenericsMatrix matrix6 = new GenericsMatrix("u",6,7);
        matrix6.printElements();
    }
}