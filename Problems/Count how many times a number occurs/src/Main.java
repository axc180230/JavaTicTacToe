import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        
        int length = scanner.nextInt();
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        int numberN = scanner.nextInt();
        int counter = 0;

        for (int num : array) {
            if (num == numberN) {
                ++counter;
            }
        }

        System.out.println(counter);
    }
}