package game;

import city.cs.engine.*;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {
    GameLevel currentLevel;
    GameView view;
   // private SoundClip backgroundMusic;

    /** Initialise a new Game. */
    public Game() {
        currentLevel = new Level1(this);

        view = new GameView(currentLevel, 500, 500);
        view.addMouseListener(new GiveFocus(view));
        view.addKeyListener(new WolfController(currentLevel.getWolf()));

        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        ControlPanel buttons = new ControlPanel( view);
        frame.add(buttons.getMainPanel(), BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        currentLevel.start();
    }

    public void goToNextLevel(){
       if (currentLevel instanceof Level1) {
           currentLevel.stop();
           //Transition to next level
           currentLevel = new Level2( this );
           view.setWorld( currentLevel );
           view.addKeyListener(new WolfController(currentLevel.getWolf()));
           currentLevel.start();
       }
       else if (currentLevel instanceof Level2) {
           currentLevel.stop();
           //Transition to next level
           currentLevel = new Level3( this );
           view.setWorld( currentLevel );
           view.addKeyListener(new WolfController(currentLevel.getWolf()));
           currentLevel.start();
       }

       else if (currentLevel instanceof Level3){
           System.out.println("Finished game");
           System.exit(0);
       }
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
