public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if(headA == null || headB == null ){
        return null;
      }
      //nodeA和nodeB被定义为了headA和headB	
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while (nodeA != nodeB) {
            nodeA = nodeA != null ? nodeA.next : headB;  // 如果 nodeA 不为 null，则继续往后走，否则从链表 B 的头结点开始走
            nodeB = nodeB != null ? nodeB.next : headA;  // 如果 nodeB 不为 null，则继续往后走，否则从链表 A 的头结点开始走
        }
        
        return nodeA;  // 返回相交节点（如果链表不相交，则返回 null）
    }
}

