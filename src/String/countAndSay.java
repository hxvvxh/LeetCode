package String;
/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221

1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
注意：整数顺序将表示为一个字符串。
 * @author Administrator
 *
 */
public class countAndSay {
public static void main(String[] args) {
	
}
public String countAndSay(int n) {
	String end = "1";
	for (int i = 2; i <= n; i++) {
		char[] tem = end.toCharArray();
		int indexS = -1;
		int indexE = 0;
		int count = 0;
		end = ""; 
		for (int j = 0; j < tem.length; j++) {
			if(j != tem.length - 1&&tem[j] != tem[j+1]) {
				indexE = j;
				count = indexE-indexS;
				indexS = indexE;
				end = end.concat(String.valueOf(count));
				end = end.concat(String.valueOf(tem[j]));
			}else if(j == tem.length - 1) {
				count = tem.length - 1 - indexS;
				end = end.concat(String.valueOf(count));
				end = end.concat(String.valueOf(tem[j]));
				} 
			} 
		} 
	return end;
}
}
