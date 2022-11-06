package t7;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0;i<next.length();i++) {
			char danci = next.charAt(i);
			if (danci=='a'||danci=='e'||danci=='i'||danci=='o'||danci=='u') {
				danci = (char) (danci-32);
			}
			stringBuffer.append(danci);
		}
		System.out.println(stringBuffer);
	}
}
