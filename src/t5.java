import org.junit.Test;

public class t5 {
	public static void main(String[] args) {
		// 指定矩阵行、列的开始下标、结束下标，求和
//		// 子矩阵大小遍历
//		for (int i = 1; i <= 100; i++) {
//			for (int j = 1; j <= 100; j++) {
//
//				// 确定大小后位置遍历
//				for (int leftTop = 1; leftTop + i <= 100 && leftTop + j <= 100; leftTop++) {
//
//				}
//
//			}
//		}
		// 先确定左上角位置，再遍历
		for (int left = 1; left <= 100; left++) {
			for (int top = 1; top <= 100; top++) {

				// 子矩阵大小遍历
				for (int i = 1; left + i <= 100; i++) {
					for (int j = 1; top + j <= 100; j++) {
						
						int sum = sum(left, left + i, top, top + j);
//						System.out.println(left + "," + (left + i) + "," + top + "," + (top + j) + "和为" + sum);
						
						if(sum==2022) {
							// 计算矩阵大小
							int mu = i*j;
							System.out.println(mu);
						}
					}
				}
			}
			break;
		}

	}

	public static int sum(int hbegin, int hend, int lbegin, int lend) {
		int sum = 0;
		for (int h = hbegin; h <= hend; h++) {
			int hangSum = (get(h, lbegin) + get(h, lend)) * (lend - lbegin + 1) / 2;
			sum += hangSum;
		}
		return sum;
	}

	@Test
	public void TestSum() {
		System.out.println("子矩阵和" + sum(7, 8, 13, 15));
	}

	/**
	 * 获取某一位置的值
	 * 
	 * @param h 第？行
	 * @param l 第？列
	 * @return
	 */
	public static int get(int h, int l) {
		return h + (l - 1) * 2;
	}

//	@Test
//	public void TestGet() {
//		System.out.println(get(7, 13));
//	}
}
