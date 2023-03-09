import java.awt.Dimension;
public class Movable {
    int x;
    int y;
    int speed;
    int movementTypeIndx;
    int maxSize;
    Dimension dimension;
    String[] movements = {"scrollLeftRight","scrollUpDown","scrollDownUp"};
    public Movable(int x, int y, int speed, int movementTypeIndx, Dimension d){  // for candy 
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dimension = d;
        this.movementTypeIndx = movementTypeIndx;
        this.maxSize = 0;
    }
    public Movable(int x, int y, int speed, int movementTypeIndx, Dimension d, int maxSize){ //for fishes 
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dimension = d;
        this.movementTypeIndx = movementTypeIndx;
        this.maxSize = maxSize;
    }
    public int[] move(){
        if(movementTypeIndx == 0){
           scrollLeftRight();
        }else if(movementTypeIndx == 1){
            scrollUpDown();
        }else{
            scrollDownUp();
        }
        int[] coords = {this.x, this.y};
        return coords ;
    }
    public void scrollLeftRight(){// 0 
        if(outOfScreen()){
            this.x = (int) dimension.getWidth();
        }
        this.x -= speed; 
    }
    public void scrollUpDown(){ // 1
        if(outOfScreen()){
            this.y = 40;
        }
        this.y += speed;

    }
    public void scrollDownUp(){ //2
        if(outOfScreen()){
            this.y = (int) dimension.getHeight();
        }
        this.y -= speed; 
    }

    public boolean outOfScreen(){
        if(this.x < 0 - maxSize || this.y > dimension.getHeight() + maxSize || this. x > dimension.getWidth() + maxSize|| this.y < 0 - maxSize ){
            return true;
        }
        return false;
    }
    
    //bubbles move down to up
    //fishes move right to left
    //candy moves up to down
}
