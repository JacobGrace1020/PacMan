package mainGame;

//Pinky
//Pinky
//Pinky
import java.awt.Color;
//the pink one that aims for 4 spaces ahead
//scatters to top left
public class Pinky extends Ghost
{
    
    public Pinky(int ex, int why)
    {
        super(ex,why);
        setColor(Color.PINK);

    }
    
    public void act(Player p)
    {
        if(getMode().equals("Chase") && actCounter % 5 ==0)
        {
            if(p.getDirection()==0)
            {changeTarget(p.getX()+80,p.getY());}
            if(p.getDirection()==90)
            {changeTarget(p.getX(),p.getY()-80);}
            if(p.getDirection()==180)
            {changeTarget(p.getX()-80,p.getY());}
            if(p.getDirection()==270)
            {changeTarget(p.getX(),p.getY()+80);}
        }
        else if(getMode().equals("Scatter"))
        {
            changeTarget(0,0);
        }
        
        super.act(p);
    }
    

}




