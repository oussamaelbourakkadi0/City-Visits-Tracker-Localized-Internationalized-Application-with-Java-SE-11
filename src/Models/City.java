package Models;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import Utils.LocaleDateFormatter;

public final class City {
	private String cityName;
	private Date visitedDate;
	
	public City() {
		
	}
	
	public City(String cityName, Date visitedDate) {
		this.cityName = cityName;
		this.visitedDate = visitedDate;
	}

	public String getCityName() {
		return cityName;
	}
	
	public Date getVisitedDate() {
		return visitedDate;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public void setVisitedAt(Date visitedDate) {
		this.visitedDate = visitedDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int hashedCityName = prime * cityName.hashCode();
		return hashedCityName;
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
	
	@Override
	public String toString() {
		Locale locale = Locale.getDefault();
		ResourceBundle userResourceBundle = ResourceBundle.getBundle("resources/MessageBundle", locale);
		String printCityMessage = userResourceBundle.getString("message.printCity");
		String datePattern = LocaleDateFormatter.getLocaleDateFormat();
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		String dateString = dateFormat.format(visitedDate);
		
		return MessageFormat.format(printCityMessage, getCityName(), dateString);
	}
	
}
