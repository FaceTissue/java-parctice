package algorithm.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42.接雨水
 */
public class Trap {
    //dp
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length, res = 0;
        int[] left_max = new int[n], right_max = new int[n];
        left_max[0] = height[0];
        right_max[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        for (int j = n - 2; j > 0; j--) {
            right_max[j] = Math.max(right_max[j + 1], height[j]);
            res += Math.min(left_max[j], right_max[j]) - height[j];
        }
        return res;
    }

    // double point
    public int trap1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1, left_max = 0, right_max = 0, res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < left_max) res += left_max - height[left];
                else left_max = height[left];
                left++;
            } else {
                if (height[right] < right_max) res += right_max - height[right];
                else right_max = height[right];
                right--;
            }
        }
        return res;
    }

    // stack
    public int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int tmp = stack.pop();
                if (stack.isEmpty()) break;
                res += (Math.min(height[stack.peek()], height[i]) - height[tmp]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }
}
