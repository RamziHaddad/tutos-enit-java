import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodesDurees {

	public static void main(String[] args) {
		LocalDate d0 = LocalDate.parse("2023-03-03");
		System.out.println("d0 = "+d0);
		LocalDate d1 = d0.plus(Period.ofDays(5));
		System.out.println("d1 = d + 5 jours = "+d1);

		System.out.println("Periode entre d0 et d1 (jours) = "+Period.between(d0, d1).getDays());
		System.out.println("Periode entre d0 et d1 (jours) = "+ChronoUnit.DAYS.between(d0, d1));

		LocalTime t0 = LocalTime.of(6, 30, 0); 
		LocalTime t1 = t0.plus(Duration.ofSeconds(30));
		System.out.println("t0 = "+t0);
		System.out.println("t1 = t0 + 30 sec = "+t1);
		System.out.println("Durée entre t0 et t1 (secondes) = "+Duration.between(t0, t1).getSeconds());
		System.out.println("Durée entre t0 et t1 (secondes) = "+ChronoUnit.SECONDS.between(t0, t1));







	}

}
