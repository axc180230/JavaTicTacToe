import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        long[] longNumbers;
        longNumbers = new long[3];
        
        long one = 100_000_000_001L;
        long two = 100_000_000_002L;
        long three = 100_000_000_003L;
        
        longNumbers[0] = one;
        longNumbers[1] = two;
        longNumbers[2] = three;
        
        System.out.println(Arrays.toString(longNumbers));
    }
}
