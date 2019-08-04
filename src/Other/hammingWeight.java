package Other;
/**
 *找出0001111111100011中的1的个数 
 * @author Administrator
 *
 */
public class hammingWeight {
public static void main(String[] args) {
	hammingWeight h=new hammingWeight();
	int i=h.test(0001011);
	System.out.println("======");
	System.out.println(i);
}
public int test(int x) {
	//返回int类型的2进值数
	String s=Integer.toBinaryString(x);
	//返回int类型的8进值数
	String s2=Integer.toOctalString(x);
	//返回int类型的16进值数
	String s1=Integer.toHexString(x);
	
	char[] charS=s.toCharArray();
	int index=0;
	for(int i=0;i<charS.length;i++) {
		System.out.print(charS[i]);
		if(charS[i]=='1') {
			index++;
		}
	}
	return index;
}
public int leecode(int n) {
	int result = 0;
    long x = n&0xFFFFFFFFl;
    while(x>0){
        result += x % 2;
        x = x / 2;
    }
    return result;
}
}
