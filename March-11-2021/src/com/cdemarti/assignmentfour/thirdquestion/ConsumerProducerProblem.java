package com.cdemarti.assignmentfour.thirdquestion;

public class ConsumerProducerProblem {
    public static void main(String[] args) {
        Producer p = new Producer();
        Consumer c = new Consumer(p);

        Thread threadOne = new Thread(c);
        Thread threadTwo = new Thread(p);

        threadTwo.start();
        threadOne.start();
    }
}
