package mainGame;

//Blinky
//Blinky
//Blinky
//Blinky
//Blinky
//Blinky
import java.awt.Color;
//teh red one that aims where pacman is
//scatters to top right
public class Blinky extends Ghost
{
    
    public Blinky(int ex, int why)
    {
        super(ex,why);
        setColor(Color.RED);
    }
    
    public void act(Player p)
    {
        //System.out.println("Yay");
        
        if(getMode().equals("Chase") && actCounter % 3 == 0)
        {
            changeTarget(p.getX(), p.getY());      
            
        }
        else if(getMode().equals("Scatter"))
        {
            changeTarget(540,0);
        }
        else if(getMode().equals("Cruise Elroy"))
        {
             changeSpeed(getSpeed()*1.05);
        }
        
        super.act(p);
    }
    

}




