import java.time.LocalDate;
import java.time.LocalTime;

public class Comparaison {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.parse("2016-03-04");
		LocalDate d2 = LocalDate.parse("2014-06-18");
		System.out.println("d1= "+d1);
		System.out.println("d2= "+d2);

		System.out.println("d1.isBefore(d2) = "+d1.isBefore(d2));
		System.out.println("d1.isAfter(d2) = "+d1.isAfter(d2));
		
		LocalTime t1 = LocalTime.parse("06:30");
		LocalTime t2 = LocalTime.parse("07:30");

		System.out.println("t1= "+t1);
		System.out.println("t2= "+t2);
		System.out.println("t1.isBefore(t2) = "+t1.isBefore(t2));

	}

}
