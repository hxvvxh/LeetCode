package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @author Administrator
 *
 */
public class firstUniqChar {
	public static void main(String[] args) {
		firstUniqChar f = new firstUniqChar();
		String s = "dddccdbba";
		int result = f.firstUniqChar1(s);
		System.out.println(result);
	}
/**
 * 我的
 * @param s
 * @return
 */
	public int firstUniqChar1(String s) {

		if (s.isEmpty() || s.length() == 0) {
			return -1;
		}
		char[] charS = s.toCharArray();
		Map map = new HashMap();
		for (int i = 0; i < charS.length; i++) {
			if (map.containsKey(charS[i])) {
				map.put(charS[i], -1);
			} else {
				map.put(charS[i], i);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.containsValue(i)) {
				return i;
			}
		}
		return -1;

	}
/**
 * leecode上最快的
 * @param s
 * @return
 */
	public int firstUniqChar2(String s) {
		int res = -1;

		for (char ch = 'a'; ch <= 'z'; ch++) {
			int index = s.indexOf(ch);
			if (index != -1 && index == s.lastIndexOf(ch)) {
				res = res == -1 ? index : Math.min(res, index);
			}
		}

		return res;
	}
}
