package asteroids;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import asteroids.Player;
/**
 *
 * @author jmsgfhr,(add o nome de vcs)
 */
public class Play extends BasicGameState{
    
    public Player player;
    
    public Play(int state){
        
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
        g.drawRect(0, 0, 100, 100); // x, y, width, height
        player = new Player();
        player.init(gc);
        player.render(gc, g);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        
    }
    
    @Override
    public int getID(){
        return 1;
    }
}
