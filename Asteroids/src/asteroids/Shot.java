package asteroids;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author jmsgfhr
 */
public class Shot extends Player{
    
    Image shot = null;
    float shotPosX = 0;
    float shotPosY = 0;
    float shiftShotX;
    float shiftShotY;

    public Shot(int state) {
        super(state);
    }
    
    
    
    @Override
    public void init(GameContainer gc) throws SlickException{
        shot = new Image("Art/beam.png");
        shiftShotX = this.getPlayerPosX()+((gc.getWidth()/2)-(shot.getWidth()/2));
        shiftShotY = this.getPlayerPosY()+((gc.getHeight()/2)-(shot.getHeight()/2));
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        while(true){
            shotPosX -= (float) Math.cos(Math.toRadians(this.getAngle()+90))*delta*.2f;
            shotPosY -= (float) Math.sin(Math.toRadians(this.getAngle()+90))*delta*.2f;
        }
    }
    
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException{
        shot.draw(shiftShotX,shiftShotY,1);
        g.drawString(""+shiftShotX+" "+shiftShotY, shiftShotX, shiftShotY);
    }
    
}
