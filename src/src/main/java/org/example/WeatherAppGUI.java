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
        setSize(450,480);
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


        JTextField searchField = new JTextField();
        searchField.setBounds(20,70,355,45);
        searchField.setFont(new Font("Dialog", Font.PLAIN, 26));
            add(searchField);



        JLabel weatherImage = new JLabel(loadImage("src/src/main/resources/images/cloudy.png"));
        weatherImage.setBounds(100, 115, 250, 200);
        add(weatherImage);

        JLabel weatherTemperature = new JLabel("10C");
        weatherTemperature.setBounds(195, 260, 150,50);
        weatherTemperature.setFont(new Font("Dialog", Font.BOLD, 28));
        add(weatherTemperature);

        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(185, 290, 150,50);
        weatherConditionDesc.setFont(new Font("Dialog", Font.ITALIC, 22));
        appName2.setForeground(new Color(29, 44, 97));
        add(weatherConditionDesc);

        JLabel humidityImage = new JLabel(loadImage("src/src/main/resources/images/humidity2.png"));
        humidityImage.setBounds(10, 374, 50,50);
        add(humidityImage);

        JLabel humidityText = new JLabel("Humidity");
        humidityText.setBounds(70, 360, 90,50);
        humidityText.setFont(new Font("Dialog", Font.BOLD, 14));
        add(humidityText);

        JLabel humidityPercent = new JLabel("100%");
        humidityPercent.setBounds(70, 380, 50,50);
        humidityPercent.setFont(new Font("Dialog", Font.BOLD, 14));
        add(humidityPercent);

        JLabel windImage = new JLabel(loadImage("src/src/main/resources/images/wind.png"));
        windImage.setBounds(290, 364, 50,50);
        add(windImage);

        JLabel windText = new JLabel("Wind");
        windText.setBounds(350, 360, 90,50);
        windText.setFont(new Font("Dialog", Font.BOLD, 14));
        add(windText);

        JLabel windPercent = new JLabel("100km/h");
        windPercent.setBounds(350, 380, 90,50);
        windPercent.setFont(new Font("Dialog", Font.BOLD, 14));
        add(windPercent);

        JButton searchButton = new JButton(loadImage("src/src/main/resources/images/search2.png"));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(380, 71, 45, 43);
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
