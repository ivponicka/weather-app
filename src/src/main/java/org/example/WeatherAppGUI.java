package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGUI extends JFrame {
    public WeatherAppGUI(){
        super("Weather App");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450,460);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        setComponents();
    }

    private void setComponents(){
        JTextField searchField = new JTextField();
        searchField.setBounds(20,20,355,45);
        searchField.setFont(new Font("Dialog", Font.PLAIN, 26));
            add(searchField);

        JButton searchButton = new JButton(loadImage("src/src/main/resources/images/search2.png"));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(380, 21, 45, 43);
        searchButton.setBackground(new Color(147, 165, 186));
        add(searchButton);

        JLabel weatherImage = new JLabel(loadImage("src/src/main/resources/images/cloudy.png"));
        weatherImage.setBounds(95, 75, 250, 200);
        add(weatherImage);

        JLabel weatherTemperature = new JLabel("10C");
        weatherTemperature.setBounds(185, 240, 50,50);
        weatherTemperature.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(weatherTemperature);

        JLabel weatherCondition = new JLabel("Cloudy");
        weatherCondition.setBounds(175, 270, 150,50);
        weatherCondition.setFont(new Font("Dialog", Font.PLAIN, 22));
        add(weatherCondition);

        JLabel humidityImage = new JLabel(loadImage("src/src/main/resources/images/humidity2.png"));
        humidityImage.setBounds(10, 344, 50,50);
        add(humidityImage);

        JLabel humidityText = new JLabel("Humidity");
        humidityText.setBounds(70, 330, 90,50);
        humidityText.setFont(new Font("Dialog", Font.BOLD, 14));
        add(humidityText);

        JLabel humidityPercent = new JLabel("100%");
        humidityPercent.setBounds(70, 350, 50,50);
        humidityPercent.setFont(new Font("Dialog", Font.BOLD, 14));
        add(humidityPercent);

        JLabel windImage = new JLabel(loadImage("src/src/main/resources/images/wind.png"));
        windImage.setBounds(290, 344, 50,50);
        add(windImage);

        JLabel windText = new JLabel("Wind");
        windText.setBounds(340, 330, 90,50);
        windText.setFont(new Font("Dialog", Font.BOLD, 14));
        add(windText);

        JLabel windPercent = new JLabel("100km/h");
        windPercent.setBounds(340, 350, 90,50);
        windPercent.setFont(new Font("Dialog", Font.BOLD, 14));
        add(windPercent);
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
