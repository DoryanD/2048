import bo.GameGrid;
import bo.Tile;

import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        GameGrid gg = new GameGrid();
        gg.init();

        System.out.println("------------\n");
        System.out.println(gg);
        System.out.println("------------");

    }

}
