package repositories;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

import Models.City;

public class CityRepository {
	
	private static List<City> cities;
	private static final String citiesFilePath = "cities.txt";
	
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
	
	private void storeCity(City city) {
		try(RandomAccessFile myFile = new RandomAccessFile("file", "rw");
				FileOutputStream file = new FileOutputStream(myFile.getFD()); 
				BufferedOutputStream out = new BufferedOutputStream(file);) {
			long fileLenght = myFile.length();
			myFile.seek(fileLenght);
			out.write(city.getCityName().getBytes());
		} catch (IOException ex) {
			
		}
	}
	
	private  void fetchAllCities() {
		try (FileReader fileReader = new FileReader(citiesFilePath);
				BufferedReader reader = new BufferedReader(fileReader);) {
			String line;
			while((line = reader.readLine()) != null) {
				String[] element = splitLine(line);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private String[] splitLine(String line) {
		String[] element = new String[2];
		element[0] = getElementBeforeOrAfterSpcace(line, 1);
		element[1] = getElementBeforeOrAfterSpcace(line, 2);
		return element;
	}
	
	/**
	 * Internally used to retrieve the city or the date element from a line.
	 * 
	 * @param line the line that we want to split
	 * @param splitCase the element that we want to get: 1 for the cityName and 2 for the cityDate.
	 * @return the cityName or the cityDate element as a String.	 
	 */
	private String getElementBeforeOrAfterSpcace(String line, int splitCase) {
		int pos = line.indexOf(" ");
		if(splitCase == 1) {
			return line.substring(0, pos);
		}
		else if(splitCase == 2) {
			return line.substring(pos);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
}
