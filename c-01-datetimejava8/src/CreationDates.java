import java.time.LocalDate;

public class CreationDates {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.of(2023, 02, 20);
		LocalDate d2 = LocalDate.parse("2022-02-20");
		LocalDate d3 = LocalDate.now();
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);

	}

}
