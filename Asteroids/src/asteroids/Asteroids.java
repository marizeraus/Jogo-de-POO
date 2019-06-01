
package asteroids;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
/**
 * quando iniciarem o projeto vá em propriedades do projeto e alterem o local do slick
 * @author jmsgfhr,(add o nome de vcs)
 */
public class Asteroids extends StateBasedGame{

    public static final String gamename = "Asteroids";
    public static final int menu = 0;
    public static final int play = 1;
    
    public Asteroids(String gamename){
        super(gamename);
        this.addState(new Menu(menu));
        this.addState(new Play(play));
    }
    
    public void initStatesList(GameContainer gc) throws SlickException{
        this.getState(menu).init(gc, this);
        this.getState(menu).init(gc, this);
        this.enterState(menu);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new Asteroids(gamename));
            appgc.setDisplayMode(640, 360, false);
            appgc.start();
        } catch (SlickException e){
            e.printStackTrace();
        }
    }
    
}
