package com.cdemarti.assignmentfour.thirdquestion;

public class Producer extends Thread {
    StringBuffer buffer;
    boolean doneProducing = false;

    Producer(){
        buffer = new StringBuffer(4);
    }

    public void run(){
        synchronized (buffer){
            for (int i = 0; i < 4; i++){
                try {
                    buffer.append(i);
                    System.out.println("Adding to buffer - " + i);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            buffer.notify();
        }
    }

}
