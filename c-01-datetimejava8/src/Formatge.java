import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatge {

	public static void main(String[] args) {
		LocalDateTime d = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);

		String d1 = d.format(DateTimeFormatter.ISO_DATE);
		String d2 = d.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		String d3 = d.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US));
		String d4 = d.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.FRANCE));

		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);

	}

}
