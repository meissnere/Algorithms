package techQuestions;

public class BitwiseANDNumbersRange {
    public static void main(String[] args) {
        int m = 10;
        int n = 11;
        System.out.println(rangeBitwiseAnd(m, n));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        } else if (m == 0) {
            return 0;
        }
        int shift_counter = 0;
        while (m < n) {
            System.out.println("m is: " + m + ", n is: " + n);
            m = m >> 1;
            n = n >> 1;
            shift_counter++;
        }
        int res = m << shift_counter;
        return res;
    }
}
