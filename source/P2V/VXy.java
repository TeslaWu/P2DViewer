package P2V;

/**
 * The {@code VXy} class represents a pair of {@code Variable} objects.
 * @author Telsa
 */
public class VXy
{
    /**
     * The x {@code Variable} in the pair.
     */
    public Variable x;

    /**
     * The y {@code Variable} in the pair.
     */
    public Variable y;

    /**
     * Constructs a {@code VXy} with the given x and y values.
     *
     * @param x the x value of the pair
     * @param y the y value of the pair
     */
    public VXy(float x, float y)
    {
        this.x=new Variable(x);
        this.y=new Variable(y);
    }

    /**
     * Constructs a {@code VXy} with the given x and y values and animation mode.
     *
     * @param x the x value of the pair
     * @param y the y value of the pair
     * @param animationMode the animation mode of the pair
     */
    public VXy(float x, float y, int animationMode)
    {
        this.x=new Variable(x,animationMode);
        this.y=new Variable(y,animationMode);
    }

    /**
     * Constructs a {@code VXy} with the given x and y {@code Variable} objects.
     *
     * @param x the x {@code Variable} of the pair
     * @param y the y {@code Variable} of the pair
     */
    public VXy(Variable x, Variable y)
    {
        this.x=x.copy();
        this.y=y.copy();
    }

    /**
     * Creates and returns a copy of this {@code VXy}.
     *
     * @return a copy of this {@code VXy}
     */
    public VXy copy()
    {
        Variable rx=x.copy();
        Variable ry=y.copy();
        return new VXy(rx,ry);
    }

    /**
     * Modifies the x and y values of this {@code VXy} and triggers their {@code AnimationController}s.
     *
     * @param x the new x value
     * @param y the new y value
     */
    public void toMoveXY(float x, float y)
    {
        this.x.toMoveValue(x);
        this.y.toMoveValue(y);
    }

    /**
     * Modifies the x and y values of this {@code VXy} based on their old values and triggers their {@code AnimationController}s.
     *
     * @param x the offset x value based on the old x value
     * @param y the offset y value based on the old y value
     */
    public void toMoveXYRelatively(float x,float y)
    {
        this.x.toMoveValueRelatively(x);
        this.y.toMoveValueRelatively(y);
    }

    /**
     * Prints the x and y values of this {@code VXy} to the console.
     */
    public void printXyValue()
    {
        System.out.println(x.value+","+y.value);
    }

    /**
     * Prints the actual x and y values of this {@code VXy} to the console.
     */
    public void printXyActualValue()
    {
        System.out.println(x.actualValue+","+y.actualValue);
    }

    /**
     * Sets the animation mode of the x and y {@code Variable}s in this {@code VXy}.
     *
     * @param mode the new animation mode
     */
    public void setAnimationMode(int mode)
    {
        x.animationMode = mode;
        y.animationMode = mode;
    }
}