package com.cdemarti.assignmenttwo.thirdquestion;

public class Rectangle implements IShape{
    int length = 100;
    int width = 100;


    @Override
    public Number area() {
        return this.width * this.length;
    }

    @Override
    public void display() {
        System.out.println("The area of this rectangle is: " + this.area());
    }
}
