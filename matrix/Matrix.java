package matrix;

import exceptions.MatrixRuntimeExceptions;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    protected final Integer[][] arr;
    protected final int rows;
    protected final int columns;

    public Matrix(int rows, int columns, int value) {
        this.rows = rows;
        this.columns = columns;
        arr = new Integer[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = value;
            }
        }
    }

    public Matrix(int rows, int columns) {
        this(rows, columns, 0);
    }

    public Matrix(Matrix b) {
        if (b == null)
            throw new MatrixRuntimeExceptions("Matrix NULL parameter init. NPE!");
        this.rows = b.rows;
        this.columns = b.columns;
        this.arr = new Integer[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = b.arr[i][j];
            }
        }
    }

    public Matrix sum(Matrix b) {
        if (b == null)
            throw new MatrixRuntimeExceptions("Matrix NULL parameter. NPE!");
        if (this.rows != b.rows || this.columns != b.columns) {
            throw new MatrixRuntimeExceptions("Matrices of different sizes!", this.rows, this.columns, b.rows, b.columns);
        }
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.arr[i][j] += b.arr[i][j];
            }
        }
        return this;
    }

    public Matrix product(Matrix b) {
        if (b == null)
            throw new MatrixRuntimeExceptions("Matrix NULL parameter. NPE!");
        if (this.columns != b.rows) {
            throw new MatrixRuntimeExceptions("Matrices of different sizes!", this.columns, b.rows);
        }
        Matrix res = new Matrix(this.rows, b.columns);
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < b.columns; j++) {
                res.arr[i][j] = 0;
                for (int k = 0; k < this.columns; k++)
                    res.arr[i][j] += this.arr[i][k] * b.arr[k][j];
            }
        return res;
    }

    public final void setElement(int row, int column, int value) {
        if (row > this.rows || column > this.columns || row < 0 || column < 0)
            throw new MatrixRuntimeExceptions("Out of bounds!");
        arr[row][column] = value;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public final int getElement(int row, int column) {
        if (row > this.rows || column > this.columns || row < 0 || column < 0)
            throw new MatrixRuntimeExceptions("Out of bounds!");
        return arr[row][column];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //not synchro and mutable
        for (int i = 0; i < rows; i++) {
            sb.append("[");
            for (int j = 0; j < columns; j++) {
                sb.append(arr[i][j]);
                if (j != columns - 1) //fix last space
                    sb.append("\t");
            }
            sb.append("\t]");
            if (i != rows - 1) //fix last new row
                sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix = (Matrix) o;
        return rows == matrix.rows && columns == matrix.columns && Arrays.deepEquals(arr, matrix.arr);
    }
    //hashcode didn't overload!
}
