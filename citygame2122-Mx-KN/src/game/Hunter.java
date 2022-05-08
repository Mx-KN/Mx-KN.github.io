package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Hunter extends DynamicBody /*implements StepListener*/ {
    private static final Shape hunterShape = new PolygonShape(
            1.07f,1.98f,
            -1.06f,1.74f,
            -1.12f,-1.97f,
            0.18f,-1.83f );

    private static SoundClip enemy, gameOver;

    static {
        try {
            enemy = new SoundClip("data/Death.wav");
            System.out.println("Loading sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    static {
        try {
            gameOver = new SoundClip("data/Game_Over.wav");
            System.out.println("Loading sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    private static final BodyImage image =
            new BodyImage( "data/hunter.png", 4f );

   /* private enum State {
        GO_RIGHT, GO_lEFT, STAY_STILL
    } */

    private static final float range = 15;
    private GameLevel world;
    //private State state;

    public Hunter(GameLevel world) {
        super( world, hunterShape );
        this.world= world;
        addImage( image );
        //state = State.STAY_STILL;
        //getWorld().addStepListener(this);
    }

   /* public boolean inLeftRange() {
        Body w = world.getWolf();
        float gap = getPosition().x - w.getPosition().x;
        return gap < range && gap > 0;
    }

    public boolean inRightRange() {
        Body w = world.getWolf();
        float gap = getPosition().x - w.getPosition().x;
        return gap > -range && gap < 0;
    }

    public void preStep(StepEvent e) {
        if (inRightRange()) {
            if (state != State.GO_RIGHT) {
                state = State.GO_RIGHT;
                setLinearVelocity( new Vec2(50,50) );;
            }
        } else if (inLeftRange()) {
            if (state != State.GO_lEFT) {
                state = State.GO_lEFT;
                setLinearVelocity( new Vec2(0,0) );;
            }
        } else {
            if (state != State.STAY_STILL) {
                state = State.STAY_STILL;
                setAngularVelocity(0);
                setLinearVelocity(new Vec2(0, 0));
            }
        }
        refreshPatrol();
    }

    private void refreshPatrol() {
        switch (state) {
            case GO_lEFT:
                setLinearVelocity( new Vec2(50,50) );
                break;
            case GO_RIGHT:
                setLinearVelocity( new Vec2(0,0) );
                break;
            default: // nothing to do
        }
    }

    public void postStep(StepEvent e) {
    } */

    @Override
    public void destroy()
    { // if hit, game over.
        enemy.play();
        super.destroy();
        System.out.println("Game Over");
        world.stop();
        gameOver.play();

    }
}