package asteroids;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author jmsgfhr
 */
public class Mob {
    private Image mob;
    private float mobPosX = 0;
    private float mobPosY = 0;
    private float shiftMobX;
    private float shiftMobY;
    
    public Mob(boolean child) throws SlickException{
        this.mob = new Image("Art/asteroid.png");
        shiftMobX = (float) ((Math.random() * ((960 - (-60)) + 1)) + (-60));
        shiftMobY = (float) ((Math.random() * ((660 - (-60)) + 1)) + (-60));
        
    }
    
    public void init(GameContainer gc){
    }
    
    public void update(GameContainer gc, int delta) throws SlickException {
        
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException{
        mob.draw(shiftMobX,shiftMobY,1);
    }
}
