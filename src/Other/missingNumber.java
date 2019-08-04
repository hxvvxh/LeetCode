package Other;

import java.util.Arrays;
/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
 * 示例 1:

输入: [3,0,1]
输出: 2



示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8

 * @author Administrator
 *
 */
public class missingNumber {
	public static void main(String[] args) {

	}

	public int test(int[] nums) {
		Arrays.sort(nums);
		if (nums.length == 1) {
			if (nums[0] == 0) {
				return 1;
			} else if (nums[0] == 1) {
				return 0;
			}
		}
		if (nums[0] != 0) {
			return 0;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1] + 1) {
				return nums[i] - 1;
			}
		}

		return nums[nums.length] + 1;
	}
	/**
	 * leecode最快的方法
	 * @param nums
	 * @return
	 */
	public int test2(int[] nums) {
		int ret=nums.length;
        for(int i=0;i<nums.length;i++){
            ret+=(i-nums[i]);
        }
        return ret;
	}
}
