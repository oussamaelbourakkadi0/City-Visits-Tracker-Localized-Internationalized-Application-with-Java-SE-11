package Models;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class Client {
	
	private Locale userLocale;
	private final String username;
	private Map<City, Date> visitedCities;
	
	public Client(Locale userLocale, String username) {
		this.userLocale = userLocale;
		this.username = username;
	}

	public Locale getUserLocale() {
		return userLocale;
	}
	
	public void addCity(City city, Date dateVisited) {
		this.visitedCities.put(city, dateVisited);
	}
	
	public void removeCity(City city, Date dateVisited) {
		this.visitedCities.remove(city, dateVisited);
	}
	
}
