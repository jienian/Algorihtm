//time：O(n)遍历链表，递归n次  spatial: O(n)系统递归需要使用O(n)的栈空间。
class Solution {
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }

    //第二种方法
    //时间复杂度:O(n)入栈和出栈共使用时间.
    //空间复杂度:O(n)stack和数组res共使用的额外空间。
    class Solution {
        public int[] reversePrint(ListNode head) {
            LinkedList<Integer> stack = new LinkedList<Integer>();
            while(head != null) {
                stack.addLast(head.val);
                head = head.next;
            }
            int[] res = new int[stack.size()];
            for(int i = 0; i < res.length; i++)
                res[i] = stack.removeLast();
        return res;
        }
    }

    
}