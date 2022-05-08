package game;

import city.cs.engine.BoxShape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level2 extends GameLevel{

    Image background;

    public Level2(Game game){
        super(game);

        background = new ImageIcon( "data/background.jpg" ).getImage();

        StaticBody platform2 = new StaticBody(this, new BoxShape(3.5f, 0.5f));
        platform2.setPosition(new Vec2(8, 5.5f));

        StaticBody platform3 = new StaticBody( this, new BoxShape(3.5f, 0.5f));
        platform3.setPosition( new Vec2(0, 0f) );

        StaticBody platform = new StaticBody( this, new BoxShape(3.5f, 0.5f));
        platform.setPosition( new Vec2(8, -5.5f) );

        new Gem(this).putOn( platform2);
        new Gem(this).putOn( platform3);

        getWolf().setPosition(new Vec2(8,-6));
        getHunter().setPosition( new Vec2(0,-6) );
        getHunter().setPosition(new Vec2(-5,-6) );
    }

    @Override
    public boolean isComplete() {
        if (getWolf().getGems() == 2)
            return true;
        else
            return false;
    }
    @Override
    public Image getBackground() {
        return background;
    }
}
