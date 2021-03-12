package com.cdemarti.assignmentfour.thirdquestion;

public class Consumer extends Thread {
    Producer p;

    Consumer(Producer temp){
        p = temp;
    }

    public void run(){
        synchronized (p.buffer){
            try {
                p.buffer.wait();
            } catch (Exception e){
                e.printStackTrace();
            }
            for (int i = 0; i < 4; i++) {
                System.out.print(p.buffer.charAt(i) + " ");
                p.buffer.deleteCharAt(i);
            }
        }
    }
}
