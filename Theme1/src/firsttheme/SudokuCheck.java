package firsttheme;

import java.util.Arrays;

public class SudokuCheck {

    public static boolean sudokuChecker(int[][] sudoku) {
        int[] tmp = new int[9];
        if (sudoku.length != 9) {
            throw new IllegalArgumentException("wrong size of sudoku");
        }
        for(int[] sudokuRow : sudoku) {
            if(sudokuRow.length != 9) {
                throw new IllegalArgumentException("wrong size of sudoku");
            }
        }
        //check of row
        for(int[] line : sudoku) {
            if (!lineChecker(line)) {
                return false;
            }
        }
        //check of column
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tmp[j] = sudoku[j][i];
            }
            if (!lineChecker(tmp)) {
                return false;
            }
        }
        //check of square
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                for (int i = r * 3, i2 = 0; i < r * 3 + 3; i++, i2++) {
                    for (int j = c * 3, j2 = 0; j < c * 3 + 3; j++, j2++) {
                        tmp[i2*3 + j2] = sudoku[i][j];
                    }
                }
                if(!lineChecker(tmp)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean lineChecker(int[] arr) {
        var input = Arrays.stream(arr).filter(x -> x != 0).count();
        var inputDist = Arrays.stream(arr).filter(x -> x != 0).distinct().count();
        return input == inputDist;
    }
}

