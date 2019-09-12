package cn.edu.kust.hard;

/**
 *
 * 4. Median of Two Sorted Arrays
 * pass
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            if (nums2.length % 2 == 1) {
                return nums2[nums2.length / 2];
            } else {
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
            }
        }

        if (nums2 == null || nums2.length == 0) {
            if (nums1.length % 2 == 1) {
                return nums1[nums1.length / 2];
            } else {
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
            }
        }

        int[] merged = new int[nums1.length + nums2.length];

        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int k = merged.length - 1;

        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    merged[k] = nums1[i];
                    i--;
                } else {
                    merged[k] = nums2[j];
                    j--;
                }
                k--;
                continue;
            }

            if (i >= 0) {
                merged[k] = nums1[i];
                i--;
                k--;
                continue;
            }

            if (j >= 0) {
                merged[k] = nums2[j];
                j--;
                k--;
                continue;
            }
        }

        if (merged.length % 2 == 1) {
            return merged[merged.length / 2];
        } else {
            return (merged[merged.length / 2 - 1] + merged[merged.length / 2]) / 2.0;
        }
    }
}
