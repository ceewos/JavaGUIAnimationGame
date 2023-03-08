import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
/** A simple 2D animation game where players can score points by feeding. */
public class Main extends AnimationNoApplet {

    private static final int NUM_FISH = 5;
    private ArrayList<Fish> fishes = new ArrayList<>();
    private Image backImage;

    // WRITE YOUR FIELD HERE

    public Main(String[] args) {
        super(args);
        backImage = new ImageIcon("res/feedfish/background.png").getImage();
        for(int i = 0; i < NUM_FISH; i++){
            fishes.add(new Fish());
        }
        repaint();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dropCandy();
            }
        });
    }

    /** Called when the mouse is clicked to drop a candy. */
    private void dropCandy() {
        
        // WRITE YOUR CODE HERE
    }

    protected void paintComponent(Graphics g){
        g.drawImage(backImage, 0, 0 ,null);
        for(Fish fish : fishes){
            fish.draw(g);
        }
        // JLabel label = new JLabel(); //JLabel Creation
        // label.setIcon(skin); //Sets the image to be displayed as an icon
        // label.setBounds(position[0], position[1], 10, 10); //Sets the location of the image
        // add(label);
    }
    // WRITE YOUR METHOD HERE

    public static void main(String[] args) {
        new Main(new String[]{"width=600", "height=700", "delay=100"}).run();
    }
}
