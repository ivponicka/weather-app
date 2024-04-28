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
        appName2.setFont(new Font("Monospace", Font.ITALIC, 22));
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
        searchField.setBounds(20,80,355,35);
        searchField.setFont(new Font("Monospace", Font.PLAIN, 24));
            add(searchField);


        // main weather image (today)
        JLabel weatherImage = new JLabel(loadImage("src/src/main/resources/images/cloudy.png"));
        weatherImage.setBounds(100, 115, 250, 200);
        add(weatherImage);

        // temperature
        JLabel weatherTemperature = new JLabel("10C");
        weatherTemperature.setBounds(195, 260, 150,50);
        weatherTemperature.setFont(new Font("Monospace", Font.BOLD, 28));
        add(weatherTemperature);

        // weather description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(185, 290, 150,50);
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
        JLabel windImage = new JLabel(loadImage("src/src/main/resources/images/wind.png"));
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
        tomorrowText.setBounds(40, 360, 90,50);
        tomorrowText.setFont(new Font("Monospace", Font.BOLD, 14));
        add(tomorrowText);

        // tomorrow weather image (today)
        JLabel weatherImageTomorrow = new JLabel(loadImage("src/src/main/resources/images/clearsmall.png"));
        weatherImageTomorrow.setBounds(33, 400, 90,50);
        add(weatherImageTomorrow);

        // tomorrow temperature
        JLabel weatherTemperatureTomorrow = new JLabel("10C");
        weatherTemperatureTomorrow.setBounds(58, 435, 90,50);
        weatherTemperatureTomorrow.setFont(new Font("Dialog", Font.BOLD, 18));
        add(weatherTemperatureTomorrow);

        // tomorrow weather description
        JLabel weatherConditionDescTomorrow = new JLabel("Cloudy");
        weatherConditionDescTomorrow.setBounds(50, 455, 90,50);
        weatherConditionDescTomorrow.setFont(new Font("Dialog", Font.ITALIC, 14));
        weatherConditionDescTomorrow.setForeground(new Color(29, 44, 97));
        add(weatherConditionDescTomorrow);

        // tomorrow + 1 day
        JLabel tomorrowText1 = new JLabel("Next day");
        tomorrowText1.setBounds(190, 360, 90,50);
        tomorrowText1.setFont(new Font("Monospace", Font.BOLD, 14));
        add(tomorrowText1);

        // tomorrow weather image (today) + 1 day
        JLabel weatherImageTomorrow1 = new JLabel(loadImage("src/src/main/resources/images/clearsmall.png"));
        weatherImageTomorrow1.setBounds(183, 400, 90,50);
        add(weatherImageTomorrow1);

        // tomorrow temperature + 1 day
        JLabel weatherTemperatureTomorrow1 = new JLabel("10C");
        weatherTemperatureTomorrow1.setBounds(208, 435, 90,50);
        weatherTemperatureTomorrow1.setFont(new Font("Dialog", Font.BOLD, 18));
        add(weatherTemperatureTomorrow1);

        // tomorrow weather description + 1 day
        JLabel weatherConditionDescTomorrow1 = new JLabel("Cloudy");
        weatherConditionDescTomorrow1.setBounds(200, 455, 90,50);
        weatherConditionDescTomorrow1.setFont(new Font("Dialog", Font.ITALIC, 14));
        weatherConditionDescTomorrow1.setForeground(new Color(29, 44, 97));
        add(weatherConditionDescTomorrow1);

        // tomorrow + 2 days
        JLabel tomorrowText2 = new JLabel("Next day +1");
        tomorrowText2.setBounds(340, 360, 90,50);
        tomorrowText2.setFont(new Font("Monospace", Font.BOLD, 14));
        add(tomorrowText2);

        // tomorrow weather image (today) + 2 days
        JLabel weatherImageTomorrow2 = new JLabel(loadImage("src/src/main/resources/images/clearsmall.png"));
        weatherImageTomorrow2.setBounds(333, 400, 90,50);
        add(weatherImageTomorrow2);

        // tomorrow temperature + 2 days
        JLabel weatherTemperatureTomorrow2 = new JLabel("10C");
        weatherTemperatureTomorrow2.setBounds(358, 435, 90,50);
        weatherTemperatureTomorrow2.setFont(new Font("Dialog", Font.BOLD, 18));
        add(weatherTemperatureTomorrow2);

        // tomorrow weather description + 2 days
        JLabel weatherConditionDescTomorrow2 = new JLabel("Cloudy");
        weatherConditionDescTomorrow2.setBounds(350, 455, 90,50);
        weatherConditionDescTomorrow2.setFont(new Font("Dialog", Font.ITALIC, 14));
        weatherConditionDescTomorrow2.setForeground(new Color(29, 44, 97));
        add(weatherConditionDescTomorrow2);

        // search button

        JButton searchButton = new JButton(loadImage("src/src/main/resources/images/search2.png"));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(380, 81, 45, 33);
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

                double weatherTemp = (double) weatherData.get("temperature");
                weatherTemperature.setText(weatherTemp + "C");
                weatherConditionDesc.setText(weatherCondition);

                double weatherTempTomorrow = (double) weatherData.get("temperature_tomorrow");

                weatherTemperatureTomorrow.setText(weatherTempTomorrow + "C");

                long humidity = (long) weatherData.get("humidity");
                humidityText.setText(humidity + "%</html>");

                double windSpeed = (double) weatherData.get("windspeed");
                windPercent.setText(windSpeed + "km/h</html>");


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
