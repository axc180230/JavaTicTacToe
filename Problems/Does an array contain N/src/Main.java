import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // get user input
        int arraySize = scanner.nextInt();
        String clearingNewLine = scanner.nextLine();
        String numberString = scanner.nextLine();
        int intN = scanner.nextInt();

        // Convert number string to string array
        String[] stringArray = numberString.split(" ");

        boolean intNInNumbers = false;

        for (int i = 0; i < arraySize; i++) {
            if (intN == Integer.parseInt(stringArray[i])) {
                intNInNumbers = true;
                break;
            }
        }

        System.out.println(intNInNumbers);

    }
}