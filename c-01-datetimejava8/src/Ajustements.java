import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class Ajustements {

	public static void main(String[] args) {
		LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX); 
		System.out.println(endOfDay);
		LocalDate lastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(lastDayOfMonth);

	}

}
