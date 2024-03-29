package MovenGuiHua;

public class maxSubarray {

	/**
	 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	 * @param nums
	 * @return
	 */
	public int test(int [] nums) {
		   int len = nums.length; 
	        if (len == 0) { 
	            return 0; 
	        } 
	        int[] dp = new int[len];
	        dp[0] = nums[0];
	        for (int i = 1; i < len; i++) {
	            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
	        } // 最后这一步，是求一个全局的最优值 
	        int res = dp[0];
	        for (int i = 1; i < len; i++)
	        { 
	            res = Math.max(res,dp[i]); 
	        } return res;
	}
}
