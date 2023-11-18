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
        
        // // Matrix matrix1 = new Matrix(4,4);
        // // ImmutMatrix matrix2 = new ImmutMatrix(4,2);

        // // Matrix matrix3 = new Matrix(matrix2);
        // // ImmutMatrix matrix4 = new ImmutMatrix(matrix1);

        // // matrix3.printElements();
        // // matrix4.printElements();
        // // System.out.print(mat.getSize()[0]);
        // // mat.printElements();


        // Matrix matrix1 = new Matrix(3,4);
        // matrix1.printElements();
        // for (int i = 0; i < matrix1.getSize()[1]; i++) {
        //     matrix1.randomizeRow(i);
        // }
        // matrix1.printElements();

        // matrix1 = matrix1.plusMatrix(matrix1);
        // matrix1.printElements();

        // ImmutMatrix matrix2 = new ImmutMatrix(matrix1);
        // matrix2.printElements();

        // System.out.println(matrix1.matrixEquals(matrix2));
        // System.out.println(matrix2.matrixEquals(matrix1));

        // Matrix matrix3 = new Matrix(matrix2);


        
        // matrix3 = matrix3.plusMatrix(matrix3);
        // matrix3.printElements();
        // Matrix matrix1 = new Matrix(3,2);
        // matrix1.printElements();
        // for (int i = 0; i < matrix1.getSize()[0]; i++) {
        //     matrix1.randomizeRow(i);
        // }
        // matrix1.printElements();

        // Matrix matrix2 = new Matrix(1,3);
        // for (int i = 0; i < matrix1.getSize()[1]; i++) {
        //     matrix2.randomizeRow(i);
        // }

        // ImmutMatrix matrix3 = new ImmutMatrix(matrix2);
        // matrix3.printElements();

        // matrix1.multMatrix(matrix2);
        // matrix1.printElements();

        // Matrix matrix1 = new Matrix(3,3);   
        // matrix1.setValue(1,1,0);
        // matrix1.setValue(2,1,2);
        // matrix1.setValue(3,1,3);
        // matrix1.setValue(1,2,4);
        // matrix1.setValue(2,2,0);
        // matrix1.setValue(3,2,6);
        // matrix1.setValue(1,3,7);
        // matrix1.setValue(2,3,8);
        // matrix1.setValue(3,3,0);

        // // matrix1.printElements();
        // matrix1.makeTriangularUp();
        // matrix1.printElements();
        GenericsMatrix matrix1 = new GenericsMatrix("hello world",3,3);
        matrix1.setValue(1,1,"a1");
        matrix1.setValue(2,1,"a2");
        matrix1.setValue(3,1,"a3");
        matrix1.setValue(1,2,"a4");
        matrix1.setValue(2,2,"a5");
        matrix1.setValue(3,2,"a6");
        matrix1.setValue(1,3,"a7");
        matrix1.setValue(2,3,"a8");
        matrix1.setValue(3,3,"a9");
        
        matrix1.setValue(2,2,"hello world");

        matrix1.printElements();

    }
}