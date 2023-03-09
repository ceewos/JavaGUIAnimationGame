import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
/** A simple 2D animation game where players can score points by feeding. */
public class Main extends AnimationNoApplet {

    private static final int NUM_FISH = 5;
    private static final int NUM_BUBBLE = 5;
    private ArrayList<Fish> fishes = new ArrayList<>();
    private ArrayList<Bubble> bubbles = new ArrayList<>();

    private Image backImage;

    // WRITE YOUR FIELD HERE

    public Main(String[] args) {
        super(args);
        int[] fishSpeedRange = {8,20};
        int[] fishSizeRange = {50,80};
        String[] validFishSkin = { "fish1.png", "fish2.png", "fish3.png", "fish4.png" };

        int[] bubbleSpeedRange = {18,24};
        int[] bubbleSizeRange = {10,18};

        backImage = new ImageIcon("res/feedfish/background.png").getImage();
        for(int i = 0; i < NUM_FISH; i++){
            fishes.add(new Fish(fishSpeedRange,fishSizeRange,validFishSkin));
        }

        for(int i = 0; i < NUM_BUBBLE; i++){
            bubbles.add(new Bubble(bubbleSpeedRange, bubbleSizeRange));
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
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(backImage, 0, 0 ,null);
        for(Bubble bubble : bubbles){
            System.out.println(bubble.getSize());
            bubble.draw(g);
        }
        for(Fish fish : fishes){
            fish.draw(g);
        }
    }
    // WRITE YOUR METHOD HERE

    public static void main(String[] args) {
        new Main(new String[]{"width=600", "height=700", "delay=100"}).run();
    }
}
