package String;

/**
 * 翻转整数-翻转后越界则值0
 * 
 * @author Administrator
 *
 */
public class reverse {
	public static void main(String[] args) {
		reverse r = new reverse();
		int result = r.reverse(1534236469);
		System.out.println(result);
	}

	/**
	 * 除10取余-越界值0
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		int ans = 0;
		while (x != 0) {
			ans = ans * 10 + (x % 10);
			x /= 10;
		}
		if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
			ans = 0;
		}
		return ans;
	}

	/**
	 * 取长度。取最后一位，到最高位上，依次执行。越界则置零
	 * 
	 * @param x
	 * @return
	 */
	public int reverse2(int x) {
		long a = 0;
		int b = 0;
		if (x >= 0) {
			b = (x + "").length();// 正数
		} else {
			b = (x + "").length() - 1;// 负数有一个负号
		}
		while (x != 0) {
			for (int i = 0; i < b; i++) {
				int a1 = x % 10;// 当前最后一位数字 ，负数则显示的是负数-25%10 等于 -5
				x = (x - a1) / 10;// 把最后一位数字剔除掉的新数字
				a += (int) (a1 * Math.pow(10, b - i - 1)); // 相当于将每次的最后一位乘以当前位在十进制中的权重。234 = 2*10^2+3*10^1+4*10^0
			}
		}
		if ((a > Math.pow(2, 31) - 1) || (a < (-1) * Math.pow(2, 31))) { // 超过范围的返回0
			return 0;
		}
		return (int) a;
	}

	/**
	 * int 转化成String 然后在长度的1/2处进行前后调换实现翻转 在将char数组转化成String String转换成int的时候报错则是越界 置0
	 * 在判断int的值为负还是正。进行最终的retrun
	 * 
	 * @param x
	 * @return
	 */
	public int reverse3(int x) {
		int absX = 0;
		if (x < 0) {
			absX = Math.abs(x);// 将其转换成无符号整数
		} else {
			absX = x;
		}
		int result = 0;
		char[] xChar = String.valueOf(absX).toCharArray(); // 转换成char类型数组
		for (int i = 0; i < (xChar.length) / 2; i++) {
			char temp = 0;
			temp = xChar[i];
			xChar[i] = xChar[xChar.length - 1 - i];
			xChar[xChar.length - 1 - i] = temp;
			// 将字符数组转换成整型
		}
		try {
			result = Integer.parseInt(String.valueOf(xChar));
		} catch (Exception e) {
			return 0;
		}
		if (x < 0) {
			x = -1 * result;
			return x;
		} else {
			x = result;
			return x;
		}
	}
/**
 * leecode最块的方法
 * @param x
 * @return
 */
	public int reverse4(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}
}