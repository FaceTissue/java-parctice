import bean.ListNode;
import org.junit.Test;

public class RotateRight {
    // my solution
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        int pos = k % size;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (pos != 0) {
            ListNode fast = dummy, low = dummy;
            while (pos > 0) {
                fast = fast.next;
                pos--;
            }
            while (fast.next != null) {
                fast = fast.next;
                low = low.next;
            }
            ListNode prevHead = dummy.next;
            dummy.next = low.next;
            low.next = null;
            fast.next = prevHead;
        }
        return dummy.next;
    }

    // official
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        int n;
        ListNode old_tail = head;
        for (n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }

    @Test
    public void rotateRightTest() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode res = rotateRight(head, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
