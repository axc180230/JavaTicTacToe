import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static char[][] createCharMatrixFrom4x4Input() {
        char[][] matrix = new char[4][4];

        // ingest string lines into char matrix
        for (int i = 0; i < 4; i++) {
            String temp = scanner.nextLine();

            for (int j = 0; j < 4; j++) {
                matrix[i][j] = temp.charAt(j);
            }
        }

        return matrix;
    }

    public static boolean checkIfMatrixPretty(char[][] charMatrix) {
        boolean pretty = true;

        // Using top left char as anchor, then checkin next right, below
        // and diagonally to the bottom right. Going through except last
        // column and row to avoid out of index error
        for (int i = 0; i < charMatrix.length - 1; i++) {
            for (int j = 0; j < charMatrix[i].length - 1; j++) {
                if (charMatrix[i][j] == charMatrix[i][j + 1] &&
                        charMatrix[i][j + 1] == charMatrix[i + 1][j] &&
                        charMatrix[i + 1][j] == charMatrix[i + 1][j + 1]) {
                    pretty = false;
                    break;
                }
            }
        }

        return pretty;
    }

    public static void main(String[] args) {
        // write your code here
        char[][] userMatrix = createCharMatrixFrom4x4Input();

        // Print arrays for review
//        for (char[] array: userMatrix) {
//            System.out.println(Arrays.toString(array));
//        }

        String response = checkIfMatrixPretty(userMatrix) ? "YES" : "NO";
        System.out.println(response);
    }
}