import java.time.LocalDate;
import java.time.LocalTime;

public class Comparaison {

	public static void main(String[] args) {
		boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11")); 
		boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));

		boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));




	}

}
