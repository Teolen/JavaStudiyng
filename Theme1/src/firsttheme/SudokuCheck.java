package firsttheme;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SudokuCheck {

    public static boolean sudokuChecker(int[][] sudoku) {

        if (sudoku.length != 9) {
            throw new IllegalArgumentException("wrong size of sudoku");
        }

        if (Stream.of(sudoku).anyMatch(s -> s.length != 9)) {
            throw new IllegalArgumentException("wrong size of sudoku");
        }

        //Stream check of row
        if (!Stream.of(sudoku)
                .allMatch(SudokuCheck::lineChecker)) {
        System.out.println("Row error!");
            return false;
        }

        //Stream check of column
        if (!Stream.iterate(0,x -> x < 9, x -> x+1)
                .map(i -> IntStream.range(0,9)
                        .map(j -> sudoku[j][i]).toArray())
                .allMatch(SudokuCheck::lineChecker)) {
            System.out.println("Column error!");
            return false;
        }

        //Stream check of square
        if(!Stream.of(0,1,2)
                .flatMap(r -> Stream.of(0,1,2)
                        .map(c -> IntStream.iterate(3*r, i -> i < r*3+3,i -> i+1)
                                .flatMap(i -> IntStream.iterate(3*c, j -> j < c*3+3,j -> j+1)
                                        .map(j -> sudoku[i][j]))
                                .toArray()))
                .allMatch(SudokuCheck::lineChecker)) {
            System.out.println("Square error!");
            return false;
        }
        return true;
    }

    private static boolean lineChecker(int[] arr) {
        var input = Arrays.stream(arr).filter(x -> x != 0).count();
        var inputDist = Arrays.stream(arr).filter(x -> x != 0).distinct().count();
        return input == inputDist;
    }
}

