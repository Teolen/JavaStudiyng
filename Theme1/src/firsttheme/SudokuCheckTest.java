package firsttheme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import static firsttheme.SudokuCheck.*;

public class SudokuCheckTest {

    @Test
    public void sudokuCheckerTest() {
        int[][] sudoku = {  {5,3,0,0,7,0,0,0,0},
                            {6,0,0,1,9,5,0,0,0},
                            {0,9,8,0,0,0,0,6,0},
                            {8,0,0,0,6,0,0,0,3},
                            {4,0,0,8,0,3,0,0,1},
                            {7,0,0,0,2,0,0,0,6},
                            {0,6,0,0,0,0,2,8,0},
                            {0,0,0,4,1,9,0,0,5},
                            {0,0,0,0,8,0,0,7,9}};
        List<Boolean> expected = Arrays.asList(true, false, false,true);
        List<Boolean> actual = new ArrayList<>();
        actual.add(sudokuChecker(sudoku));
        sudoku[0][0] = 8;
        actual.add(sudokuChecker(sudoku));
        sudoku[0][0] = 1; sudoku[2][4] = 5;
        actual.add(sudokuChecker(sudoku));
        sudoku[2][4] = 4;
        actual.add(sudokuChecker(sudoku));
        assertEquals(expected, actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void sudokuCheckerIllegalTest() {
        // 10 rows
        int[][] sudoku = {  {5,3,0,0,7,0,0,0,0},
                            {6,0,0,1,9,5,0,0,0},
                            {0,9,8,0,0,0,0,6,0},
                            {8,0,0,0,6,0,0,0,3},
                            {4,0,0,8,0,3,0,0,1},
                            {7,0,0,0,2,0,0,0,6},
                            {0,6,0,0,0,0,2,8,0},
                            {0,0,0,4,1,9,0,0,5},
                            {0,0,0,0,8,0,0,7,9},
                            {5,2,0,0,0,1,8,0,0}};
        sudokuChecker(sudoku);
    }
    @Test(expected = NullPointerException.class)
    public void sudokuCheckerNullTest() {
        sudokuChecker(null);
    }
}