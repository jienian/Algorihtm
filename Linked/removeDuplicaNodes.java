class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = null, cur = head;
        HashSet<Integer> set = new HashSet<Integer>();
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

