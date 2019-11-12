package ua.kpi.tef.ti71.lab1;

import java.util.*;

public class EquationSolver {

    public  Double[] solveSquareEquation(Double a, Double b, Double c) {
        Double d = b * b - 4 * a * c;
        Double x1, x2;

        if (a == 0d) {
            //Linear
            return new Double[]{solveLinearEquation(b, c)};
        }
        //Quadratic
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);

            return new Double[]{x1, x2};
        } else if (d == 0) {
            x1 = (-b + Math.sqrt(d)) / (2d * a);
            x2 = x1;

            System.out.println("x1 = x2 = " + x1);

            return new Double[]{x1, x2};
        } else {
            Double im, re;

            im = Math.sqrt(-d) / (2d * a);
            re = (-b) / (2 * a);

            System.out.println("x1 = " + re + " +" + im + "i");
            System.out.println("x2 = " + re + " -" + im + "i");

            return new Double[]{re, im, im * -1};

        }

    }


    public Double solveLinearEquation(Double b, Double c){
        double x;

        if (b != 0d) {
            x = -c / b;
            System.out.println("This equation has 1 solution ");
            System.out.println("x = " + x);

            return x;
        } else  if (c == 0d && b == 0d){
            System.out.println("This equation has infinite solutions ");
            return null;
        } else {
            System.out.println("This equation is not solvable");
            return null;
    }
    }
}
