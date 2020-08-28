import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // getting array size from user and creating array
        int arraySize = scanner.nextInt();
        int[] intArray = new int[arraySize];

        // reading array from user input
        for (int i = 0; i < arraySize; i++) {
            intArray[i] = scanner.nextInt();
        }

        int minInt = intArray[0];

        for (int i = 1; i < arraySize; i++) {
            if (intArray[i] < minInt) {
                minInt = intArray[i];
            }
        }

        System.out.println(minInt);
    }
}