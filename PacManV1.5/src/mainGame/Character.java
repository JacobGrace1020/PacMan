package mainGame;

//Character
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;

/**
 * 
 */
public abstract class Character
{
    private int direction;
    private double speed;
    private int x;
    private int y;
    private Color color;
    
    public Character()
    {
        direction = 0;
        speed = 5.0;
    }
    
    public Character(int ex, int why){
    	direction = 0;
    	speed = 5.0;
    	x = ex;
    	y = why;
    }
    public void act()
    {
        if(getDirection() == 0 && canMove(getX(),getY(),0))
        {
            move(1,0);
        }
        else if(getDirection() == 90 && canMove(getX(),getY(),90))
        {
            move(0,-1);
        }
        else if(getDirection() == 180 && canMove(getX(),getY(),180))
        {
            move(-1,0);
        }
        else if(getDirection() == 270 && canMove(getX(),getY(),270))
        {
            move(0,1);
        }
        if(getX() == 0 && getY() <= 360 && getY() >= 300)
        {
            move(534, 0);
        }
        if(getX() == 535 && getY() <= 360 && getY() >= 300)
        {
            move(-534,0);
        }
    }
    public abstract void draw(Graphics2D g2);
    public void setColor(Color c){ color = c;}
    public Color getColor(){return color;}
    public int getX(){return x;}
    public int getY(){return y;}
    public double getSpeed(){return speed;}
    public void changeSpeed(double newSpeed){speed = newSpeed;}
    public void changeDirection(int newDirection){direction = newDirection;}
    public int getDirection(){return direction;}
    
    public void move(int dx, int dy)
    {
        x += dx;
        y += dy;
    }
    public boolean canMove(int ex, int why, int d)
    {
        //decides if they can move in a certain direction 
        ArrayList<Integer> dRay = new ArrayList<Integer>();
         for(Shape e: Walls.getWalls())
         {
            
                if(e.contains(ex+25,why+12))
                { 
                    dRay.add(0);
                }
                if(e.contains(ex,why+12))
                {
                    dRay.add(180);
                }
                if(e.contains(ex-12,why+25))
                {
                    dRay.add(270);
                }
                if(e.contains(ex+12,why))
                {
                    dRay.add(90);
                }
                
            
         }
         //if a valid direction stored in dRay = direction, return true
         for(int i = 0; i<dRay.size();i++)
         {
             if(dRay.get(i)==d)
             return false;
            }
            return true;
    }
}




