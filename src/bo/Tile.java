package bo;

public class Tile
{

    private int value;
    private Coordinates coordinates;

    public Tile(int x, int y)
    {
        this.coordinates = new Coordinates(x, y);
    }

    public void add(Tile c)
    {
        this.setValue(c.getValue() + this.getValue());
    }

    public void initValue()
    {
        this.value = 2;
    }

    @Override
    public String toString()
    {
        return "" + value;//(value == 0 ? " " : value);
    }

    public Coordinates getCoordinates()
    {
        return coordinates;
    }

    public int getX()
    {
        return this.coordinates.getX();
    }

    public int getY()
    {
        return this.coordinates.getY();
    }


    public void addToX(int val)
    {
        this.coordinates.setX(this.coordinates.getX() + val);
    }

    public void addToY(int val)
    {
        this.coordinates.setY(this.coordinates.getY() + val);
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

}
