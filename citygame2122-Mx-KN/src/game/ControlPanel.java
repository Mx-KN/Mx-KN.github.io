package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel {
    private GameView view;
    private JPanel mainPanel;
    private JButton Quit;
    private JButton music1;
    private JButton music2;
    private JButton Experience;

    Game game;
    SoundClip backgroundMusic1, backgroundMusic2, backgroundMusic3;

    public ControlPanel(GameView view) {
        this.view = view;

        Quit.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit( 0 );
            }
        } );

        music1.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    backgroundMusic2 = new SoundClip("data/I_Am_The_Doctor.mp3");   //background music
                    backgroundMusic1.stop();
                    backgroundMusic2.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException c) {
                    System.out.println("music for level 2");
                }
            }
        } );
        music2.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    backgroundMusic3 = new SoundClip("data/Donna_Noble_Theme.mp3");   //background music
                    backgroundMusic2.stop();
                    backgroundMusic3.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException c) {
                    System.out.println("music for level 3");
                }
            }
        } );
        Experience.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    backgroundMusic1 = new SoundClip("data/experience.mp3");   // background music
                    backgroundMusic1.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException c) {
                    System.out.println("music for level 1");
                }
            }
        } );
    }
        public JPanel getMainPanel(){
            return mainPanel;
        }
    }