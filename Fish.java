import java.awt.*;
import java.util.Random;
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
            //if candy collides with fish, make fish go down
            collisionMovement();
            //increase a score in candy to keep track of how many fish candy has hit
            candy.increaseScore();
        }
        if(getPos().outOfScreen()){ 
            //if fish is out of visible range, then remake fish skin, size, and speed, and place at a random position in the bottom right half of the screen
            newDrawable(movementDirection);
        }
        int[] xy = getPos().move();
        g.drawImage(getSkin(), xy[0], xy[1], getSize() + getSize()/3, getSize(),null);
    }
    public boolean checkCollision(){
        int x = getPos().x;
        int y = getPos().y;
        int size = getSize();
        //check if the candy collided with self
        //make sure to not count self as collision if already collided and falling ( getPos().movementTypeIndx != 1 )
        if(candy.getPos().y >= y && candy.getPos().y <= y+size-1 && getPos().movementTypeIndx != 1 ){ 
            if(candy.getPos().x >= x && candy.getPos().x <= x+size-1){
                return true;
            }
        }
        return false;
    }
    @Override
    public void setMovement(){
        //setMovement is called by newDrawable in super class, after newDrawable gives fish a new skin and size
        //setMoveent then resets and randomizes fishes position and speed 
        Random rand = new Random();
        int y = rand.nextInt( (int) getD().getHeight()/2 , (int) getD().getHeight() - 70 );
        int speed = rand.nextInt(getSpeedRange()[0] , getSpeedRange()[1]);
        setPos ( new Movable(600,y,speed ,movementDirection,getD(),getSizeRange()[1]));
    }
    ///set Collison movement
    public void collisionMovement(){
        int speed = candy.getSpeed() - 10;
        //movement type index changes from current position to right into current position to down
        setPos ( new Movable(getPos().x,getPos().y,speed ,1,getD(),getSizeRange()[1]));
    }
    
}