package com;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

import Models.City;
import Utils.ChangeLocaleUtils;
import Utils.LocaleDateFormatter;
import Utils.LocaleDateFormatter.*;
import repositories.CityRepository;

public class Main {
	
	private static ResourceBundle userResourceBundle;
	private static Locale locale;
	private static final Scanner scanner = new Scanner(System.in);
	private static final CityRepository cityRepository = new CityRepository();

	
	public static void main(String... args) {
		Locale.setDefault(Locale.US);
		locale = Locale.getDefault();
		
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

		String answer = scanner.nextLine();
		
		switch(answer) {
		case "0":
			printAll();
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
	
	public static void printAll() {
		String availableCitiesMessage = userResourceBundle.getString("message.availableCitiesStr");
		System.out.println(availableCitiesMessage);
		System.out.println(cityRepository.getAll());
	}
	
	public static void editCity() {
		printAll();
		String editMessage = userResourceBundle.getString("message.chooseIndexForEdit");
		System.out.println(editMessage);
		
		int index = scanner.nextInt();
		
	}
	
	public static void addCity() throws ParseException {
		String printCityNameMessage = userResourceBundle.getString("message.printCityName");
		System.out.println(printCityNameMessage);
		
		String newCityName = scanner.nextLine();
		
		String printedCityDate = userResourceBundle.getString("message.printVisitedDate");
		System.out.println(printedCityDate);
		
		String newDateStr = scanner.nextLine();
		Date newDate = LocaleDateFormatter.fromStringToDate(newDateStr);
		
		City newCity = new City(newCityName, newDate);
		cityRepository.addCity(newCity);
		
		String savedMessage = userResourceBundle.getString("message.citySaved");
	}
	
	public static void changeLocale() {
		System.out.println(userResourceBundle.getString("message.chooseLanguage"));
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.next().toUpperCase();
		
		try {
			boolean checkAnswer = ChangeLocaleUtils.checkChangeLocaleAnswer(answer);
			if(!checkAnswer) {
				menu();
			}
			else {
				if (Locale.getDefault().toString().equals("en_US")) {
					Locale.setDefault(Locale.FRANCE);
					locale = Locale.getDefault();
					userResourceBundle = ResourceBundle.getBundle("resources/MessageBundle", locale);
				}
				else if (Locale.getDefault().toString().equals("fr_FR")) {
					Locale.setDefault(Locale.ENGLISH);
					locale = Locale.getDefault();
					userResourceBundle = ResourceBundle.getBundle("resources/MessageBundle", locale);
				}
			}
		}
		catch (InputMismatchException ex) {
			System.out.println(userResourceBundle.getString("message.printValidAnswerException"));
			changeLocale();
		}
	}
	
}