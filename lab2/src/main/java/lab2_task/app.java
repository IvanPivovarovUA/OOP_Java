package lab2_task; 

public class app {
    /*
    gradle --console plain run
    - run comand for Scanner
    */
    public static void main(String[] args) { 
        GenericsMatrix<String> matrix1 = new GenericsMatrix("hello world",6,2);

        matrix1.printElements();
        System.out.println(matrix1.getRow(1));
        System.out.println(matrix1.getColumn(1));
        System.out.println(matrix1.getValue(4,2));

        matrix1.setValue(4,1, "new string!!!!!!!!!!!!11");
        matrix1.printElements();
    }
}