package res;

public enum Direction
{

    UP("up", 1),
    RIGHT("right", 2),
    DOWN("down", 3),
    LEFT("left", 4);

    String name;
    int index;

    Direction(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    @Override
    public String toString()
    {
        return "Direction{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

}
