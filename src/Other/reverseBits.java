package Other;
/**
 * 颠倒给定的 32 位无符号整数的二进制位
 * 00000010100101000001111010011100
 * 00111001011110000010100101000000
 * 
 * 
 * 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * @author Administrator
 *
 */
public class reverseBits {
	public static void main(String[] args) {
		reverseBits r=new reverseBits();
		int i=43261596;
		r.test(i);
	}

	public int test(int n) {
		//定义了初始化结果参数0
		int m=0;
        for(int i=0;i<32;i++){
        	//m向左移1位；解释：向左移动一位是为了后续将从n中取出的最后一位放入
            m<<=1;
            /**
             * 二进制运算符& | ^
             * 解释：
             * n&1 （如1010&0001）得到的必定是n的最后一位(0/1)
             * m|...  由于最后一位是左移出来的位置所以初始的是0  
             *  |运算是将m的末尾设置成为取出n的最后一位
             */
            m = m|(n & 1);//m的末位设置为n的末位
            //n向右移1位；解释：向右移动一位是为了出參
            n>>=1;//n向右移1位
        }
        System.out.println(m);
        return m;

	}
	public int test2(int n) {
	int r = 0;
    int count = 0;
    while (n != 0) {
        if ((n & 1) == 1) r |= (1 << (31 - count));
        n = n >>> 1;
        count++;
    }
    return r;
	}
}
