package cn.edu.kust.medium;

/**
 *
 * 91. Decode Ways
 * pass
 *
 * 斐波那契数列的变形
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] count = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            count[i] = 0;
        }

        count[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                count[i] += count[i - 1];
            }
            if (s.charAt(i - 1) == '1' ||
                    (s.charAt(i - 1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6')) {
                if (i - 2 >= 0) {
                    count[i] += count[i - 2];
                } else {
                    count[i] += count[i - 1];
                }

            }
        }

        return count[s.length() - 1];
    }
}
