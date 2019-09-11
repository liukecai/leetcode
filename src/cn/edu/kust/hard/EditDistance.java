package cn.edu.kust.hard;

import cn.edu.kust.util.Print;

/**
 *
 * 72. Edit Distance
 * pass
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }
        if (word1.length() == 0 && word2.length() != 0) {
            return word2.length();
        }
        if (word2.length() == 0 && word1.length() != 0) {
            return word1.length();
        }

        int[][] editMatrix = new int[word1.length() + 1][word2.length() + 1];

        editMatrix[0][0] = 0;

        for (int i = 0; i < word1.length() + 1; i++) {
            editMatrix[i][0] = i;
        }

        for (int i = 1; i < word2.length() + 1; i++) {
            editMatrix[0][i] = i;
        }

        int min = 0;

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    editMatrix[i][j] = editMatrix[i - 1][j - 1];
                } else {
                    editMatrix[i][j] = min(editMatrix[i - 1][j - 1], editMatrix[i - 1][j], editMatrix[i][j - 1]) + 1;
                }

                if (editMatrix[i][j] >= min) {
                    min = editMatrix[i][j];
                }
            }
        }

        // Print.print2DArray(editMatrix);

        return editMatrix[word1.length()][word2.length()];
    }

    private int min(int a, int b, int c) {
        int min1 = Math.min(a, b);
        return Math.min(min1, c);
    }
}
