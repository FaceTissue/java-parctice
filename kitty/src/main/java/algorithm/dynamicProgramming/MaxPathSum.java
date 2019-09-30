package algorithm.dynamicProgramming;

import bean.TreeNode;
import org.junit.Test;

/***************************************************************************
 * @className: MaxPathSum
 * @date     : 2019/9/30 17:07
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class MaxPathSum {

    public int maxPathSum(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dp(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[] {root.val, root.val};
        }
        int[] res = new int[2];
        if (root.left == null || root.right == null) {
            int[] result = root.left == null ? dp(root.right) : dp(root.left);
            res[0] = Math.max(Math.max(result[0], root.val), result[1] + root.val);
            res[1] = Math.max(root.val, root.val + result[1]);
            return res;
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        res[0] = Math.max(Math.max(Math.max(left[0], right[0]), root.val),
                Math.max(Math.max(left[1] + root.val, right[1] + root.val), left[1] + right[1] + root.val));
        res[1] = Math.max(Math.max(left[1], right[1]) + root.val, root.val);
        return res;
    }

    @Test
    public void maxPathSumTest() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));

        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));

        root = new TreeNode(-2);
        root.left = new TreeNode(-1);
        System.out.println(maxPathSum(root));
    }

    /**
     * [官方题解]
     * @Author: 张琰培 (zhangyanpei@vvise.com)
     * @Date: 2019/9/30 17:08
     */
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum1(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);
        int self = node.val + left + right;
        maxSum = Math.max(maxSum, self);
        return node.val + Math.max(left, right);
    }
}
