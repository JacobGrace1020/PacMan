package mainGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import javax.sound.sampled.*;
import java.io.*;
/**
 * The actual game
 */
public class GameUnit
{
	static int score = 0;
	static int highscore;
	static int counter;

	public static void pelletScore()
	{
		score+=10;
	}
	public static void superPelletScore()
	{
		score+=50;
	}
	public static void main(String[] args) throws InterruptedException
	{
		final JFrame frame = new JFrame("PacMan");
		//final JPanel panel = new JPanel();//idk what this was for?
		frame.setSize(600, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final Player pacman = new Player(280,520);
		final Pinky pinky = new Pinky(310,340);
		final Blinky blinky = new Blinky(280,280);
		final Inky inky = new Inky(240,340,blinky);
		final Clyde clyde = new Clyde(265,340);
		final Walls walls = new Walls();
		final Ghost[] ghosts = {inky, pinky, blinky, clyde};
		


		Ghost.changeAllModes(ghosts,"Chase");


		class Key extends KeyAdapter
		{
			public void keyPressed(KeyEvent e)
			{

				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					pacman.changeDirection(270);                
				}
				else if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					pacman.changeDirection(90);                 
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					pacman.changeDirection(180);                
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					pacman.changeDirection(0);              
				}


			}
		}

		final Key m = new Key();
		frame.addKeyListener(m);

		class Component extends JComponent
		{
			/**
			 * idk what this is for, but it suggested that i do this
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				walls.draw(g2);
				walls.drawPellets(g2);
				pacman.draw(g2);
				//inky.draw(g2);
				//pinky.draw(g2);
				//blinky.draw(g2);
				//clyde.draw(g2);
				Font f = new Font("high",Font.BOLD,30);
				g2.setFont(f);
				g2.setColor(Color.WHITE);
				//g2.drawString("HIGH SCORE: "+highscore,150,30);
				//g2.drawString("SCORE: "+score,150,60);
				if(Walls.getPellets().size() == 0)
				{
					g2.setFont(f);
					g2.setColor(Color.WHITE);
					g2.drawString("YOU WIN",150,280);
					System.out.println("YOU WIN!!!!!!");
					System.out.println("for now...");
					try{
						File endForNow = new File("pacman_intermission.wav");
						AudioInputStream audioIn = AudioSystem.getAudioInputStream(endForNow);
						Clip clip = AudioSystem.getClip();
						clip.open(audioIn);
						clip.start();
					}
					catch(UnsupportedAudioFileException a){a.printStackTrace();}
					catch(IOException io){io.printStackTrace();}
					catch(LineUnavailableException l){l.printStackTrace();}
					try{
						Thread.sleep(5500);
					}catch(InterruptedException i){}
					System.exit(0);
				}
			}
		}

		final Component comp = new Component();
		frame.add(comp);


		try{
			File beginning = new File("pacman_beginning.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(beginning);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		}
		catch(UnsupportedAudioFileException a){a.printStackTrace();}
		catch(IOException io){io.printStackTrace();}
		catch(LineUnavailableException l){l.printStackTrace();}
		frame.repaint();
		frame.setVisible(true);
		Thread.sleep(3500);

		class MyCounter implements ActionListener
		{
			//int dx=1;
			//int dy=1;
			public void actionPerformed(ActionEvent e)
			{
				pacman.act(ghosts);
				//System.out.println(pacman.getY());
				//ghost movement
				blinky.act(pacman);
				pinky.act(pacman);
				inky.act(pacman);
				clyde.act(pacman);

				//get pacman's direction and move

				highscore = counter;
				counter++;                
				frame.repaint();
			}
		}
		Timer t = new Timer(15, new MyCounter());
		t.start();



		frame.repaint();
		frame.setVisible(true);
	}
}




