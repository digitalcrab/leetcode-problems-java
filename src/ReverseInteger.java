/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed
 * integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger {

    /**
     * Time Complexity: O(log(x)). There are roughly log10(x) digits in x
     * Space Complexity: O(1)
     * ​
     * log10(x) = y  --- 10^y = x
     * We reduce a number of iterations by 10
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;

        // loop over example 123
        while (x != 0) {
            // 1) 123 % 10 = 3; 2) 12 % 10 = 2; 3) 1 % 10 = 1
            int pop = x % 10;

            // Hint: Java removed the trailing part by casting to int
            // 1) 123 / 10 = 12; 2) 12 / 10 = 1; 3) 1 / 10 = 0
            x = x / 10;

            // 2147483647 / 10 = 214748364 and only 7 left
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            // -2147483648 / 10 = -214748364 and only -8 left
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            // 1) 0 * 10 + 3 = 3; 2) 3 * 10 + 2 = 32; 3) 32 * 10 + 1 = 321
            res = res * 10 + pop;
        }

        return res;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();

        System.out.println(ri.reverse(123));  // 321
        System.out.println(ri.reverse(-123)); // -321
        System.out.println(ri.reverse(120));  // 21
    }
}
