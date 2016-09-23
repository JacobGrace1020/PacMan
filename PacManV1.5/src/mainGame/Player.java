package mainGame;

//Player
//Player
//Player
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Player extends Character
{
    private Ellipse2D.Double pacman;
    private int ps;
    public Player(int ex, int why)
    {
        super(ex,why);
        pacman = new Ellipse2D.Double(getX(),getY(), 25, 25);
        setColor(new Color(255,239,0));
        ps = 0;
        //move(280,520);
    }
    public void act(Ghost[] toBeScared)
    {
        super.act();
        ArrayList<Pellet> pellets = Walls.getPellets();
        for(int i = 0; i < pellets.size(); i++)
        {
            if(pacman.intersects(pellets.get(i).getEllipse().getBounds2D()))
            {
                if(pellets.get(i) instanceof SuperPellet)
                {
                    Ghost.changeAllModes(toBeScared, "Scared");
                    GameUnit.superPelletScore();
                }
                else
                {
                    GameUnit.pelletScore();
                }
                pellets.remove(i);
                ps++;
                i--;
                if(ps % 2 == 1)
                {
                    try{
                        File waka = new File("pacman_chomp.wav");
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(waka);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioIn);
                        clip.start();
                    }
                    catch(UnsupportedAudioFileException a){a.printStackTrace();}
                    catch(IOException io){io.printStackTrace();}
                    catch(LineUnavailableException l){l.printStackTrace();}
                }
                
            }
            Walls.updatePellets(pellets);
        }
    }
    public void draw(Graphics2D g2)
    {
        pacman = new Ellipse2D.Double(getX(),getY(), 25, 25);
        g2.setColor(getColor());
        g2.fill(pacman);
    }
    public Ellipse2D.Double getEllipse()
    {
        return pacman;
    }
    public void die() throws InterruptedException
    {
        try{
                File death = new File("pacman_death.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(death);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            }
            catch(UnsupportedAudioFileException a){a.printStackTrace();}
            catch(IOException io){io.printStackTrace();}
            catch(LineUnavailableException l){l.printStackTrace();}
        System.out.println("dead");
        Thread.sleep(2500);
        System.exit(0);
    }
    
}


