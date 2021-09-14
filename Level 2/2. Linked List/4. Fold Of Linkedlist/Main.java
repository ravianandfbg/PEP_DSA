import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode middle(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void fold(ListNode head) {
        ListNode mid = middle(head);
        ListNode nextHead = mid.next;
        
        mid.next = null;
        
        ListNode right = reverse(nextHead);
        ListNode left = head;
        
        while(right != null){
            //backup
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;
            
            //connection
            left.next = right;
            right.next = leftNext;
            
            //move
            left = leftNext;
            right = rightNext;
        }
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}