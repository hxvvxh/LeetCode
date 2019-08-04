package Node;

import java.util.ArrayList;
import java.util.List;
/**
 * 翻转链表
 * @author Administrator
 *
 */
public class reverseList {
	/**
	 * 递归
	 * @param node
	 * @return
	 */
	 public ListNode reverseList(ListNode node) {
	        if (node == null || node.next == null) 
	        { 
	            return node;
	        } 
	        else 
	        {
	            ListNode headNode = reverseList(node.next); 
	            node.next.next = node;
	            node.next = null;
	            return headNode; 
	        }
	    }
	 /**
	  * leecode最快的方法
	  * @param head
	  * @return
	  */
	 public ListNode reverseList2(ListNode head) {
	        if (head == null || head.next == null){
	            return head;
	        }
	        ListNode pre = null;
	        ListNode cur = head;
	        while (cur != null){
	            ListNode next = cur.next;
	            cur.next = pre;
	            pre = cur;
	            cur = next;
	        }
	        return pre;
	    }
}
