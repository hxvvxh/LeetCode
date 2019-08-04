package Array;
/**
 * 旋转数组
 * 给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。
 * @author Administrator
 *
 */
public class totate2 {
	public static void main(String[] args) {

	}

	public void rotate1(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
	}
}
