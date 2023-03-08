import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.random.*;
public abstract class Drawable{
    private int size;
    private Image skin;
    private Movable pos; // contains x,y coordinates and speed 
    private Dimension d;
    private int[] speedRange = {8,20};
    private int[] sizeRange = {50,80};
    public Drawable(Dimension d){
        this.d = d;
        
    }
    public abstract void draw(Graphics g);

}
