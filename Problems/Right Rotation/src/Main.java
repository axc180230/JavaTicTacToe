import java.util.Scanner;

class Main {

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

        String lineString = scanner.nextLine();
        String[] stringArray = lineString.split(" ");
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        int rotation = scanner.nextInt();
        rotation %= intArray.length;

        int[] intArrayCopy = new int[intArray.length];
        System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            int temp = (i + rotation) % intArray.length;
            //intArray[temp] = intArrayCopy[i];
            System.arraycopy(intArrayCopy, i, intArray, temp, 1);
        }

        System.out.println(convertIntArrayToString(intArray));
    }
}