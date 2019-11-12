package ua.kpi.tef.ti71.lab1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ua.kpi.tef.ti71.lab1.EquationSolver;


class EquationSolverTest {


    private EquationSolver solver;

    EquationSolverTest(){
        this.solver = new EquationSolver();
    }

    @Test
    public void solveSquareEquation_dGreater0() {
        assertArrayEquals(new Double[]{-1d, -2d}, solver.solveSquareEquation(1d, 3d, 2d));
        assertArrayEquals(new Double[]{-0.25d, -1d}, solver.solveSquareEquation(4d, 5d, 1d));
    }

    @Test
    public void solveSquareEquation_dEquals0() {
        assertArrayEquals(new Double[]{-1d, -1d}, solver.solveSquareEquation(1d, 2d, 1d));
    }

    @Test void solveSquareEquation_dLess0() {
        assertEquals(3, solver.solveSquareEquation(1d, 0d, 1d).length); //Three results
        assertArrayEquals(new Double[]{-0d, 1d, -1d}, solver.solveSquareEquation(1d, 0d, 1d));
    }

    @Test void solveSquareEquation_aEquals0AndbNot0() {
        assertEquals(1, solver.solveSquareEquation(0d, 1d, 1d).length); //Three results
        assertArrayEquals(new Double[]{-1d}, solver.solveSquareEquation(0d, 1d, 1d));
    }

    @Test void solveSquareEquation_aEquals0AndbEquals0AndcEquals0() {
        assertArrayEquals(null, solver.solveSquareEquation(0d, 0d, 0d));
    }

    @Test void solveSquareEquation_aEquals0AndbEquals0AndcNot0() {
        assertArrayEquals(null, solver.solveSquareEquation(0d, 0d, 1d));
    }

    @Test void solveLinearEquation_bNot0(){
        assertEquals(-1d, solver.solveLinearEquation(1d, 1d)); //Three results
    }

    @Test void solveLinearEquation_bEquals0(){
        assertEquals(null, solver.solveLinearEquation(0d, 1d)); //Three results
    }

    @Test void solveLinearEquation_bEquals0cEquals0(){
        assertEquals(null, solver.solveLinearEquation(0d, 0d)); //Three results
    }

}