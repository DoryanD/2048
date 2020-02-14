package ihm;

import bo.GameGrid;
import bo.GameManager;
import res.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class IHM extends JFrame
{

    private GameManager gm;
    private GameGrid                   grid;
    private Long                       startTime;
    private Long                       animationDuration = 10l;
    private boolean                    isRunning         = true;

    public IHM() throws InterruptedException
    {
        super("2048");
        this.setSize(800, 800);
        addWindowListener(new WindowAdapter()
                          {
                              public void windowClosing(WindowEvent e)
                              {
                                  dispose();
                                  System.exit(0);
                              }
                          }
        );

        this.setLocationRelativeTo(null);
        gm = new GameManager();
        gm.newGame();
        grid = gm.getGameGrid();
        Panel panel = new Panel(gm);

        this.setContentPane(panel);

        this.getContentPane().setPreferredSize(new Dimension(800,800));
        this.pack();
        this.setVisible(true);

        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyChar() == 'z')
                {
                    grid.move(Direction.UP);
                    repaint();
                }
                else if(e.getKeyChar() == 's'){
                    grid.move(Direction.DOWN);
                    repaint();
                }
                else if(e.getKeyChar() == 'd'){
                    grid.move(Direction.RIGHT);
                    repaint();
                }
                else if(e.getKeyChar() == 'q'){
                    grid.move(Direction.LEFT);
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {

            }
        });

        //this.Render();

        /*this.startTime = System.currentTimeMillis();


        SwingUtilities.invokeLater(() ->
        {
            try
            {
                runAnimation();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });*/

    }

    /*private void runAnimation() throws InterruptedException{
        while(isRunning){

            long currentTime = System.nanoTime ();
            long deltaTime += (currentTime - lastLoopTime) / OPTIMAL_TIME;
            lastLoopTime = currentTime;


            //Thread.sleep(100);
            System.out.println("tick");
            //System.out.println("test");
            //repaint();
        }
    }*/

    private void Render()
    {
        repaint();
    }
}
