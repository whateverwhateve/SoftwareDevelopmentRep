package com.company;

public class Main {

    public static void main(String[] args) {

        //SmallInteger example
        try {

            SmallInteger a = new SmallInteger("-1000");
            SmallInteger b = new SmallInteger("5");
            //SmallInteger с = new SmallInteger("200000");
            System.out.println("First number: " + a);
            System.out.println("Second number: " + b);
            System.out.println("a * b operations:");
            System.out.println("Sum result = " + a.add(b).toString());
            System.out.println("Sub result = " + a.subtract(b).toString());
            System.out.println("Mul result = " + a.multiply(b).toString());
            System.out.println("Div result = " + a.divide(b).toString());
            System.out.println("b * a operations:");
            System.out.println("Sum result = " + b.add(a).toString());
            System.out.println("Sub result = " + b.subtract(a).toString());
            System.out.println("Mul result = " + b.multiply(a).toString());
            System.out.println("Div result = " + b.divide(a).toString());
        }
        catch(SmallIntegerException ex){

            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }

    }
}
