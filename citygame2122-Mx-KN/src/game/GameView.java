package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    GameLevel currentLevel;
    private Wolf wolf;

    public GameView(GameLevel w, int width, int height) {
        super( w, width, height );
        currentLevel = w;

    }

    @Override
    public void setWorld(World w){
        super.setWorld(w); //inheritance
        currentLevel = (GameLevel)w;
    }
    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(currentLevel.getBackground(), 0, 0, this ); //creates background
    }

    protected void paintForeground(Graphics2D g) { //for stats
        g.setColor(Color.blue );
        g.setFont( new Font( "Serif", Font.BOLD, 15 ) );
        g.drawString("Gems: " /* +wolf.getGems()*/, 20, 20 );
    }
}


