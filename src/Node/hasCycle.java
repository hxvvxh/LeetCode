package Node;
/**
 * 判断是否有环
 * @author Administrator
 *
 */
public class hasCycle {
	public static void main(String[] args) {

	}
/**
 * 通过两个指针，first+1；send+2；这样的方式，如果存在则f与s会相遇。不存在则不会相遇
 * @param h
 * @return
 */
	public boolean hasCycle1(ListNode h) {
		if(h == null || h.next == null) 
            return false; 
        ListNode slow = h; 
        ListNode fast = h; 
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode p=h;
                ListNode q=slow;//相当于让q指向了m1 
                while(p != q){
                    p = p.next;
                    q = q.next;
                }
                if(p == q)
                    return true;
            }
        } 
        return false;
	}
}
