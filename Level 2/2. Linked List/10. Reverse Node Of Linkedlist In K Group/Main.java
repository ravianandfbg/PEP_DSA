import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // code starts from here
    public static int size(ListNode head){
        int count = 0;
        ListNode temp = head;
        
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    
    public static ListNode reverseInKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1){
            return head;
        }
        int count = size(head);
        
        // take pointers for overall answer
        ListNode ah = null; // ah : answer head
        ListNode at = null; // at : answer tail
        
        ListNode temp = head;
        
        while(count >= k){
            // these pointers are used to store the current answer
            ListNode ch = null; // ch: current head
            ListNode ct = null; // ct : current tail
            
            
            for(int i = 1 ; i <= k ; i++){
                ListNode n = temp.next; // n : next
                
                //removeFirst
                temp.next = null;
                
                //addFirst
                if(ch == null){
                    ch = ct = temp;
                }
                else{
                    temp.next = ch;
                    ch = temp;
                }
                temp = n;
                count--;
        }
            
        // introduce this current group in your overall answer
        if(ah == null){
            ah = ch;
            at = ct;
        }
        else{
            at.next = ch;
            at = ct;
        }
    }
        if(count > 0){
            at.next = temp;
        }
        return ah;
}

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}