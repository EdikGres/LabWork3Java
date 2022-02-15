package exceptions;

public class MatrixRuntimeExceptions extends RuntimeException {
    public MatrixRuntimeExceptions(String message) {
        super(message);
    }

    public MatrixRuntimeExceptions(String message, int rowA, int rowB, int columnA, int columnB) {
        super(message + " (" + rowA + "," + columnA + ") != (" + rowB + ", " + columnB + ")");
    }

    public MatrixRuntimeExceptions(String message, int columnA, int rowB) {
        super(message + " Columns number A != Rows number B; " + columnA + "!=" + rowB);
    }
}
