package algorithm.dp;

/**
 * leetCode 11.生最多水的容器
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return ans;
    }
}
