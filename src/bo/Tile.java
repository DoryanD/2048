package bo;

public class Tile
{

    private int         value;
    private Coordinates coordinates;

    public Tile(int x, int y)
    {
        this.coordinates = new Coordinates(x, y);
    }

    public int add(Tile t)
    {
        this.setValue(t.getValue() + this.getValue());
        t.setValue(0);
        return this.getValue();
    }

    public void initValue()
    {
        int val = (int) (Math.random() * 100);
        val = val <= 75 ? 2 : 4;
        this.value = val;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Tile)) return false;
        if(this.value == 0 || ((Tile) obj).getValue() == 0) return false;
        return this.value == ((Tile) obj).getValue();
    }

    @Override
    public String toString()
    {
        return "" + (value == 0 ? " " : value);
    }

    public Coordinates getCoordinates()
    {
        return coordinates;
    }

    public void setX(int x)
    {
        this.coordinates.setX(x);
    }

    public void setY(int y)
    {
        this.coordinates.setX(y);
    }

    public int getX()
    {
        return this.coordinates.getX();
    }

    public int getY()
    {
        return this.coordinates.getY();
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
