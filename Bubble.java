import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.random.*;
public class Bubble extends Drawable{
    private int movementDirection = 2; // down to up
    public Bubble(int[] speedRange, int[] sizeRange, String[] validSkins){
        super( speedRange ,sizeRange, validSkins, 2);
    }
    public Bubble(int[] speedRange, int[] sizeRange){
        super( speedRange ,sizeRange, 2);
    }
    @Override
    public void draw(Graphics g){
        if(getPos().outOfScreen()){ 
            newDrawable(2);
        }
        int[] xy = getPos().move();
        g.setColor(Color.WHITE);
        g.drawOval(xy[0], xy[1], getSize(), getSize());
    }
    @Override
    //    public Movable(int x, int y, int speed, int movementTypeIndx, Dimension d, int maxSize){ //for fishes 
    public void setMovement(){
        Random rand = new Random();
        int x = rand.nextInt( 0,(int) getD().getWidth() );
        int speed = rand.nextInt(getSpeedRange()[0] , getSpeedRange()[1]);
        setPos ( new Movable(x,getD().height, speed ,movementDirection, getD(),getSizeRange()[1]));
    }

}
