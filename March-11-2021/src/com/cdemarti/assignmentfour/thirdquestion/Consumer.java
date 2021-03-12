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
            for (int i = 3; i >= 0; i--) {
                System.out.println(p.buffer.charAt(i) + " ");
                p.buffer.deleteCharAt(i);
            }
        }
    }
}
