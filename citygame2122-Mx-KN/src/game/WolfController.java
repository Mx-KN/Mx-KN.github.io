package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WolfController implements KeyListener {

    private static final float WALKING_SPEED = 4;
    private Wolf wolf;

    public WolfController(Wolf wolf) {this.wolf = wolf;}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) /* left arrow key */ {
            wolf.startWalking(-WALKING_SPEED); //to the left side
            wolf.removeAllImages();
            wolf.addImage( new BodyImage( "data/wolfL.png", 4f));
        }
        else if (code == KeyEvent.VK_RIGHT) /* right arrow key */ {
            wolf.startWalking(WALKING_SPEED); //right side
            wolf.removeAllImages();
            wolf.addImage( new BodyImage( "data/wolfR.png", 4f));
        }
        else if (code == KeyEvent.VK_SPACE)/* key spacebar */{
            wolf.jump(12);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            wolf.stopWalking();
        }
        else if (code == KeyEvent.VK_RIGHT) {
            wolf.stopWalking();
        }
    }

    public void keyTyped(KeyEvent e){
    }
}
