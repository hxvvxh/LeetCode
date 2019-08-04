package Array;

import java.util.Arrays;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1

示例 2:

输入: [4,1,2,1,2]
输出: 4


 * @author Administrator
 *
 */
public class singleNumber {
	public static void main(String[] args) {
		singleNumber s = new singleNumber();
		int[] nums = {1,1,2};
		int result=s.singleNumber1(nums);
		System.out.println(result);
	}

	public int singleNumber1(int[] nums) {
	if(nums.length==1) {
		return nums[0];
	}
		Arrays.sort(nums);
		int index=nums.length+1;
		
		for(int i=0;i<nums.length;i=i+2) {
			if(i==nums.length-1) {
				return nums[i];
			}
			if(nums[i] != nums[i+1]) {
				index=i;
				return nums[index];
			}
		}
		if(index==nums.length+1) {
			index=nums.length;
		}
		
		
		return nums[index];
	}
	/**
	 * 网上解答：
	 * 关系运算符 ^ 异或    比较时采用的是二进制的方法来进行比较
	 * 由于题目中必然会有两个一样的数字和只有一个的数字。使用异或可以使得的两个相同的数字抵消
	 * 从而保留只有一个的数字
	 * @param nums
	 * @return
	 */
	public int singleNumber2(int[] nums) {
		int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
	}
}
