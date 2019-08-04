package math;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。
 * 
 * @author Administrator
 *
 */
public class Solution {
	private int[] a;
	private int[] b;

	public Solution(int[] nums) {
		a = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return a;

	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		Random r = new Random();

		for (int i = 0; i < b.length; i++) {
			int random = r.nextInt(i);
			int tem = b[random];
			b[random] = b[i];
			b[i] = tem;
		}

		return b;

	}
}

/**
 * leecode 上的做法
 * @author Administrator
 *
 */
class Leecode {
	private int[] originalNums;
	private int[] currentNums;

	public Leecode(int[] nums) {
		originalNums = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return originalNums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		currentNums = Arrays.copyOf(originalNums, originalNums.length);
		Random randNum = new Random();
		for (int i = currentNums.length - 1; i >= 0; i--) {
			int selectedElem = randNum.nextInt(i + 1);

			int temp = currentNums[selectedElem];
			currentNums[selectedElem] = currentNums[i];
			currentNums[i] = temp;
		}
		return currentNums;
	}
}
