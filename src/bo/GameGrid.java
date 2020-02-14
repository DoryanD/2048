package bo;

import res.Direction;

import java.util.ArrayList;
import java.util.List;

public class GameGrid
{

    private int              width;
    private int              height;
    private int              nbTilesInit;
    private List<List<Tile>> allTiles = new ArrayList<>();

    public GameGrid()
    {
        this.width = 4;
        this.height = 4;
        this.nbTilesInit = 2;
        init();
    }

    public GameGrid(int width, int height, int nbTilesInit)
    {
        this.width = width;
        this.height = height;
        this.nbTilesInit = nbTilesInit;
        init();
    }

    private void init()
    {
        for (int i = 0; i < height; i++)
        {
            List<Tile> aLine = new ArrayList<>();
            for (int k = 0; k < width; k++)
            {
                aLine.add(new Tile(k, i));
            }
            allTiles.add(aLine);
        }

        for (int j = 0; j < nbTilesInit; j++)
        {
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);
            if (allTiles.get(x).get(y).getValue() == 2)
                j--;

            allTiles.get(x).get(y).initValue();
        }

    }

    public void move(Direction direction)
    {
        switch (direction)
        {
            case DOWN:
            case RIGHT:
                for (List<Tile> allTile : allTiles)
                {
                    for (Tile t : allTile)
                    {
                        switch (direction)
                        {
                            case DOWN:
                                if (t.getY() + 1 < height)
                                {
                                    Tile t2 = getATile(t.getY() + 1, t.getX());
                                    if (t2.equals(t))
                                        t2.add(t);
                                    else if (t2.getValue() == 0)
                                    {
                                        t2.setValue(t.getValue());
                                        t.setValue(0);
                                    }
                                }
                                break;
                            case RIGHT:
                                if (t.getX() + 1 < width)
                                {
                                    Tile t2 = getATile(t.getY(), t.getX() + 1);
                                    if (t2.equals(t))
                                        t2.add(t);
                                    else if (t2.getValue() == 0)
                                    {
                                        t2.setValue(t.getValue());
                                        t.setValue(0);
                                    }
                                }
                                break;
                        }
                    }
                }
            case UP:
            case LEFT:
                for (int i = allTiles.size() - 1; i >= 0; i--)
                {
                    for (int k = allTiles.get(i).size() - 1; k >= 0; k--)
                    {
                        Tile t = allTiles.get(i).get(k);
                        switch (direction)
                        {
                            case UP:
                                if (t.getY() - 1 >= 0)
                                {
                                    Tile t2 = getATile(t.getY() - 1, t.getX());
                                    if (t2.equals(t))
                                        t2.add(t);
                                    else if (t2.getValue() == 0)
                                    {
                                        t2.setValue(t.getValue());
                                        t.setValue(0);
                                    }
                                }
                                break;
                            case LEFT:
                                if (t.getX() - 1 >= 0)
                                {
                                    Tile t2 = getATile(t.getY(), t.getX() - 1);
                                    if (t2.equals(t))
                                        t2.add(t);
                                    else if (t2.getValue() == 0)
                                    {
                                        t2.setValue(t.getValue());
                                        t.setValue(0);
                                    }
                                }
                                break;
                        }
                    }
                }
        }
        spawnATile();
    }

    private void spawnATile()
    {
        for (List<Tile> aLine :
                allTiles)
        {
            for (Tile t :
                    aLine)
            {
                if (t.getValue() == 0)
                {
                    if ((int) (Math.random() * 10) > 1)
                    {
                        t.initValue();
                        return;
                    }
                }

            }
        }
    }

    public Tile getATile(int y, int x)
    {
        return this.allTiles.get(y).get(x);
    }

    @Override
    public String toString()
    {
        String[][] toDisplay = new String[height][width];
        for (List<Tile> aLine :
                allTiles)
        {
            for (Tile t :
                    aLine)
            {
                toDisplay[t.getY()][t.getX()] = t.toString();
            }
        }

        String str = "";
        for (String[] aLine :
                toDisplay)
        {
            for (String s :
                    aLine)
            {
                str += " " + s + " ";
            }
            str += "\n";
        }
        return str;
    }

    public List<List<Tile>> getAllTiles()
    {
        return allTiles;
    }

    public void setAllTiles(List<List<Tile>> allTiles)
    {
        this.allTiles = allTiles;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getNbTilesInit()
    {
        return nbTilesInit;
    }

    public void setNbTilesInit(int nbTilesInit)
    {
        this.nbTilesInit = nbTilesInit;
    }
}
