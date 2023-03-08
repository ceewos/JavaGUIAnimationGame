import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;

/** Reusable class implementing the animation idiom. */
@SuppressWarnings("serial")
public abstract class AnimationNoApplet extends NoApplet {
    
	/** Delay in milliseconds between two consecutive frames. */
	protected int delay = 10;
	
	/** Dimension of the screen. */
	protected Dimension dim;
	
    /** Refresh display once per <code>delay</code> milliseconds. */
    private Timer timer;

    protected AnimationNoApplet() {
    }

    protected AnimationNoApplet(String[] args) {
    	super(args);
    }

    /** Overridden here to initialize the animation. */
    @Override
    public final void init() {
    	dim = getSize();
    	initAnimation();
        var delay = getParameter("delay");
        if (delay != null) {
            this.delay = Integer.parseInt(delay);
        }
        timer = new Timer(this.delay, e -> repaint());
    }
    
    /** Callback to be invoked by the <code>init</code> method 
     * to perform a subclass-specific initialization. */
    protected void initAnimation() {
    }
    
    /** Overridden here to start the animation timer. */
    @Override
    public void start() {
        timer.start();
    }

    /** Overridden here to stop the animation timer. */
    @Override
    public void stop() {
        timer.stop();
    }

    public static void main(String[] args) {
        //new BouncingBallAnimation(new String[] {"width=300", "height=300"}).run();
    }
    
}
