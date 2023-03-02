import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatge {

	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);

		String d1 = localDateTime.format(DateTimeFormatter.ISO_DATE);

		String d2 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

		String d3 = localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US));

		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);

	}

}
