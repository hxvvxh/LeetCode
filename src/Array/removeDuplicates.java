package Array;
//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
public class removeDuplicates {
	public static void main(String[] args) {
		removeDuplicates rm = new removeDuplicates();
		int[] nums = {0,0,1,2,3,4,4,4,};
		int index = rm.removeDuplicates1(nums);
//		int index2 = rm.removeDuplicates2(nums);
		System.out.println(index);
	}

	public int removeDuplicates1(int[] nums) {
		if(nums.length==0 || nums==null) {
			return 0;
		}
		int index=1;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]!=nums[i+1]) {
				nums[index]=nums[i+1];
				index++;
			}
		}
		
		return index;
	}
	public int  removeDuplicates2(int[] A) {
		if(A == null || A.length==0)  
	        return 0;  
	    int index = 1;  
	    for(int i=1;i<A.length;i++)  
	    {  
	        if(A[i]!=A[i-1])  
	        {  
	            A[index]=A[i];  
	            index++;  
	        }  
	    }  
	    return index;
	}
}
