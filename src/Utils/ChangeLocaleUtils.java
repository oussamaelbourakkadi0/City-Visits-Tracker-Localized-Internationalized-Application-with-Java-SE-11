package Utils;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ChangeLocaleUtils {

	public static boolean checkChangeLocaleAnswer(String answer) {
		Locale locale = Locale.getDefault();
		String localeStr = locale.toString();
		
		//Check if the default locale is en_US.
		if(localeStr.equals("en_US")) {
			//Check if the answer submitted by the user is equal to YES or Y.
			if(answer.equals("YES") || answer.equals("Y")) {
				return true;
			}
			//Otherwise, check if it is equal to NO or N.
			else if(answer.equals("NO") || answer.equals("N")) {
				return false;
			}
		}
		//Check if the default locale is fr_FR.
		else if(localeStr.equals("fr_FR")) {
			//Check if the answer submitted by the user is equal to OUI or O.
			if(answer.equals("OUI") || answer.equals("O")) {
				return true;
			}
			//Otherwise, check if it is equal to NON or N.
			else if(answer.equals("NON") || answer.contentEquals("N")) {
				return false;
			}
		}
		
		/* Throw an InputMismatchException since all the valid answers are checked above:
		 * 'YES', 'Y', 'NO', 'N' if the default locale is en_US.
		 * 'OUI', 'O', 'NON', 'N' if the default locale is fr_FR.
		 */
		throw new InputMismatchException();
	}
}


