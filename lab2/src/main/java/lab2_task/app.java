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

        matrix4.setValue(2,4,1234);

        System.out.println(matrix4.getValue(2,4));
        System.out.println(matrix4.getRow(2));
        System.out.println(matrix4.getRow(0));
        System.out.println(matrix4.getColumn(4));

        int[] X = matrix4.getSize();
        System.out.println(X[0] + " X " + X[1]);
    }
}