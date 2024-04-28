package org.example;

import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGUI extends JFrame {

    private JSONObject weatherData;
    public WeatherAppGUI(){
        super("Weather App");
        setSize(450,550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);

        getContentPane().setBackground(new Color(201, 216, 240));
        setComponents();
    }

    private void setComponents(){

        JLabel appName1 = new JLabel("Weather");
        appName1.setBounds(20,15, 355, 45);
        appName1.setFont(new Font("Monospace", Font.BOLD, 22));

        add(appName1);

        JLabel appName2 = new JLabel("APP");
        appName2.setBounds(120,15, 355, 45);
        appName2.setFont(new Font("Monospace", Font.BOLD | Font.ITALIC, 22));
        appName2.setForeground(new Color(29, 44, 97));
        add(appName2);

        JLabel exit = new JLabel(loadImage("src/src/main/resources/images/exit.png"));
        exit.setBounds(395,15, 35, 45);
        add(exit);

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });


        // search field
        JTextField searchField = new JTextField();
        searchField.setBounds(20,85,355,30);
        searchField.setFont(new Font("Monospace", Font.PLAIN, 22));
            add(searchField);


        // main weather image (today)
        JLabel weatherImage = new JLabel(loadImage("src/src/main/resources/images/clear.png"));
        weatherImage.setBounds(100, 125, 250, 200);
        add(weatherImage);

        // temperature
        JLabel weatherTemperature = new JLabel("10°C");
        weatherTemperature.setBounds(195, 295, 150,50);
        weatherTemperature.setFont(new Font("Monospace", Font.BOLD, 28));
        add(weatherTemperature);

        // weather description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(190, 325, 150,50);
        weatherConditionDesc.setFont(new Font("Monospace", Font.ITALIC, 22));

        appName2.setForeground(new Color(29, 44, 97));
        add(weatherConditionDesc);

        // humidity
        JLabel humidityImage = new JLabel(loadImage("src/src/main/resources/images/humidity2.png"));
        humidityImage.setBounds(40, 184, 50,50);
        add(humidityImage);

        JLabel humidityText = new JLabel("Humidity");
        humidityText.setBounds(36, 225, 90,50);
        humidityText.setFont(new Font("Monospace", Font.BOLD, 14));
        add(humidityText);

        JLabel humidityPercent = new JLabel("100%");
        humidityPercent.setBounds(43, 250, 50,50);
        humidityPercent.setFont(new Font("Monospace", Font.BOLD, 14));
        add(humidityPercent);

        // wind
        JLabel windImage = new JLabel(loadImage("src/src/main/resources/images/windspeed3.png"));
        windImage.setBounds(350, 184, 50,50);
        add(windImage);

        JLabel windText = new JLabel("Wind");
        windText.setBounds(350, 225, 90,50);
        windText.setFont(new Font("Monospace", Font.BOLD, 14));
        add(windText);

        JLabel windPercent = new JLabel("100km/h");
        windPercent.setBounds(350, 250, 90,50);
        windPercent.setFont(new Font("Monospace", Font.BOLD, 14));
        add(windPercent);


        // tomorrow
        JLabel tomorrowText = new JLabel("Tomorrow");
        tomorrowText.setBounds(40, 380, 90,50);
        tomorrowText.setFont(new Font("Monospace", Font.BOLD, 14));
        add(tomorrowText);

        // tomorrow weather image (today)
        JLabel weatherImageTomorrow = new JLabel(loadImage("src/src/main/resources/images/clearsmall.png"));
        weatherImageTomorrow.setBounds(33, 420, 90,50);
        add(weatherImageTomorrow);

        // tomorrow temperature
        JLabel weatherTemperatureTomorrow = new JLabel("10°C");
        weatherTemperatureTomorrow.setBounds(55, 455, 90,50);
        weatherTemperatureTomorrow.setFont(new Font("Dialog", Font.BOLD, 18));
        add(weatherTemperatureTomorrow);

        // tomorrow weather description
        JLabel weatherConditionDescTomorrow = new JLabel("Cloudy");
        weatherConditionDescTomorrow.setBounds(50, 475, 90,50);
        weatherConditionDescTomorrow.setFont(new Font("Dialog", Font.ITALIC, 14));
        weatherConditionDescTomorrow.setForeground(new Color(29, 44, 97));
        add(weatherConditionDescTomorrow);

        // label second day
        JLabel secondDayText = new JLabel("Next day");
        secondDayText.setBounds(190, 380, 90,50);
        secondDayText.setFont(new Font("Monospace", Font.BOLD, 14));
        add(secondDayText);

        // second day weather image
        JLabel weatherImageSecondDay = new JLabel(loadImage("src/src/main/resources/images/clearsmall.png"));
        weatherImageSecondDay.setBounds(174, 420, 90,50);
        add(weatherImageSecondDay);

        // second day temperature
        JLabel weatherTemperatureSecondDay = new JLabel("10°C");
        weatherTemperatureSecondDay.setBounds(203, 455, 90,50);
        weatherTemperatureSecondDay.setFont(new Font("Dialog", Font.BOLD, 18));
        add(weatherTemperatureSecondDay);

        // second day weather description
        JLabel weatherConditionDescSecondDay = new JLabel("Cloudy");
        weatherConditionDescSecondDay.setBounds(200, 475, 90,50);
        weatherConditionDescSecondDay.setFont(new Font("Dialog", Font.ITALIC, 14));
        weatherConditionDescSecondDay.setForeground(new Color(29, 44, 97));
        add(weatherConditionDescSecondDay);

        // third day
        JLabel thirdDayText = new JLabel("Day after");
        thirdDayText.setBounds(335, 380, 120,50);
        thirdDayText.setFont(new Font("Monospace", Font.BOLD, 14));
        add(thirdDayText);

        // third day weather image
        JLabel weatherImageThirdDay = new JLabel(loadImage("src/src/main/resources/images/clearsmall.png"));
        weatherImageThirdDay.setBounds(330, 420, 90,50);
        add(weatherImageThirdDay);

        // third day temperature
        JLabel weatherTemperatureThirdDay = new JLabel("10°C");
        weatherTemperatureThirdDay.setBounds(350, 455, 90,50);
        weatherTemperatureThirdDay.setFont(new Font("Monospace", Font.BOLD, 18));
        add(weatherTemperatureThirdDay);

        // third day weather description
        JLabel weatherConditionDescThirdDay = new JLabel("Cloudy");
        weatherConditionDescThirdDay.setBounds(350, 475, 90,50);
        weatherConditionDescThirdDay.setFont(new Font("Monospace", Font.ITALIC, 14));
        weatherConditionDescThirdDay.setForeground(new Color(29, 44, 97));
        add(weatherConditionDescThirdDay);


        // search button

        JButton searchButton = new JButton(loadImage("src/src/main/resources/images/search.png"));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(380, 85, 35, 28);
        searchButton.setBackground(new Color(147, 165, 186));

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    // get location from user
                    String userInput = searchField.getText();

                    // validate input - remove whitespace to ensure non-empty text
                    if(userInput.replaceAll("\\s", "").length() <= 0){
                        return;
                    }

                    // retrieve weather data
                    weatherData = WeatherAppBackEnd.getWeatherData(userInput);

                    // update gui

                    // update weather image
                    String weatherCondition = (String) weatherData.get("weather_condition");
                    String weatherConditionTomorrow = (String) weatherData.get("weather_condition_tomorrow");
                    String weatherConditionSecondDay = (String) weatherData.get("weather_condition_second_day");
                    String weatherConditionThirdDay = (String) weatherData.get("weather_condition_third_day");

                switch (weatherCondition){
                    case "Clear":
                        weatherImage.setIcon(loadImage("src/src/main/resources/images/clear.png"));
                        break;
                    case "Cloudy":
                        weatherImage.setIcon(loadImage("src/src/main/resources/images/cloudy.png"));
                        break;
                    case "Rain":
                        weatherImage.setIcon(loadImage("src/src/main/resources/images/rain.png"));
                        break;
                    case "Snow":
                        weatherImage.setIcon(loadImage("src/src/main/resources/images/snow.png"));
                        break;
                    case "Stormy":
                            weatherImage.setIcon(loadImage("src/src/main/resources/images/stormy.png"));
                            break;
                    case "Drizzle":
                            weatherImage.setIcon(loadImage("src/src/main/resources/images/drizzle.png"));
                            break;

                }

                switch (weatherConditionTomorrow){
                    case "Clear":
                        weatherImageTomorrow.setIcon(loadImage("src/src/main/resources/images/clearsmall.png"));
                        break;
                    case "Cloudy":
                        weatherImageTomorrow.setIcon(loadImage("src/src/main/resources/images/cloudysmall.png"));
                        break;
                    case "Rain":
                        weatherImageTomorrow.setIcon(loadImage("src/src/main/resources/images/rainsmall.png"));
                        break;
                    case "Snow":
                        weatherImageTomorrow.setIcon(loadImage("src/src/main/resources/images/snowsmall.png"));
                        break;
                    case "Stormy":
                        weatherImageTomorrow.setIcon(loadImage("src/src/main/resources/images/stormysmall.png"));
                        break;
                    case "Drizzle":
                        weatherImageTomorrow.setIcon(loadImage("src/src/main/resources/images/drizzlesmall.png"));
                        break;

                }

                switch (weatherConditionSecondDay){
                    case "Clear":
                        weatherImageSecondDay.setIcon(loadImage("src/src/main/resources/images/clearsmall.png"));
                        break;
                    case "Cloudy":
                        weatherImageSecondDay.setIcon(loadImage("src/src/main/resources/images/cloudysmall.png"));
                        break;
                    case "Rain":
                        weatherImageSecondDay.setIcon(loadImage("src/src/main/resources/images/rainsmall.png"));
                        break;
                    case "Snow":
                        weatherImageSecondDay.setIcon(loadImage("src/src/main/resources/images/snowsmall.png"));
                        break;
                    case "Stormy":
                        weatherImageSecondDay.setIcon(loadImage("src/src/main/resources/images/stormysmall.png"));
                        break;
                    case "Drizzle":
                        weatherImageSecondDay.setIcon(loadImage("src/src/main/resources/images/drizzlesmall.png"));
                        break;

                }

                switch (weatherConditionThirdDay){
                    case "Clear":
                        weatherImageThirdDay.setIcon(loadImage("src/src/main/resources/images/clearsmall.png"));
                        break;
                    case "Cloudy":
                        weatherImageThirdDay.setIcon(loadImage("src/src/main/resources/images/cloudysmall.png"));
                        break;
                    case "Rain":
                        weatherImageThirdDay.setIcon(loadImage("src/src/main/resources/images/rainsmall.png"));
                        break;
                    case "Snow":
                        weatherImageThirdDay.setIcon(loadImage("src/src/main/resources/images/snowsmall.png"));
                        break;
                    case "Stormy":
                        weatherImageThirdDay.setIcon(loadImage("src/src/main/resources/images/stormysmall.png"));
                        break;
                    case "Drizzle":
                        weatherImageThirdDay.setIcon(loadImage("src/src/main/resources/images/drizzlesmall.png"));
                        break;

                }

                double weatherTemp = (double) weatherData.get("temperature");
                weatherTemperature.setText(weatherTemp + "°C");
                weatherConditionDesc.setText(weatherCondition);

                double weatherTempTomorrow = (double) weatherData.get("temperature_tomorrow");
                weatherTemperatureTomorrow.setText(weatherTempTomorrow + "°C");
                weatherConditionDescTomorrow.setText(weatherConditionTomorrow);

                double weatherTemp2ndDay = (double) weatherData.get("temperature_2nd_day");
                weatherTemperatureSecondDay.setText(weatherTemp2ndDay + "°C");
                weatherConditionDescSecondDay.setText(weatherConditionSecondDay);

                double weatherTemp3rdDay = (double) weatherData.get("temperature_3rd_day");
                weatherTemperatureThirdDay.setText(weatherTemp3rdDay + "°C");
                weatherConditionDescThirdDay.setText(weatherConditionThirdDay);



                long humidity = (long) weatherData.get("humidity");
                humidityPercent.setText(humidity + "%");

                double windSpeed = (double) weatherData.get("windspeed");
                windPercent.setText(windSpeed + "km/h");


            }

        });
        add(searchButton);
    }

    private ImageIcon loadImage(String resourcePath){
        try{
            BufferedImage image = ImageIO.read(new File(resourcePath));
            return new ImageIcon(image);
        } catch (IOException e){
            e.printStackTrace();;
        }
        System.out.println("Couldn't find a resource");
        return null;
    }
}
