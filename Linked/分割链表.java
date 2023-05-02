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