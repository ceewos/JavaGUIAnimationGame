import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.random.*;
public class Fish extends Drawable{
    private int movementDirection = 0; // left to right
    public Fish(int[] speedRange, int[] sizeRange, String[] validSkins){
        super( speedRange ,sizeRange, validSkins, 0);
    }
    @Override
    public void draw(Graphics g){
        if(getPos().outOfScreen()){ 
            newDrawable(0);
        }
        int[] xy = getPos().move();
        g.drawImage(getSkin(), xy[0], xy[1], getSize() + getSize()/3, getSize(),null);
    }
    @Override
    public void setMovement(){
        Random rand = new Random();
        int y = rand.nextInt( (int) getD().getHeight()/2 , (int) getD().getHeight() - 40 );
        int speed = rand.nextInt(getSpeedRange()[0] , getSpeedRange()[1]);
        setPos ( new Movable(600,y,speed ,movementDirection,getD(),getSizeRange()[1]));
    }
}