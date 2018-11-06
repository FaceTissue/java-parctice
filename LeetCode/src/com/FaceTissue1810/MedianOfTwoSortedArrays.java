package com.FaceTissue1810;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays out = new MedianOfTwoSortedArrays();
        Solution solution = out.new Solution();
        int[] nums1 = {7, 8, 9, 10};
        int[] nums2 = {2, 5, 6, 7};
        System.out.println(solution.findMedianSortedArrays1(nums1, nums2));

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
        /**
         * best solution
         */
        public double findMedianSortedArrays1(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j-1] > A[i]){
                    iMin = i + 1; // i is too small
                }
                else if (i > iMin && A[i-1] > B[j]) {
                    iMax = i - 1; // i is too big
                }
                else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }

        public double copy(int[] A, int[] B) {
            int m = A.length, n = B.length;
            if (m > n) {
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {

            }
            return 0.0;
        }
    }
}
