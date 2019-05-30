package algorithm.greedy;

/**
 * 55.跳跃游戏
 */
public class CanJump {
    /**
     * 通常解决并理解一个动态规划问题需要以下4个步骤：
     * 1.利用递归回溯解决问题
     * 2.利用记忆表优化（自顶向下的动态规划）
     * 3.移除递归的部分（自底向上的动态规划）
     * 4.使用技巧减少时间和空间复杂度
     */
    // 方法一：回溯
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
    private boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) return true;
        }
        return false;
    }
    // 方法二：自顶向下的动态规划
    enum Index {
        GOOD, BAD, UNKNOW
    }
    Index[] memo;
    public boolean canJump1(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = Index.UNKNOW;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition1(0, nums);
    }
    private boolean canJumpFromPosition1(int position, int[] nums) {
        if (memo[position] != Index.UNKNOW) {
            return memo[position] == Index.GOOD;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition1(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }
    // 方法三：自底向上的动态规划
    public boolean canJump2(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOW;
        }
        memo[memo.length - 1] = Index.GOOD;
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    // 方法四：贪心算法
    public boolean canJump3(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
