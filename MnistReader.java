package com.company.MNIST;

import java.io.*;

public class MnistReader  {

    public MnistMatrix[] readData(String dataFilePath, String labelFilePath) throws IOException {
        //считывание информации об изображениях
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFilePath)));
        int magicNumber = dataInputStream.readInt();
        int numberOfItems = dataInputStream.readInt();
        int nRows = dataInputStream.readInt();
        int nCols = dataInputStream.readInt();

        /*//вывовд информации
        System.out.println("magic number is " + magicNumber);
        System.out.println("number of items is " + numberOfItems);
        System.out.println("number of rows is: " + nRows);
        System.out.println("number of cols is: " + nCols);*/

        //считывание информации об этикетках
        DataInputStream labelInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(labelFilePath)));
        int labelMagicNumber = labelInputStream.readInt();
        int numberOfLabels = labelInputStream.readInt();

        /*//вывод считанной информации
        System.out.println("labels magic number is: " + labelMagicNumber);
        System.out.println("number of labels is: " + numberOfLabels);*/

        //создание матрицы с изображениями (просто массив/ матрица, матриц MNIST)
        MnistMatrix[] data = new MnistMatrix[numberOfItems];

        //проверка, что число изображений = числу этикеток в файлах
        assert numberOfItems == numberOfLabels;

        //перебираем все изображения
        for(int i = 0; i < numberOfItems; i++) {

            //создаём объект MNIST с матрицей 28*28
            MnistMatrix mnistMatrix = new MnistMatrix(nRows, nCols);

            //пишем в значение этикетки считанное из файла, оно в виде байтовой переменной
            mnistMatrix.setLabel(labelInputStream.readUnsignedByte());

            for (int r = 0; r < nRows; r++) {

                for (int c = 0; c < nCols; c++) {

                    //пишем считанный байт в квадратную матрицу, каждый элемент матрицы это отдельный пиксель
                    mnistMatrix.setValue(r, c, dataInputStream.readUnsignedByte());
                }
            }

            //пишем в матрицу объектов наш, только что созданный объект
            data[i] = mnistMatrix;
        }

        //закрываем потоки чтения этикеток и картинок
        dataInputStream.close();
        labelInputStream.close();

        //возвращаем нашу матрицу объектов - это выборка
        return data;
    }
}
