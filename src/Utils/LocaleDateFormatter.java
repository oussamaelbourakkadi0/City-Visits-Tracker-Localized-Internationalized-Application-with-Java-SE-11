package Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LocaleDateFormatter {
	
	public static String getLocaleDateFormat() {
		String localeStr = Locale.getDefault().toString();
		
		switch(localeStr) {
		case "en_US":
			return "MM/dd/yyyy";
		case "fr_FR":
			return "dd/MM/yyyy";
		default:
			return null;
		}
	}
	
	public static Date fromStringToDate(String dateStr) throws ParseException {
		String datePattern = getLocaleDateFormat();
		DateFormat dateFormatter = new SimpleDateFormat(datePattern);
		return dateFormatter.parse(dateStr);
	}
}
