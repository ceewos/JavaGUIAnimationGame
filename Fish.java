import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.random.*;
public class Fish extends Drawable{
    private int movementDirection = 0; // left to right
    private Candy candy;
    public Fish(int[] speedRange, int[] sizeRange, String[] validSkins, Candy candy){
        super( speedRange ,sizeRange, validSkins, 0);
        this.candy = candy;
    }
    @Override
    public void draw(Graphics g){
        if( checkCollision()){
            collisionMovement();
        }
        if(getPos().outOfScreen()){ 
            newDrawable(0);
        }
        int[] xy = getPos().move();
        g.drawImage(getSkin(), xy[0], xy[1], getSize() + getSize()/3, getSize(),null);
    }
    public boolean checkCollision(){
        int x = getPos().x;
        int y = getPos().y;
        int size = getSize();
        if(candy.getPos().y >= y && candy.getPos().y <= y+size-1 && getPos().movementTypeIndx != 1 ){ //make sure to not count a fish that's already collided and falling
            if(candy.getPos().x >= x && candy.getPos().x <= x+size-1){
                return true;
            }
        }
        return false;
    }
    @Override
    public void setMovement(){
        Random rand = new Random();
        int y = rand.nextInt( (int) getD().getHeight()/2 , (int) getD().getHeight() - 70 );
        int speed = rand.nextInt(getSpeedRange()[0] , getSpeedRange()[1]);
        setPos ( new Movable(600,y,speed ,movementDirection,getD(),getSizeRange()[1]));
    }
    ///set Collison movement
    public void collisionMovement(){
        int speed = candy.getSpeed() - 10;
        setPos ( new Movable(getPos().x,getPos().y,speed ,1,getD(),getSizeRange()[1]));
    }
    
}