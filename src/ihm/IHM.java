package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IHM extends JFrame
{

    private Long startTime;
    private Long animationDuration = 10l;
    private boolean isRunning = true;

    public IHM() throws InterruptedException
    {
        super("Snake");
        this.setSize(800,800);
        addWindowListener(new WindowAdapter()
                          {
                              public void windowClosing(WindowEvent e)
                              {
                                  isRunning = false;
                                  System.out.println("coucou");
                                  dispose(); System.exit(0);
                              }
                          }
        );

        this.setLocationRelativeTo(null);
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
                if(e.getKeyChar() == 'z'){
                    Render();
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {

            }
        });

        this.Render();

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

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        Rectangle r =g.getClipBounds();
        System.out.println(r.getHeight());
        System.out.println(r.getWidth());
        g.setClip(r);
        g.fillRect(700, 5, 95, 95);
        System.out.println("test");
    }
}
