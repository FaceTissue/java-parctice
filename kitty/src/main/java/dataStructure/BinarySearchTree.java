package dataStructure;

/***************************************************************************
 * @className: BinarySearchTree
 * @date     : 2019/9/17 12:53
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(b.kthSmallest(root, 3));
    }
    private class ResultType {
        boolean found;
        int val;
        ResultType(boolean found, int val) {
            this.found = found;
            this.val = val;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root, k).val;
    }

    private ResultType kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return new ResultType(false, 0);
        }
        ResultType left = kthSmallestHelper(root.left, k);
        if (left.found) {
            return new ResultType(true, left.val);
        }
        if (k - left.val == 1) {
            return new ResultType(true, root.val);
        }
        ResultType right = kthSmallestHelper(root.right, k - left.val - 1);
        if (right.found) {
            return new ResultType(true, right.val);
        }
        return new ResultType(false, left.val + right.val + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
