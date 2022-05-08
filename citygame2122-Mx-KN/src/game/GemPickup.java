package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class GemPickup implements CollisionListener {

    private Wolf wolf;
    public GemPickup(Wolf w){
        this.wolf = w;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Gem) {
            wolf.setGems(wolf.getGems()+1);
            e.getOtherBody().destroy();
            System.out.println(wolf.getGems());
        }
    }
}

