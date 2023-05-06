public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 不可能存在环路的情况直接返回
        if(head==null || head.next==null)  return null;
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            // 快指针步数是慢指针两倍
            fast = fast.next.next;
            slow = slow.next;
            // 快慢指针在环内相遇
            if(fast == slow){
                // 快指针移向表头
                fast = head;
                while(fast != slow){
                    // 快慢指针同步移动，再次相遇即为环开头
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
        
    }
}   