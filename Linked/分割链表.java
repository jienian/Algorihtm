// 分割链表。编写程序以 x 为基准分割链表,使得所有小于 x 的节点排在大于或等于 x 的
// 节点之前。如果链表中包含 x,x 只需出现在小于 x 的元素之前(如下所示)。分割元素 x
// 只需处于“右半部分”即可,其不需要被置于左右两部分之间。
// 示例:
// 输入:3 -> 5 -> 8-> 5 -> 10 -> 2 -> 1 [分节点为 5]
// 输出:3 -> 1 -> 2 -> 10 -> 5-> 5 -> 8
 class Solution {
        public ListNode partition(ListNode head, int x) {
            // 定义两个指针，left指针指向当前最后一个小于x的节点的的后一个节点
            ListNode left = head;
            //right指针指向当前遍历的节点
            for (ListNode right = head; right != null; right = right.next) {
                // 如果right指针指向的节点的值小于x，则将它交换到前面
                if (right.val < x) {
                    // 交换left和right指针指向的节点的值
                    swapVal(left, right);
                    // 将left指针向右移一位
                    left = left.next;
                }
            }
            return head;
        }
        public void swapVal(ListNode left, ListNode right) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
    }