package tree;

import java.util.LinkedList;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *  1
   / \
  2   2
 / \ / \
3  4 4  3

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3
 * @author Administrator
 *
 */
public class isSymmetric {
	public static void main(String[] args) {
		
	}
	/**
	 * 思路：递归
	 * 先判断根节点是否为空。为空则返回false；（特殊的处理）
	 * 下面则是真正递归的内容：
	 * 建立方法，这个方法返回的是对于单个对称节点的比较true和false
	 * 传入两个节点做比较（两个参数-对于树来说是对称的节点）
	 * 1:两个节点都为空则true，
	 * 一个节点空，一个节点不为空则false；
	 * 然后迭代，这两个节点的-（l的right，r的left）（l的left，r的right） 取boolean类型的交集
	 * 由于传入的节点是对称的，那么上一行的传入的子节点必定是对称的
	 * @param args
	 */
	public boolean test(TreeNode root) {
		if(root == null) {
			return true;
		}
		return test2(root.left,root.right);
	}
	public boolean test2(TreeNode l,TreeNode r) {
		if(l==null &&r == null) {
			return true;
		}
		if(l==null ||r == null) {
			return false;
		}
		if(l.val!=r.val) {
			return false;
		}
		return test2(l.left,r.right)&&test2(l.right,r.left);
	}
	/**
	 * 
	 * @param root
	 * @return
	 * 迭代的思想
	 * 自己看
	 * 使用队列先进先出的思想
	 */
	public boolean test3(TreeNode root) {
		if(root==null) return true;
        LinkedList<TreeNode> queue1=new LinkedList<>();
        LinkedList<TreeNode> queue2=new LinkedList<>();
        queue1.add(root.left);
        queue2.add(root.right);
        while(!queue1.isEmpty()&&!queue2.isEmpty()){
            TreeNode v1=queue1.poll();
            TreeNode v2=queue2.poll();
            if(v1==null&&v2==null) continue;
            if(v1==null||v2==null){
                return false;
            }else if(v1.val!=v2.val){
                return false;
            }else{
                queue1.add(v1.left);queue2.add(v2.right);
                queue1.add(v1.right);queue2.add(v2.left);
            }
            
        }
        return true;
	}
}
