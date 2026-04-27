//Linked List
//Write a function to find the middle node of a singly linked list.
// If there are two middle nodes, return the second middle node.
public class Task2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int value) { this.val = value; }
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static ListNode buildList(int[] vals) {
        ListNode vremenny = new ListNode(0);
        ListNode curr = vremenny;
        for (int v : vals) curr = curr.next = new ListNode(v);
        return vremenny.next;
    }
    public static void printList(ListNode node) {
        StringBuilder finish = new StringBuilder("[");
        while (node != null) {
            finish.append(node.val);
            if (node.next != null) finish.append(", ");
            node = node.next;
        }
        finish.append("]");
        System.out.println(finish);
    }

    public static void main(String[] args) {
        ListNode list1 = buildList(new int[]{1, 2, 3, 4, 5});
        printList(middleNode(list1));
    }
}