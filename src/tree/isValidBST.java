package tree;

import java.util.ArrayList;
import java.util.List;
/**
 * 验证二叉树的正确性
 * 左边的小于根节点
 * 右边的大于根节点
 * 节点的左子节点小于节点
 * 节点的右子节点大于节点
 * @author Administrator
 *
 */
public class isValidBST {
public static void main(String[] args) {
	
}
/**
 * 我的方法一！
 * 不可行！ 没有考虑到和根节点的比较
 * @param root
 * @return
 */
public boolean test(TreeNode root) {
	if(root==null) {
		return true;
	}
	boolean i1=true;
	boolean i2=true;
	//左节点不为空
	if(root.left!=null) {
		if(root.left.val<root.val) {
			i1=test(root.left);
		}else {
			return false;
		}
	}
	//右节点不为空
	if(root.right!=null) {
			if(root.right.val>root.val) {
			  i2=test(root.right);
			}else {
				return false;
			}
		}
	
	return i1&i2;
}

/**
 * 我的方法2
 * 将二叉树按照顺序来放到一个集合中，这样遍历比较大小判断就可以了
 *          10
 *      5          15
 *             14       20
 *             
 * 需要的list是：5 10 14 15 20 这样的形式
 * 思路是，先找左节点在找右节点
 * @param root
 * @return
 */
public boolean test2(TreeNode root) {
   if(root==null) {
	   return true;
   }
	
	List<Integer> list=new ArrayList<Integer>();
    NodeList(root,list);
	for(int i=0;i<list.size()-1;i++) {
		if(list.get(i)>=list.get(i+1)) {
			return false;
		}
	}
	
	return true;
}
private void NodeList(TreeNode root, List<Integer> list) {
	// TODO Auto-generated method stub
	if(root==null) {
		return ;
	}
	NodeList(root.left,list);
	list.add(root.val);
	NodeList(root.right,list);
}

/**
 * leecode 最快的方法
 */
double prev = -Double.MAX_VALUE;
public boolean isValidBST(TreeNode root) {
    if(root == null) return true;
    if(!isValidBST(root.left)) return false;
    if(root.val <= prev) return false;
    prev = root.val;
    return isValidBST(root.right);
} 
}








