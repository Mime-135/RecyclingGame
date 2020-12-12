//This class contains objects variables and functions that is needed
//for launching the Settings screen
package GUI;

import Game.GUIOtherSettingScreen;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings implements GUIOtherSettingScreen{
    //private attributes
    private final JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JLabel RecycleMania;
    private JButton backButton;
    private JRadioButton abstractRadioButton;
    private JRadioButton blueSkyRadioButton;
    private JRadioButton oliveRadioButton;
    private JRadioButton tealRadioButton;
    private JRadioButton brownWoodenRadioButton;
    private JRadioButton lightGreyRadioButton;
    private JRadioButton navyRadioButton;
    private JRadioButton puceRadioButton;
    private JRadioButton ONRadioButton;
    private JPanel background;
    private JRadioButton greenRadioButton;
    private Image image;
    private Color background_color;
    private Color theme_color;
    public int R, G, B;

    //default constructor
    public Settings() {

        frame.add(background); //add the About Us UI components to the JFrame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true); //show the JFrame on the window

        //Group background option radiobuttons so that only can be selected
        //at a time
        ButtonGroup backgrnd_group = new ButtonGroup();
        backgrnd_group.add(abstractRadioButton);
        backgrnd_group.add(blueSkyRadioButton);
        backgrnd_group.add(oliveRadioButton);
        backgrnd_group.add(tealRadioButton);
        backgrnd_group.add(brownWoodenRadioButton);
        abstractRadioButton.setSelected(true); //default background
        try {
            changeBackgroundColor("Forest Green"); //Updates the Background.txt with default choice
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        //Group theme option radiobuttons so that only can be selected
        //at a time
        ButtonGroup theme_group = new ButtonGroup();
        theme_group.add(greenRadioButton);
        theme_group.add(lightGreyRadioButton);
        theme_group.add(navyRadioButton);
        theme_group.add(puceRadioButton);
        greenRadioButton.setSelected(true);//default theme
        changeTheme("Green"); //Updates the Theme.txt with default choice

        //Group sound option radiobuttons so that only can be selected
        //at a time
        ButtonGroup sound_group = new ButtonGroup();
        sound_group.add(ONRadioButton);
        ONRadioButton.setSelected(true); //default sound is ON

        //Function takes the user to the GUI (Main GUI) when the user clicks Back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI g = new GUI();
                g.run();
            }
        });

        //Action listeners for backgrounds
        //Function changes background color to Forest Green when the user clicks Forest Green radiobutton
        abstractRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Forest Green");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        //Function changes background color to Blue sky when the user clicks Blue sky radiobutton
        blueSkyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Blue sky");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //Function changes background color to Brown wooden when the user clicks Brown wooden radiobutton
        brownWoodenRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Brown wooden");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //Function changes background color to Olive when the user clicks Olive radiobutton
        oliveRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Olive");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //Function changes background color to Teal when the user clicks Teal radiobutton
        tealRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Teal");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //Action listeners for themes
        //Function changes theme color to Green when the user clicks Green radiobutton
        greenRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("Green");
            }
        });
        //Function changes theme color to Light grey when the user clicks Light grey radiobutton
        lightGreyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("Light Grey");
            }
        });
        //Function changes theme color to Navy when the user clicks Navy radiobutton
        navyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("Royal blue");
            }
        });
        //Function changes theme color to Maroon when the user clicks Maroon radiobutton
        puceRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("Puce");
            }
        });
    }

    //getter for theme color
    public Color getTheme_color(){
        return theme_color;
    }

    //getter for background color
    public Color getBackground_color(){
        return background_color;
    }

    //Function to change the background color and update the Background.txt file
    @Override
    public void changeBackgroundColor(String str) throws IOException {

        if (str.equals("Blue sky")){
            R=137;
            G=207;
            B=240;
            background_color = new Color(R,G,B); //customized background color
        }
        if(str.equals("Teal")){
            R=0;
            G=128;
            B=128;
            background_color = new Color(R,G,B); //customized background color
        }
        if(str.equals("Olive")){
            R=184;
            G=188;
            B=134;
            background_color = new Color(R,G,B); //customized background color
        }
        if(str.equals("Brown wooden")){
            R=248;
            G=196;
            B=113;
            background_color = new Color(R,G,B); //customized background color
        }
        if(str.equals("Forest Green")){
            R=154;
            G=205;
            B=50;
            background_color = new Color(R,G,B); //customized background color
        }

        //Grab path location of the text file Background.txt
        Path path = Paths.get("src\\main\\java\\GamePlay Info\\Background.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);

        String temp = R +"-"+ G +"-"+ B;

        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))){ //open the file
            br.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Function to change the theme color and update the Theme.txt file
    @Override
    public void changeTheme(String str){

        if (str.equals("Green")){
            R=0;
            G=170;
            B=0;
            theme_color = new Color(R,G,B); //customized theme color
        }
        if(str.equals("Light Grey")) {
            R = 211;
            G = 211;
            B = 211;
            theme_color = new Color(R, G, B); //customized theme color
        }
        if(str.equals("Royal blue")){
            R=65;
            G=105;
            B=225;
            theme_color = new Color(R,G,B); //customized theme color
        }

        if(str.equals("Puce")){
            R=204;
            G=136;
            B=153;
            theme_color = new Color(R,G,B); //customized theme color
        }

        //Grab path location of the text file Theme.txt
        Path path = Paths.get("src\\main\\java\\GamePlay Info\\Theme.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);

        String temp = R +"-"+ G +"-"+ B;
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))){ //open the file
            br.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //main
    public static void main(String[] args) {
        Settings g = new Settings(); //calls the About Us constructor to show whats in the JFrame

    }
}
