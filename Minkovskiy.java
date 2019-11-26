package com.company.MNIST;

public class Minkovskiy implements NeighborSercher {

    @Override
    public double neighborSearch(MnistMatrix data, MnistMatrix testPhoto) {
        //double[] distances = new double[data.length];
        //for (int i = 0; i < data.length; i++) {
            double sum = 0;
            for (int r = 0; r < data.getNumberOfRows(); r++) {//перебор по стоке матрицы 28*28

                for (int c = 0; c < data.getNumberOfColumns(); c++) {//перебор по столбцу матрицы 28*28
                    sum = sum + Math.abs(data.getValue(r, c) - testPhoto.getValue(r, c));

                }
            }
            //distances[i] = sum;
        return sum;
        //}
        //return distances;
    }
}
