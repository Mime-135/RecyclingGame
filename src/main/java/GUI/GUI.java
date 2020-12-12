//This class contains objects variables and functions that is needed
//for launching the GUI screen
package GUI;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GUI implements MainGameScreen{
    //private attributes
    private final JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JButton playButton;
    private JButton aboutUsButton;
    private JButton settingsButton;
    private JButton gameStatisticsButton;
    private JButton howToPlayButton;
    private JLabel RecycleMania;
    private JPanel image_panel;
    private Image image;
    private Draw_Image Image_canvas;

    //default constructor
    @Override
    public void GUI() {

        //get the main image and display it on the image canvas panel
        String str;
        str = "src/main/resources/main_image.jpg"; //holds the location of the image
        Path path = Paths.get(str);
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        image = new ImageIcon(location).getImage();
        Image_canvas = new Draw_Image(); //create the JPanel
        image_panel.add(Image_canvas);
        frame.add(main_panel); //add the About Us UI components to the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true); //show the JFrame on the window
    }

    //Function takes the user to the GameSettings screen when the user clicks Play button
    @Override
    public void PlayGame() {
        playButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GameSettings g = new GameSettings();
            }
        });

    }

    //Function takes the user to the HowToPlay screen when the user clicks HowToPlay button
    @Override
    public void HowToPlay(){
        howToPlayButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                HowToPlayGUI g = new HowToPlayGUI();
            }

        });
    }

    //Function takes the user to the Settings screen when the user clicks Settings button
    @Override
    public void Setting(){
        settingsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Settings g = new Settings();

            }
        });
    }

    //Function takes the user to the GameStatistics screen when the user clicks GameStatistics button
    @Override
    public void GameStatistics(){
        gameStatisticsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    GameStatistics g = new GameStatistics();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    //Function takes the user to the AboutUs screen when the user clicks AboutUs button
    @Override
    public void AboutUs(){
        aboutUsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AboutUs g = new AboutUs();
            }
        });
    }

    //Creates an image panel with a specified dimension width and height
    private class Draw_Image extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image,0,0,this.getWidth(),this.getHeight(),null);
        }
    }

    public void run()
    {
        GUI(); //launches the Main game GUI screen
        PlayGame(); //launches the Play game GUI screen
        HowToPlay(); //launches the HowToPlay GUI screen
        Setting(); //launches the Settings GUI screen
        AboutUs(); //launches the AboutUs GUI screen
        GameStatistics(); //launches the GameStatics GUI screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true); //show the JFrame on the window

    }


    // Main function to start the game up.
    public static void main(String[] args) {
        // Create an object of the GUI class and run it
        GUI g = new GUI();
        g.run();
        //To play the background music, create an object of the sound class and loop it.
        for (int i = 0; i < 10; i++){
            SoundClass sound = new SoundClass();
            sound.playSong();
        }

    }
}

