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
    public Mob mob;
    
    public double tickerTiro = System.currentTimeMillis(); // tempo para o botão de atirar
    
    public Play(int state){
        
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        player1 = new Player(1);// instancia do jogador
        mob = new Mob(false);
        //tiro =  new Shot(1); // instancia do tiro
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
        //g.drawRect(0, 0, 100, 100);  x, y, width, height
        player1.init(gc);
        player1.render(gc, g);
        mob.init(gc);
        mob.render(gc, g);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        player1.commands(gc, delta);
        player1.update(gc, delta);
        
        
        
    }
    
    @Override
    public int getID(){
        return 1;
    }
}
