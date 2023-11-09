package lab2_task; 

public class app {
    /*
    gradle --console plain run
    - run comand for Scanner
    */
    public static void main(String[] args) { 
        Matrix matrix1 = new Matrix(10,4);

        // matrix1.setValue(1,1,3);//3
        // matrix1.setValue(1,2,4);
        // matrix1.setValue(1,3,1);
        // matrix1.setValue(1,4,2);

        // matrix1.setValue(2,1,2);
        // matrix1.setValue(2,2,(double) 4*2/3);//4
        // matrix1.setValue(2,3,(double) 1*2/3);//4
        // matrix1.setValue(2,4,(double) 2*2/3);//3
        
        // matrix1.setValue(3,1,3);
        // matrix1.setValue(3,2,3);
        // matrix1.setValue(3,3,4);//4;
        // matrix1.setValue(3,4,1);

        // matrix1.setValue(4,1,4);
        // matrix1.setValue(4,2,2);
        // matrix1.setValue(4,3,3);
        // matrix1.setValue(4,4,1);

        matrix1.setValue(1,1,3);//3
        matrix1.setValue(1,2,4);
        matrix1.setValue(1,3,1);
        matrix1.setValue(1,4,2);

        matrix1.setValue(2,1,2);
        matrix1.setValue(2,2,4);//4
        matrix1.setValue(2,3,4);//4
        matrix1.setValue(2,4,3);//3
        
        matrix1.setValue(3,1,3);//3
        matrix1.setValue(3,2,3);//3
        matrix1.setValue(3,3,4);//4;
        matrix1.setValue(3,4,1);

        matrix1.setValue(4,1,4);
        matrix1.setValue(4,2,2);
        matrix1.setValue(4,3,3);
        matrix1.setValue(4,4,1);


        // matrix1.printElements();
        matrix1.makeTriangularUp();
        // matrix1.printElements();
    }
}