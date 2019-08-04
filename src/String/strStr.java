package String;
/**
 * 实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1
 * @author Administrator
 *
 */
public class strStr {
public static void main(String[] args) {
	strStr s=new strStr();
	String haystack="aaa"; 
	String needle="a";
	int result=s.strStr1(haystack, needle);
	System.out.println(result);
}

public int strStr1(String haystack, String needle) {
	if(needle.isEmpty()) {
		return 0;
	}
	int index=-1;
	for(int i=0;i<haystack.length();i++) {
		if((needle.length()+i)<=haystack.length()) {
		String s=haystack.substring(i, needle.length()+i);
		if(s.equals(needle)) {
			index=i;
			break;
		}
		}
	}
    return index;
}
/**
 * leecode最块的方法
 * @param haystack
 * @param needle
 * @return
 */
public int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
}
}
