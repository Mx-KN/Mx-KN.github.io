package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PortalEncounter implements CollisionListener {

    GameLevel currentLevel;
    Game game;

    public PortalEncounter(GameLevel level, Game game){
            currentLevel = level;
            this.game = game;
        }

        @Override
        public void collide(CollisionEvent e) {
            if (e.getOtherBody() instanceof Portal) {

                if (currentLevel.isComplete())
                    game.goToNextLevel();

                e.getOtherBody().destroy();
            }
        }

}
