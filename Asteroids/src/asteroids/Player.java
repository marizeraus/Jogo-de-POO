
package asteroids;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author jmsgfhr
 */
public class Player extends Play{
    private Image player = null;
    private float playerPosX = 0;
    private float playerPosY = 0;
    private float shiftX;
    private float shiftY;
    private float angle;
    private float speed;

    public Player(int state) {
        super(state);
    }
    
    public void init(GameContainer gc) throws SlickException{
        speed = .1f;
        player = new Image("Art/player.png");
        shiftX = playerPosX+((gc.getWidth()/2)-(player.getWidth()/2));
        shiftY = playerPosY+((gc.getHeight()/2)-(player.getHeight()/2));
    }
    
    public void update(GameContainer gc, int delta) throws SlickException {
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException {
        if(playerPosX>470){
            playerPosX=-470;
        }
        if(playerPosY>330){
            playerPosY=-330;
        }
        if(playerPosX<-470){
            playerPosX=470;
        }
        if(playerPosY<-330){
            playerPosY=330;
        }
        player.setRotation(angle);
        player.draw(shiftX, shiftY, 1);
        g.drawString(""+playerPosX+" "+playerPosY, shiftX, shiftY);
    }
    
    public void commands(GameContainer gc,int delta){
        Input keyboard = gc.getInput();
        if(keyboard.isKeyDown(Input.KEY_UP)){
            moveUp(delta);
        }
        if(keyboard.isKeyDown(Input.KEY_LEFT)){
            rotateLeft(delta);
        }
        if(keyboard.isKeyDown(Input.KEY_RIGHT)){
            rotateRight(delta);
        }
        
    }
    
    private void moveUp(int delta){
        playerPosX -= (float) Math.cos(Math.toRadians(angle+90))*delta*speed;
        playerPosY -= (float) Math.sin(Math.toRadians(angle+90))*delta*speed;
    }
    
    private void rotateLeft(int delta){
        angle -= delta * .1f;
    }
    
    private void rotateRight(int delta){
        angle += delta * .1f;
    }
    
    /*public void moveAtrito(int delta){
        playerPosX -= (float) Math.cos(Math.toRadians(angle+90))*delta*speed;
        playerPosY -= (float) Math.sin(Math.toRadians(angle+90))*delta*speed;
    }*/
    
    public float getPlayerPosX(){
        return shiftX+player.getWidth()/2; // centro da nave
    }
    
    public float getPlayerPosY(){
        return shiftY+player.getHeight()/2; // centro da nave
    }
    
    public float getAngle(){
        return angle;
    }
}
