import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Getting Array Size and getting rid of NewLine
        String arraySizeString = scanner.nextLine();
        int arraySize = Integer.parseInt(arraySizeString);

        int intArraySum = 0;

        // Looping through to create int array
        for (int i = 0; i < arraySize; i++) {
            intArraySum += scanner.nextInt();
        }

        System.out.println(intArraySum);
    }
}