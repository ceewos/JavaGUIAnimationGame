import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
/** A simple 2D animation game where players can score points by feeding. */
public class Main extends AnimationNoApplet { //Main works as controller

    private static final int NUM_FISH = 5;
    private static final int NUM_BUBBLE = 40;
    private ArrayList<Fish> fishes = new ArrayList<>();
    private ArrayList<Bubble> bubbles = new ArrayList<>();
    private Candy candy;
    private Image backImage;
    private int score = 0;


    public Main(String[] args) {
        super(args);
        int candySpeed = 35;
        candy = new Candy("candy.png",candySpeed);
        int[] fishSpeedRange = {8,17};
        int[] fishSizeRange = {50,80};
        String[] validFishSkin = { "fish1.png", "fish2.png", "fish3.png", "fish4.png" };

        int[] bubbleSpeedRange = {18,29};
        int[] bubbleSizeRange = {4,10};
        

        backImage = new ImageIcon("res/feedfish/background.png").getImage();
        for(int i = 0; i < NUM_FISH; i++){
            fishes.add(new Fish(fishSpeedRange,fishSizeRange,validFishSkin,candy));
        }
        for(int i = 0; i < NUM_BUBBLE; i++){
            bubbles.add(new Bubble(bubbleSpeedRange, bubbleSizeRange));
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dropCandy();
            }
        });
        repaint();
    }

    /** Called when the mouse is clicked to drop a candy. */
    private void dropCandy() {
        if (candy.moving() != true){ //only play sound and set moving to true if candies already not falling
            play("res/feedfish/drop.ogg");
            candy.setMoving(true);
        }
        // WRITE YOUR CODE HERE
    }
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(backImage, 0, 0 ,null);
        for(Bubble bubble : bubbles){
            bubble.draw(g);
        }
        g.setColor(Color.WHITE);
        g.drawString("Score: "+score, getWidth()-70, 20);
        for(Fish fish : fishes){
            if( fish.checkCollision()){
                score++;
                play("res/feedfish/woohoo.wav");
            }
            fish.draw(g);
        }
        candy.draw(g);
    }
    // WRITE YOUR METHOD HERE

    public static void main(String[] args) {
        new Main(new String[]{"width=600", "height=700", "delay=70"}).run();
    }
}
