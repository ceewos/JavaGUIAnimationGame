import javax.swing.*;
import java.awt.*;
import java.util.Random;
public abstract class Drawable{
    private int speed;
    private int size;
    private Image skin; 
    private Move pos; // position, contains x,y coordinates,speed and next coordinates for movement // Movable
    private Dimension d;
    private int[] speedRange;
    private int[] sizeRange;
    private String[] validSkins = {};
    //drawable constructor used by fish
    public Drawable(int[] speedRange, int[] sizeRange, String[] validSkins, int movementDirection){
        this.d = new Dimension(600,700);
        this.speedRange = speedRange;
        this.sizeRange = sizeRange;
        this.validSkins = validSkins;
        newDrawable(movementDirection);
    }
    //drawable constructor used by Bubble
    public Drawable(int[] speedRange, int[] sizeRange, int movementDirection){
        this.d = new Dimension(600,700);
        this.speedRange = speedRange;
        this.sizeRange = sizeRange;
        newDrawable(movementDirection);
    }
    //drawable constructor used by Candy
    public Drawable(String skin, int speed){
        this.speed = speed;
        this.d = new Dimension(600,700);
        this.skin = new ImageIcon( "res/feedfish/"+skin ).getImage();
        this.size =this.skin.getWidth(null);
        setMovement();
    }
    
    public void newDrawable(int movementDirection){ 
        //re-pick and or re-size image 
        Random rand = new Random(); 
        if(this.sizeRange != null){
            this.size = rand.nextInt(sizeRange[0] , sizeRange[1]);
        }else{
            this.size = 20;
        }
        if(validSkins.length > 0){
            this.skin = new ImageIcon( "res/feedfish/"+validSkins[ rand.nextInt(0,validSkins.length )] ).getImage();
        }
        setMovement();
    }

    public abstract void setMovement();
    public abstract void draw(Graphics g);    
    //-----------------------------------------------GETTERS/SETTERS---------------------------------------------------
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public Image getSkin() {
        return skin;
    }
    public void setSkin(Image skin) {
        this.skin = skin;
    }
    public Move getPos() {
        return pos;
    }
    public void setPos(Move pos) {
        this.pos = pos;
    }
    public Dimension getD() {
        return d;
    }
    public void setD(Dimension d) {
        this.d = d;
    }
    public int[] getSpeedRange() {
        return speedRange;
    }
    public void setSpeedRange(int[] speedRange) {
        this.speedRange = speedRange;
    }
    public int[] getSizeRange() {
        return sizeRange;
    }
    public void setSizeRange(int[] sizeRange) {
        this.sizeRange = sizeRange;
    }

}
