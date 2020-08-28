import java.util.Scanner;

class Main {

    public static int[][] createSpiralArray(int num) {
        int[][] spiralArray = new int[num][num];

        int leftBoundary = 0;
        int topBoundary = 0;
        int rightBoundary = num;
        int bottomBoundary = num;
        int pass = 1;
        int currentNum = 1;

        while (leftBoundary < rightBoundary && topBoundary < bottomBoundary) {
            if (pass == 1) {
                // going left to right (top boundary)
                for (int i = leftBoundary; i < rightBoundary; i++) {
                    spiralArray[topBoundary][i] = currentNum++;
                }

                topBoundary += 1;
                pass = 2;
                continue;
            }

            if (pass == 2) {
                // going top to bottom (right boundary)
                for (int i = topBoundary; i < bottomBoundary; i++) {
                    spiralArray[i][rightBoundary - 1] = currentNum++;
                }

                rightBoundary -= 1;
                pass = 3;
                continue;
            }

            if (pass == 3) {
                // going right to left (bottom boundary)
                for (int i = rightBoundary - 1; i >= leftBoundary; i--) {
                    spiralArray[bottomBoundary - 1][i] = currentNum++;
                }

                bottomBoundary -= 1;
                pass = 4;
                continue;
            }

            if (pass == 4) {
                // going bottom to top (left boundary)
                for (int i = bottomBoundary - 1; i >= topBoundary; i--) {
                    spiralArray[i][leftBoundary] = currentNum++;
                }

                leftBoundary += 1;
                pass = 1;
            }
        } // end while

        return spiralArray;
    }

    public static String convertIntArrayToString(int[] intArray) {

        //Create new StringBuffer object to store temporary String
        StringBuffer sbf = new StringBuffer();

        String strDelimiter = " ";

        // Avoiding having leading space before first number
        sbf.append(intArray[0]);

        // Loop (starting index 1) to append rest of numbers
        for (int i = 1; i < intArray.length; i++) {
            sbf.append(strDelimiter).append(intArray[i]);
        }

        return sbf.toString();
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int dimension = scanner.nextInt();
        int[][] spiralArr = createSpiralArray(dimension);


//        for (int i = 0; i < spiralArr.length; i++) {
//            System.out.println(convertIntArrayToString(spiralArr[i]));
//        }
        for (int[] array: spiralArr) {
            System.out.println(convertIntArrayToString(array));
        }

    }
}