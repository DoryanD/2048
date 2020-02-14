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

    public int move(Direction direction)
    {
        int ret = 0;
        for (int k = 0; k < width; k++)
        {
            switch (direction)
            {

                case UP:
                    for (int i = 0; i < allTiles.size(); i++)
                    {
                        for (int j = 0; j < allTiles.get(i).size(); j++)
                        {
                            Tile t = allTiles.get(i).get(j);
                            if (i - 1 >= 0)
                            {
                                Tile t2 = getATile(i - 1, j);
                                if (t2.equals(t))
                                {
                                    ret += t2.add(t);
                                }
                                else if (t2.getValue() == 0)
                                {
                                    t2.setValue(t.getValue());
                                    t.setValue(0);
                                    ret += 0;
                                }
                            }

                        }
                    }
                    break;
                case LEFT:
                    for (int i = 0; i < allTiles.size(); i++)
                    {
                        for (int j = 0; j < allTiles.get(i).size(); j++)
                        {
                            Tile t = allTiles.get(i).get(j);

                            if (j - 1 >= 0)
                            {
                                Tile t2 = getATile(i, j - 1);
                                if (t2.equals(t))
                                {
                                    ret += t2.add(t);
                                }
                                else if (t2.getValue() == 0)
                                {
                                    t2.setValue(t.getValue());
                                    t.setValue(0);
                                    ret += 0;
                                }
                            }
                        }
                    }
                    break;
                case RIGHT:
                    for (int i = 0; i < allTiles.size(); i++)
                    {
                        for (int j = allTiles.get(i).size() - 1; j >= 0; j--)
                        {
                            Tile t = allTiles.get(i).get(j);
                            if (j + 1 < width)
                            {
                                Tile t2 = getATile(i, j + 1);
                                if (t2.equals(t))
                                {
                                    ret += t2.add(t);
                                }
                                else if (t2.getValue() == 0)
                                {
                                    t2.setValue(t.getValue());
                                    t.setValue(0);
                                    ret += 0;
                                }
                            }
                        }
                    }
                    break;
                case DOWN:
                    for (int i = allTiles.size() - 1; i >= 0; i--)
                    {
                        for (int j = 0; j < allTiles.get(i).size(); j++)
                        {
                            Tile t = allTiles.get(i).get(j);
                            if (i + 1 < height)
                            {
                                Tile t2 = getATile(i + 1, j);
                                if (t2.equals(t))
                                {
                                    ret += t2.add(t);
                                }
                                else if (t2.getValue() == 0)
                                {
                                    t2.setValue(t.getValue());
                                    t.setValue(0);
                                    ret += 0;
                                }
                            }
                        }
                    }
                    break;
            }
        }

        Tile aTile = allTiles.get((int) (Math.random() * height)).get((int) (Math.random() * width));
        while (aTile.getValue() != 0)
            aTile = allTiles.get((int) (Math.random() * height)).get((int) (Math.random() * width));
        aTile.initValue();

        return ret;
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

        String str = "|";
        for (int i = 0; i < toDisplay.length; i++)
        {
            for (int j = 0; j < toDisplay[i].length; j++)
            {
                str += " " + toDisplay[i][j] + " ";
            }
            str += "|" + (i == toDisplay.length - 1 ? "" : "\n|");
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
