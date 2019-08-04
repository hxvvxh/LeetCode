package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 *给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]


 */
public class twoSum {
	public static void main(String[] args) {
		twoSum t = new twoSum();
		int[] nums = { 1, 2, 3, 4 };
		int target = 4;
		t.twoSum1(nums, target);
	}

	/**
	 * 使用list集合的下标作为最后的输出。 使用指定数与数组数向减放入list的方法，来进行判断list是否存在值。存在即为这两个数。不存在则记录在list中
	 * 在返回对应的下标，因为数组和list的下标是一致的
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum1(int[] nums, int target) {
		List list = new ArrayList();
		int[] sum = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(target - nums[i])) {
				sum[0] = list.indexOf(target - nums[i]);
				sum[1] = i;
				break;
			} else {
				list.add(nums[i]);
			}
		}
		return sum;
	}

	/**
	 * 思路大致与上相同，但是速度要块的多
	 * 
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int com = target - nums[i];
			if (map.containsKey(com) && map.get(com) != i) {
				return new int[] { i, map.get(com) };
			}
		}
		return null;
	}
}
