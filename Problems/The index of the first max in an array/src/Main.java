import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int[] intArray = new int[arraySize];

        // Bring in array
        for (int i = 0; i < arraySize; i++) {
            intArray[i] = scanner.nextInt();
        }

        // Vars to keep track of return value
        int maxNum = intArray[0];
        int maxNumIndex = 0;

        for (int i = 1; i < arraySize; i++) {
            if (intArray[i] > maxNum) {
                maxNum = intArray[i];
                maxNumIndex = i;
            }
        }

        System.out.println(maxNumIndex);
    }
}