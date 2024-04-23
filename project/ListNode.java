public ListNode reverseList(ListNode head) {
	if (head == null || head.next) {
		return head;
	}
	ListNode next = head.next;
	ListNode newHead = reverseList(next);
	next.next = head;
	head.next = null;
	return newHead;
}

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	if(l1 == null ) return l2;
	if(l2 == null)  return l1;
	if(l1.val < l2.val) {
	l1.next = mergeTwoLists(l1.next, l2);
	return l1;
	} else {
	l2.next = mergeTwoLists(l1, l2.next);
	return l2;
	}
}
public ListNode  deleteDuplicates(ListNode head) {
	if (head == null || head.next == null) return head;
	head.next = deleteDuplicates(head.next);
	return head.val == head.next.val ? head.next: head;
}


