
public class t3 {
	public static void main(String[] args) {
		double count = 0;
		int n = 1;
		while (true) {
			count += 1.0 / n;
			n++;
			System.out.println(count);
			if (count > 12) {
				break;
			}
		}
		System.out.println(n);
	}

}
