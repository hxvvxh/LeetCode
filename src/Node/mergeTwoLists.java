package Node;

/**
 * 合并两个有序链表
 * 
 * @author Administrator
 *将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class mergeTwoLists {
	public static void main(String[] args) {

	}
/**
 * 希望记住的解法：递归。

因为是两个排序好的链表，所以，每次ListNode temp都是两者中较小的那个节点。

那么可以理解为已经排好一个了，可以作为返回值。那么只需要 排序 包涵这个节点的剩余节点的链表以及另外一条链表即可。

接着就实现了递归
 * @param l1
 * @param l2
 * @return
 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode temp;
		if (l1.val < l2.val) {
			temp = l1;
			temp.next = mergeTwoLists(l1.next, l2);
		} else {
			temp = l2;
			temp.next = mergeTwoLists(l1, l2.next);
		}
		return temp;
	}
}
