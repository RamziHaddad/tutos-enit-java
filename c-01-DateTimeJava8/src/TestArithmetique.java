import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TestArithmetique {

	public static void main(String[] args) {
		LocalDate.now().plusDays(1);
		LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		LocalDate.now().isLeapYear();

		LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);

		System.out.println(LocalDate.now().plusDays(1));
		System.out.println(LocalDateTime.now().minusHours(2));
		
		//("yyyy/MM/dd HH'h'mm'm'ss's'")
		
		

	}

}
