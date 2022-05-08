package game;

import city.cs.engine.*;

public class Wolf extends Walker {
    private static final Shape studentShape = new PolygonShape(
            -1.94f,0.55f,
            -1.29f,1.74f,
            -0.03f,1.67f,
            0.8f,0.46f,
            1.76f,-1.56f,
            1.78f,-1.98f,
            -1.71f,-1.91f );


    private static final BodyImage image =
            new BodyImage( "data/wolfL.png", 4f );

    private int gemCount;

    public Wolf(World world) {
        super( world, studentShape );
        addImage( image );
        //setAlwaysOutline(true);
        gemCount = 0;
    }


    public void setGems(int gems){
        this.gemCount = gemCount + 1;}

    public int getGems(){
        return gemCount;}
}
