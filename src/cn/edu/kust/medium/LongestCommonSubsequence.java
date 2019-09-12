package cn.edu.kust.medium;

/**
 *
 * 1143. Longest Common Subsequence
 * pass
 */
public class LongestCommonSubsequence {
    public int lcs(String text1, String text2) {
        text1 = "#" + text1;
        text2 = "#" + text2;

        int x = text1.length();
        int y = text2.length();

        int[][] matrix = new int[x][y];

        for (int i = 0; i < x; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i < y; i++) {
            matrix[0][i] = 0;
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        return matrix[x - 1][y - 1];
    }

    public static void main(String[] args) {
        // output: 4
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.lcs(str1, str2));
    }
}
