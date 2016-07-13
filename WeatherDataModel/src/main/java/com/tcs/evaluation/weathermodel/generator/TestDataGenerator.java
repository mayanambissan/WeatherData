package com.tcs.evaluation.weathermodel.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

import com.tcs.evaluation.weathermodel.model.Features;
import com.tcs.evaluation.weathermodel.model.WeatherStations;
import com.tcs.evaluation.weathermodel.utils.FeatureExtraction;
import com.tcs.evaluation.weathermodel.utils.TimeUtils;

public class TestDataGenerator {
	
	public static void main(String args[]) throws ParseException, IOException{
		Date formattedDateTime;
		String time;
		Features features = new Features();
		String weatherData;		
		String year = "2016";
		String modelFileName = "modelFile"; 
		String fileName = "testData.txt";
						
		File file = new File(fileName);

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
		
		for(WeatherStations weatherStation : WeatherStations.values()){
			System.out.println("\nGenerating weather data for "+weatherStation+".....");
			System.out.println("For dates : ");
			for(int index=1; index<=5; index++){
				int month = (int)(Math.random()*10000)%12+1;
				int day = (int)(Math.random()*10000)%28+1;
				time = TimeUtils.getTimeString();						
				formattedDateTime = TimeUtils.formatDateTime(year, month, day, time);
				System.out.println(year+"-"+month+"-"+day);
				features = FeatureExtraction.getFeatures(weatherStation, month, formattedDateTime);
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
						features.isDay();		
				try {
					writer.write(weatherData+"\n\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// Closing
		try {
			if(writer!=null){
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		runCRF(modelFileName, fileName);
	}

	public static void runCRF(String modelFileName, String testData) throws IOException
	{
		String columns[];
		String firstColumn[];
		String line, outputRow = "";
		String outputFile = "weatherData.txt";

		String command[] = {"crf_test","-m", modelFileName ,testData};		
		Process process = Runtime.getRuntime().exec(command);		
		InputStream inputStream = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));			
		
		FileWriter fileWriter = new FileWriter(outputFile); 	
		BufferedWriter writer = new BufferedWriter(fileWriter);

		outputRow = "WeatherStation|Coordinates|DateTime|Temperature|Humidity";
		writer.write(outputRow + "\n\n");
		while((line = reader.readLine())!=null)
		{			
			columns = line.split("\t");
			firstColumn = columns[0].split("\\|");				
			if(columns.length==13){
				outputRow = firstColumn[0]+"|"+columns[1]+"|"+firstColumn[1]+"|"+columns[12];
				writer.write(outputRow + "\n\n");
			}
		}
		System.out.println("\nGenerated weather data for 15 weather stations in the file "+outputFile);
		reader.close();
		writer.close();
	}
}
