package Node;

import java.util.Stack;
/**
 * 回文链表
 * @author Administrator
 *
 */
public class isPalindrome {
	public static void main(String[] args) {
		isPalindrome i=new isPalindrome();
		ListNode head=new ListNode();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(2);
		ListNode l4=new ListNode(1);
		head.next=l1;
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=null;
		boolean f=i.isPalindrome1(head);
		System.out.println(f);
	}
/**
 * 我的
 * @param head
 * @return
 */
	public boolean isPalindrome1(ListNode head) {
		ListNode pa = head.next;
		ListNode pb = head.next;
		ListNode index = head;
		ListNode index2 = head;
		int i = 0;
		while (index2.next != null) {
			i++;
			index2=index2.next;
		}
		i = i / 2;
		while (index.next != null) {
			if (i > 0) {
				while (pb.next.next != null) {
					pb.next = pb.next.next;
				}
				if (pa.val != pb.next.val) {
					return false;
				}
				pb.next=null;
                pa=pa.next;
                pb=pa;
				i--;
				index=index.next;
			}
		}
		return true;

	}
	/**
	 * 网上的
	 * @param node
	 * @return
	 */
public boolean leecode(ListNode node) {
	if(node == null || node.next == null) return true;
	ListNode fast = node;
	ListNode slow = node;
    Stack<ListNode> stack = new Stack<>();
    boolean flag = true;
    while(fast.next != null && fast.next.next != null){
        stack.push(slow);
        fast = fast.next.next;
        slow = slow.next;
    }
    slow = slow.next;
    if(stack.peek().val != slow.val){
        slow = slow.next;
    }
    while(!stack.empty() && slow != null){
        if(stack.pop().val != slow.val){
            flag = false;
            break;
        }
        slow = slow.next;
    }
    if(flag && stack.empty() && slow == null){
        return true;
    }else{
        return false;
    }
}
/**
 * 行不通
 * @param node
 * @return
 */
public boolean leecode3(ListNode node) {
	String str="";
	while(node!=null) {
		str=str+node.val;
		node=node.next;
	}
	return str.equals(new StringBuilder(str).reverse().toString());
	
}
/**
 * 找出中间节点。翻转后面的链表，然后对节点前后进行比较
 * @param head
 * @return
 */
public boolean leecode4(ListNode head) {
	if (head == null || head.next == null) {
        return true;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    while (fast != null && fast.next != null ) {
        fast = fast.next.next;
        slow = slow.next;
    }
    ListNode second = slow.next;
    slow.next = null;

    ListNode secondhead = null;
    ListNode p = second;
    while (p != null) {
        ListNode temp = p.next;
        p.next = secondhead;
        secondhead = p;
        p = temp;
    }

    ListNode p1 = head;
    ListNode p2 = secondhead;
    while (p2 != null && p2.val == p1.val) {
        p1 = p1.next;
        p2 = p2.next;
    }
    if (p2 == null) {
        return true;
    } else {
        return false;
    }
}

/**
 * 递归实现
 * 递归实现
递归的终止条件：
当长度为0或者1的时候表明链表处于中间位置

结果就是返回值的result 
 * @param head
 * @param length
 * @return
 */
public Result ispalindromeResourse(ListNode head,int length) {
        if (head == null || length == 0) {
            return new Result(null,true);
        } else if (length == 1 ){
            return new Result(head.next,true);
        } else if (length == 2) {
            return new Result(head.next.next,head.val == head.next.val);
        }
        Result res = ispalindromeResourse(head.next,length-2);
        if (!res.result || res.node==null) {
            return res;
        } else {
            res.result = head.val == res.node.val;
            res.node = res.node.next;
            return res;
        }
    }
public static class Result{
    public ListNode node;
    public boolean result;
    public Result(ListNode node,boolean res) {
        this.node = node;
        this.result=res;
    }
}
/**
 * leecode最快的方法
 * @param head
 * @return
 */
public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
        return true;
    }

    if (head.next.next == null) {
        return head.val == head.next.val;
    }

    ListNode fast = head.next;
    ListNode slow = head;

    while (fast.next != null) {
        if (fast.next.val == slow.val) {
            if (fast.next.next != null) {
                return false;
            }
            fast.next = null;
            slow = slow.next;
            fast = slow.next;
            if (fast == null || fast.val == slow.val) {
                return true;
            }
        } else {
            fast = fast.next;
        }
    }
    return false;
}
}
