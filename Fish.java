import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.random.*;
public class Fish {//extends Drawable{
    private int size;
    private Image skin;
    private Movable pos; // contains x,y coordinates and speed 
    private Dimension d;
    private int[] speedRange = {8,20};
    private int[] sizeRange = {50,80};
    private String[] validSkins = { "fish1.png", "fish2.png", "fish3.png", "fish4.png" };

    public Fish(){
        //super(new Dimension(600,700));
        this.d = new Dimension(600,700);
        newFish();
    }
    public Fish(Dimension d){ 
        //super();
        this.d = d;
        newFish();
    }
    public void newFish(){ // if a fish goes out of bounds on the screen the fish is recreated with different params
        Random rand = new Random();
        this.size = rand.nextInt(sizeRange[0] , sizeRange[1]);
        this.skin = new ImageIcon( "res/feedfish/"+validSkins[ rand.nextInt(0,validSkins.length )] ).getImage();
        int speed = rand.nextInt(speedRange[0] , speedRange[1]);
        int y = rand.nextInt( (int) d.getHeight()/2 , (int) d.getHeight() - 40 );
        this.pos = new Movable(600,y,speed,0,d,sizeRange[1]);
    }
    //@Override
    public void draw(Graphics g){
        if(pos.outOfScreen()){ 
            newFish();
        }
        int[] xy = pos.move();
        g.drawImage(skin, xy[0], xy[1], size + size/3, size,null);
    }

}