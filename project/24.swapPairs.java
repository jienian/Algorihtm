//两交换链表中的节点
class Solution{
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        // 创建链表节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        // 构建链表
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 创建 Solution 对象
        Solution solution = new Solution();

        // 调用 swapPairs 方法
        ListNode result = solution.swapPairs(node1);

        // 打印交换后的链表
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

}
