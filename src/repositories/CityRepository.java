package repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

import Models.City;

public class CityRepository {
	
	private static List<City> cities;
	
	public CityRepository() {
		cities = new ArrayList<>();
	}
	
	public void addCity(City city) {
		cities.add(city);
	}
	
	public City getByName(String cityName) throws NoSuchElementException {
		
		Predicate<City> predicate = (City city) -> {
			return city.getCityName().equals(cityName);
		};
		
		return cities.stream()
				.filter(predicate)
				.findFirst()
				.get();
	}
	
	public List<City> getAll() throws IllegalStateException {
		if (cities.isEmpty()) {
			throw new IllegalStateException();
		}
		return cities;
	}
	
	public void deleteCity(String cityName) {
		try {
		  City city = getByName(cityName);
		  cities.remove(city);
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
		}
	}
	
	public void editCity(String cityName, Date newVisitDate) {
		try {
			City city = getByName(cityName);
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
		}
	}
}
