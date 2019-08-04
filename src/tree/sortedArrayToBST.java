package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *    0
     / \
   -3   9
   /   /
 -10  5
 * @author Administrator
 *
 */
public class sortedArrayToBST {
	public static void main(String[] args) {

	}

	public TreeNode test(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return getTree(nums, 0, nums.length - 1);
	}

	public TreeNode getTree(int[] nums, int l, int r) {
		if (l <= r) {
			int mid = (l + r) / 2;
			TreeNode node = new TreeNode(nums[mid]);
			node.left = getTree(nums, l, mid - 1);
			node.right = getTree(nums, mid + 1, r);
			return node;
		} else {
			return null;
		}
	}
}
