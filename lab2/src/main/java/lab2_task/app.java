package lab2_task; 

public class app {
    /*
    gradle --console plain run
    - run comand for Scanner
    */
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix(-4,0);
        Matrix matrix3 = new Matrix(0,13);
        Matrix matrix4 = new Matrix(2,-15);
        Matrix matrix5 = new Matrix(matrix1);
        Matrix matrix6 = new Matrix(matrix4);
        Matrix matrix7 = new Matrix(1,1);

        matrix1.setMatrix();
        matrix1.printElements();

        matrix4.setValue(2,4,2222);
        matrix4.printElements();
    }
}