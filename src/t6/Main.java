package t6;

//机器人判分系统要求必须如下规则：
//1： 不能有package关键字
//2： 类名必须是Main

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int start = scanner.nextInt();
		int end = scanner.nextInt();

		int gap = ((end + 7) - start) % 7;
		System.out.println(gap);
	}
}