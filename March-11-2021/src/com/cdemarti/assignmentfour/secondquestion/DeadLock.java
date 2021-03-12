package com.cdemarti.assignmentfour.secondquestion;

public class DeadLock {
        public static void main(String[] args) {
            final String exampleOne = "Hello World.";
            final String exampleTwo = "Goodbye World.";

            // t1 tries to lock resource1 then resource2
            Thread t1 = new Thread() {
                public void run() {
                    synchronized (exampleOne) {
                        System.out.println("Thread 1: locked resource 1");

                        try { Thread.sleep(100);} catch (Exception e) {}

                        synchronized (exampleTwo) {
                            System.out.println("Thread 1: locked resource 2");
                        }
                    }
                }
            };

            // t2 tries to lock resource2 then resource1
            Thread t2 = new Thread() {
                public void run() {
                    synchronized (exampleTwo) {
                        System.out.println("Thread 2: locked resource 2");

                        try { Thread.sleep(100);} catch (Exception e) {}

                        synchronized (exampleOne) {
                            System.out.println("Thread 2: locked resource 1");
                        }
                    }
                }
            };


            t1.start();
            t2.start();
        }
    }
