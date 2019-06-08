package asteroids;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

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
    public Shape mobShape;
    
    public Mob(boolean child) throws SlickException{
        mobShape = new Circle(shiftMobX, shiftMobY, 30);
        this.mob = new Image("Art/asteroid.png");
        int pos = (int) (4 * Math.random());
        switch (pos) {
            case 0:
                mobPosX = -30;
                mobPosY = (float) (600 * Math.random());
                break;
            case 1:
                mobPosX = 930;
                mobPosY = (float) (600 * Math.random());
                break;
            case 2:
                mobPosX = (float) (900 * Math.random());
                mobPosY = -30;
                break;
            case 3:
                mobPosX = (float) (900 * Math.random());
                mobPosY = 630;
                break;
            default:
                break;
        }
        shiftMobX = mobPosX;
        shiftMobY = mobPosY;
    }
    
    public void init(GameContainer gc){
    }
    
    public void update(GameContainer gc, int delta) throws SlickException {
        //shiftMobX += velx;
        //shiftMobY += vely;
        
        if(shiftMobX>gc.getWidth()){
            shiftMobX=gc.getWidth()*(-1);
        }
        if(shiftMobY>gc.getHeight()){
            shiftMobY=gc.getHeight()*(-1);
        }
        if(shiftMobX + mob.getWidth()<0){
            shiftMobX=gc.getWidth();
        }
        if(shiftMobY + mob.getWidth()<0){
            shiftMobY=gc.getHeight();
        }
        mobShape.setLocation(shiftMobX, shiftMobY);
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException{
        mob.draw(shiftMobX,shiftMobY,1);
        g.draw(mobShape);
    }
    
    public Shape getShape(){
        return mobShape;
    }
}
