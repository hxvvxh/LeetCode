package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集
 * 
 * @author Administrator
 *
 */
public class intersect {
	public static void main(String[] args) {
		intersect in = new intersect();
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] result = in.intersect1(nums1, nums2);
		for (int i : result) {
			System.out.println(i);
		}
	}

	public int[] intersect1(int[] nums1, int[] nums2) {
		int result = 0;
		int[] k = new int[10];
		for (int i : nums1) {
			for (int j : nums2) {
				result = result ^ i ^ j;
				if (result == 0) {
					k[i] = nums1[i];
				}
			}
		}

		return k;
	}

	/**
	 * 用Map来建立nums1中字符和其出现个数之间的映射, 然后遍历nums2数组，如果当前字符在Map中的个数大于0，
	 * 则将此字符加入结果res中，然后Map的对应值自减1。
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect2(int[] nums1, int[] nums2) {
		List<Integer> tmp = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			Integer value = map.get(nums1[i]);
			map.put(nums1[i], (value == null ? 0 : value) + 1);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
				tmp.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		int[] result = new int[tmp.size()];
		int i = 0;
		for (Integer e : tmp)
			result[i++] = e;
		return result;

	}
/**
 * 给两个数组排序，然后用两个索引分别代表两个数组的起始位置，
 * 如果两个索引所代表的数字相等，则将数字存入结果中，两个索引均自增1，
 * 如果第一个索引所代表的数字大，则第二个索引自增1，反之亦然
 * @param nums1
 * @param nums2
 * @return
 */
	public int[] intersect3(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> tmp = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums2[j] > nums1[i]) {
				i++;
			} else if (nums2[j] < nums1[i]) {
				j++;
			} else {
				tmp.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] result = new int[tmp.size()];
		for (int k = 0; k < result.length; k++) {
			result[k] = tmp.get(k);
		}
		return result;
	}
}
