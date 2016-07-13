package com.tcs.evaluation.weathermodel.utils;

import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

public class WolframAlphaAPI {

    // PUT YOUR APPID HERE:
    private static String appid = "WVK4J3-E5LJK2WQEJ";

    public static String getWeather(String input) {   

        //String input = "weather London September 9, 2016 5:34 am";
        String subpodContents, temperature, humidity;
        
        // The WAEngine is a factory for creating WAQuery objects,
        // and it also used to perform those queries. You can set properties of
        // the WAEngine (such as the desired API output format types) that will
        // be inherited by all WAQuery objects created from it. Most applications
        // will only need to crete one WAEngine object, which is used throughout
        // the life of the application.
        WAEngine engine = new WAEngine();
        
        // These properties will be set in all the WAQuery objects created from this WAEngine.
        engine.setAppID(appid);
        engine.addFormat("plaintext");

        // Create the query.
        WAQuery query = engine.createQuery();
        query.setInput(input);
        
        try {
            // This sends the URL to the Wolfram|Alpha server, gets the XML result
            // and parses it into an object hierarchy held by the WAQueryResult object.
            WAQueryResult queryResult = engine.performQuery(query);
            
            if (queryResult.isError()) {
                System.out.println("Query error");
                System.out.println("  error code: " + queryResult.getErrorCode());
                System.out.println("  error message: " + queryResult.getErrorMessage());
            } 
            else {
                // Got a result.
                for (WAPod pod : queryResult.getPods()) {
                    if (!pod.isError() && pod.getTitle().startsWith("Recorded weather")) {
                        for (WASubpod subpod : pod.getSubpods()) {

                            for (Object element : subpod.getContents()) {
                                if (element instanceof WAPlainText) {
                                	subpodContents = ((WAPlainText) element).getText();
                                	System.out.println(subpodContents);
                                    String words[] = subpodContents.split("\n");
                                    if(words[1].contains("average")){
                                    	temperature = words[1].substring(words[1].indexOf("average")).replaceAll("[average: | °C)]", "");
                                    }
                                    else{
                                    	temperature = words[1].replaceAll("[temperature || °C]","");
                                    }
                                    if(words[2].contains("average")){
                                    	humidity = words[2].substring(words[3].indexOf("average")).replaceAll("[average: |%)]", "");
                                    }
                                    else{
                                    	humidity = words[2].replaceAll("[relative humidity ||%]", "");
                                    }
                                    System.out.println(temperature+"|"+humidity);
                                    return temperature+"|"+humidity;
                                }
                            }
                        }
                    }
                }
            }
        } catch (WAException e) {
            e.printStackTrace();
        }
        return "NO";
    }

}
