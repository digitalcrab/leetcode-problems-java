import java.util.HashSet;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        return floydCycleFinding(head);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * @param head
     * @return
     */
    public boolean floydCycleFinding(ListNode head) {
        // we have 2 pointers, the fast (2x) and the slow (1x) one
        ListNode fast = head;
        ListNode slow = head;

        // while both not empty and fast has 1 step more than slow
        while (fast != null && slow != null && fast.next != null) {
            // move pointers
            slow = slow.next;
            fast = fast.next.next;

            // compare
            if (slow.equals(fast)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycleHashing(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();

        while (head != null) {
            if (hs.contains(head)) {
                return true;
            }

            hs.add(head);

            // move the node
            head = head.next;
        }

        return false;
    }

    public ListNode makeCycle() {
        ListNode root = new ListNode(1);

        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        // make a loop
        root.next.next.next.next.next = root;

        return root;
    }

    public static void main(String[] args) {
        LinkedListCycle llc = new LinkedListCycle();
        System.out.println(llc.hasCycle(llc.makeCycle()));
    }
}
