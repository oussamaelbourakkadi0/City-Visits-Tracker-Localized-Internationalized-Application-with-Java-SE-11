package Utils;

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
}
