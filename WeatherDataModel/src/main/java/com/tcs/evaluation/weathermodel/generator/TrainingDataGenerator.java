package com.tcs.evaluation.weathermodel.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import com.tcs.evaluation.weathermodel.model.Features;
import com.tcs.evaluation.weathermodel.model.Month;
import com.tcs.evaluation.weathermodel.utils.FeatureExtraction;
import com.tcs.evaluation.weathermodel.utils.TimeUtils;
import com.tcs.evaluation.weathermodel.utils.WolframAlphaAPI;
import com.tcs.evaluation.weathermodel.model.WeatherStations;


public class TrainingDataGenerator {
	public static void main(String args[]) throws ParseException{
		Date formattedDateTime;
		String input, time;
		String weatherData;			
		String year[] = {"2013"};	//,"2014","2015"};

		Features features = new Features();

		File file = new File("trainingData.txt");

		// creates the file
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// creates a FileWriter Object
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		} 

		for(int index = 0; index<year.length; index++){

			for(WeatherStations weatherStation : WeatherStations.values()){

				for(Month month : Month.values()){

					for(int day = 1; day<=month.getNumOfDays(); day++){										
						time = TimeUtils.getTimeString();							
						formattedDateTime = TimeUtils.formatDateTime(year[index], month.getMonth(), day, time);

						// Extract features here
						features = FeatureExtraction.getFeatures(weatherStation, month.getMonth(), formattedDateTime);

						input = "weather "+weatherStation.name()+" "+month.name()
								+" "+day+", "+year[index]+" "+time;

						weatherData = weatherStation.getCode()+"|"+TimeUtils.formatedDateTimeString(formattedDateTime)+"\t"+
								weatherStation.getLatitude()+","+weatherStation.getLongitude()+"\t"+																		
								features.getHemisphere()+"\t"+
								features.getLatitude()+"\t"+
								features.getLongitude()+"\t"+
								features.getElevation()+"\t"+
								features.getMonth()+"\t"+
								features.getKoppen_1()+"\t"+
								features.getKoppen_2()+"\t"+
								features.getKoppen_3()+"\t"+
								features.getSeason()+"\t"+
								features.isDay()+"\t"+	
								WolframAlphaAPI.getWeather(input);

						System.out.println(weatherData);
						try {
							writer.write(weatherData+"\n");
						} catch (IOException e) {
							e.printStackTrace();
						}						
					}
				}				
			}
		}

		// Closes
		try {
			if(writer!=null){
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
