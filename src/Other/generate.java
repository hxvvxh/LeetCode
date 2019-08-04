package Other;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author Administrator
 *
 */
public class generate {
public static void main(String[] args) {
	
}
public List<List<Integer>> test(int n){
	List<List<Integer>> resList=new ArrayList<List<Integer>>();
	for(int i=0;i<n;i++) {
		List<Integer> nList=new ArrayList<Integer>();
		for(int j=0;j<=i;j++) {
			if(j==0||j==i) {
				nList.add(1);
			}else {
				List<Integer> list=resList.get(i-1);
				nList.add(list.get(j-1)+list.get(j));
			}
			   			
		}
		resList.add(nList);
	}
	
	return resList;
}
}
