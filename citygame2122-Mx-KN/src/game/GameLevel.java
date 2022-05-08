package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {
    private Wolf wolf;
    private Hunter hunter;
    private Portal portal;

    public GameLevel(Game game) {

        Shape shape = new BoxShape(13, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        wolf = new Wolf(this);
        wolf.setPosition(new Vec2(7,-6));
        GemPickup pickup = new GemPickup(wolf);
        wolf.addCollisionListener(pickup);

        hunter = new Hunter(this);
        HunterCollision enemy = new HunterCollision(wolf);
        wolf.addCollisionListener(enemy);

        portal = new Portal( this );
        portal.setPosition( new Vec2(-13f, -10f));
        PortalEncounter encounter = new PortalEncounter( this, game);
        wolf.addCollisionListener( encounter);

    }
    public Wolf getWolf(){
        return wolf;
    }

    public Hunter getHunter() {return hunter;}

    public abstract boolean isComplete();

    public abstract Image getBackground();
}