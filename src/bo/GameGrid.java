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
        this.nbTilesInit = 3;
    }

    public GameGrid(int width, int height, int nbTilesInit)
    {
        this.width = width;
        this.height = height;
        this.nbTilesInit = nbTilesInit;
    }

    public void init()
    {
        for (int i = 0; i < width; i++)
        {
            List<Tile> aLine = new ArrayList<>();
            for (int k = 0; k < height; k++)
            {
                aLine.add(new Tile(i, k));
            }
            allTiles.add(aLine);
        }

        for (int j = 0; j < nbTilesInit; j++)
        {
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);
            allTiles.get(x).get(y).initValue();
        }

    }

    public void move(Direction direction)
    {
        for (List<Tile> aLine :
                allTiles)
        {
            for (Tile t :
                    aLine)
            {
                switch (direction)
                {

                    case UP:
                        if(t.getCoordinates().getY() - 1 >= 0)
                            t.addToY(-1);
                        break;
                    case RIGHT:
                        if(t.getCoordinates().getX() + 1 < width)
                            t.addToX(1);
                        break;
                    case DOWN:
                        if(t.getCoordinates().getY() + 1 < height)
                            t.addToY(1);
                        break;
                    case LEFT:
                        if(t.getCoordinates().getX() - 1 >= 0)
                            t.addToX(-1);
                        break;
                }
            }
        }
    }

    @Override
    public String toString()
    {
        String[][] toDisplay = new String[width][height];
        for (List<Tile> aLine :
                allTiles)
        {
            for (Tile t :
                    aLine)
            {
                toDisplay[t.getX()][t.getY()] = t.toString();
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
