package Moden;

import java.util.Arrays;
import java.util.Random;
/**
 * 打乱一个没有重复元素的数组
 * // 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
 * @author Administrator
 *
 */
public class Solution {
	private static int[] numsCon1;
	private static int[] numsCon2;

	// 初始化数组
	public Solution(int[] nums) {
		numsCon1 = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return numsCon1;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		numsCon2 = Arrays.copyOf(numsCon1, numsCon1.length);
		Random random = new Random();
		/**
		 * 洗牌算法
		 * 随机去取在i之前的位置k，将此k对应的值和i对应的值交换
		 * 是一种等概率的计算方法！！
		 */
		for (int i = 0; i < numsCon2.length; i++) {
			int ran = random.nextInt(i);
			int tem = numsCon2[ran];
			numsCon2[ran] = numsCon2[i];
			numsCon2[i] = tem;
		}
		return numsCon2;
	}
}
