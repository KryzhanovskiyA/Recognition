package com.company.MNIST;
public class MnistMatrix {

    private int [][] foto;//матрица

    private int nRows;//строки
    private int nCols;//столбцы

    private int label;//метка

    public MnistMatrix(int nRows, int nCols) {//конструктор матрицы
        this.nRows = nRows;//сохраняем число строк и число строк
        this.nCols = nCols;//сохраняем число строк и число столбцов

        foto = new int[nRows][nCols];//создаём матрицу с числом строу и числом столбцов
    }

    public int getValue(int r, int c) {//получаем значение элемента матрицы по строке и стлбцу
        return foto[r][c];
    }

    public void setValue(int row, int col, int value) {//записываем значение в элемент матрицы по строке и столбцу
        foto[row][col] = value;
    }

    public int getLabel() {//возвращаем метку
        return label;
    }

    public void setLabel(int label) {//записываем метку
        this.label = label;
    }

    public int getNumberOfRows() {//получаем значение количества строк
        return nRows;
    }

    public int getNumberOfColumns() {//получаем значение количества столбцов
        return nCols;
    }

}
