package Array;
/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author Administrator
 *
 */

public class maxProfit {
	public static void main(String[] args) {
		maxProfit mp = new maxProfit();
		int[] nums = { 7, 1, 5, 3, 6,4 };
//		int index = mp.maxProfit1(nums);
		int index2 = mp.maxProfit2(nums);
		System.out.println(index2);
	}

	public int maxProfit1(int[] nums) {
		int sum = 0;
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		int first = 0;
		first = (nums[0] < nums[1] ? (nums[0] < nums[2] ? 0 : 2) : (nums[1] < nums[2] ? 1 : 2));
		System.out.println("first=" + first);
		for (int i = first; i < nums.length - 2; i++) {
			if (nums[i + 1] > nums[i + 2]) {
				sum += nums[i + 1] - nums[i];
			}
		}

		return 1;
	}
	/**
	 * 贪心算法。
	 * 贪心算法（又称贪婪算法）是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的是在某种意义上的局部最优解。

贪心算法不是对所有问题都能得到整体最优解，关键是贪心策略的选择，选择的贪心策略必须具备无后效性，即某个状态以前的过程不会影响以后的状态，只与当前状态有关。

刚好在做递归的题,写一点点感想:计算机里的很多问题都很庞大,但他们又存在一些相关的地方,比如二叉树之类的,这个时候有可能只需要考虑一步问题或者一小块问题,然后让它自己照着思路去循环就可以了,我们考虑只需要考虑一下结果判定 还有一些特殊情况即可.

	 * @param nums
	 * @return
	 */
	public int maxProfit2(int[] nums) {
		int a=0;
		int b=0;
		for(int i=1;i<nums.length;i++) {
			a=nums[i]-nums[i-1];
			if(a>0) {
				b+=a;
			}
		}
		return b;
	}
}
