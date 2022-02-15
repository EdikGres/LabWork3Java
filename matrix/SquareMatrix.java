package matrix;

import exceptions.MatrixRuntimeExceptions;

public class SquareMatrix extends Matrix {
    protected final int side;

    public SquareMatrix(int side) {
        super(side, side);
        this.side = side;
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (i == j)
                    arr[i][j] = 1;
            }
        }
    }

    public SquareMatrix(SquareMatrix b) {
        super(b);
        this.side = b.side;
    }

    //Зачем его переопределять? Он делает одно и тоже.
    @Override
    public SquareMatrix sum(Matrix b) {
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
}
