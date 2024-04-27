package org.example;


import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WeatherAppBackEnd {
    public static JSONObject getWeatherData(String locationName){
        JSONArray locationData = getLocationData(locationName);
        JSONObject location = (JSONObject) locationData.get(0);
        double latitude = (double) location.get("latitude");
        double longitude = (double) location.get("longitude");

        String apiULR = "https://api.open-meteo.com/v1/forecast?latitude="+latitude+"&longitude="+longitude+"&hourly=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m&timezone=Europe%2FBerlin";

        try {
            HttpURLConnection connection = fetchApiResponse(apiULR);
            if(connection.getResponseCode() != 200){
                System.out.println("Couldn't conntect to API");

                StringBuilder resultJson = new StringBuilder();
                Scanner scanner = new Scanner(connection.getInputStream());
                while (scanner.hasNext()){
                    resultJson.append(scanner.nextLine());
                    scanner.close();
                    connection.disconnect();
                    JSONParser parser = new JSONParser();
                    JSONObject resultJsonOjb = (JSONObject) parser.parse(String.valueOf(resultJson));

                    JSONObject hourly = (JSONObject) resultJsonOjb.get("hourly");
                    JSONArray time = (JSONArray) hourly.get("time");
                    int index = findIndexOfCurrentTime(time);

                    JSONArray temperatureData = (JSONArray) hourly.get("temperature_2m");
                    double temperature = (double) temperatureData.get(index);

                    JSONArray weatherCode = (JSONArray) hourly.get("weather_code");
                    String weaterCondition = convertWeatherCode((long)weatherCode.get(index));
                }
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static JSONArray getLocationData(String locationName){
        locationName = locationName.replace(" ","+");
         String apiURL = "https://geocoding-api.open-meteo.com/v1/search?name="+locationName+"&count=10&language=en&format=json";

         try{
             HttpURLConnection connection = fetchApiResponse(apiURL);
             if(connection.getResponseCode() != 200){
                 System.out.println("Error! Couldn't connect to API");
                 return  null;
             } else {
                 StringBuilder resultJSON = new StringBuilder();
                 Scanner scanner = new Scanner(connection.getInputStream());
                 while (scanner.hasNext()){
                     resultJSON.append(scanner.nextLine());
                 }
                 scanner.close();
                 connection.disconnect();

                 JSONParser jsonParser = new JSONParser();
                 JSONObject resultJsonObject = (JSONObject) jsonParser.parse(String.valueOf(resultJSON));
                 JSONArray locationData = (JSONArray) resultJsonObject.get("results");
                 return locationData;
             }
         } catch (Exception e){
             e.printStackTrace();
         }
        return null;
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

    private  static int findIndexOfCurrentTime(JSONArray timeList){
        String currentTime = getCurrentTime();
        for(int i=0; i<timeList.size(); i++){
            String time = (String) timeList.get(i);
            if(time.equalsIgnoreCase(currentTime )){
                return i;
            }
        }
        return  0;
    }

    private static String getCurrentTime(){
        LocalDateTime currentTimeDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");
        String formattedDateTime = currentTimeDate.format(format);
        return formattedDateTime;
    }

    private static String convertWeatherCode(long weatherCode){
        String weatherCondition = "";
        if(weatherCode == 0L){
            weatherCondition = "clear";
        } else if(weatherCode < 3L && weatherCode > 0L){
            weatherCondition = "cloudy";
        } else if ((weatherCode >= 51L && weatherCode <= 67L) || (weatherCode >= 80L && weatherCode <= 99L)) {
            weatherCondition = "rainy";
        } else if (weatherCode >= 71L && weatherCode <= 77L){
            weatherCondition = "snow";
        }
        return weatherCondition;
    }

}
