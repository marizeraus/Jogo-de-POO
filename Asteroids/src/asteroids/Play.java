package asteroids;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import asteroids.Player;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author jmsgfhr,(add o nome de vcs)
 */
public class Play extends BasicGameState{
    // variaveis do estado play
    public Player player1; // jogador
    private ArrayList<Mob> mob = new ArrayList<Mob>();
    
    public double tickerTiro = System.currentTimeMillis(); // tempo para o botão de atirar
    public double tickerMob = System.currentTimeMillis();
    
    public Play(int state){
        
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        player1 = new Player(1);// instancia do jogador
        player1.init(gc);
        //tiro =  new Shot(1); // instancia do tiro
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
        //g.drawRect(0, 0, 100, 100);  x, y, width, height
        player1.render(gc, g);
        for(Mob m: mob){
            m.render(gc, g);
            m.update(gc, 0);
        }
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        player1.commands(gc, delta);
        player1.update(gc, delta);
        
        //parte de colisoes prototipo para usar no futuro
        /*if(player1.playerShape.intersects(mob.mobShape))
            System.exit(0);
        ArrayList<Shot> auxShot = player1.getShot();
        Iterator<Shot> i = auxShot.iterator();
        while(i.hasNext()){
            Shot s = i.next();
            if(s.shot.intersects(mob.mobShape))
                i.remove();
        }*/
        if((System.currentTimeMillis()-tickerMob)>2000){
            mob.add(new Mob(false));
            tickerMob = System.currentTimeMillis();
        }
        Iterator<Mob> m = mob.iterator();
        while (m.hasNext()) {
            Mob next = m.next();
            ArrayList<Shot> auxShot = player1.getShot();
            Iterator<Shot> i = auxShot.iterator();
            while(i.hasNext()){
                Shot snext = i.next();
                if(next.mobShape.intersects(snext.shot)){
                    i.remove();
                    m.remove();
                }
            }
        }
    }
    
    @Override
    public int getID(){
        return 1;
    }
    
}
