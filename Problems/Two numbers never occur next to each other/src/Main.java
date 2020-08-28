import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int[] intArray = new int[arraySize];

        // Reading Array
        for (int i = 0; i < arraySize; i++) {
            intArray[i] = scanner.nextInt();
        }

        // reading nums N and M
        int numM = scanner.nextInt();
        int numN = scanner.nextInt();

        boolean numsNotNextToEachOther = true;

        // Loop to check if N & M are next to each other
        for (int i = 1; i < arraySize; i++) {
            if (intArray[i - 1] == numM && intArray[i] == numN ||
                    intArray[i - 1] == numN && intArray[i] == numM) {
                numsNotNextToEachOther = false;
                break;
            }
        }

        System.out.println(numsNotNextToEachOther);
    }
}