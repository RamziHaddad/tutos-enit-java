import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TestArithmetique {

	public static void main(String[] args) {
		System.out.println("Demain =" + LocalDate.now().plusDays(1));
		System.out.println("meme jour mois dernier = "+LocalDate.now().minus(1, ChronoUnit.MONTHS));
		System.out.println("Cette année bissextile?" + LocalDate.now().isLeapYear());;
		System.out.println("6H30 + *1H " + LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS));
		System.out.println("de heures avant maintenant = "+LocalDateTime.now().minusHours(2));
	}

}
