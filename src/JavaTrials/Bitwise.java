package JavaTrials;

public class Bitwise {
    public static void main(String args[]) {

        // x is stored using 32 bit 2's complement form.
        // Binary representation of -1 is all 1s (111..1)
        int x = -1;

        System.out.print(x >>> 29);  // The value of 'x>>>29' is 00...0111
        System.out.print(" | ");  // The value of 'x>>>29' is 00...0111
        System.out.print(x >> 29);  // The value of 'x>>>29' is 00...0111
        System.out.println(x >>> 30);  // The value of 'x>>>30' is 00...0011
        System.out.println(x >>> 31);  // The value of 'x>>>31' is 00...0001

        int y = 4;
        System.out.println(y>>1);
    }
}
