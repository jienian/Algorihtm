public ListNode removeNthFormEnd(ListNode head, int n ) {
	int l = length(head, n);
	if ( l == n) return head.next;
	return head;
}

private int length(ListNode node, int n ) {
	if (node == null) return0;
	int len = length(node.next, n) + 1;
	if(len == n + 1) node.next = noed.next.next;
	return len;
}
