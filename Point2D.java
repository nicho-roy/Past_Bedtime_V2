import lang.stride.*;

/**
 * 
 */
public class Point2D
{
    private double x;
    private double y;

    /**
     * 
     */
    public Point2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     */
    public double getX()
    {
        return x;
    }

    /**
     * 
     */
    public double getY()
    {
        return y;
    }

    /**
     * 
     */
    public void add(Vector2D v)
    {
        x = x + v.getX();
        y = y + v.getY();
    }
}

