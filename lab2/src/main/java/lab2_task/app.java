package lab2_task; 

public class app {
    /*
    gradle --console plain run
    - run comand for Scanner
    */
    public static void main(String[] args) { 
        Matrix matrix1 = new Matrix(4,4);
        ImmutMatrix matrix2 = new ImmutMatrix(4,2);

        Matrix matrix3 = new Matrix(matrix2);
        ImmutMatrix matrix4 = new ImmutMatrix(matrix1);

        matrix3.printElements();
        matrix4.printElements();
        // System.out.print(mat.getSize()[0]);
        // mat.printElements();

    }
}