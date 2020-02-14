import bo.GameManager;
import res.Direction;

public class Main
{

    static GameManager gm = new GameManager();

    public static void main(String[] args)
    {
        gm.newGame(4, 4, 2, 2048);
        show();
        System.out.println("Score : " + gm.moveTo(Direction.RIGHT));
        show();
        System.out.println("Score : " + gm.moveTo(Direction.LEFT));
        show();
        System.out.println("Score : " + gm.moveTo(Direction.UP));
        show();
        System.out.println("Score : " + gm.moveTo(Direction.UP));
        show();
        System.out.println("Score : " + gm.moveTo(Direction.DOWN));
        show();
        System.out.println("Score : " + gm.moveTo(Direction.LEFT));
        show();
        System.out.println("Score : " + gm.moveTo(Direction.RIGHT));
        show();
        System.out.println("Score : " + gm.moveTo(Direction.LEFT));
        show();
        System.out.println("Score : " + gm.moveTo(Direction.RIGHT));
        show();
        System.out.println("Score : " + gm.moveTo(Direction.RIGHT));
        show();
    }

    public static void show()
    {
        System.out.println("  -  -  -  -");
        System.out.println(gm.getGameGrid());
        System.out.println("  -  -  -  -");
    }

}
