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

        long maxProduct = intArray[0] * intArray[1];

        // Loop to find max product of 2 consecutive integers
        for (int i = 1; i < arraySize; i++) {
            long newPossibleMaxProduct = intArray[i - 1] * intArray[i];
            if (newPossibleMaxProduct > maxProduct) {
                maxProduct = newPossibleMaxProduct;
            }
        }

        System.out.println(maxProduct);
    }
}