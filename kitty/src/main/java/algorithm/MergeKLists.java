package algorithm;

import bean.ListNode;

/**
 * 23.合并K个排序链表
 */
public class MergeKLists {
    // my solution
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return merge(lists, lists.length - 1, new ListNode(0));
    }
    public ListNode merge(ListNode[] lists, int pos, ListNode cur) {
        ListNode dummy = cur;
        if (pos == 1) {
            ListNode first = lists[0], second = lists[1];
            while (first != null && second != null) {
                int v1 = first.val, v2 = second.val;
                if (v1 < v2) {
                    cur.next = first;
                    first = first.next;
                } else {
                    cur.next = second;
                    second = second.next;
                }
                cur = cur.next;
            }
            cur.next = first != null ? first : second;
            return dummy.next;
        } else {
            return merge(new ListNode[]{merge(lists, pos - 1, cur), lists[pos]}, 1, cur);
        }
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode[] newLists = new ListNode[(lists.length + 1) / 2];
        for (int i = 0; i < lists.length; i += 2) {
            ListNode a = lists[i];
            if (i + 1 == lists.length) newLists[i / 2] = a;
            else {
                ListNode b = lists[i + 1], dummy = new ListNode(0), curr = dummy;
                while (a != null && b != null) {
                    int v1 = a.val, v2 = b.val;
                    if (v1 < v2) {
                        curr.next = a;
                        a = a.next;
                    } else {
                        curr.next = b;
                        b = b.next;
                    }
                    curr = curr.next;
                }
                curr.next = a != null ? a : b;
                newLists[i / 2] = dummy.next;
            }
        }
        return mergeKLists1(newLists);
    }

    /**
     * 分治法
     */
    public ListNode mergeKList2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int mid = lists.length / 2;
        ListNode[] l1 = new ListNode[mid], l2 = new ListNode[lists.length - mid];
        for (int i = 0; i < mid; i++) l1[i] = lists[i];
        for (int i = mid; i < lists.length; i++) l2[i - mid] = lists[i];

        return mergeTwoLists(mergeKList2(l1), mergeKList2(l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
}
