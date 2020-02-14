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



    public void setEndValue(int endValue)
    {
        this.endValue = endValue;
    }
}
