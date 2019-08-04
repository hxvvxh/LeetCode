package String;

import java.util.HashMap;
import java.util.Map;
/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true

示例 2:

输入: "race a car"
输出: false

 
 * @author Administrator
 *
 */
public class isPalindrome {
	public static void main(String[] args) {
		isPalindrome is=new isPalindrome();
		String s="!043XjqjX043!";
		boolean result=is.isPalindrome2(s);
		System.out.println(result);
	}

//	public boolean isPalindrome1(String s) {
//		if(s.equals("")||s.isEmpty()) {
//			return true;
//		}
//		s = s.replaceAll("[^a-z^A-Z^0-9]", "");//提取英文
//		s=s.toLowerCase();//转换成小写
//		char[] charS = s.toCharArray();
//		int i = 0;
//		int j = charS.length - 1;
//		Map<String, Integer> mapResult = new HashMap<String, Integer>();
//		for (int k = 0; k < charS.length; k++) {
//				if (mapResult.get(String.valueOf(charS[i])) != null) {
//					mapResult.put(String.valueOf(charS[i]), 2);
//				} else {
//					mapResult.put(String.valueOf(charS[i]), 1);
//				}
//				if (mapResult.get(String.valueOf(charS[j])) != null) {
//					mapResult.put(String.valueOf(charS[j]), 2);
//				} else {
//					mapResult.put(String.valueOf(charS[j]), 1);
//				}
//				i++;
//				j--;
//				if(i>=j) {
//					break;
//				}
//		}
//		boolean result= mapResult.containsValue(1);
//		if(result == true) {
//			return false;
//		}
//		return true;
//	}
	public boolean isPalindrome2(String s) {
		if(s.length()==0&&s.isEmpty()) {
			return true;
		}
		s=s.replaceAll("[^a-z^A-Z^0-9]", "");
		s=s.toLowerCase();
		char[] charS=s.toCharArray();
		int i=0;
		int j=charS.length-1;
		for(int k=0;k<charS.length;k++) {
			if(charS[i]!=charS[j]) {
				return false;
			}else {
				if(i>=j) {
					break;
				}
				i++;
				j--;
			}
			
		}
		return true;
	}
	/**
	 * leecode最块的方法
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {

	      s = s.toLowerCase();
	      for(int left = 0, right = s.length() - 1; left < right; ) {
	        while(! ((s.charAt(left) >= 'a' && s.charAt(left) <= 'z') || (s.charAt(left) <= '9' && s.charAt(left) >= '0'))) {
	          left++;
	          if(left >= right) return true;
	        }
	        while(!( (s.charAt(right) >= 'a' && s.charAt(right) <= 'z') || (s.charAt(right) <= '9' && s.charAt(right) >= '0'))) {
	          right--;
	          if(left >= right) return true;
	        }

	        if(Character.compare(s.charAt(left), s.charAt(right)) != 0) {
	          return false;
	        }

	        left++; right--;
	      }
	      return true;
	    }
}
