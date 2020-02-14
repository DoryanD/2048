import ihm.IHM;

import javax.swing.*;

public class Main
{

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            try
            {
                new IHM();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
    }

}
