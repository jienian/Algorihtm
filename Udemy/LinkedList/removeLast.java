import org.w3c.dom.Node;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

	// WRITE REMOVELAST METHOD HERE //
	//                              //
	//                              //
	//                              //
	//                              //
	//////////////////////////////////

  public Node removeLast() {
    if (length == 0) { // 如果链表为空，则返回null
        return null;
    }
    
    Node temp = head; // temp用于遍历链表
    Node pre = null;  // pre将保持在temp的前一个节点
    
    while (temp.next != null) { // 遍历直到最后一个节点
        pre = temp;      // 更新pre为当前节点
        temp = temp.next; // 移动到下一个节点
    }


    if (pre == null) { // 如果链表只有一个节点
        head = null;   // 将头节点设置为null
        tail = null;   // 将尾节点设置为null
    } else { 
        pre.next = null; // 将倒数第二个节点的next设置为null
        tail = pre;      // 更新尾节点为倒数第二个节点
    }
    
    length--; // 减少链表长度
    
    if (length == 0) { // 如果删除节点后链表为空
        head = null;  // 将头节点设置为null
        tail = null;  // 将尾节点设置为null
    }
    
    return temp; // 返回被删除的节点
    }
}
//优化后 简化了对只有一个节点的链表处理逻辑，将其合并到初始条件判断.

public Node removeLast() {
    if (length == 0) { // 链表为空，直接返回null
        return null;
    }
    
    // 如果链表只剩一个节点，特殊处理
    if (length == 1) {
        Node removedNode = head;
        head = tail = null;
        length = 0;
        return removedNode;
    }
    
    Node pre = head;
    // 遍历到倒数第二个节点
    for (int i = 0; i < length - 2; i++) {
        pre = pre.next;
    }
    
    Node removedNode = tail; // 记录将要删除的尾节点
    tail = pre;             // 更新尾节点为倒数第二个节点
    tail.next = null;       // 断开原尾节点的链接
    
    length--; // 减少链表长度
    
    return removedNode; // 返回被删除的尾节点
}

