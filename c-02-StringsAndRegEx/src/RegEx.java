import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static String pattern0255  = "((([0-1]?)(\\d{1,2}))|(2[0-4]\\d)|(25[0-5]))";
	public static String patternIP = pattern0255+"\\."+pattern0255+"\\."+pattern0255+"\\."+pattern0255;

	
	public static void main(String[] args) {
		//factoriser la compilation pour gagner en performances!!

		Pattern p = Pattern.compile("a*b");
		 Matcher m = p.matcher("aaaaab");
		 boolean b = m.matches();
		 //System.out.println(b);
		 
		 //System.out.println(Pattern.matches("a*b", "aaaaab"));

		 System.out.println(isIP("192.161.100.155"));
		 System.out.println(isIP("092.61.0.055"));
		 System.out.println(isIP("222.211.200.255"));
		 System.out.println(isIP("0.61.0.055"));
		 System.out.println(isIP("0.0.0.0"));
		 System.out.println(isIP("222.211.200.255"));
		 System.out.println(isIP("999.110.1.0"));
		 System.out.println(isIP("1999.110.1.0"));
		 System.out.println(isIP("999.110.a.0"));

		 
		 //System.out.println(Pattern.matches(pattern0255, "0"));
	}
	
	public static boolean isIP(String s) {
		//factoriser la compilation pour gagner en performances
		return Pattern.matches(patternIP, s);
	}
	public static boolean is0255(String s) {
		//factoriser la compilation pour gagner en performances
		return Pattern.matches(pattern0255, s);
	}
}
