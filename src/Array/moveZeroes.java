package Array;

public class moveZeroes {
/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
       示例: 
       输入: [0,1,0,3,12]
       输出: [1,3,12,0,0]
      说明:
      必须在原数组上操作，不能拷贝额外的数组。
       尽量减少操作次数。
 * @param nums
 */
	public static void main(String[] args) {
		int [] nums= {0,1,0,3,6,5};
		moveZeroes m=new moveZeroes();
		m.moveZero(nums);
	}
	
	
	public void moveZero(int[] nums) {
		int zeroNum=0;//用来计算0的个数
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){//如果nums[i]=0,zeroNum个数加一
                zeroNum++;
            }else if(zeroNum!=0){//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                nums[i-zeroNum]=nums[i];  
                nums[i]=0;
            }
        }
        
	}
	
	public void test1(int[] nums) {
		int loc = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[loc++] = nums[i];
            }
        }

        for(int j=loc;j<nums.length;j++){
            nums[j] = 0;
        }
	}
	
	
}
