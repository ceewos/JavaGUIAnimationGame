import java.awt.*;
public class Candy extends Drawable{
    private boolean moving = false;
    public Candy( String skin, int speed){
        super(skin, speed);
    }
    public void drawStill(Graphics g){
        int[] xy = {40,40};
        g.drawImage(getSkin(), xy[0], xy[1], null);
    }
    @Override
    public void draw(Graphics g){
        if(!moving){
            drawStill(g);
        }else{
            if(getPos().outOfScreen()){ 
                newDrawable(1);
                this.moving = false;
            }
           
            int[] xy = getPos().move();
            g.drawImage(getSkin(), xy[0], xy[1], null);
        }
    }
    @Override
    public void setMovement(){
        setPos ( new Movable(40,40,getSpeed() , 1 ,getD(),getSize()));
        //movementDirection = 1 -> up to down
    }

    public boolean moving() {
        return moving;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}