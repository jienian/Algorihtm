class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    /**
     * 删除链表中重复的节点
     * @param head 链表的头节点
     * @return 删除重复节点后的链表头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        // 创建示例链表 1->1->2->3->3
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 调用 deleteDuplicates 方法删除重复节点
        Main solution = new Main();
        ListNode result = solution.deleteDuplicates(head);

        // 打印删除重复节点后的链表
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
