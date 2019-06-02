
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
    
    public void init(GameContainer gc) throws SlickException {
        player = new Image("Art/player.png");
        shiftX = playerPosX+((gc.getWidth()/2)-(player.getWidth()/2));
        shiftY = playerPosY+((gc.getHeight()/2)-(player.getHeight()/2));
    }
    
    public void update(GameContainer gc, int delta) throws SlickException {
        
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException {
        player.draw(shiftX, shiftY, 1);
    }
    
}
