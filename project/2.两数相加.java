class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        int carry = 0;
        ListNode cur = prev;
        while(l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sum   = sum % 10;
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
public class Test{
public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    ListNode result = solution.addTwoNumbers(l1, l2);
    while(result != null) {
        System.out.print(result.val + " "); // 输出 7 0 8
        result = result.next;
    }
}
}
