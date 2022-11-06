import java.util.Calendar;

public class t2 {
	public static void main(String[] args) {
		int count = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.set(2022, 0, 1);
		while (true) {
			// 中文语境下的时间
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int day_of_week = calendar.get(Calendar.DAY_OF_WEEK)-1;
			System.out.print(year + "年" + month + "月" + day + "日，是周" + day_of_week);

			// 判断是否增加1
			if (day_of_week == 6 || day_of_week == 0 || day % 10 == 1) {
				count += 1;
			}
			System.out.println("\tcount:"+count);
			if (year == 2022 && month == 12 && day == 31) {
				break;
			}
			// 增加一天
			calendar.add(5, 1);
		}
		System.out.println(count);
	}
}
