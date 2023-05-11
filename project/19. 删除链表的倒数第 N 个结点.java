class Solution{
    public ListNode removeNthFromEnd(ListNode head, int n ){
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode fast = dumpy;
        ListNode slow = dumpy;
        while(n > 0){
            fast = fast.next;
            n--;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dumpy.next;
    }
}
class Solution {
    //通过快慢指针来解决，类似于你要删除中间元素的题
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个伪节点，用于返回结果
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        //定义一个快指针,指向伪节点，用于遍历链表
        ListNode prev = dumpy;
        //定一个慢指针，
        ListNode tail = dumpy;
        //让快指针先移动 n 步
        while(n >0){
            prev = prev.next;
            n--;
        }
        //只要快指针不指向空，就继续循环
        while(prev.next !=null){
            //让快慢指针同时移动
            tail = tail.next;
            prev = prev.next;
        }
        //这时慢指针移动到的位置就是，要删除节点的前一个节点
        //所以只要删除当前节点的下一个节点
        tail.next = tail.next.next;
        //返回为指针指向的头节点
        return dumpy.next;
    }
}