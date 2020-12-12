//This class contains objects variables and functions that is needed
//for launching the About Us screen
package GUI;

//import Game.GAME_GUI;
//import Game.HowToPlayScreen;
//import Game.MainGameScreen;
//import Game.StartingGameScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUs extends JFrame {
    //private attributes
    private final JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JLabel RecycleMania;
    private JButton backButton;

    //default constructor
    public AboutUs() {
        frame.add(main_panel); //add the About Us UI components to the JFrame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true); //show the JFrame on the window


        //Function takes the user to the GUI (Main GUI) when the user clicks Back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI g = new GUI();
                g.run();
            }
        });
    }

    //main
    public static void main(String[] args) {
        AboutUs g = new AboutUs(); //calls the About Us constructor to show whats in the JFrame
    }

}
