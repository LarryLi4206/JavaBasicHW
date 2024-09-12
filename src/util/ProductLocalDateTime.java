package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProductLocalDateTime {
	
	public static String findLocalDateTime() {
		LocalDateTime ldt=LocalDateTime.now();
		String DateTime_login=ldt.
				format(DateTimeFormatter.ofPattern("YYY/MM/dd-HH:mm:ss"))
				.toString();
		
		return DateTime_login;
	}
	
}
