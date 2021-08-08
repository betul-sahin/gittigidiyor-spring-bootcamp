package dev.patika.inheritance3;

public class TestInheritance3 {
    public static void main(String[] args) {

        Pen pen = new Pen();

        Shape circle = new Circle(10.0 , "Blue");
        pen.draw((Circle) circle);
        pen.changeColor("Aqua", (Circle) circle);


        Shape rectangle = new Rectangle("Yellow", 10, 10);
        if(rectangle instanceof Circle){
            pen.draw((Circle) rectangle);
            pen.changeColor("Brown", (Circle) rectangle);
        }

    }
}
