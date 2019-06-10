package asteroids;

import static java.lang.Math.abs;
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
    private float velx = 0;
    private float vely = 0;
    public Shape mobShape;
    private int child;
    
    public Mob(GameContainer gc) throws SlickException{
        mobShape = new Circle(shiftMobX, shiftMobY, 30);
        this.mob = new Image("Art/asteroid.png");
        int pos = (int) (4 * Math.random());
        switch (pos) {
            case 0:
                mobPosX = -mob.getWidth();
                mobPosY = (float) (600 * Math.random());
                break;
            case 1:
                mobPosX = gc.getWidth() + mob.getWidth();
                mobPosY = (float) (600 * Math.random());
                break;
            case 2:
                mobPosX = (float) (900 * Math.random());
                mobPosY = -mob.getHeight();
                break;
            case 3:
                mobPosX = (float) (900 * Math.random());
                mobPosY = gc.getHeight() + mob.getHeight();
                break;
            default:
                break;
        }
        shiftMobX = mobPosX + mob.getWidth()/2;
        shiftMobY = mobPosY + mob.getHeight()/2;
    }
    
    public void init(GameContainer gc){
    }
    
    public void update(GameContainer gc, int delta) throws SlickException {
        shiftMobX += velx;
        shiftMobY += vely;
        
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
    
    public void direcao(float playerx, float playery){
        //float h = (float) sqrt(( pow(playerx, 2)) + pow(playery, 2));
        if(playerx>shiftMobX ) velx = (float) (abs(playerx - shiftMobX))/(60*5);    
        else if(playerx<shiftMobX ) velx = (float) -(abs(playerx - shiftMobX)/(60*5));
        if(playery>shiftMobY) vely = (float) (abs(playery - shiftMobY))/(60*5);
        else if(playery<shiftMobY) vely = (float) -((abs(playery - shiftMobY))/(60*5));
        //System.out.println("" + shiftMobX +" " + shiftMobY +" "+ playerx +" " + playery + " " + velx + " " + vely);
    }
    
}