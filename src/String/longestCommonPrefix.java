package String;

import java.util.HashMap;
import java.util.Map;
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。
 * @author Administrator
 *
 */
public class longestCommonPrefix {
	public static void main(String[] args) {
		longestCommonPrefix l = new longestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		String result = l.longestCommonPrefix(strs);
		System.out.println(result);
	}
/**
 * 我的方法。99.06%
 * @param strs
 * @return
 */
	public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) {
        	return "";
        }
		int index = 0;
		for (int i = 0; i < strs.length; i++) {
			if (strs[index].length() >= strs[i].length()) {
				index = i;
			}
		}
		if(strs[index].isEmpty()&&strs[index].length()==0) {
			return "";
		}
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < strs[index].length(); i++) {
			Boolean f = true;
			for (int j = 0; j < strs.length; j++) {
				if (strs[index].charAt(i) != strs[j].charAt(i)) {
					f = false;
				}
			}
			if (f) {
				buff.append(strs[index].charAt(i));
			}else {
				return buff.toString();
			}
		}
		if(buff.toString().isEmpty()&&buff.toString().equals("")) {
			return "";
		}
		return buff.toString();

	}
	/**
	 * leecode最快的方法
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix1(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int min=Integer.MAX_VALUE;
        String minStr="";
        for(int i=0;i<strs.length;i++){
            if(min>strs[i].length()){
                minStr=strs[i];
                min=strs[i].length();
            }
        }
        if(min==0){
            return "";
        }
        for(int i=min;i>0;i--){
            String standard=minStr.substring(0,i);
            int j=0;
            for(j=0;j<strs.length;j++){
                if(!(strs[j].substring(0,i)).equals(standard)){
                    break;
                }
            }
            if(j==strs.length){
                return standard;
            }
        }
        return "";
    }
}
