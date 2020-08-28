import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Getting Array Size and getting rid of NewLine
        int arraySize = scanner.nextInt();

        int[] intArray = new int[arraySize];
        int intArraySum = 0;

        // Reading input to create int array
        for (int i = 0; i < arraySize; i++) {
            intArray[i] = scanner.nextInt();
        }

        // Number N is below minimum requirement to Sum
        int numberN = scanner.nextInt();

        // Looping through to create int array
        for (int i = 0; i < arraySize; i++) {
            if (intArray[i] > numberN) {
                intArraySum += intArray[i];
            }
        }

        System.out.println(intArraySum);
    }
}