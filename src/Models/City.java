package Models;
import java.util.Locale;

public final class City {
	private Locale cityLocale;
	private String cityName;
	private String cityCountry;
	
	public City(Locale cityLocale, String cityName, String cityCountry) {
		this.cityLocale = cityLocale;
		this.cityName = cityName;
		this.cityCountry = cityCountry;
	}

	public Locale getCityLocale() {
		return cityLocale;
	}

	public String getCityName() {
		return cityName;
	}

	public String getCityCountry() {
		return cityCountry;
	}

	public void setCityLocale(Locale cityLocale) {
		this.cityLocale = cityLocale;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCityCountry(String cityCountry) {
		this.cityCountry = cityCountry;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof City)) {
			return false;
		}
		
		City city = (City) obj;
		boolean check = this.cityCountry.equals(city.cityCountry) &&
				this.cityName.equals(city.cityName);
		return check;
	}
}
