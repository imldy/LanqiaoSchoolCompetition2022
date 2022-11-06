import java.math.BigDecimal;

public class t3_2 {
	public static void main(String[] args) {
		BigDecimal count = new BigDecimal(0);
		int n = 1;
		while (true) {
			count = count.add(new BigDecimal(1.0).divide(new BigDecimal(n))) ;
			n++;
			System.out.println(n+"-"+count);
			if (count.intValue() > 12) {
				break;
			}
		}
		System.out.println(n);
	}

}
