import java.time.LocalTime;

public class TestTime {

	public static void main(String[] args) {
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		LocalTime sixThirty = LocalTime.parse("06:30");
		
		LocalTime sixThirty2 = LocalTime.of(6, 30);

		System.out.println(sixThirty2);
		
		LocalTime maxTime = LocalTime.MAX;
		
		System.out.println(maxTime);


	}

}
