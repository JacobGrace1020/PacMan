package mainGame;

//Inky
//Inky
//Inky
import java.awt.Color;
//the blue one the aims for the vector one
//scatters to bottom right
public class Inky extends Ghost
{
    private Ghost b;
    public Inky(int ex, int why, Ghost blink)
    {
        super(ex,why);
        b = blink;
        setColor(Color.CYAN);
    }
    
    public void act(Player p)
    {
        if(getMode().equals("Chase") && actCounter % 5 == 0)
        {
            int px = p.getX();
            int py = p.getY();
            int bx = b.getX();
            int by = b.getY();
            if(p.getDirection()==0)
            {
               px += 40;
            }
            if(p.getDirection()==90)
            {
                py -= 40;
            }
            if(p.getDirection()==180)
            {
                px -= 40;
            }
            if(p.getDirection()==270)
            {
                py += 40;
            }
            changeTarget(bx+(2*(px-bx)),by+(2*(py-by)));
        }
        else if(getMode().equals("Scatter"))
        {
            changeTarget(500,700);
        }
        
        super.act(p);
    }
}




