package repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Models.City;

public class CityRepository {
	
	private static Set<City> cities;
	
	public CityRepository() {
		cities = new HashSet<>();
	}
	
	public void addCity(City city) {
		cities.add(city);
	}
	
	public Set<City> getAll() {
		if (cities.isEmpty()) {
			throw new IllegalStateException();
		}
		return cities;
	}
	
	public void deleteCity(City city) {
		cities.remove(city);
	}
}
