package Models;
import java.util.Date;
import java.util.Locale;

public final class City {
	private Locale cityLocale;
	private String cityName;
	private Date visitedDate;
	
	public City() {
		
	}
	
	public City(Locale cityLocale, String cityName, String cityCountry, Date visitedDate) {
		this.cityLocale = cityLocale;
		this.cityName = cityName;
		this.visitedDate = visitedDate;
	}

	public Locale getCityLocale() {
		return cityLocale;
	}

	public String getCityName() {
		return cityName;
	}
	
	public Date getVisitedDate() {
		return visitedDate;
	}

	public void setCityLocale(Locale cityLocale) {
		this.cityLocale = cityLocale;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public void setVisitedAt(Date visitedDate) {
		this.visitedDate = visitedDate;
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
		boolean check = this.cityName.equals(city.cityName) &&
				this.visitedDate.equals(city.cityName);
		return check;
	}
}
