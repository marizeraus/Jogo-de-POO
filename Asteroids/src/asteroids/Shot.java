package asteroids;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author jmsgfhr
 */
public class Shot extends Player{
    
    public Shape shot = null;
    public float shotPosX = 0;
    public float shotPosY = 0;
    private float shiftShotX;
    private float shiftShotY;
    private float angle;
    private float playerPosx;
    private float playerPosy;
    private float time = 150; // vida de duração do tiro

    public Shot(int state, GameContainer gc, float posx, float posy, float angle) {
        super(state);
        this.angle = angle;
        this.playerPosx=posx;
        this.playerPosy=posy;
        shot = new Circle(shiftShotX, shiftShotY, 2);
    }
    
    @Override
    public void init(GameContainer gc){
        
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        shiftShotX = shotPosX+playerPosx;
        shiftShotY = shotPosY+playerPosy;
        shotPosX -= (float) Math.cos(Math.toRadians(angle+90))*delta*.5f;
        shotPosY -= (float) Math.sin(Math.toRadians(angle+90))*delta*.5f;
        time-= 3;
        if(playerPosx+shotPosX>900){
            shotPosX=0-playerPosx;
        }
        if(playerPosy+shotPosY>600){
            shotPosY=0-playerPosy;
        }
        if(playerPosx+shotPosX<0){
            shotPosX=gc.getWidth()-playerPosx;
        }
        if(playerPosy+shotPosY<0){
            shotPosY=gc.getHeight()-playerPosy;
        }
        shot.setLocation(shiftShotX, shiftShotY);
    }
    
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException{
        g.setColor(Color.white);
        //g.fillOval(shiftShotX, shiftShotY, 5, 5);
        g.draw(shot);
    }
    
    public float getTime(){
        return time;
    }
    
        /*float[] area = mob.getArea();
        if(((shotPosX>area[0])&&(shotPosY>area[1]))&&((shotPosX<area[2])&&(shotPosY<area[3]))){
            colisao = true;
        }*/
}