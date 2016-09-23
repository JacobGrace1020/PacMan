package mainGame;

//Clyde
//Clyde
//Clyde
import java.awt.Color;
//teh orange that aims for pacman untill he gets within 8 tiles
//scatters to bottom left
public class Clyde extends Ghost
{
    
    public Clyde(int ex, int why)
    {
        super(ex,why);
        setColor(new Color(255, 200, 0));

    }
    
    public void act(Player p)
    {
        if(getMode().equals("Chase") && actCounter % 3 == 0)
        {
             changeTarget(p.getX(), p.getY());      
            if(Math.abs(getX()-getTargetX())<160 || Math.abs(getY()-getTargetY())<160)
            {
                changeMode("Scatter");
            }
           
        }
        else if(getMode().equals("Scatter"))
        {
             if(!(Math.abs(getX()-getTargetX())<160 && Math.abs(getY()-getTargetY())<160) && actCounter % 5 == 0)
             {
                 changeMode("Chase");
             }
             else
            changeTarget(0,640);
        }
        
        super.act(p);
    }
    

}




