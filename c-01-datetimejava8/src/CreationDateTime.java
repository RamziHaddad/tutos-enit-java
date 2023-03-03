import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Set;

public class CreationDateTime {

	public static void main(String[] args) {
		LocalDateTime d1 = LocalDateTime.now();

		LocalDateTime d2 = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);

		System.out.println(d1);
		System.out.println(d2);
		
		ZoneId zoneId = ZoneId.of("Europe/Paris");
		System.out.println(zoneId);
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println(allZoneIds);

		ZonedDateTime zonedDateTime = ZonedDateTime.of(d1, zoneId);
		System.out.println(zonedDateTime);
		
		System.out.println("----------------");


		ZoneOffset offset = ZoneOffset.of("+02:00"); 
		OffsetDateTime offSetByTwo = OffsetDateTime .of(d1, offset);
		System.out.println(ZoneOffset.MAX);
		System.out.println(ZoneOffset.UTC);
		System.out.println(ZoneOffset.MIN);
		
		System.out.println(offSetByTwo);
		
		Instant i = Calendar.getInstance().toInstant();
		System.out.println(i);
		
		LocalDateTime ldt1 = LocalDateTime.ofInstant(Calendar.getInstance().getTime().toInstant(), ZoneId.systemDefault()); 
		LocalDateTime ldt2 = LocalDateTime.ofInstant(Calendar.getInstance().toInstant(), ZoneId.systemDefault());
		System.out.println(ldt1);
		System.out.println(ldt2);
	}

}
