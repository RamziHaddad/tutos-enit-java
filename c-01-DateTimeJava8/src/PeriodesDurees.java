import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodesDurees {

	public static void main(String[] args) {
		LocalDate initialDate = LocalDate.parse("2007-05-10");
		LocalDate finalDate = initialDate.plus(Period.ofDays(5));

		int five = Period.between(initialDate, finalDate).getDays();
		long five2 = ChronoUnit.DAYS.between(initialDate, finalDate);

		LocalTime initialTime = LocalTime.of(6, 30, 0); LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));

		long thirty = Duration.between(initialTime, finalTime).getSeconds();
		//ou
		long thirty2 = ChronoUnit.SECONDS.between(initialTime, finalTime);








	}

}
