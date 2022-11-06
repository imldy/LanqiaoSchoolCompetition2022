package t9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String string = "AAAA\r\n" + 
						"ALAQ\r\n" + 
						"ALQQ";
		String string2 = string.replace("　", "");
		String[] split = string2.split("\\r\\n");

//		Scanner scanner = new Scanner(System.in);
//		int hNum = scanner.nextInt();
//		int lNum = scanner.nextInt();
		int hNum = 3;
		int lNum = 4;

		char[][] matrix = new char[hNum][lNum];
		int count = 0;

		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = split[i].toCharArray();
		}

		// 先确定直角位置，再遍历
		Dot dot = new Dot(0, 0);
		for (; dot.xIndex < 100; dot.xIndex++) {
			for (; dot.yIndex < 100; dot.yIndex++) {
				/* length+left<=lNum&&length+top<hNum */
				for (int length = 2;length<=100; length++) {
					// 确定三个点
					// 一个直角点和腰长可以确定4个三角形

					// 三角形1
					Triangle triangle1 = new Triangle(dot, new Dot(dot.xIndex - length, dot.yIndex),
							new Dot(dot.xIndex, dot.yIndex - length));
					Triangle triangle2 = new Triangle(dot, new Dot(dot.xIndex + length, dot.yIndex),
							new Dot(dot.xIndex, dot.yIndex - length));
					Triangle triangle3 = new Triangle(dot, new Dot(dot.xIndex - length, dot.yIndex),
							new Dot(dot.xIndex, dot.yIndex + length));
					Triangle triangle4 = new Triangle(dot, new Dot(dot.xIndex + length, dot.yIndex),
							new Dot(dot.xIndex, dot.yIndex + length));

					ArrayList<Triangle> arrayList = new ArrayList<Triangle>(4);
//					arrayList.add(triangle1);
//					arrayList.add(triangle2);
//					arrayList.add(triangle3);
					arrayList.add(triangle4);
					for (int i = 0; i < arrayList.size(); i++) {
						boolean lq = false;
						try {
							lq = isLQ(matrix, arrayList.get(i));
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						if (lq) {
							count++;
						}
					}

				}
			}
		}
		System.out.println(count);
	}

	public static boolean isLQ(char[][] matrix, Triangle triangle) {
		boolean result = true;
		char c = matrix[triangle.rightAngle.xIndex][triangle.rightAngle.yIndex];
		// 取大
		int endIndex = triangle.rightAngle.xIndex > triangle.AngleQ.xIndex ? triangle.rightAngle.xIndex
				: triangle.AngleQ.xIndex;
		// 取小
		int startIndex = triangle.rightAngle.xIndex > triangle.AngleQ.xIndex ? triangle.AngleQ.xIndex
				: triangle.rightAngle.xIndex;
		// 横
		for (int i = startIndex; i <= endIndex; i++) {
			if (matrix[triangle.rightAngle.yIndex][i] != c) {
				result = false;
			}
		}
		// 竖
		// 取大
		int endIndex2 = triangle.rightAngle.yIndex > triangle.AngleW.yIndex ? triangle.rightAngle.yIndex
				: triangle.AngleW.yIndex;
		// 取小
		int startIndex2 = triangle.rightAngle.yIndex > triangle.AngleW.yIndex ? triangle.AngleW.yIndex
				: triangle.rightAngle.yIndex;
		for (int j = startIndex2; j <= endIndex; j++) {
			if (matrix[j][triangle.rightAngle.xIndex] != c) {
				result = false;
			}
		}
		// 斜着
		for (int i = startIndex,j = startIndex2; i <= endIndex&&j <= endIndex; i++,i++) {
				if (matrix[j][i] != c) {
					result = false;
				}
		}
		return result;
	}

}

class Dot {
	int xIndex;
	int yIndex;

	public Dot(int xIndex, int yIndex) {
		super();
		this.xIndex = xIndex;
		this.yIndex = yIndex;
	}

}

class Triangle {
	Dot rightAngle;
	// 横线的另一个角
	Dot AngleQ;
	// 竖线的另一个角
	Dot AngleW;

	public Triangle(Dot rightAngle, Dot angleQ, Dot angleW) {
		super();
		this.rightAngle = rightAngle;
		AngleQ = angleQ;
		AngleW = angleW;
	}

}
