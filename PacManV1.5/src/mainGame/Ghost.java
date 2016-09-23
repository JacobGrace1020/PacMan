package mainGame;

//Ghost
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

/**
 * A general Ghost
 * including (and limited to) Inky, Blinky, Pinky, and Clyde
 */
public class Ghost extends Character
{
    private int targetX;
    private int targetY;
    private String mode;
    private Ellipse2D.Double ghost;
    public int actCounter = 0;
    
    public Ghost(int ex, int why)
    {
        super(ex,why);
        ghost = new Ellipse2D.Double(getX(),getY(),25,25);
        mode = "Chase";
    }
    public void act(Player p)
    {
        actCounter++;
        //System.out.println(actCounter);
        if(actCounter < 500 && this.getColor() != Color.RED){
        	this.changeTarget(0, 50);
        	//this is an attempt at making the ghosts get out of the box
        }
        if(getMode().equals("Scared"))
        {
            setColor(Color.BLUE);
            Random ran = new Random();
            int determiner = ran.nextInt(4);
            if(canMove(getX(),getY(),90*determiner))
                changeDirection(90*determiner);
        }
        else
        {
            ArrayList<Recty> recties2 = checkDistance(getX(),getY(),getTargetX(),getTargetY());
            int one = recties2.get(0).getDir();
            int two = recties2.get(1).getDir();
            int tree = recties2.get(2).getDir();
            int four = recties2.get(3).getDir();

            if(canMove(getX(),getY(),one))
            {
                changeDirection(one);
            }
            else if(canMove(getX(),getY(),two))
            {
                changeDirection(two);
            }
            else if(canMove(getX(),getY(),tree))
            {
                changeDirection(tree);
            }
            else if(canMove(getX(),getY(),four))
            {
                changeDirection(four);
            }
            else
            {
                changeDirection((getDirection() + 90) % 360);
            }
        }
        super.act();
        if(ghost.intersects(p.getEllipse().getBounds2D()))
        {            
           // this is where i die // try{p.die();}catch(InterruptedException i){};
        }
        
    }
    public void draw(Graphics2D g2)
    {
        ghost = new Ellipse2D.Double(getX(),getY(), 25, 25);
        g2.setColor(getColor());
        g2.fill(ghost);
    }
    public String getMode()
    {
        return mode;
    }
    public int getTargetX()
    {
        return targetX;
    }
    public int getTargetY()
    {
        return targetY;
    }
    public void changeTarget(int newTargetX, int newTargetY)
    {
        targetX = newTargetX;
        targetY = newTargetY;
    }
    public void changeMode(String newMode)
    {
        changeDirection(getDirection() + 90);
        mode = newMode;
    }
    public static void changeAllModes(Ghost[] ghosts, String newMode)
    {
        for(int i = 0; i < ghosts.length; i++)
        {
            ghosts[i].changeMode(newMode);
        }
    }
    public ArrayList<Recty> checkDistance(double myX,double myY,double tX,double tY)
    {
        //this is going to find whitch direction is the shortest
        //and then return an array of the options from shortest to longest
        double horz = myX-tX;
        double vert = myY-tY;
        Recty l = new Recty(180);
        Recty r = new Recty(0);
        Recty u = new Recty(90);
        Recty d = new Recty(270);
        ArrayList<Recty> recties = new ArrayList<Recty>();
        //this crap still sorts the array
        if(horz>0)
        {
            if(vert<0)
            {
                if(Math.abs(horz)<Math.abs(vert))
                {
                    recties.add(l);
                    recties.add(d);
                    recties.add(r);
                    recties.add(u);
                }
                else{
                    recties.add(d);
                    recties.add(l);
                    recties.add(u);
                    recties.add(r);
                }
                
            }
            else
            {
                if(Math.abs(horz)<Math.abs(vert))
                {
                    recties.add(l);
                    recties.add(u);
                    recties.add(r);
                    recties.add(d);
                }
                else{
                    recties.add(u);
                    recties.add(l);
                    recties.add(d);
                    recties.add(r);
                }
            }
        }
        else
        {
            if(vert<0)
            {
                if(Math.abs(horz)<Math.abs(vert))
                {
                    recties.add(r);
                    recties.add(d);
                    recties.add(l);
                    recties.add(u);
                }
                else{recties.add(d);
                    recties.add(r);
                    recties.add(u);
                    recties.add(l);
                }
            }
            else
            {
                if(Math.abs(horz)<Math.abs(vert))
                {
                    recties.add(r);
                    recties.add(u);
                    recties.add(l);
                    recties.add(d);
                }
                else{recties.add(u);
                    recties.add(r);
                    recties.add(d);
                    recties.add(l);
                }
            }
        }
            
        return recties;
    }
    public boolean canMove(int ex, int why, int d)
    {
        if(d == getDirection()+180)
            return false;
        else 
            return super.canMove(ex,why,d);        
    }
}
