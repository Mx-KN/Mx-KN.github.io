package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Portal extends DynamicBody {
    private static final Shape portalShape = new CircleShape( 2 );
    private static SoundClip PortalSound;

    static {
        try {
            PortalSound = new SoundClip("data/Whoosh.wav");
            System.out.println("Loading sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage( "data/portal.png", 4f );

    public Portal(World world) {
        super( world, portalShape );
        addImage( image );
    }

    @Override
    public void destroy()
    {
        PortalSound.play();
        super.destroy();
    }
}
