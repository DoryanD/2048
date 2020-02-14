package bo;

import res.Direction;

import java.util.List;

public class GameManager
{

    private GameGrid gameGrid;
    private int      score    = 0;
    private boolean  win      = false;
    private int      endValue = 2048;

    public void newGame()
    {
        gameGrid = new GameGrid(4, 4, 2);
        score = 0;
        win = false;
        this.endValue = 2048;
    }

    public void newGame(int width, int height, int nbInit)
    {
        gameGrid = new GameGrid(width, height, nbInit);
        score = 0;
        win = false;
        this.endValue = 2048;
    }

    public void newGame(int width, int height, int nbInit, int endValue)
    {
        gameGrid = new GameGrid(width, height, nbInit);
        score = 0;
        win = false;
        this.endValue = endValue;
    }

    public int moveTo(Direction direction)
    {
        int val = gameGrid.move(direction);
        score += val;
        win = val >= endValue;
        return score;
    }

    public GameGrid getGameGrid()
    {
        return gameGrid;
    }

    public int getScore()
    {
        return score;
    }

    public boolean isWin()
    {
        return win;
    }

    public boolean isLoose()
    {
        boolean ret = false;

        for (int i = 0; i < gameGrid.getAllTiles().size(); i++)
        {
            for (int j = 0; j < gameGrid.getAllTiles().get(i).size(); j++)
            {
                Tile t = gameGrid.getAllTiles().get(i).get(j);
                if(i - 1 >= 0)
                    ret |= t.equals(gameGrid.getAllTiles().get(i - 1).get(j));
                if(i + 1 < gameGrid.getAllTiles().size())
                    ret |= t.equals(gameGrid.getAllTiles().get(i + 1).get(j));
                if(j + 1 < gameGrid.getAllTiles().get(i).size())
                    ret |= t.equals(gameGrid.getAllTiles().get(i).get(j + 1));
                if(j - 1 >= 0)
                    ret |= t.equals(gameGrid.getAllTiles().get(i).get(j - 1));
            }
        }

        return ret;
    }

    public void setEndValue(int endValue)
    {
        this.endValue = endValue;
    }
}
