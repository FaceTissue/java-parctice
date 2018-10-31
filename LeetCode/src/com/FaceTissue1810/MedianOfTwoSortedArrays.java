package com.FaceTissue1810;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays out = new MedianOfTwoSortedArrays();
        Solution solution = out.new Solution();
        int[] nums1 = {};
        int[] nums2 = {2, 5, 6, 7};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));

    }

    class Solution {
        /**
         * my solution
         */
        double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length, m = nums2.length, i = 0, j = 0;
            if (n == 0 && m == 0) throw new IllegalArgumentException();
            List<Integer> merge = new ArrayList<>();
            while (i < n && j < m) {
                merge.add(nums1[i] < nums2[j] ? nums1[i++] : nums2[j++]);
            }
            while (i < n) merge.add(nums1[i++]);
            while (j < m) merge.add(nums2[j++]);

            return  (((n + m) & 1) == 1) ? merge.get((n + m - 1) / 2) :
                    (merge.get((n + m - 1) / 2) + merge.get((n + m) / 2)) / 2.0;
        }
    }
}
