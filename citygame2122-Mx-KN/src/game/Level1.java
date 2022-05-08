package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level1 extends GameLevel{

    Image background;

    public Level1(Game game){
        super(game);

        background = new ImageIcon( "data/background.jpg" ).getImage();

        //creates platforms
        Shape platformShape = new BoxShape(3.5f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -5.5f));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(8, 5.5f));

        StaticBody platform3 = new StaticBody( this, platformShape );
        platform3.setPosition( new Vec2(0, 0f) );

        //gems and bodies
        new Gem(this).putOn( platform1);
        new Gem(this).putOn( platform2);
        new Gem(this).putOn( platform3);

        getWolf().setPosition(new Vec2(9,-6));
        getHunter().setPosition( new Vec2(8, 5.5f) );

    }

    @Override
    public boolean isComplete() {
        if (getWolf().getGems() == 3)
            return true;
        else
            return false;
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
