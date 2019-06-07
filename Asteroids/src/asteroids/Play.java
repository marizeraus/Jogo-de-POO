package asteroids;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import asteroids.Player;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author jmsgfhr,(add o nome de vcs)
 */
public class Play extends BasicGameState{
    // variaveis do estado play
    public Player player1; // jogador
    public Shot tiro; // um unico tiro
    public ArrayList<Shot> shot = new ArrayList<Shot>(); //lista de tiros
    public double ticker = System.currentTimeMillis(); // tempo para o botão de atirar
    
    public Play(int state){
        
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        player1 = new Player(1);// instancia do jogador
        //tiro =  new Shot(1); // instancia do tiro
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
        //g.drawRect(0, 0, 100, 100);  x, y, width, height
        player1.init(gc);
        player1.render(gc, g);
        for(Shot s: shot){
            //s.init(gc, player1.getPlayerPosX(), player1.getPlayerPosY());
            s.render(gc, g);
        }
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        player1.commands(gc, delta);
        //tiro.update(gc, delta);
        Iterator<Shot> i = shot.iterator();
        while(i.hasNext()){
            Shot s = i.next();
            if(s.getTime()>0)
                s.update(gc, delta);
            else
                i.remove();
        }
        
        if(gc.getInput().isKeyDown(Input.KEY_SPACE)){
            if((System.currentTimeMillis()-ticker)>600){//verifica o tempo da ultima vez que atirou foi a mais de 600 milisegundos
                shot.add(new Shot(1,gc, player1.getPlayerPosX(), player1.getPlayerPosY(), player1.getAngle()));
                ticker = System.currentTimeMillis(); // "zera" a contagem do tempo de tiro
            }
        }
    }
    
    @Override
    public int getID(){
        return 1;
    }
}
