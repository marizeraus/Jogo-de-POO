
package asteroids;
import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author jmsgfhr
 */
public class Player extends Play{
    
    public Shape playerShape;
    private Image player = null;
    private float playerPosX = 0;
    private float playerPosY = 0;
    private float shiftX;
    private float shiftY;
    private float angle;
    private float speed;
    public Shot tiro; // um unico tiro
    public ArrayList<Shot> shot = new ArrayList<Shot>(); //lista de tiros

    public Player(int state) {
        super(state);
    }
    
    public void init(GameContainer gc) throws SlickException{
        speed = .1f;
        player = new Image("Art/player.png");
        playerShape = new Rectangle(shiftX, shiftY, player.getWidth(), player.getHeight());
    }
    
    public void update(GameContainer gc, int delta) throws SlickException {
        Iterator<Shot> i = shot.iterator(); // itera o tiro
        while(i.hasNext()){ // verifica se tem proximo
            Shot s = i.next(); // variavel auxiliar do tipo shot
            if((s.getTime()>0)) // verifica se o tiro ainda tem tempo de vida
                s.update(gc, delta); // atualiza o tiro
            else
                i.remove(); // se o tiro nao tiver mais vida é removido
            //System.out.println(mob.getMinX());
            
        }
        shiftX = playerPosX+((gc.getWidth()/2)-(player.getWidth()/2));
        shiftY = playerPosY+((gc.getHeight()/2)-(player.getHeight()/2));
        playerShape.setLocation(shiftX, shiftY);
        
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
        g.draw(playerShape);
        
        //render do tiro do player
        for(Shot s: shot){
            //s.init(gc, player1.getPlayerPosX(), player1.getPlayerPosY());
            s.render(gc, g);
        }
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
        if(gc.getInput().isKeyDown(Input.KEY_SPACE)){ // aivador de tiro do player
            if((System.currentTimeMillis()-tickerTiro)>600){//verifica o tempo da ultima vez que atirou foi a mais de 600 milisegundos
                shot.add(new Shot(1,gc, shiftX+player.getWidth()/2, shiftY+player.getHeight()/2, angle));
                tickerTiro = System.currentTimeMillis(); // "zera" a contagem do tempo de tiro
            }
        }
    }
    
    private void moveUp(int delta){
        playerPosX -= (float) Math.cos(Math.toRadians(angle+90))*delta*speed;
        playerPosY -= (float) Math.sin(Math.toRadians(angle+90))*delta*speed;
        System.out.println(Math.cos(Math.toRadians(angle+90)));
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
    
    public ArrayList<Shot> getShot(){
        return shot;
    }
}
