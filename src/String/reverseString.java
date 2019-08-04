package String;
/**
 * 翻转字符串
 * @author Administrator
 *
 */
public class reverseString {
public static void main(String[] args) {
	reverseString r=new reverseString();
	String s="hello";
	String result=r.reverseString1(s);
	System.out.println(result+"-----------");
}
public String reverseString1(String s) {
	char[] sChar=s.toCharArray();
	int i=0;
	int j=s.length()-1;	
	for(int k=0;i<j;k++) {
        char t=sChar[i];
		sChar[i]=sChar[j];
		sChar[j]=t;
		i++;
		j--;
	}
	return String.valueOf(sChar);
}
}
