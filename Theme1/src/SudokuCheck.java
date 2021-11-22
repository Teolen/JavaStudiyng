public class SudokuCheck {
    public static boolean sudokuChecker(int[][] sudoku) {
        int[] tmp = new int[9];
        if (sudoku.length != 9) throw new IllegalArgumentException("wrong size of sudoku!");
        for(int[] sudokuRow : sudoku) {
            if(sudokuRow.length != 9) throw new IllegalArgumentException("wrong size of sudoku");
        }
        //check of row
        for(int[] line : sudoku)
            if (!lineChecker(line)) return false;

        //check if column
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tmp[j] = sudoku[j][i];
            }
            if (!lineChecker(tmp)) return false;
        }

        //check of square
        for(int r = 0; r < 3; r++)
            for(int c = 0; c < 3; c++) {
                for (int i = r * 3, i2 = 0; i < r * 3 + 3; i++, i2++) {
                    for (int j = c * 3, j2 = 0; j < c * 3 + 3; j++, j2++) {
                        tmp[i2*3 + j2] = sudoku[i][j];
                    }
                }
                if(!lineChecker(tmp)) return false;
            }
        return true;
    }
    private static boolean lineChecker(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr.length; j++)
                if((arr[i] != 0) && (i !=j) && (arr[i] == arr[j])) return false;
        return true;
    }

    public static void main(String[] args) {
        //int[][] sudoku3 = {{3,0,2},{3,1,0},{0,2,3}};
        int[][] sudoku9 = { {5,3,0,0,7,0,0,0,0},
                            {6,0,0,1,9,5,0,0,0},
                            {0,9,8,0,0,0,0,6,0},
                            {8,0,0,0,6,0,0,0,3},
                            {4,0,0,8,0,3,0,0,1},
                            {7,0,0,0,2,0,0,0,6},
                            {0,6,0,0,0,0,2,8,0},
                            {0,0,0,4,1,9,0,0,5},
                            {0,0,0,0,8,0,0,7,9}};
        System.out.println(sudokuChecker(sudoku9));
//        for(int[] line : sudoku9) {
//            for (int num : line)
//                System.out.print(num + ", ");
//            System.out.println();
//        }
        System.out.println("------------------------------");
        for(int i = 0; i < 9; i++) {

            System.out.print("|");
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku9[i][j]);
                if ((j+1)%3 == 0) System.out.print(" | ");
                        else System.out.print(", ");
            }
            System.out.println();
            if ((i+1)%3 == 0) System.out.println("------------------------------");
        }
    }
}
