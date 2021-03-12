package com.cdemarti.assignmentfour.thirdquestion;

public class ConsumerProducerProblem {
    public static void main(String[] args) {
        Producer p = new Producer();
        Consumer c = new Consumer(p);

        Thread threadOne = new Thread(p);
        Thread threadTwo = new Thread(c);

        threadTwo.start();
        threadOne.start();
    }
}
