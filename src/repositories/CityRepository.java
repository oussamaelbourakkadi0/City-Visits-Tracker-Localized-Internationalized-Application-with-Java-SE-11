package repositories;

import java.util.ArrayList;
import java.util.List;

import Models.City;

public class CityRepository {
	
	private static List<City> cities;
	
	public CityRepository() {
		cities = new ArrayList<>();
	}
	
	public void addCity(City city) {
		cities.add(city);
	}
	
	public List<City> getAll() {
		if (cities.isEmpty()) {
			throw new IllegalStateException();
		}
		return cities;
	}
	
	public void deleteCity(City city) {
		cities.remove(city);
	}
}
