package methodThinking.recursion;

import bean.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseKGroup {
    // 递归实现
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        // 找终止条件:剩余的节点数量不够K个
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            // 希望返回给上一级递归的是：反转好的头节点
            cur = reverseKGroup(cur, k);
            // 本级递归做的事情
            while (count > 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    // 用栈数据结构实现
    public ListNode reverseKGroup1(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0), cur = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                count++;
                tmp = tmp.next;
            }
            if (count < k) {
                cur.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                cur.next = stack.pollLast();
                cur = cur.next;
            }
            cur.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }

    // 尾插法
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy, prev = dummy;
        while (true) {
            int count = 0;
            while (tail != null && count < k) {
                tail = tail.next;
                count++;
            }
            if (tail == null) break;
            ListNode head1 = prev.next;
            while (prev.next != tail) {
                ListNode cur = prev.next;
                prev.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            prev = head1;
            tail = head1;
        }
        return dummy.next;
    }
}
