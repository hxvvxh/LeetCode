package Other;
/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离


输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置
 * @author Administrator
 *
 */
public class hammingDistance {
	public static void main(String[] args) {
		hammingDistance h = new hammingDistance();
		h.test(1, 4);
	}

	public int test(int x, int y) {
		int tem = x ^ y;
		int con = 0;
		while (tem != 0) {
			//tem%2是取2进制的最后一位
			if (tem%2==1) {
				con++;
			}
			//由于tem是int类型 /2会直接保留整数位（相当与是2进制数向右移动一位）
            //tem=tem>>1; 也是2进制数向右移动一位
			tem=tem/2;
		}
		return con;
	}
	
	public int test2(int x, int y) {
		int k = x ^ y;
        int res = 0;
        while (k != 0) {
            if ((k % 2) == 1) res++;
            k = k >> 1;
        }
        return res;
	}
	
	
}
