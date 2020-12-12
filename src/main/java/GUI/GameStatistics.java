//This class contains objects variables and functions that is needed
//for launching the GameStatistics screen
package GUI;

//import Game.GAME_GUI;
import Game.HowToPlayScreen;
import Game.MainGameScreen;
//import Game.StartingGameScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameStatistics extends JFrame {
    //private attributes
    private final JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JLabel RecycleMania;
    private JLabel lowest_score;
    private JLabel last_score;
    private JLabel highest_score;
    private JButton backButton;

    //default constructor
    public GameStatistics() throws IOException {
        //added exception because of file access
        frame.add(main_panel); //add the About Us UI components to the JFrame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true); //show the JFrame on the window

        //Grab path location of the text file Game Statistics.txt
        Path path = Paths.get("src\\main\\java\\GamePlay Info\\Game Statistics.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);
        BufferedReader br = new BufferedReader(new FileReader(file)); //open the file

        String st;
        while((st= br.readLine())!=null){//read each line of the text file
            String[] num = st.split("-"); //split by the -
            double a,b,c;
            a= Double.parseDouble(num[0]); //grab the last score
            b= Double.parseDouble(num[1]); //grab the highest score
            c= Double.parseDouble(num[2]); //grab the lowest score
            last_score.setText(String.valueOf(a)); //display it on the GameStatistics field for last score
            highest_score.setText(String.valueOf(b)); //display it on the GameStatistics field for highest score
            lowest_score.setText(String.valueOf(c)); //display it on the GameStatistics field for lowest score
        }
        br.close(); //close the file

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
    public static void main(String[] args) throws IOException {
        GameStatistics g = new GameStatistics(); //calls the About Us constructor to show whats in the JFrame
    }

}
