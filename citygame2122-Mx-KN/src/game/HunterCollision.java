package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class HunterCollision implements CollisionListener {

    private Wolf wolf;

    public HunterCollision(Wolf w){
        this.wolf = w;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Hunter) {
            e.getOtherBody().destroy(); //destroys body
        }
    }
}
