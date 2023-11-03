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
        matrix2.printElements();
        matrix3.printElements();
        matrix4.printElements();
        matrix5.printElements();
        matrix6.printElements();
        matrix7.printElements();
        matrix4.setValue(2,5,11111);
        matrix2.setValue(2,5,11111);
        matrix4.setValue(0,0,11111);
        matrix4.setValue(1,1,11111);
        matrix4.setValue(100,100,11111);
        matrix4.setValue(2,15,11111);
        matrix4.setValue(22,15,11111);
        matrix4.printElements();
    }
}