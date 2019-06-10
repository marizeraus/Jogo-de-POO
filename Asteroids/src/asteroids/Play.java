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
    private ArrayList<Mob> mob = new ArrayList<Mob>(); // inicia a lista de asteroid
    
    public double tickerTiro = System.currentTimeMillis(); // tempo para o botão de atirar
    public double tickerMob = System.currentTimeMillis(); // tempo para spawnar o asteroid
    
    public Play(int state){
        
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        player1 = new Player(1);// instancia do jogador
        player1.init(gc); //inicia as variaveis do player
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
        player1.render(gc, g); //renderiza o player
        for(Mob m: mob){
            m.render(gc, g); //renderiza cada asteroid da lista
            m.update(gc, 0); // atualiza cada asteroid da lista
        }
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        player1.commands(gc, delta);//verifica os comandos do player
        player1.update(gc, delta);//atualiza o player
        
        if((System.currentTimeMillis()-tickerMob)>2000){//medidor de tempo para spawnar o asteroid
            Mob m = new Mob(gc); // cria um asteroid
            m.direcao(player1.getPlayerPosX(), player1.getPlayerPosY()); //define a direção do asteroid
            mob.add(m);// adiciona asteroid em uma lista de asteroid
            tickerMob = System.currentTimeMillis();// zera o tempo do asteroid
        }
        Iterator<Mob> m = mob.iterator();//itera a lista de asteroid
        while (m.hasNext()) {
            Mob next = m.next();
            ArrayList<Shot> auxShot = player1.getShot(); //cria uma lista de tiros que recebe a lista de tiros do player
            Iterator<Shot> i = auxShot.iterator();// itera a lista d tiros
            while(i.hasNext()){
                Shot snext = i.next();
                if(next.mobShape.intersects(snext.shot)){// verifica se o asteroid esta colidindo com o tiro
                    i.remove(); // remove o tiro
                    m.remove(); // remove o asteroid
                }
            }
        }
    }
    
    @Override
    public int getID(){
        return 1;
    }
    
}