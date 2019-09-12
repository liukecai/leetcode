package cn.edu.kust.medium;

import cn.edu.kust.util.Print;

public class LongestSubstring {
    public int lsb(String str1, String str2) {
        str1 = "#" + str1;
        str2 = "#" + str2;

        int max = 0;

        int x = str1.length();
        int y = str2.length();

        int[][] matrix = new int[x][y];
        for (int i = 0; i < x; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i < y; i++) {
            matrix[0][i] = 0;
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (max < matrix[i][j]) {
                        max = matrix[i][j];
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        Print.print2DArray(matrix);

        return max;
    }
}
