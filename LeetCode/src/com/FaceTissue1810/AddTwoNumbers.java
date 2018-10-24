package com.FaceTissue1810;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * my solution
 */
class Solution {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1, b = l2;
        boolean addTag = false;
        List<ListNode> nodeList = new ArrayList<>();
        while (a != null || b != null) {
            int size = nodeList.size();
            int sum;
            if (a == null || b == null) {
                if (!addTag) {
                    ListNode breakNode = a == null ? b : a;
                    if (size > 0) {
                        nodeList.get(size - 1).next = breakNode;
                    } else {
                        nodeList.add(breakNode);
                    }
                    return nodeList.get(0);
                }
                else {
                    ListNode listNode = a == null ? b : a;
                    sum = listNode.val + 1;
                    a = a == null ? null : a.next;
                    b = b == null ? null : b.next;
                }
            }
            else {
                sum = addTag ? a.val + b.val + 1 : a.val + b.val;
                a = a.next;
                b = b.next;
            }
            addTag = sum >= 10;
            ListNode node = new ListNode(sum % 10);
            if (size > 0) {
                nodeList.get(size - 1).next = node;
            }
            nodeList.add(node);
            if (a == null && b == null && addTag) {
                ListNode tailNode = new ListNode(1);
                nodeList.get(size).next = tailNode;
            }
        }
        return nodeList.get(0);
    }
}

/**
 * the best solution
 */
class BestSolution {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
