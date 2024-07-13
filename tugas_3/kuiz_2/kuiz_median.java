import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge two sorted arrays into one sorted array
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // If there are remaining elements in nums1
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // If there are remaining elements in nums2
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // Calculate median
        int total = m + n;
        if (total % 2 == 1) {
            return merged[total / 2];
        } else {
            int mid1 = merged[(total / 2) - 1];
            int mid2 = merged[total / 2];
            return (double) (mid1 + mid2) / 2;
        }
    }
}