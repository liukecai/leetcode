package cn.edu.kust.medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * 11. Container with most water
 * pass
 */
public class ContainerWater {
    public int maxArea(int[] height) {
        // space O(nlogn)
        if (height == null || height.length == 0) {
            return 0;
        }

        ArrayList<Integer> area = new ArrayList<>(height.length * height.length);
        int min = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j++) {
                min = Math.min(height[i], height[j]);
                area.add(min * (j - i));
            }
        }

        Collections.sort(area);
        return area.get(area.size() - 1);
    }

    public int maxArea2(int[] height) {
        // space O(1)
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    public int maxArea3(int[] height) {
        // time O(n)
        // space O(1)
        int head = 0;
        int tail = height.length - 1;
        int max = 0;

        while (head < tail) {
            max = Math.max(max, Math.min(height[head], height[tail]) * (tail - head));

            if (height[head] >= height[tail]) {
                tail--;
            } else {
                head++;
            }
        }

        return max;
    }
}
