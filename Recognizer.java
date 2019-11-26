package com.company.MNIST;

public class Recognizer {
    private MnistMatrix testPhoto;
    private MnistMatrix[] samples;
    private NeighborSercher metric;

//конструктор распознавателя с выборкой, метрикой для распознавания или тестируемым фото
    public Recognizer(MnistMatrix testPhoto, MnistMatrix[] samples, NeighborSercher metric) {
        this.testPhoto = testPhoto;
        this.samples = samples;
        this.metric = metric;
    }



    public int analysis(){
        double[] distances = new double[samples.length];
        for (int i = 0; i < samples.length; i++) {
            distances[i] = metric.neighborSearch(samples[i],this.testPhoto);
        }
        //double[] kOfNeighbors = metric.neighborSearch(this.samples,this.testPhoto);
        int[] indexOfNearestNeighbors = nearestNeighbors(distances,20);
        int resultLabel = resultLabel(this.samples,indexOfNearestNeighbors);
        System.out.println("На картинке: " + resultLabel);
        return resultLabel;
    }

    private int[] nearestNeighbors(double[] dist, int k){//ok
        int[] indOfNearests = new int[k];
        double minK = Double.MAX_VALUE;
        int indexOfMinK = 0;

        for(int j = 0;j<k;j++) {
            for (int i = 0; i < dist.length; i++) {
                if (minK > dist[i]) {
                    minK = dist[i];
                    indexOfMinK = i;
                }
            }
            indOfNearests[j] = indexOfMinK;
            dist[indexOfMinK] = Double.MAX_VALUE;
            indexOfMinK = 0;
            minK = Double.MAX_VALUE;
        }
        return indOfNearests;
    }

    private int resultLabel(MnistMatrix[] vyb, int[] indexOfNearestNeighbors){
        int resultLabel = 10;

        int maxCount = 0;
        int count = 0;
        for(int j = 0;j<10;j++) {
            for (int i = 0; i < indexOfNearestNeighbors.length; i++) {
                if(vyb[indexOfNearestNeighbors[i]].getLabel() == j){
                    count++;
                }
            }
            System.out.print(j + " : " + count + "  :  ");
            if(maxCount<count){
                maxCount = count;
                resultLabel = j;

                count = 0;
            }
            else count = 0;
        }
        System.out.println();
        return resultLabel;
    }
//метод для задания тестового фото
    public void setTestPhoto(MnistMatrix testPhoto) {
        this.testPhoto = testPhoto;
    }
//метод для обучения/переобучения рекогнайзера
    public void setSamples(MnistMatrix[] samples) {
        this.samples = samples;
    }
//метод для задания метрики распознавания
    public void setMetric(NeighborSercher metric) {
        this.metric = metric;
    }

    public MnistMatrix getTestPhoto() {
        return testPhoto;
    }
}
