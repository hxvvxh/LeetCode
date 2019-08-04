package Array;
/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val
的元素，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 > 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
示例 1:
给定 nums = [3,2,2,3], val = 3,
函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
你不需要考虑数组中超出新长度后面的元素。
示例 2:
给定 nums = [0,1,2,2,3,0,4,2], val = 2,
函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
注意这五个元素可为任意顺序。
你不需要考虑数组中超出新长度后面的元素
 * @author Administrator
 *
 */
public class removeElement {
	public static void main(String[] args) {
		int[] nums= {3,2,2,3};
       removeElement re=new removeElement();
       re.removeElement1(nums, 3);
	}
	/**
	 * 
              遍历一遍数组，当找到相等的元素时，从这个元素的位置向后出发，
               查询与之不同的元素，接着将两元素指对换，如果未查询到与之不同的元素，那么意味着算法的结束，返回当前元素位置
	 * @param nums
	 * @param var
	 */
	public void removeElement1(int[] nums,int var) {
		int varNumber=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==var) {
				varNumber++;
				continue;
			}else {
				System.out.print(nums[i]);
			}
		 	
		}
		System.out.println("新的长度为："+(nums.length-varNumber));
	}
	public int removeElement2(int[] nums,int val) {
		if (nums.length == 0) return 0;
		int i = 0, j = 0; 
		for (i = 0; i < nums.length; i++) { 
			if (nums[i] == val) {
				for (j = i + 1; j < nums.length; j++) {
					if (nums[i] != nums[j]) {
						nums[i] = nums[j];
						nums[j] = val; 
						break; 
						} 
					} 
				if (j == nums.length) { 
					return i; 
					}
				}
			} return nums.length;
	}
}
