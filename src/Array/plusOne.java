package Array;

import java.util.Arrays;
/**
 * int类型的数组加1操作
 * 
 * @author Administrator
 *
 */
public class plusOne {
public static void main(String[] args) {
	plusOne p=new plusOne();
	int[] nums= {9,9,9,9};
	int[] reslut=p.plusOne1(nums);
	for(int i=0;i<nums.length;i++) {
		System.out.print(reslut[i]);
	}
}

public int[] plusOne1(int[] nums) {
	//获取长度
	int n=nums.length;
	//最后一位不为9，不需要进位直接加1
	//最后一位为9.最后一位置0；向前判断加1的位置
    for(int i=n-1;i>=0;i--) {
    	if(nums[i]<9) {
    		nums[i]++;
    		return nums;
    	}
    	nums[i]=0;
    }
    //执行到这了就意味着没有之前的return  为9999
    //为9999...的请况，第一位置1，其他为0
    int [] numsnew=new int[n+1];
    numsnew[0]=1;
    return numsnew;
}
//网上的答案
public int[] plusOne3(int[] digits) {
    int addOne = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] != 9) {
            if (i == digits.length - 1) {
                digits[i] += 1;
            }
            digits[i] += addOne;
            addOne = 0;
            return digits;
        } else {
            digits[i] = 0;
            addOne = 1;
        }
    }
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
}
}
