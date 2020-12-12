//This class contains objects variables and functions that is needed
//for launching the GameSettings screen
package GUI;

import Game.Game_Info;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

    public class GameSettings {
        //private attributes
        private final JFrame frame = new JFrame("RecycleMania");
        private JPanel main_panel;
        private JButton startButton;
        private JRadioButton a5RadioButton;
        private JRadioButton a10RadioButton;
        private JRadioButton a15RadioButton;
        private JRadioButton easyRadioButton;
        private JRadioButton normalRadioButton;
        private JRadioButton hardRadioButton;
        private JRadioButton wordsRadioButton;
        private JRadioButton wordsAndImagesRadioButton;
        private JRadioButton ONRadioButton;
        private JRadioButton OFFRadioButton;
        private JButton backButton;

    //default constructor
    public GameSettings(){
        //Group number of words radiobuttons so that only can be selected
        //at a time
        ButtonGroup num_of_wordsGrp = new ButtonGroup();
        num_of_wordsGrp.add(a5RadioButton);
        num_of_wordsGrp.add(a10RadioButton);
        num_of_wordsGrp.add(a15RadioButton);

        //Group level of difficulty radiobuttons so that only can be selected
        //at a time
        ButtonGroup level_of_diffGrp = new ButtonGroup();
        level_of_diffGrp.add(easyRadioButton);
        level_of_diffGrp.add(normalRadioButton);
        level_of_diffGrp.add(hardRadioButton);

        //Group game modes radiobuttons so that only can be selected
        //at a time
        ButtonGroup gameModeGrp = new ButtonGroup();
        gameModeGrp.add(wordsRadioButton);
        gameModeGrp.add(wordsAndImagesRadioButton);

        //Group timer radiobuttons so that only can be selected
        //at a time
        ButtonGroup timerGrp = new ButtonGroup();
        timerGrp.add(ONRadioButton);
        timerGrp.add(OFFRadioButton);

        frame.add(main_panel); //add the About Us UI components to the JFrame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true); //show the JFrame on the window

        //a5RadioButton = new JRadioButton();

        //Function takes the user to the PlayGUI when the user clicks Start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                //get all the info from the button groups
                //difficultly
                String Game_Difficulty = get_Difficulty();
                // item_type
                String Game_Item_type = get_Item_type();
                //timers
                boolean timer = get_Timer(); //true if it is selected
                //num of items
                int Game_num_items = get_Item_num();

                //System.out.println(Game_Difficulty);//for debugging purposes

                PlayGui g = null;
                try {
                    g = new PlayGui();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                g.SetGameGUIParam( Game_Difficulty, Game_Item_type ,timer, Game_num_items);
                    g.start_word_or_images();


            }
        });

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

    //getter for difficulty level
    public String get_Difficulty(){
        if(easyRadioButton.isSelected()){
            return "Easy";
        }
        else if(normalRadioButton.isSelected()){
            return "Normal";
        }
        else if(hardRadioButton.isSelected()){
            return "Hard";
        }
        return "Easy";
    }

    //getter for Game Mode type
    public String get_Item_type(){
        if(wordsAndImagesRadioButton.isSelected()){
            return "Images";
        }
        if(wordsRadioButton.isSelected()) {
            return "Words";
        }
        return "Images";
    }

    //getter for number of items
    public int get_Item_num(){
        if(a5RadioButton.isSelected()){
            return 5;
        }
        else if(a10RadioButton.isSelected()){
            return 10;
        }
        else if(a15RadioButton.isSelected()){
            return 15;
        }
        return 5;
    }


    public boolean get_Timer(){
        //also the default
        return ONRadioButton.isSelected();
    }

    //main
    public static void main(String[] args) {
        GameSettings g = new GameSettings(); //calls the GameSettings constructor to show whats in the JFrame
    }
}