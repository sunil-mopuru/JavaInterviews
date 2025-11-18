package com.javastack.datastructures.linkedlist;

public class ReverseSingleLinkedList
{
    public static void main(String[] args) {
        // create sample list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original: ");
        printList(head);

        System.out.print("Reversed: ");
        //printList(reverseList(head));;

        System.out.println("Middle node: " + middleNode(head).val);
    }

    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static ListNode reverseList(ListNode head) {
        ListNode left = null, ptr = head, right = null;
        while (ptr != null) {
            right = ptr.next; // temp variable
            ptr.next = left;
            left = ptr;
            ptr = right;
        }
        return left;
    }

    private static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static boolean hasCycle(ListNode head) {
         ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Find the node at which cycle begins (if any)
    public static ListNode detectCycleStart(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (!cycle) return null;  // no loop

        // Reset slow to head; keep fast at meeting point
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        // Where they meet is the start of the cycle
        return slow;
    }
}
