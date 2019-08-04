package Node;
/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5
 * @author Administrator
 *
 */
public class removeNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pa=head;
		ListNode pb=head;
		
		for(int i=0;i<n&&pa!=null;i++) {
			pa=pa.next;
		}
		if(pa == null) {
			head=head.next;
			return head;
		}
		while(pa.next!=null) {
			pa=pa.next;
			pb=pb.next;
		}
		pb.next=pb.next.next;
     return head;		
	}
}
