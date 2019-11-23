package com.company.MNIST;

import java.util.Arrays;

public class Euclid implements NeighborSercher {
    /*public int[] neighbors;

    public  Euclid(int numberOfItems){
        neighbors = new int[numberOfItems];
    }*/

    @Override
    public double[] neighborSearch(MnistMatrix[] data, MnistMatrix testPhoto) {//ok
        double[] distances = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            double sum = 0;
            for (int r = 0; r < data[i].getNumberOfRows(); r++) {//перебор по стоке матрицы 28*28

                for (int c = 0; c < data[i].getNumberOfColumns(); c++) {//перебор по столбцу матрицы 28*28
                        sum = sum + Math.pow(data[i].getValue(r, c) - testPhoto.getValue(r, c), 2);

                    }
            }
            distances[i] = Math.sqrt(sum);
        }
        return distances;
    }
}
