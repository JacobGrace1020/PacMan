package mainGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
//pellet color== 250,200,170
public class Pellet
{
	static Color col = new Color(250,200,170);
	private Ellipse2D.Double p;
	public Pellet(int ex,int why)
	{
     	p = new Ellipse2D.Double(ex,why,5,5);
	}
    
	public Pellet(int ex,int why, int d)
	{
    	p = new Ellipse2D.Double(ex,why,d,d);
	}
    
	public Ellipse2D.Double getEllipse()
	{
    	return p;
	}
    
	public void draw(Graphics2D g2)
	{
    	g2.setColor(col);
    	g2.fill(p);
	}
}







