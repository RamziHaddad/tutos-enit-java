import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.DayOfWeek;

public class Parsing {

	public static void main(String[] args) {
		DayOfWeek dayOfWeek = LocalDate.parse("2023-03-03").getDayOfWeek();
		System.out.println(dayOfWeek);
		int leTrois = LocalDate.parse("2023-03-03").getDayOfMonth();
		System.out.println(leTrois);
		int onzeHeures = LocalTime.parse("11:30").getHour();
		System.out.println(onzeHeures);
		LocalDateTime d1 = LocalDateTime.parse("2015-02-20T06:30:00");
		System.out.println(d1);
		ZonedDateTime d2 = ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
		System.out.println(d2);
	}
}
