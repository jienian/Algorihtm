//Linked Basic
//1. 定义一个名为 Node 的类
class Node{
     // 定义一个指向下一个节点的变量，并将其初始值设为 null
    Node next = null;
     // 定义节点的数据
    int data;
    // 构造函数，用于创建新节点，并传入节点数据
    public Node(int d){
        data = d;
    }
    // 在链表末尾追加新节点的方法
    void appendToTail(int d){
        //创建一个新的节点
        Node end = new Node(d);
         // 获取当前节点
        Node n = this;
        // 遍历链表，找到链表的末尾节点
        while(n.next != null){
            n = n.next;
        }   
        // 将新节点连接到链表的末尾
        n.next = end;
    }
}
//2.从单链表中删除节点
public static void main(String[] args) {
    // 输入链表
    Node head = new Node(1);
    head.appendToTail(2);
    head.appendToTail(3);
    head.appendToTail(4);
    head.appendToTail(5);
    
    // 删除链表中的节点
    head = deleteNode(head, 3);
    
    // 输出删除节点后的链表
    while (head != null) {
        System.out.print(head.data + " ");
        head = head.next;
    }
    // 输出结果为：1 2 4 5
}

// 链表节点类
static class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}

// 删除链表中指定节点的方法
public static Node deleteNode(Node head, int d) {
    Node n = head;
    // 处理头节点的情况
    if (n.data == d) {
        return head.next;
    }
    // 处理其他节点的情况
    while (n.next != null) {
        if (n.next.data == d) {
            n.next = n.next.next;
            break;
        }
        n = n.next;
    }
    return head;
}

//3.例如，假设你有一个链表 a1 -> a2 -> ... -> an -> b1 -> b2 -> ... -> bn，并且你想把它重新排列成 a1 -> b1 -> a2 -> b2 -> ... -> an -> bn。你不知道链表的长度（但是你知道长度是偶数)
 public static void main(String[] args) {
    // 创建一个链表 a1 -> a2 -> a3 -> b1 -> b2 -> b3
    ListNode a1 = new ListNode(1);
    ListNode a2 = new ListNode(2);
    ListNode a3 = new ListNode(3);
    ListNode b1 = new ListNode(4);
    ListNode b2 = new ListNode(5);
    ListNode b3 = new ListNode(6);
    a1.next = a2;
    a2.next = a3;
    a3.next = b1;
    b1.next = b2;
    b2.next = b3;

    // 输出原始链表
    System.out.print("Original List: ");
    ListNode curr = a1;
    while (curr != null) {
        System.out.print(curr.val + " ");
        curr = curr.next;
    }
    System.out.println();

    // 使用“Runner”技术重新排列链表
    reorderList(a1);

    // 输出重新排列后的链表
    System.out.print("Reordered List: ");
    curr = a1;
    while (curr != null) {
        System.out.print(curr.val + " ");
        curr = curr.next;
    }
    System.out.println();
}
//算法
public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
        return;
    }

    // 使用快慢指针找到链表的中间节点
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // 将链表分成两个部分
    ListNode secondHead = slow.next;
    slow.next = null;

    // 将第二个部分的链表翻转
    ListNode prev = null;
    ListNode curr = secondHead;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    // 将两个链表交错合并
    ListNode p1 = head;
    ListNode p2 = prev;
    while (p2 != null) {
        ListNode next1 = p1.next;
        ListNode next2 = p2.next;
        p1.next = p2;
        p2.next = next1;
        p1 = next1;
        p2 = next2;
    }
}

class Solution {
    public void deleteNode(ListNode node) {
      if (node == null || node.next == null) {
        return;
    }
    node.val = node.next.val;
    node.next = node.next.next;
    }
}