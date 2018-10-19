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
        System.out.println("hello world");
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean tag = false;
        List<ListNode> nodeList = new ArrayList<>();
        while (l1 != null || l2 != null) {
            int sum = tag ? l1.val + l2.val + 1 : l1.val + l2.val;
            tag = l1.val + l2.val >= 10;
            ListNode listNode = new ListNode(Math.abs(sum - 10));

            int size = nodeList.size();
            if (size > 0) {
                nodeList.get(size - 1).next = listNode;
            }
            nodeList.add(listNode);
        }
        return new ListNode(10);
    }
}
