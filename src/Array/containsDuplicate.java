package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class containsDuplicate {
public static void main(String[] args) {
	int[] nums= {1,2,3,4};
	containsDuplicate c=new containsDuplicate();
	boolean index=c.containsDuplicate2(nums);
	System.out.println(index);
}
public boolean containsDuplicate1(int nums[]) {
	boolean ii=false;
	for(int i=0;i<nums.length-1;i++) {
		for(int j=i+1;j<nums.length;j++) {
			if(nums[i]==nums[j]) {
				ii=true;
				break;
			}
		}
	}
	return ii;
}
public boolean containsDuplicate2(int nums[]) {
	boolean ii=false;
	/**
	 * Arrays 的排序方法！！先进行排序
	 * 在进行i和i+1的比较
	 */
   Arrays.sort(nums);	
	for(int i=0;i<nums.length-1;i++) {
		if(nums[i]==nums[i+1]) {
			ii=true;
			break;
		}
	}
	return ii;
}
/**
 * 将数组中的数据当做map的key。每次进行是否存在数组值的key，进行判断、存在则是有相同的元素，不存在怎进行下次判断
 * 一直到数组最后没有的话就是不存在相同的元素。
 * @param nums
 * @return
 */
public boolean containsDuplicate3(int nums[]) {
	boolean ii=false;Boolean flag = false;
    Map<Integer,Integer> ht = new HashMap<Integer,Integer>();
    for (int i = 0; i < nums.length ; i++) {
        int num = nums[i];
        Integer is = ht.get(num);
        if(null != is){
            flag = true;
            break;
        }else {
            ht.put(num,num);
        }
    }
    return flag;
}
}
