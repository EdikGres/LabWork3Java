import exceptions.MatrixRuntimeExceptions;
import matrix.Matrix;
import matrix.SquareMatrix;

public class Main {

    public static void main(String[] args) {
        
		Matrix a = new Matrix(3,4,5);
        a.setElement(0,0,5);
        Matrix b = new Matrix(3,4,5);
        System.out.println(a.equals(b));
    }
}
