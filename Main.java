package com.company.MNIST;

import java.io.IOException;



public class Main {
    public static void main(String[] args){

        try {
            MnistMatrix[] mnistMatrix = new MnistReader().readData("C:\\Users\\User\\IdeaProjects\\Test\\src\\com\\company\\MNIST\\train-images.idx3-ubyte", "C:\\Users\\User\\IdeaProjects\\Test\\src\\com\\company\\MNIST\\train-labels.idx1-ubyte");
            MnistMatrix[] testMatrix = new MnistReader().readData("C:\\Users\\User\\IdeaProjects\\Test\\src\\com\\company\\MNIST\\t10k-images.idx3-ubyte", "C:\\Users\\User\\IdeaProjects\\Test\\src\\com\\company\\MNIST\\t10k-labels.idx1-ubyte");

            Recognizer recognizer = new Recognizer(testMatrix[0],mnistMatrix,new Minkovskiy());
            int ok = 0,ng = 0;
            for(int i = 0; i<testMatrix.length;i+=200){
                recognizer.setTestPhoto(testMatrix[i]);
                if(testMatrix[i].getLabel() == recognizer.analysis()){ok++;}
                else{ng++;}
            }
            System.out.println("Удачных распознаваний: " + ok + "\nНеудачных распознаваний: " + ng);

//---------------------------------------------------------------

//------------------------------------------------------------------
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void printMnistMatrix(final MnistMatrix matrix) {
        System.out.println("label: " + matrix.getLabel());
        for (int r = 0; r < matrix.getNumberOfRows(); r++ ) {
            for (int c = 0; c < matrix.getNumberOfColumns(); c++) {
                System.out.print(matrix.getValue(r, c) + " ");
            }
            System.out.println();
        }
    }
}

