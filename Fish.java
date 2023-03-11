import java.awt.*;
import java.util.Random;
public class Fish extends Drawable{
    private int movementDirection = 0; // left to right
    private Candy candy;
    private int width;
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
        g.drawImage(getSkin(), xy[0], xy[1], this.width, getSize(),null);
    }
    public boolean checkCollision(){
        //fish
        int x = getPos().x;
        int y = getPos().y;
        int size = getSize();
        //candy
        int candySize = candy.getSize();
        int xCandy = candy.getPos().x + candySize/2;
        int yCandy = candy.getPos().y + candySize/2;
        //check if the candy collided with fish
        //make sure to not count self as collision if already collided and falling ( getPos().movementTypeIndx != 1 )
        if(yCandy >= y && yCandy <= y+size && getPos().movementTypeIndx != 1 ){ 
            if(xCandy >= x && xCandy  <= x+width){
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
        this.width = (int) ( getSize() + getSize()/1.6) ;
        setPos ( new Move(600,y,speed ,movementDirection,getD(),getSizeRange()[1]));
    }
    ///set Collison movement
    public void collisionMovement(){
        int speed = candy.getSpeed() - 10;
        //movement type index changes from current position to right into current position to down
        setPos ( new Move(getPos().x,getPos().y,speed ,1,getD(),getSizeRange()[1]));
    }
    
}