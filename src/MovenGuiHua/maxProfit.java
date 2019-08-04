package MovenGuiHua;
/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。


只允许完成一笔交易
 * @author Administrator
 *
 */
public class maxProfit {
	
	/**
	 * 从前到后，记录最小的数值，和n与min的差值与max进行比较
	 * 循环，更新，得到最大差值
	 * @param nums
	 * @return
	 */
	public int maxProfit(int[] nums) {
		if(nums.length==0) {
	    	return 0;
	    }
		
		int min=nums[0];
	    int max=0;
	    for(int i=0;i<nums.length;i++) {
	    	if(nums[i] < min) {
	    		min=nums[i];
	    	}else {
	    		if(nums[i]-min>max) {
	    			max=nums[i]-min;
	    		}
	    	}
	    }
		
		return max;
	}
}

