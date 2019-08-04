package Array;
/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * @author Administrator
 *
 */
public class rotate {
	public static void main(String[] args) {
		rotate r = new rotate();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int[] j = r.rotate1(nums, k);
//		System.out.println(j.toString());
		 for(int i=0;i<j.length;i++) {
		 System.out.print(j[i]+"-");
		 }
	}

	public int[] rotate1(int[] nums, int k) {
		int[] c = new int[nums.length];
		int length = nums.length - k;
		for (int i = 0; i < nums.length; i++) {
			if (i < length) {
				c[i + k] = nums[i];
			}
			if (length < i || length == i) {
				c[i - length] = nums[i];
			}
		}
		for (int i = 0; i < c.length; i++) {
			nums[i] = c[i];
		}
		return nums;

	}
    /**
     * 网上的答案：
     * 使用取余的方式来确定下标
     * @param nums
     * @param k
     */
	public void rotate2(int[] nums, int k) {
		int length = nums.length;
		int newk = k % length;
		int[] newArray = new int[length];
		for (int i = 0; i < length; i++) {
			int newPosition = (i + newk) % length;
			newArray[newPosition] = nums[i];
		}
		for (int i = 0; i < length; i++) {
			nums[i] = newArray[i];
		}
	}
}
