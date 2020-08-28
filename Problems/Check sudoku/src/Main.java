import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static int[][] getSudokuMatrix(int sudokoSize) {
        int[][] sudokuPuzzle = new int[sudokoSize][sudokoSize];
        
        // Getting Sudodku data from users
        for (int i = 0; i < sudokoSize; i++) {
            for (int j = 0; j < sudokoSize; j++) {
                sudokuPuzzle[i][j] = scanner.nextInt();
            }
        }
        return sudokuPuzzle;
    }

    public static int getSum(int num) {
        int total = 0;
        for (int i = num; i > 0; i--) {
            total += i;
        }

        return total;
    }

    public static boolean checkColumnsPass(int[][] completedSudoku,
                                           int expectedColSum, int colLength) {
        boolean pass = true;

        for (int i = 0; i < colLength; i++) {
            int runningtotal = 0;

            for (int j = 0; j < colLength; j++) {
                runningtotal += completedSudoku[j][i];
            }

            if (runningtotal != expectedColSum) {
                pass = false;
                break;
            }
        }

        return pass;
    }

    public static boolean checkRowsPass(int[][] completedSudoku,
                                           int expectedRowSum, int rowLength) {
        boolean pass = true;

        for (int i = 0; i < rowLength; i++) {
            int runningtotal = 0;

            for (int j = 0; j < rowLength; j++) {
                runningtotal += completedSudoku[i][j];
            }

            if (runningtotal != expectedRowSum) {
                pass = false;
                break;
            }
        }

        return pass;
    }

    public static boolean checkSubSquaresPass(int[][] completedSudko,
                                              int expectedSquareSum,
                                              int subSquareSize,
                                              int subSectionSize) {

        boolean pass = true;

        // Section by section - Top to Bottom
        for (int i = 0; i < subSquareSize; i += subSectionSize) {
            // Section by section - Left to Right
            for (int j = 0; j < subSquareSize; j += subSectionSize) {

                // Summing for each row in section
                int runningTotal = 0;

                for (int k = 0; k < subSectionSize; k++) {
                    // Summing up current row
                    for (int l = 0; l < subSectionSize; l++) {
                        runningTotal += completedSudko[i + k][j + l];
                    }
                }

                if (runningTotal != expectedSquareSum) {
                    pass = false;
                    break;
                }

            }
        }

        return pass;
    }

    public static void main(String[] args) {
        // write your code here
        int arrSize = scanner.nextInt();
        int sizeSquared = arrSize * arrSize;
        int[][] sudoku = getSudokuMatrix(sizeSquared);
        int sumToCheckAgainst = getSum(sizeSquared);

        if (!checkColumnsPass(sudoku, sumToCheckAgainst, sizeSquared)) {
            System.out.println("NO");
            return;
        }

        if (!checkRowsPass(sudoku, sumToCheckAgainst, sizeSquared)) {
            System.out.println("NO");
            return;
        }

        if (!checkSubSquaresPass(sudoku, sumToCheckAgainst, sizeSquared, arrSize)) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");

//        // Print arrays for review
//        for (int[] array: sudoku) {
//            System.out.println(Arrays.toString(array));
    }
}