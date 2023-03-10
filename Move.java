import java.awt.Dimension;
public class Move {
    int x;
    int y;
    int speed;
    int movementTypeIndx;
    int maxSize;
    Dimension dimension;
    String[] movements = {"scrollLeftRight","scrollUpDown","scrollDownUp"};
    //Constructor used by candy
    public Move(int x, int y, int speed, int movementTypeIndx, Dimension d){ 
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dimension = d;
        this.movementTypeIndx = movementTypeIndx;
        this.maxSize = 0;
    }
    //Constructor used by fishes
    public Move(int x, int y, int speed, int movementTypeIndx, Dimension d, int maxSize){ 
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
    //set coordinates to move based on entered moving pattern 0,1,2
    // 0: fishes move left -> right
    // 1: candy moves up -> down
    // 2: bubbles move down -> up
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
    //detects if coordinates have gone out of viewing range
    public boolean outOfScreen(){
        if(this.x < 0 - maxSize || this.y > dimension.getHeight() + maxSize || this. x > dimension.getWidth() + maxSize|| this.y < 0 - maxSize ){
            return true;
        }
        return false;
    }
    
}
