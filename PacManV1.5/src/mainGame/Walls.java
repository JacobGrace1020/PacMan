package mainGame;


 
/**
 * #Walls
 * #Code
 * #WallsCode
 * @version Arc.4
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class Walls
{
	//private int x;
	//private int y;
	private static ArrayList<Shape> map;
	private static ArrayList<Pellet> pelletArray;
	private static Rectangle2D.Double board;
	public Walls()
	{
    	//x = 0;
    	//y = 0;
    	map = new ArrayList<Shape>();
    	//all drawing code here
    	board = new Rectangle2D.Double(0,0,560,720);
    	//top sides?
    	map.add(new RoundRectangle2D.Double(0,70,20,250,30,30));
    	map.add(new RoundRectangle2D.Double(0,60,560,20,30,30));
    	map.add(new RoundRectangle2D.Double(540,70,20,250,30,30));
    	//left boxes
    	map.add(new RoundRectangle2D.Double(50,110,60,40,10,10));
    	map.add(new RoundRectangle2D.Double(150,110,80,40,10,10));
    	map.add(new RoundRectangle2D.Double(50,190,60,20,10,10));
    	//right boxes
    	map.add(new RoundRectangle2D.Double(330,110,80,40,10,10));
    	map.add(new RoundRectangle2D.Double(450,110,60,40,10,10));
    	map.add(new RoundRectangle2D.Double(450,190,60,20,10,10));
    	//left top peg
    	//map.add(new RoundRectangle2D.Double(150,200,40,120,10,10)); also good, needs adjustment
    	//right top peg
    	//map.add(new RoundRectangle2D.Double(370,200,40,120,10,10)); this is the good oone, needs to be fixed
    	//middle top peg
		map.add(new RoundRectangle2D.Double(220,190,120,30,30,30));
		map.add(new RoundRectangle2D.Double(265,200,30,70,30,30));
    	//top bottom peg
		map.add(new RoundRectangle2D.Double(220,430,120,30,30,30));
    	//bottom bottom peg
		map.add(new RoundRectangle2D.Double(210,550,140,20,30,30));
		map.add(new RoundRectangle2D.Double(270,550,20,80,30,30));  
    	//tunnel
		map.add(new RoundRectangle2D.Double(10,250,100,20,30,30));
		//map.add(new RoundRectangle2D.Double(220,550,120,2,1,1)); ugh work....
//		map.add(new RoundRectangle2D.Double(20,250,70,2,1,1));
//		map.add(new RoundRectangle2D.Double(20,260,70,2,1,1));
//		map.add(new RoundRectangle2D.Double(100,270,2,40,1,1));
//		map.add(new RoundRectangle2D.Double(110,270,2,40,1,1));
//		map.add(new RoundRectangle2D.Double(0,320,90,2,1,1));
//		map.add(new RoundRectangle2D.Double(0,330,90,2,1,1));
//		map.add(new RoundRectangle2D.Double(0,370,90,2,1,1));
//		map.add(new RoundRectangle2D.Double(0,380,90,2,1,1));
//		map.add(new RoundRectangle2D.Double(100,390,2,40,1,1));
//		map.add(new RoundRectangle2D.Double(110,390,2,40,1,1));
//		map.add(new RoundRectangle2D.Double(20,440,70,2,1,1));
//		map.add(new RoundRectangle2D.Double(20,450,70,2,1,1));
//		map.add(new RoundRectangle2D.Double(470,250,70,2,1,1));
//		map.add(new RoundRectangle2D.Double(470,260,70,2,1,1));
//		map.add(new RoundRectangle2D.Double(450,270,2,40,1,1));
//		map.add(new RoundRectangle2D.Double(460,270,2,40,1,1));
//		map.add(new RoundRectangle2D.Double(470,320,90,2,1,1));
//		map.add(new RoundRectangle2D.Double(470,330,90,2,1,1));
//		map.add(new RoundRectangle2D.Double(470,370,90,2,1,1));
//		map.add(new RoundRectangle2D.Double(470,380,90,2,1,1));
//		map.add(new RoundRectangle2D.Double(450,390,2,40,1,1));
//		map.add(new RoundRectangle2D.Double(460,390,2,40,1,1));
//		map.add(new RoundRectangle2D.Double(470,440,70,2,1,1));
//		map.add(new RoundRectangle2D.Double(470,450,70,2,1,1)); 	 
   	 
        //the bottom outline
		map.add(new RoundRectangle2D.Double(0,420,20,280,30,30));
		//map.add(new RoundRectangle2D.Double(150,380,20,60,30,30)); i need to fix this later
		map.add(new RoundRectangle2D.Double(10,680,550,20,30,30));
		map.add(new RoundRectangle2D.Double(540,420,20,280,30,30));
		
//		map.add(new RoundRectangle2D.Double(0,460,2,200,1,1)); done left far
//		map.add(new RoundRectangle2D.Double(10,460,2,80,1,1));
//		map.add(new RoundRectangle2D.Double(10,580,2,80,1,1));
//		map.add(new RoundRectangle2D.Double(150,380,2,60,1,1));
//		map.add(new RoundRectangle2D.Double(170,380,2,60,1,1));
//		map.add(new RoundRectangle2D.Double(390,380,2,60,1,1));
//		map.add(new RoundRectangle2D.Double(410,380,2,60,1,1));
//		map.add(new RoundRectangle2D.Double(20,680,500,2,1,1)); done abs bottom
//		map.add(new RoundRectangle2D.Double(20,670,500,2,1,1));
//		map.add(new RoundRectangle2D.Double(20,550,20,2,1,1));
//		map.add(new RoundRectangle2D.Double(20,570,20,2,1,1));
//		map.add(new RoundRectangle2D.Double(558,460,2,200,1,1)); far right?
//		map.add(new RoundRectangle2D.Double(548,460,2,80,1,1));
//		map.add(new RoundRectangle2D.Double(548,580,2,80,1,1));
//		map.add(new RoundRectangle2D.Double(160,490,60,2,1,1));
//		map.add(new RoundRectangle2D.Double(160,510,60,2,1,1));
//		map.add(new RoundRectangle2D.Double(340,490,60,2,1,1));
//		map.add(new RoundRectangle2D.Double(340,510,60,2,1,1));
//		map.add(new RoundRectangle2D.Double(520,550,20,2,1,1));
//		map.add(new RoundRectangle2D.Double(520,570,20,2,1,1));
    	//the rook moving shape things
		map.add(new RoundRectangle2D.Double(60,490,40,2,1,1));
		map.add(new RoundRectangle2D.Double(60,510,20,2,1,1));
		map.add(new RoundRectangle2D.Double(90,520,2,40,1,1));
		map.add(new RoundRectangle2D.Double(110,500,2,60,1,1));
    	//the other one
		map.add(new RoundRectangle2D.Double(460,490,40,2,1,1));
		map.add(new RoundRectangle2D.Double(480,510,20,2,1,1));
		map.add(new RoundRectangle2D.Double(450,500,2,60,1,1));
		map.add(new RoundRectangle2D.Double(470,520,2,40,1,1));
    	//the last two stupid shapes on the botom
		map.add(new RoundRectangle2D.Double(150,550,20,75,30,30));
		map.add(new RoundRectangle2D.Double(50,610,180,20,30,30));
//		map.add(new RoundRectangle2D.Double(150,560,2,40,1,1));done
//		map.add(new RoundRectangle2D.Double(170,560,2,40,1,1));
//		map.add(new RoundRectangle2D.Double(60,610,80,2,1,1));
//		map.add(new RoundRectangle2D.Double(60,630,160,2,1,1));
//		map.add(new RoundRectangle2D.Double(180,610,40,2,1,1));
    	//
		map.add(new RoundRectangle2D.Double(390,550,20,75,30,30));
		map.add(new RoundRectangle2D.Double(330,610,180,20,30,30));
//		map.add(new RoundRectangle2D.Double(390,560,2,40,1,1));done
//		map.add(new RoundRectangle2D.Double(410,560,2,40,1,1));
//		map.add(new RoundRectangle2D.Double(340,610,40,2,1,1));
//		map.add(new RoundRectangle2D.Double(340,630,160,2,1,1));
//		map.add(new RoundRectangle2D.Double(420,610,80,2,1,1));
    	//the ghost house
		map.add(new RoundRectangle2D.Double(210,310,50,2,1,1));
		map.add(new RoundRectangle2D.Double(220,320,40,2,1,1));
		map.add(new RoundRectangle2D.Double(210,310,2,80,1,1));
		map.add(new RoundRectangle2D.Double(220,320,2,60,1,1));
		map.add(new RoundRectangle2D.Double(220,380,120,2,1,1));
		map.add(new RoundRectangle2D.Double(210,390,140,2,1,1));
		map.add(new RoundRectangle2D.Double(350,310,2,80,1,1));
		map.add(new RoundRectangle2D.Double(340,320,2,60,1,1));
		map.add(new RoundRectangle2D.Double(300,310,50,2,1,1));
		map.add(new RoundRectangle2D.Double(300,320,40,2,1,1));

   	 
    	//initialize pelletArray
    	pelletArray = new ArrayList<Pellet>();
    	//top left line of pellets
    	pelletArray.add(new Pellet(30,90));
    	pelletArray.add(new Pellet(50,90));
    	pelletArray.add(new Pellet(70,90));
    	pelletArray.add(new Pellet(90,90));
    	pelletArray.add(new Pellet(110,90));
    	pelletArray.add(new Pellet(130,90));
    	pelletArray.add(new Pellet(150,90));
    	pelletArray.add(new Pellet(170,90));
    	pelletArray.add(new Pellet(190,90));
    	pelletArray.add(new Pellet(210,90));
    	pelletArray.add(new Pellet(230,90));
    	pelletArray.add(new Pellet(250,90));
    	//top right line of pellets
    	pelletArray.add(new Pellet(310,90));
    	pelletArray.add(new Pellet(330,90));
    	pelletArray.add(new Pellet(350,90));
    	pelletArray.add(new Pellet(370,90));
    	pelletArray.add(new Pellet(390,90));
    	pelletArray.add(new Pellet(410,90));
    	pelletArray.add(new Pellet(430,90));
    	pelletArray.add(new Pellet(450,90));
    	pelletArray.add(new Pellet(470,90));
    	pelletArray.add(new Pellet(490,90));
    	pelletArray.add(new Pellet(510,90));
    	pelletArray.add(new Pellet(530,90));
    	//left upper pellets
    	pelletArray.add(new Pellet(30,110));
    	pelletArray.add(new Pellet(30,130));
    	pelletArray.add(new Pellet(30,150));
    	pelletArray.add(new Pellet(30,170));
    	pelletArray.add(new Pellet(30,190));
    	pelletArray.add(new Pellet(30,210));
    	//the rest of the second quadrant
    	pelletArray.add(new Pellet(50,170));
    	pelletArray.add(new Pellet(70,170));
    	pelletArray.add(new Pellet(90,170));
    	pelletArray.add(new Pellet(110,170));
    	pelletArray.add(new Pellet(130,170));
    	pelletArray.add(new Pellet(150,170));
    	pelletArray.add(new Pellet(170,170));
    	pelletArray.add(new Pellet(190,170));
    	pelletArray.add(new Pellet(210,170));
    	pelletArray.add(new Pellet(230,170));
    	pelletArray.add(new Pellet(250,170));
    	//
    	pelletArray.add(new Pellet(130,110));
    	pelletArray.add(new Pellet(130,130));
    	pelletArray.add(new Pellet(130,150));
    	pelletArray.add(new Pellet(130,190));
    	pelletArray.add(new Pellet(130,210));
   	 
    	//PELLETS ON BOTTOM
    	pelletArray.add(new Pellet(25,645));
    	pelletArray.add(new Pellet(45,645));
    	pelletArray.add(new Pellet(65,645));
    	pelletArray.add(new Pellet(85,645));
    	pelletArray.add(new Pellet(105,645));
    	pelletArray.add(new Pellet(125,645));
    	pelletArray.add(new Pellet(145,645));
    	pelletArray.add(new Pellet(165,645));
    	pelletArray.add(new Pellet(185,645));
    	pelletArray.add(new Pellet(205,645));
    	pelletArray.add(new Pellet(225,645));
    	pelletArray.add(new Pellet(245,645));
    	pelletArray.add(new Pellet(265,645));
    	pelletArray.add(new Pellet(285,645));
    	pelletArray.add(new Pellet(305,645));
    	pelletArray.add(new Pellet(325,645));
    	pelletArray.add(new Pellet(345,645));
    	pelletArray.add(new Pellet(365,645));
    	pelletArray.add(new Pellet(385,645));
    	pelletArray.add(new Pellet(405,645));
    	pelletArray.add(new Pellet(425,645));
    	pelletArray.add(new Pellet(445,645));
    	pelletArray.add(new Pellet(465,645));
    	pelletArray.add(new Pellet(485,645));
    	pelletArray.add(new Pellet(505,645));
    	pelletArray.add(new Pellet(525,645));
    	//ok that was teh nevry bottom
    	//now im goin to move upwards, let to right, omly doing the horz linez
    	pelletArray.add(new Pellet(25,585));
    	pelletArray.add(new Pellet(45,585));
    	pelletArray.add(new Pellet(65,585));
    	pelletArray.add(new Pellet(85,585));
    	pelletArray.add(new Pellet(105,585));
    	pelletArray.add(new Pellet(125,585));
    	pelletArray.add(new Pellet(185,585));
    	pelletArray.add(new Pellet(205,585));
    	pelletArray.add(new Pellet(225,585));
    	pelletArray.add(new Pellet(245,585));
    	pelletArray.add(new Pellet(305,585));
    	pelletArray.add(new Pellet(325,585));
    	pelletArray.add(new Pellet(345,585));
    	pelletArray.add(new Pellet(365,585));
    	pelletArray.add(new Pellet(425,585));
    	pelletArray.add(new Pellet(445,585));
    	pelletArray.add(new Pellet(465,585));
    	pelletArray.add(new Pellet(485,585));
    	pelletArray.add(new Pellet(505,585));
    	pelletArray.add(new Pellet(525,585));
    	//
    	pelletArray.add(new Pellet(25,525));
    	pelletArray.add(new Pellet(45,525));
    	pelletArray.add(new Pellet(65,525));
    	pelletArray.add(new Pellet(125,525));
    	pelletArray.add(new Pellet(145,525));
    	pelletArray.add(new Pellet(165,525));
    	pelletArray.add(new Pellet(185,525));
    	pelletArray.add(new Pellet(205,525));
    	pelletArray.add(new Pellet(225,525));
    	pelletArray.add(new Pellet(245,525));
    	pelletArray.add(new Pellet(265,525));
    	pelletArray.add(new Pellet(285,525));
    	pelletArray.add(new Pellet(305,525));
    	pelletArray.add(new Pellet(325,525));
    	pelletArray.add(new Pellet(345,525));
    	pelletArray.add(new Pellet(365,525));
    	pelletArray.add(new Pellet(385,525));
    	pelletArray.add(new Pellet(405,525));
    	pelletArray.add(new Pellet(425,525));
    	pelletArray.add(new Pellet(485,525));
    	pelletArray.add(new Pellet(505,525));
    	pelletArray.add(new Pellet(525,525));
    	//
    	pelletArray.add(new Pellet(25,465));
    	pelletArray.add(new Pellet(45,465));
    	pelletArray.add(new Pellet(65,465));
    	pelletArray.add(new Pellet(85,465));
    	pelletArray.add(new Pellet(105,465));
    	pelletArray.add(new Pellet(125,465));
    	pelletArray.add(new Pellet(145,465));
    	pelletArray.add(new Pellet(165,465));
    	pelletArray.add(new Pellet(185,465));
    	pelletArray.add(new Pellet(205,465));
    	pelletArray.add(new Pellet(225,465));
    	pelletArray.add(new Pellet(245,465));
    	pelletArray.add(new Pellet(305,465));
    	pelletArray.add(new Pellet(325,465));
    	pelletArray.add(new Pellet(345,465));
    	pelletArray.add(new Pellet(365,465));
    	pelletArray.add(new Pellet(385,465));
    	pelletArray.add(new Pellet(405,465));
    	pelletArray.add(new Pellet(425,465));
    	pelletArray.add(new Pellet(44,465));
    	pelletArray.add(new Pellet(465,465));
    	pelletArray.add(new Pellet(485,465));
    	pelletArray.add(new Pellet(505,465));
    	pelletArray.add(new Pellet(525,465));
    	//
    	//alright, now its time for some up and downyies
    	//left to right again.bottom up
    	pelletArray.add(new Pellet(25,625));
    	pelletArray.add(new Pellet(25,605));
    	pelletArray.add(new Pellet(25,505));
    	pelletArray.add(new Pellet(25,485));
    	//
    	pelletArray.add(new Pellet(65,565));
    	pelletArray.add(new Pellet(65,545));
    	//
    	pelletArray.add(new Pellet(125,565));
    	pelletArray.add(new Pellet(125,545));
    	pelletArray.add(new Pellet(125,505));
    	pelletArray.add(new Pellet(125,485));
    	//
    	pelletArray.add(new Pellet(185,565));
    	pelletArray.add(new Pellet(185,545));
    	//
    	pelletArray.add(new Pellet(245,625));
    	pelletArray.add(new Pellet(245,605));
    	pelletArray.add(new Pellet(245,485));
    	pelletArray.add(new Pellet(245,505));
    	//half way across
    	pelletArray.add(new Pellet(305,625));
    	pelletArray.add(new Pellet(305,605));
    	pelletArray.add(new Pellet(305,505));
    	pelletArray.add(new Pellet(305,485));
    	//
    	pelletArray.add(new Pellet(365,565));
    	pelletArray.add(new Pellet(365,545));
    	//
    	pelletArray.add(new Pellet(425,565));
    	pelletArray.add(new Pellet(425,545));
    	pelletArray.add(new Pellet(425,505));
    	pelletArray.add(new Pellet(425,485));
    	//
    	pelletArray.add(new Pellet(485,565));
    	pelletArray.add(new Pellet(485,545));
    	//
    	pelletArray.add(new Pellet(525,625));
    	pelletArray.add(new Pellet(525,605));
    	pelletArray.add(new Pellet(525,485));
    	pelletArray.add(new Pellet(525,505));
    	//
   	 
   	 
   	 
   	 
	}
    
	public static ArrayList<Shape> getWalls()
	{
    	return map;
	}

	public static ArrayList<Pellet> getPellets()
	{
    	return pelletArray;
	}
    
	public static void updatePellets(ArrayList<Pellet> survivors)
	{
    	pelletArray = survivors;
	}

    
	public void draw(Graphics2D g2)
	{
    	//int counter = 0;
   	 
    	g2.setColor(Color.BLACK);
    	g2.fill(board);
          	 
    	for(Shape s : map)
    	{      	 
        	g2.setColor(Color.BLUE);
        	if(s instanceof RoundRectangle2D.Double)
            	g2.fill(s);
        	else
            	g2.draw(s);
        	//counter++;
    	}
   	 
   	 
	}
	public void drawPellets(Graphics2D g2)
	{
   	 
    	for(Pellet p: pelletArray)
    	{
        	p.draw(g2);
    	}
	}
}









