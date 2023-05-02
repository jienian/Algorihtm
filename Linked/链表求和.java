//1.前置知识1，链表的遍历
ListNode node = head;
while (node != null){
    //操作node节点
    node = node.next;
}

//2.前置知识2，复制链表为新链表；
ListNode node = head;
 //新链表的头节点  复制后的节点是 newDumy.next
ListNode newDumy = new ListNode(-1);
ListNode next = newDumy;
while (node!=null){
    //操作node节点
    ListNode newNode = new ListNode(node.val);
    next.next = newNode;
    //指向下一个节点
    next = next.next;
    node = node.next;
    }
return newDumy.next;

//3.求两个链表中相同节点值的和，如果链表已经为空，该节点的值为0。
  //取链表中对应位数的值，链表为空则值为0
int s1 = l1 != null ? l1.val : 0;
int s2 = l2 != null ? l2.val : 0;
//求和 需要加上上一次计算的进位
int all = s1 + s2 + fort;
//是否需要进位
fort = all / 10;
//创建当前链表节点
ListNode node = new ListNode(all % 10);
//上个节点之前当前节点
 pre.next = node;
//pre节点指向下一个节点
pre = pre.next;

//4.两链表同时进入下一节点的计算
l1 = l1 != null ? l1.next : null;
l2 = l2 != null ? l2.next : null;
//5.遍历结束，需要处理进位
if(fort > 0){
    ListNode node = new ListNode(1);
    pre.next = node;    
}
class Solution{
public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    Solution solution = new Solution();
    ListNode result = solution.addTwoNumbers(l1, l2);

    while(result != null){
        System.out.print(result.val + " ");
        result = result.next;
    }
}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int fort = 0;
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while(l1 != null || l2 != null){
            int s1 = l1 != null ? l1.val : 0;
            int s2 = l2 != null ? l2.val : 0;
            int all = s1 + s2 + fort; 
            fort = all / 10;
            ListNode node = new ListNode(all % 10);
            pre.next = node;
            pre = pre.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(fort > 0){
            ListNode node = new ListNode(1);
            pre.next = node;
        }
        return head.next;
    }
}
    
