import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.random.*;
public abstract class Drawable{
    private int size;
    private Image skin;
    private Movable pos; // contains x,y coordinates and speed 
    private Dimension d;
    private int[] speedRange;
    private int[] sizeRange;
    private String[] validSkins = {};
    public Drawable(int[] speedRange, int[] sizeRange, String[] validSkins, int movementDirection){
        this.d = new Dimension(600,700);
        this.speedRange = speedRange;
        this.sizeRange = sizeRange;
        this.validSkins = validSkins;
        newDrawable(movementDirection);
    }
    public Drawable(int[] speedRange, int[] sizeRange, int movementDirection){
        this.d = new Dimension(600,700);
        this.speedRange = speedRange;
        this.sizeRange = sizeRange;
        newDrawable(movementDirection);
    }
    
    public Drawable(Dimension d){
        this.d = d;
    }

    public void newDrawable(int movementDirection){ // reWrite image
        Random rand = new Random(); 
        this.size = rand.nextInt(sizeRange[0] , sizeRange[1]);
        if(validSkins.length > 0){
            this.skin = new ImageIcon( "res/feedfish/"+validSkins[ rand.nextInt(0,validSkins.length )] ).getImage();
        }
        setMovement();
    }

    public abstract void setMovement();
    public abstract void draw(Graphics g);
    
    //---------GET---SET-----------
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
    public Movable getPos() {
        return pos;
    }
    public void setPos(Movable pos) {
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
