import java.time.LocalDate;

public class TestDates {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		
		LocalDate localDate2 = LocalDate.of(2015, 02, 20);
		
		LocalDate localDate3 = LocalDate.parse("2015-02-20");
		System.out.println(localDate3);

	}

}
