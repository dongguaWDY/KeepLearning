/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(null == head)
            return head;
        return sortByMerge(head);
    }
    
    
    private ListNode sortByMerge(ListNode head){
        if(head.next == null)
            return head;
        int len = length(head);
        int half = len >>> 1;
        ListNode temp = head;
        while(--half > 0){
            temp = temp.next;
        }
        ListNode head1 = head;
        ListNode head2 = temp.next;
        temp.next = null;
        
        return merge2SortedLists(sortByMerge(head1), sortByMerge(head2));
        
    }
    
    
    private  ListNode merge2SortedLists(ListNode head1, ListNode head2){
        ListNode retHead = head1;
        ListNode pre1 = head1;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while(true){
            while(cur1 != null && cur1.val <= cur2.val){
                pre1 = cur1;
                cur1 = cur1.next;
            }
            if(cur1 == null){
                pre1.next = cur2;
                return retHead;
            }else{
                ListNode temp = cur2;
                ListNode pre2 = cur2;
                while(cur2 != null && cur2.val <= cur1.val){
                    pre2 = cur2;
                    cur2 = cur2.next;
                }
                
                if(pre1 == cur1){
                    retHead = temp;
                    pre2.next = pre1;
                }else{
                    pre2.next = cur1;
                    pre1.next = temp;
                }    
                
                if(cur2 == null)
                    return retHead;
            }
        }
        
    }
    
    
    private int length(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}