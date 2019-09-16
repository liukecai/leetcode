package cn.edu.kust.medium;

import java.util.Arrays;

/**
 * 494. Target Sum
 */
public class TargetSum {

    private int count = 0;

    public int findTargetSumWays(int[] nums, int s) {
        // dp:
        // https://leetcode.com/problems/target-sum/discuss/97334/java-15-ms-c-3-ms-ons-iterative-dp-solution-using-subset-sum-with-explanation

        return 0;
    }

    public int findTargetSumWaysWithMemoization(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];

        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return find(nums, 0, 0, S, memo);
    }

    private int find(int[] nums, int sum, int index, int S, int[][] memo) {
        if (index == nums.length) {
            if (sum == S) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (memo[index][sum + 1000] != Integer.MIN_VALUE) {
                return memo[index][sum + 1000];
            }

            int add = find(nums, sum + nums[index], index + 1, S, memo);
            int subtract = find(nums, sum - nums[index], index + 1, S, memo);
            memo[index][sum + 1000] = add + subtract;
            return memo[index][sum + 1000];
        }
    }



    public int findTargetSumWaysWithRecursion(int[] nums, int S) {
        count = 0;
        find(0, nums, 0, S);
        return count;
    }

    private void find(int sum, int[] nums, int start, int S) {
        if (start == nums.length - 1) {
            if (sum + nums[start] == S) {
                count++;
            }
            if (sum - nums[start] == S) {
                count++;
            }
            return;
        }

        find(sum + nums[start], nums, start + 1, S);
        find(sum - nums[start], nums, start + 1, S);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 1, 1};
        int S1 = 3;

        TargetSum ts = new TargetSum();
        System.out.println(ts.findTargetSumWaysWithMemoization(nums1, S1));
    }
}
