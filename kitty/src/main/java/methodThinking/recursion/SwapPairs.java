package methodThinking.recursion;

import bean.ListNode;

/**
 * 递归三部曲：
 * 1.找终止条件。
 * 2.找返回值。
 * 3.本级递归应该做什么。
 */
public class SwapPairs {
    // 递归解决
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    /**
     * my solution
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = head.next, curr = null;
        while (head != null) {
            ListNode next = head.next;
            if (next != null) {
                head.next = next.next;
                next.next = head;
                if (curr != null) curr.next = next;
            }
            curr = head;
            head = head.next;
        }
        return dummy;
    }
}
