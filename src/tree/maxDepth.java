package tree;
/**
 * 二叉树的最大深度
 * @author Administrator
 *
 */
public class maxDepth {
public static void main(String[] args) {
	
}
/**
 * 使用递归方法进行深度的统计！！！
 * @param root
 * @return
 */
public int test(TreeNode root) {
	int index=0;
	if(root!=null) {
		index=1+Math.max(test(root.left), test(root.right));
	}
	return index; 
}
}
