import bo.GameGrid;
import res.Direction;

public class Main
{
    static GameGrid gg = new GameGrid();

    public static void main(String[] args)
    {

        show();

        gg.move(Direction.UP);

        show();

        gg.move(Direction.LEFT);

        show();

    }

    public static void show()
    {
        System.out.println("------------\n");
        System.out.println(gg);
        System.out.println("------------");
    }

}
