package techQuestions;

public class PerformStringShifts {
    public static void main(String[] args) {
        String s = "abcdefg";
        int[][] shift = {{1,1},{1,1},{0,2},{1,3}};

        System.out.println(stringShift(s, shift));
    }

//    Output: "efgabcd"
//    Explanation:
//            [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
//            [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
//            [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
//            [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
    public static String stringShift(String s, int[][] shift) {
        char[] sArray = s.toCharArray();

        // the [0,2] example cancels right shift!
        int left_count = 0;
        int right_count = 0;
        for (int i = 0; i < shift.length; i++) {
            int[] operation = shift[i];
            if (operation[0] == 0) {
                left_count = left_count + operation[1];
            } else {
                right_count = right_count + operation[1];
            }
        }
        int res = right_count - left_count;
        // what if there are more shifts than s.length?
        res = res % s.length();
        String result = "";
        if (res > 0) {
            // perform res right shifts
            result = s.substring(s.length()-res) + s.substring(0,s.length()-res);
        } else if (res < 0) {
            // perform res = res * -1 left shifts
            result = s.substring(-res) + s.substring(0,-res);
//            res = res * -1;
//            s = leftShift(sArray, res);
        } else {
            // shifts cancel out perfectly
            return s;
        }
        return result;
    }

    public static String rightShift(char[] sArray, int shift) {
        int end = sArray.length - 1 - shift;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shift; i++) {
            sb.append(sArray[end]);
            end++;
        }
        for (int i = 0; i < sArray.length - shift - 1; i++) {
            sb.append(sArray[i]);
        }
        return sb.toString();
    }

    public static String leftShift(char[] sArray, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = shift; i < sArray.length; i++) {
            sb.append(sArray[i]);
        }
        for (int i = 0; i < shift; i++) {
            sb.append(sArray[i]);
        }

        return sb.toString();
    }
}
