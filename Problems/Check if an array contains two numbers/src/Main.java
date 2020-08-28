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
        int numberM = scanner.nextInt();
        boolean nextToEachOther = false;

        for (int i = 1; i < length; i++) {
            if (array[i] == numberM && array[i - 1] == numberN ||
                    array[i] == numberN && array[i - 1] == numberM) {
                nextToEachOther = true;
                break;
            }
        }

        System.out.println(nextToEachOther);
    }
}