package Node;

/**
 * 删除指定的链表
 * @author Administrator
 *
 */
public class deleteNode {
    void deleteNode(ListNode node) {
     node.val=node.next.val;
     node.next=node.next.next;
     
    }
     
}
