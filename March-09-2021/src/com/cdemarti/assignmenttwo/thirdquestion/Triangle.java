package com.cdemarti.assignmenttwo.thirdquestion;

public class Triangle implements IShape {

    Integer base = 10;
    Integer height = 10;

    @Override
    public Number area() {
        return (this.height * this.base)/2;
    }

    @Override
    public void display() {
        System.out.println("The area of this rectangle is: " + this.area());
    }
}
