import java.util.List;

class Solution {
    public List addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        int carry = 0;
        ListNode cur = prev;
        while(l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sum  = sum % 10;
            cur.next  = new ListNode(sum);
            cur  = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return prev.next;

    }
}