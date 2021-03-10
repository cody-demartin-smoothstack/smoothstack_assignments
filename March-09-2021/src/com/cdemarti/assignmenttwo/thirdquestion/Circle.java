package com.cdemarti.assignmenttwo.thirdquestion;

public class Circle implements IShape {
    final Number pi = 3.14;
    double radius;

    Circle(){
        this.radius = 10;
    }

    @Override
    public Number area() {
        return (float)pi*(Math.pow(this.radius, 2));
    }

    @Override
    public void display() {
        System.out.println("The area of this rectangle is: " + this.area());
    }
}
