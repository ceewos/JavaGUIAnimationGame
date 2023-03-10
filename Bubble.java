import java.awt.*;
import java.util.Random;
public class Bubble extends Drawable{
    private int movementDirection = 2; // down to up
    public Bubble(int[] speedRange, int[] sizeRange){
        super( speedRange ,sizeRange, 2);
    }

    @Override
    public void draw(Graphics g){
        if(getPos().outOfScreen()){ 
            newDrawable(movementDirection);
        }
        int[] xy = getPos().move();
        g.setColor(Color.WHITE);
        g.drawOval(xy[0], xy[1], getSize(), getSize());
    }
    @Override
    public void setMovement(){
        Random rand = new Random();
        int x = rand.nextInt( 0,(int) getD().getWidth() );
        int speed = rand.nextInt(getSpeedRange()[0] , getSpeedRange()[1]);
        setPos ( new Move(x,getD().height, speed ,movementDirection, getD(),getSizeRange()[1]));
    }

}
