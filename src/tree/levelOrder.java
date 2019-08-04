package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/**
 *给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
结果：   
[
  [3],
  [9,20],
  [15,7]
]
 * @author Administrator
 *
 */
public class levelOrder {
	static List<List<Integer>> list = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		levelOrder l=new levelOrder();
		l.Test(null);
	}

	public List<List<Integer>> test(TreeNode root) {
		if (root == null) {
			return list;
		}
		if(root!=null) {
			List<Integer> listi = new LinkedList<Integer>();
			listi.add(root.val);
			list.add(0, listi);
		}

		if (root.left != null || root.right != null) {
			test2(1, root.left, root.right);
		}
		return list;
	}

	public void test2(Integer i, TreeNode left, TreeNode right) {
		if (left != null) {
			if (list.size() > i) {
				List<Integer> listi = list.get(i);
				listi.add(left.val);
				list.set(i, listi);
			} else {
				List<Integer> listi = new ArrayList<Integer>();
				listi.add(left.val);
				// 会有数组越界的问题！！！！！
				list.add(new ArrayList<Integer>());
				list.add(i, listi);
			}
			test2(i + 1, left.left, left.right);
		}
		if (right != null) {
			if (list.size() > i) {
				List<Integer> listi = list.get(i);
				listi.add(right.val);
				list.set(i, listi);
			} else {
				List<Integer> listi = new ArrayList<Integer>();
				listi.add(right.val);
				list.add(new ArrayList<Integer>());
				list.add(i, listi);
			}
			test2(i + 1, right.left, right.right);
		}

	}

	/**
	 * 成功的方法
	 * @param root
	 * @return
	 */
	public List<List<Integer>> Test(TreeNode root) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		if (root == null) {
			return new ArrayList<>();
		}
		// 当前层结点数
		int width = 1;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		List<Integer> t = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode tem = queue.poll();
			t.add(tem.val);
			width--;
			if (tem.left != null) {
				queue.offer(tem.left);
			}
			if (tem.right != null) {
				queue.offer(tem.right);
			}
			if (width == 0) {
				re.add(t);
				// 开始想的是用clear清空t，但是后来发现清空后就只有最后一层的那些数
				t = new ArrayList<Integer>();
				// 一开始的时候是想着用一个变量保存下一层的宽度，然后每层遍历完了，就把下层宽度赋值给width，后来发现这个值就是queue的当前长度
				width = queue.size();
			}
		}
		return re;
	}
	
	/**
	 * leecode中最快的方法
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		addList(list, 0, root);
		return list;
	}

	public void addList(List<List<Integer>> list, int level, TreeNode node) {
		if (node == null)
			return;
		if (list.size() - 1 < level)
			list.add(new ArrayList<Integer>());
		list.get(level).add(node.val);
		addList(list, level + 1, node.left);
		addList(list, level + 1, node.right);
	}

}
