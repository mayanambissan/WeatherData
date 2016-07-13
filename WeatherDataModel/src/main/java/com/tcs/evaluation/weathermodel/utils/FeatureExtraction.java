package com.tcs.evaluation.weathermodel.utils;

import java.util.Calendar;
import java.util.Date;

import com.tcs.evaluation.weathermodel.model.Features;
import com.tcs.evaluation.weathermodel.model.WeatherStations;

public class FeatureExtraction {	
	public static Features getFeatures(WeatherStations weatherStation, int month, Date dateTime){ 
		Features features = new Features();
		features.setHemisphere(weatherStation.getHemisphere());
		features.setLatitude(weatherStation.getLatitude()+"");
		features.setLongitude(weatherStation.getLongitude()+"");
		features.setElevation(weatherStation.getElevation()+"");
		features.setMonth(month);
		features.setKoppen_1(weatherStation.getKoppen_1());
		features.setKoppen_2(weatherStation.getKoppen_2());
		features.setKoppen_3(weatherStation.getKoppen_3());
		features.setSeason(getSeason(weatherStation.getHemisphere(), month));
		features.setDay(isDay(dateTime));	
		return features;
	}
	
	// Get the season of the location for the date
	public static String getSeason(String hemisphere, int month){
		switch(month){
			case 3:				
			case 4:
			case 5:
				if(hemisphere.equals("N")){
					return "SPRING";	
				}
				else{
					return "FALL";
				}				
			case 6:
			case 7:
			case 8:
				if(hemisphere.equals("N")){
					return "SUMMER";
				}
				else{
					return "WINTER";
				}
			case 9:
			case 10:
			case 11:
				if(hemisphere.equals("N")){
					return "FALL";
				}
				else{
					return "SPRING";
				}
			case 12:
			case 1:
			case 2:
				if(hemisphere.equals("N")){
					return "WINTER";
				}
				else{
					return "SUMMER";
				}
		}
		return "ERROR";
	}
	
	// Check if time is day or night
	public static boolean isDay(Date dateTime){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		if(cal.get(Calendar.HOUR_OF_DAY)>=6 && cal.get(Calendar.HOUR_OF_DAY)<=19){
			return true;
		}
		else{
			return false;
		}		
	}	
}
