
package asteroids;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author jmsgfhr
 */
public class Player {
    
    Image player = null;
    float playerPosX = 0;
    float playerPosY = 0;
    float shiftX;
    float shiftY;
    float angle;
    float speed;
    
    public void init(GameContainer gc) throws SlickException {
        speed = .1f;
        player = new Image("Art/player.png");
        shiftX = playerPosX+((gc.getWidth()/2)-(player.getWidth()/2));
        shiftY = playerPosY+((gc.getHeight()/2)-(player.getHeight()/2));
    }
    
    public void update(GameContainer gc, int delta) throws SlickException {
        
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException {
        player.setRotation(angle);
        player.draw(shiftX, shiftY, 1);
        g.drawString(""+shiftX+" "+shiftY, shiftX, shiftY);
    }
    
    public void move(GameContainer gc,int delta){
        Input keyboard = gc.getInput();
        if(keyboard.isKeyDown(Input.KEY_DOWN)){
            moveDown(delta);
        }
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
    
    private void moveDown(int delta){
        playerPosY += delta * .1f;
    }
    
    private void rotateLeft(int delta){
        angle -= delta * .1f;
    }
    
    private void rotateRight(int delta){
        angle += delta * .1f;
    }
}
