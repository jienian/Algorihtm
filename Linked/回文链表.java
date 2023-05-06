class Solution{
    public boolean isPalindrome(ListNode head){
        List<Integer> vals = new ArrayList<Integer>();
        //将链表的值复制到数组中
        ListNode currentNode = head; //创建一个指针向链表的头节点
        while(currentNode != null){
            currentNode = currentnode.next; //指针后移
        }
        int front = 0;
        int back = vals.size() - 1;
        while(front < back ){
            if(!vals.get(front).equals.(vals.get(back))){
                return false;
            }
            front++; //前指针右移
            back--;//后指针左移
        }
        return true; //是回文链表
    } 
    


    publi static main(String[] args){
        //创建链表： 1 -> 2 -> 3 -> 2 -> 1
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        Solution Solution = new Soluiton();
        boolean isPalindrome = Soluiton.isPalindrome(node1);
        System.out.println("这是回文链表？" + isPalindrome);
    }
}