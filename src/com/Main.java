package com;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

import Models.City;
import repositories.CityRepository;

public class Main {
	
	protected static ResourceBundle userResourceBundle;
	private static final String[] locales = new String[] {"en_US", "pl_PL", "uk_UA"};
	private static final CityRepository cityRepository = new CityRepository();
	
	public static void main(String... args) {
		Locale.setDefault(Locale.US);
		Locale locale = Locale.getDefault();
		
		try {
			userResourceBundle = ResourceBundle.getBundle("resources/MessageBundle", locale);
			menu();
		} catch (MissingResourceException exception) {
			exception.printStackTrace();
		}
		
	}
	
	private static void menu() {
		
		System.out.println(userResourceBundle.getString("menu.chooseAction"));
		System.out.println("0 -- " + userResourceBundle.getString("menu.printAll"));
		System.out.println("1 -- " + userResourceBundle.getString("menu.addCity"));
		System.out.println("3 -- " + userResourceBundle.getString("menu.editCity"));
		System.out.println("2 -- " + userResourceBundle.getString("menu.removeCity"));
		System.out.println("4 -- " + userResourceBundle.getString("menu.changeLocale"));
		System.out.println("5 -- " + userResourceBundle.getString("menu.exit"));
		
		Scanner scanner = new Scanner (System.in);
		String answer = scanner.nextLine();
		scanner.close();
		
		switch(answer) {
		case "0":
			break;
		case "1":
			try {
				addCity();
			} catch (ParseException e) {
				String addCityExceptionMessage = userResourceBundle.getString("message.addCityException");
				System.out.println(addCityExceptionMessage);
			}
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			changeLocale();
			break;
		case "5":
			System.exit(0);
			break;
		default:
			break;
		}
		
		menu();
	}
	
	private static void printAll() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, userResourceBundle.getLocale());
		String availableCitiesMessage = userResourceBundle.getString("message.availableCitiesStr");
		System.out.println(availableCitiesMessage);
		String visitedAt = userResourceBundle.getString("message.visitedAtStr");
		for(City city: cityRepository.getAll()) {
			System.out.println(city.getCityName() + ", " + visitedAt + city.getVisitedDate());
		}
	}
	
	private static void editCity() {
		
	}
	
	private static void addCity() throws ParseException {
		String printValuesMessage = userResourceBundle.getString("message.printValues");
		System.out.println(printValuesMessage);

		Scanner scanner = new Scanner(System.in);
		String newCityName = scanner.nextLine();
		//scanner.close();
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, userResourceBundle.getLocale());
		String newDateStr = scanner.nextLine();
		
		Date newDate = dateFormat.parse(newDateStr);
		
		City newCity = new City();
		newCity.setCityLocale(userResourceBundle.getLocale());
		newCity.setCityName(newCityName);
		newCity.setVisitedAt(newDate);
		
		cityRepository.addCity(newCity);
		
		String savedMessage = userResourceBundle.getString("message.citySaved");
		
	}
	
	private static void changeLocale() {
		System.out.println(userResourceBundle.getString("message.chooseLanguage"));
		Locale newLocale = Locale.FRANCE;
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.next();
		answer.toUpperCase();
		
		if(answer.equals("N") || answer.equals("NO")) {
			menu();
		}
		else if(answer.equals("Y") || answer.equals("YES")) {
			try {
				userResourceBundle = ResourceBundle.getBundle("resources/MessageBundle", newLocale);
				System.out.println(userResourceBundle.getString("message.welcome"));
			} catch (Exception ex) {
				System.out.println(userResourceBundle.getString("message.tryAgain"));
				changeLocale();
			} finally {
				menu();
			}
		}
		else {
			throw new InputMismatchException("INVALID CHOICE, PLEASE CHOOSE A VALID OPTION (Y or NO)");
		}
		
	}
}