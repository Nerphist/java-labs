package ua.kpi.tef.ti71.lab1;

import ua.kpi.tef.ti71.lab1.EquationSolver;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        Double a,b,c;

        Scanner scan = new Scanner(System.in);

        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();

        EquationSolver solver = new EquationSolver();

        solver.solveSquareEquation(a, b, c);
    }

}
