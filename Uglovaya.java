package com.company.MNIST;

public class Uglovaya implements NeighborSercher {

    private int skal(MnistMatrix a, MnistMatrix b){
        int skal = 0;
        for (int r = 0; r < a.getNumberOfRows(); r++) {//перебор по стоке матрицы 28*28

            for (int c = 0; c < a.getNumberOfColumns(); c++) {//перебор по столбцу матрицы 28*28

                skal = skal + a.getValue(r,c)*b.getValue(r,c);

            }
        }
        return skal;
    }

    private double modVect(MnistMatrix v){
        int modVect = 0;
        for (int r = 0; r < v.getNumberOfRows(); r++) {//перебор по стоке матрицы 28*28

            for (int c = 0; c < v.getNumberOfColumns(); c++) {//перебор по столбцу матрицы 28*28

                modVect = modVect + (v.getValue(r,c)*v.getValue(r,c));

            }
        }
        return Math.sqrt(modVect);
    }
    @Override
    public double neighborSearch(MnistMatrix data, MnistMatrix testPhoto) {

            return Math.acos(skal(data,testPhoto)/(modVect(data)*modVect(testPhoto)));
    }
}
