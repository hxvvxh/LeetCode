package String;

import java.util.HashMap;
import java.util.Map;
/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词
 * 示例 1:

输入: s = "anagram", t = "nagaram"
输出: true

示例 2:

输入: s = "rat", t = "car"
输出: false
 * @author Administrator
 *
 */
public class isAnagram {
public static void main(String[] args) {
	String s="a";
	String t="b";
	isAnagram i=new isAnagram();
	System.out.println(i.isAnagram1(s, t));
}
/**
 * 我的方法
 * @param s
 * @param t
 * @return
 */
public boolean isAnagram1(String s,String t) {
	
	char[] charS=s.toCharArray();
	char[] charT=t.toCharArray();
	HashMap<String, Integer> mapS=new HashMap<String,Integer>();
	HashMap<String, Integer> mapT=new HashMap<String,Integer>();
	for(int i=0;i<s.length();i++) {
		String is=String.valueOf(charS[i]);
		if(mapS.containsKey(is)) {
			mapS.put(is, mapS.get(is)+1);
		}else {
			mapS.put(is, 1);
		}
	}
	for(int i=0;i<t.length();i++) {
		String it=String.valueOf(charT[i]);
		if(mapT.containsKey(it)) {
			mapT.put(it, mapT.get(it)+1);
		}else {
			mapT.put(it, 1);
		}
	}
	
	if(mapT.equals(mapS)) {
		return true;
	}
	return false;
}
/**
 * leecode最块的方法
 * @param s
 * @param t
 * @return
 */
public boolean isAnagram2(String s, String t) {
    if(s.length() != t.length()) {
       return false;
   }
   int[] tem = new int[26];
   char[] sc = s.toCharArray();
   for (int i = 0; i < sc.length; i++) {
       tem[sc[i]-'a']++;
   }
   char[] tc = t.toCharArray();
   for(int i = 0; i < tc.length;i++) {
       tem[tc[i]-'a']--;
   }
   int index = 0;
   for(int i = 0;i < tem.length;i++) {
       index = i;
       if(tem[i] != 0) {
           break;
       }
   }
   if(index == 25) {
       return true;
   }else {
       return false;
   }

}
}
