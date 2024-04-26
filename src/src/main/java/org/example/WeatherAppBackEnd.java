package org.example;


import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAppBackEnd {
    public static JSONObject getWeatherInfo(String location){
        JSONArray weatherData = getLocationData(location);
    }

    private static JSONArray getLocationData(String location){
        location = location.replace("","+");
         String apiURL = "https://geocoding-api.open-meteo.com/v1/search?name="+location+"&count=10&language=en&format=json";

         try{
             HttpURLConnection connection = fetchApiResponse(apiURL);
         } catch (Exception e){
             e.printStackTrace();
         }
    }

    private static HttpURLConnection fetchApiResponse(String apiURL){
        try {
            URL url = new URL(apiURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
