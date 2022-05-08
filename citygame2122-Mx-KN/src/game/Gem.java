package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Gem extends DynamicBody {
    private static final Shape gemShape = new BoxShape( 1, 1 );
    private static SoundClip gemSound;

    static {
        try {
            gemSound = new SoundClip("data/collect.wav");
            System.out.println("Loading sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage( "data/gem.png", 2f );

    public Gem(World world) {
        super( world, gemShape );
        addImage( image );
        //setAlwaysOutline(true);
    }
    @Override
    public void destroy()
    {
        gemSound.play();
        super.destroy();
    }

}
