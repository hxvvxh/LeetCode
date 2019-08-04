package Math2;
/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * @author Administrator
 *
 */
public class isPowerOfThree {
public static void main(String[] args) {
	
}

	public boolean Test(int n) {

		if (n == 0) {
			return false;
		}
		if (n == 3 || n == 1) {
			return true;
		} else if (n < 9) {
			return false;
		}
		if (n % 3 != 0) {
			return false;
		}
		return Test(n / 3);

	}
	
	public boolean Test2(int n) {
		return n > 0 && Math.pow(3, 19) % n == 0;
	}
}
