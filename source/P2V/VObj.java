package P2V;

/**
 * VObj is an abstract class that serves as a base for all visual objects in the application.
 * It provides a number of properties that are common to all visual objects, such as position, width, height,
 * fill color, stroke color, stroke weight, and an id.
 * @author Telsa
 */
public abstract class VObj {
    /**
     * The position of the visual object.
     */
    protected VXy Posi;

    /**
     * The width of the visual object.
     */
    protected Variable Widt;

    /**
     * The height of the visual object.
     */
    protected Variable Heit;

    /**
     * The red component of the fill color for the visual object.
     */
    protected Variable fillR;

    /**
     * The green component of the fill color for the visual object.
     */
    protected Variable fillG;

    /**
     * The blue component of the fill color for the visual object.
     */
    protected Variable fillB;

    /**
     * The alpha component of the fill color for the visual object.
     */
    protected Variable fillA;

    /**
     * The flag indicating whether the visual object is filled or not.
     */
    protected boolean noFill;

    /**
     * The red component of the stroke color for the visual object.
     */
    protected Variable stroR;

    /**
     * The green component of the stroke color for the visual object.
     */
    protected Variable stroG;

    /**
     * The blue component of the stroke color for the visual object.
     */
    protected Variable stroB;

    /**
     * The alpha component of the stroke color for the visual object.
     */
    protected Variable stroA;

    /**
     * The flag indicating whether the visual object has a stroke or not.
     */
    protected boolean noStro;

    /**
     * The stroke weight for the visual object.
     */
    protected Variable stroWei;

    /**
     * The unique identifier for the visual object.
     */
    protected int id;

    /**
     * The counter for generating unique identifiers for visual objects.
     */
    protected static int idct;

    /**
     * Sets the width of the visual object with a Variable instance.
     *
     * @param widt The width to set.
     * @throws Exception If setting the width fails for some reason.
     */
    public void setWidt(Variable widt) throws Exception {
        Widt = widt;
    }

    /**
     * Sets the width of the visual object with a float value.
     *
     * @param x The width to set.
     * @throws Exception If setting the width fails for some reason.
     */
    public void setWidt(float x) throws Exception {
        Widt.setActualValue(x);
    }

    /**
     * Moves the width of the visual object by a certain amount relatively.
     *
     * @param x The amount by which to move the width.
     * @throws Exception If moving the width fails for some reason.
     */
    public void toMoveWidtRelatively(float x) throws Exception {
        Widt.toMoveValueRelatively(x);
    }

    /**
     * Moves the width of the visual object by a certain amount.
     *
     * @param x The amount by which to move the width.
     * @throws Exception If moving the width fails for some reason.
     */
    public void toMoveWidt(float x) throws Exception {
        Widt.toMoveValue(x);
    }

    /**
     * Sets the position of the visual object with a VXy instance.
     *
     * @param posi The position to set.
     * @throws Exception If setting the position fails for some reason.
     */
    public void setPosi(VXy posi) throws Exception {
        Posi = posi;
    }

    /**
     * Sets the position of the visual object with two float values.
     *
     * @param x The x-coordinate to set.
     * @param y The y-coordinate to set.
     * @throws Exception If setting the position fails for some reason.
     */
    public void setPosi(float x, float y) throws Exception {
        Posi.x.setActualValue(x);
        Posi.y.setActualValue(y);
    }

    /**
     * Moves the position of the visual object by certain amounts.
     *
     * @param x The amount by which to move the x-coordinate.
     * @param y The amount by which to move the y-coordinate.
     * @throws Exception If moving the position fails for some reason.
     */
    public void toMovePosi(float x, float y) throws Exception {
        Posi.x.toMoveValue(x);
        Posi.y.toMoveValue(y);
    }

    /**
     * Moves the position of the visual object by a certain amount defined by a VXy instance.
     *
     * @param xy The VXy instance defining the amounts by which to move the coordinates.
     * @throws Exception If moving the position fails for some reason.
     */
    public void toMovePosi(VXy xy) throws Exception {
        Posi.x.toMoveValue(xy.x.actualValue);
        Posi.y.toMoveValue(xy.y.actualValue);
    }

    /**
     * Moves the width of the visual object by a Variable instance.
     *
     * @param widt The amount by which to move the width.
     * @throws Exception If moving the width fails for some reason.
     */
    public void toMoveWidt(Variable widt) throws Exception {
        Widt.toMoveValue(widt.actualValue);
    }

    /**
     * Moves the height of the visual object by a Variable instance.
     *
     * @param heit The amount by which to move the height.
     * @throws Exception If moving the height fails for some reason.
     */
    public void toMoveHeit(Variable heit) throws Exception {
        Heit.toMoveValue(heit.actualValue);
    }

    /**
     * Moves the red component of the fill color for the visual object by a Variable instance.
     *
     * @param fillR The amount by which to move the red component of the fill color.
     * @throws Exception If moving the red component fails for some reason.
     */
    public void toMoveFillR(Variable fillR) throws Exception {
        this.fillR.toMoveValue(fillR.actualValue);
    }

    /**
     * Moves the green component of the fill color for the visual object by a Variable instance.
     *
     * @param fillG The amount by which to move the green component of the fill color.
     * @throws Exception If moving the green component fails for some reason.
     */
    public void toMoveFillG(Variable fillG) throws Exception {
        this.fillG.toMoveValue(fillG.actualValue);
    }

    /**
     * Moves the blue component of the fill color for the visual object by a Variable instance.
     *
     * @param fillB The amount by which to move the blue component of the fill color.
     * @throws Exception If moving the blue component fails for some reason.
     */
    public void toMoveFillB(Variable fillB) throws Exception {
        this.fillB.toMoveValue(fillB.actualValue);
    }

    /**
     * Moves the alpha component of the fill color for the visual object by a Variable instance.
     *
     * @param fillA The amount by which to move the alpha component of the fill color.
     * @throws Exception If moving the alpha component fails for some reason.
     */
    public void toMoveFillA(Variable fillA) throws Exception {
        this.fillA.toMoveValue(fillA.actualValue);
    }

    /**
     * Moves the red component of the stroke color for the visual object by a Variable instance.
     *
     * @param stroR The amount by which to move the red component of the stroke color.
     * @throws Exception If moving the red component fails for some reason.
     */
    public void toMoveStroR(Variable stroR) throws Exception {
        this.stroR.toMoveValue(stroR.actualValue);
    }

    /**
     * Moves the green component of the stroke color for the visual object by a Variable instance.
     *
     * @param stroG The amount by which to move the green component of the stroke color.
     * @throws Exception If moving the green component fails for some reason.
     */
    public void toMoveStroG(Variable stroG) throws Exception {
        this.stroG.toMoveValue(stroG.actualValue);
    }

    /**
     * Moves the blue component of the stroke color for the visual object by a Variable instance.
     *
     * @param stroB The amount by which to move the blue component of the stroke color.
     * @throws Exception If moving the blue component fails for some reason.
     */
    public void toMoveStroB(Variable stroB) throws Exception {
        this.stroB.toMoveValue(stroB.actualValue);
    }

    /**
     * Moves the alpha component of the stroke color for the visual object by a Variable instance.
     *
     * @param stroA The amount by which to move the alpha component of the stroke color.
     * @throws Exception If moving the alpha component fails for some reason.
     */
    public void toMoveStroA(Variable stroA) throws Exception {
        this.stroA.toMoveValue(stroA.actualValue);
    }

    /**
     * Moves the stroke weight for the visual object by a Variable instance.
     *
     * @param stroWei The amount by which to move the stroke weight.
     * @throws Exception If moving the stroke weight fails for some reason.
     */
    public void toMoveStroWei(Variable stroWei) throws Exception {
        this.stroWei.toMoveValue(stroWei.actualValue);
    }

    /**
     * Moves the position of the visual object by a certain amount relatively.
     *
     * @param x The amount by which to move the x-coordinate.
     * @param y The amount by which to move the y-coordinate.
     * @throws Exception If moving the position fails for some reason.
     */
    public void toMovePosiRelatively(float x, float y) throws Exception {
        Posi.x.toMoveValueRelatively(x);
        Posi.y.toMoveValueRelatively(y);
    }

    /**
     * Retrieves the position of the visual object.
     *
     * @return The position of the visual object.
     * @throws Exception If retrieving the position fails for some reason.
     */
    public VXy getPosi() throws Exception {
        return Posi;
    }

    /**
     * Retrieves the width of the visual object.
     *
     * @return The width of the visual object.
     * @throws Exception If retrieving the width fails for some reason.
     */
    public Variable getWidt() throws Exception {
        return Widt;
    }

    /**
     * Retrieves the height of the visual object.
     *
     * @return The height of the visual object.
     * @throws Exception If retrieving the height fails for some reason.
     */
    public Variable getHeit() throws Exception {
        return Heit;
    }

    /**
     * Retrieves the red component of the fill color for the visual object.
     *
     * @return The red component of the fill color.
     * @throws Exception If retrieving the red component fails for some reason.
     */
    public Variable getFillR() throws Exception {
        return fillR;
    }

    /**
     * Retrieves the green component of the fill color for the visual object.
     *
     * @return The green component of the fill color.
     * @throws Exception If retrieving the green component fails for some reason.
     */
    public Variable getFillG() throws Exception {
        return fillG;
    }

    /**
     * Retrieves the blue component of the fill color for the visual object.
     *
     * @return The blue component of the fill color.
     * @throws Exception If retrieving the blue component fails for some reason.
     */
    public Variable getFillB() throws Exception {
        return fillB;
    }

    /**
     * Retrieves the alpha component of the fill color for the visual object.
     *
     * @return The alpha component of the fill color.
     * @throws Exception If retrieving the alpha component fails for some reason.
     */
    public Variable getFillA() throws Exception {
        return fillA;
    }

    /**
     * Checks if the visual object is filled.
     *
     * @return True if the visual object is filled, false otherwise.
     * @throws Exception If checking the fill status fails for some reason.
     */
    public boolean isNoFill() throws Exception {
        return noFill;
    }

    /**
     * Retrieves the red component of the stroke color for the visual object.
     *
     * @return The red component of the stroke color.
     * @throws Exception If retrieving the red component fails for some reason.
     */
    public Variable getStroR() throws Exception {
        return stroR;
    }

    /**
     * Retrieves the green component of the stroke color for the visual object.
     *
     * @return The green component of the stroke color.
     * @throws Exception If retrieving the green component fails for some reason.
     */
    public Variable getStroG() throws Exception {
        return stroG;
    }

    /**
     * Retrieves the blue component of the stroke color for the visual object.
     *
     * @return The blue component of the stroke color.
     * @throws Exception If retrieving the blue component fails for some reason.
     */
    public Variable getStroB() throws Exception {
        return stroB;
    }

    /**
     * Retrieves the alpha component of the stroke color for the visual object.
     *
     * @return The alpha component of the stroke color.
     * @throws Exception If retrieving the alpha component fails for some reason.
     */
    public Variable getStroA() throws Exception {
        return stroA;
    }

    /**
     * Checks if the visual object has a stroke.
     *
     * @return True if the visual object has a stroke, false otherwise.
     * @throws Exception If checking the stroke status fails for some reason.
     */
    public boolean isNoStro() throws Exception {
        return noStro;
    }

    /**
     * Retrieves the stroke weight for the visual object.
     *
     * @return The stroke weight.
     * @throws Exception If retrieving the stroke weight fails for some reason.
     */
    public Variable getStroWei() throws Exception {
        return stroWei;
    }

    /**
     * Retrieves the unique identifier for the visual object.
     *
     * @return The unique identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the red component of the fill color for the visual object with a Variable instance.
     *
     * @param fillR The red component to set.
     * @throws Exception If setting the red component fails for some reason.
     */
    public void setFillR(Variable fillR) throws Exception {
        this.fillR = fillR;
    }

    /**
     * Sets the red component of the fill color for the visual object with a float value.
     *
     * @param value The red component to set.
     * @throws Exception If setting the red component fails for some reason.
     */
    public void setFillR(float value) throws Exception {
        fillR.setActualValue(value);
    }

    /**
     * Moves the red component of the fill color for the visual object by a float value.
     *
     * @param value The amount by which to move the red component of the fill color.
     * @throws Exception If moving the red component fails for some reason.
     */
    public void toMoveFillR(float value) throws Exception {
        fillR.toMoveValue(value);
    }

    /**
     * Moves the red component of the fill color for the visual object by a relative float value.
     *
     * @param value The relative amount by which to move the red component of the fill color.
     * @throws Exception If moving the red component fails for some reason.
     */
    public void toMoveFillRRelatively(float value) throws Exception {
        fillR.toMoveValueRelatively(value);
    }

    /**
     * Sets the height of the visual object with a Variable instance.
     *
     * @param heit The height to set.
     * @throws Exception If setting the height fails for some reason.
     */
    public void setHeit(Variable heit) throws Exception {
        Heit = heit;
    }

    /**
     * Sets the height of the visual object with a float value.
     *
     * @param value The height to set.
     * @throws Exception If setting the height fails for some reason.
     */
    public void setHeit(float value) throws Exception {
        Heit.setActualValue(value);
    }

    /**
     * Moves the height of the visual object by a float value.
     *
     * @param value The amount by which to move the height.
     * @throws Exception If moving the height fails for some reason.
     */
    public void toMoveHeit(float value) throws Exception {
        Heit.toMoveValue(value);
    }

    /**
     * Moves the height of the visual object by a relative float value.
     *
     * @param value The relative amount by which to move the height.
     * @throws Exception If moving the height fails for some reason.
     */
    public void toMoveHeitRelatively(float value) throws Exception {
        Heit.toMoveValueRelatively(value);
    }

    /**
     * Sets the green component of the fill color for the visual object with a Variable instance.
     *
     * @param fillG The green component to set.
     * @throws Exception If setting the green component fails for some reason.
     */
    public void setFillG(Variable fillG) throws Exception {
        this.fillG = fillG;
    }

    /**
     * Sets the green component of the fill color for the visual object with a float value.
     *
     * @param value The green component to set.
     * @throws Exception If setting the green component fails for some reason.
     */
    public void setFillG(float value) throws Exception {
        fillG.setActualValue(value);
    }

    /**
     * Moves the green component of the fill color for the visual object by a float value.
     *
     * @param value The amount by which to move the green component of the fill color.
     * @throws Exception If moving the green component fails for some reason.
     */
    public void toMoveFillG(float value) throws Exception {
        fillG.toMoveValue(value);
    }

    /**
     * Moves the green component of the fill color for the visual object by a relative float value.
     *
     * @param value The relative amount by which to move the green component of the fill color.
     * @throws Exception If moving the green component fails for some reason.
     */
    public void toMoveFillGRelatively(float value) throws Exception {
        fillG.toMoveValueRelatively(value);
    }

    /**
     * Sets the blue component of the fill color for the visual object with a Variable instance.
     *
     * @param fillB The blue component to set.
     * @throws Exception If setting the blue component fails for some reason.
     */
    public void setFillB(Variable fillB) throws Exception {
        this.fillB = fillB;
    }

    /**
     * Sets the blue component of the fill color for the visual object with a float value.
     *
     * @param value The blue component to set.
     * @throws Exception If setting the blue component fails for some reason.
     */
    public void setFillB(float value) throws Exception {
        fillB.setActualValue(value);
    }

    /**
     * Moves the blue component of the fill color for the visual object by a float value.
     *
     * @param value The amount by which to move the blue component of the fill color.
     * @throws Exception If moving the blue component fails for some reason.
     */
    public void toMoveFillB(float value) throws Exception {
        fillB.toMoveValue(value);
    }

    /**
     * Moves the blue component of the fill color for the visual object by a relative float value.
     *
     * @param value The relative amount by which to move the blue component of the fill color.
     * @throws Exception If moving the blue component fails for some reason.
     */
    public void toMoveFillBRelatively(float value) throws Exception {
        fillB.toMoveValueRelatively(value);
    }

    /**
     * Sets the alpha component of the fill color for the visual object with a Variable instance.
     *
     * @param fillA The alpha component to set.
     * @throws Exception If setting the alpha component fails for some reason.
     */
    public void setFillA(Variable fillA) throws Exception {
        this.fillA = fillA;
    }

    /**
     * Sets the alpha component of the fill color for the visual object with a float value.
     *
     * @param value The alpha component to set.
     * @throws Exception If setting the alpha component fails for some reason.
     */
    public void setFillA(float value) throws Exception {
        fillA.setActualValue(value);
    }

    /**
     * Moves the alpha component of the fill color for the visual object by a float value.
     *
     * @param value The amount by which to move the alpha component of the fill color.
     * @throws Exception If moving the alpha component fails for some reason.
     */
    public void toMoveFillA(float value) throws Exception {
        fillA.toMoveValue(value);
    }

    /**
     * Moves the alpha component of the fill color for the visual object by a relative float value.
     *
     * @param value The relative amount by which to move the alpha component of the fill color.
     * @throws Exception If moving the alpha component fails for some reason.
     */
    public void toMoveFillARelatively(float value) throws Exception {
        fillA.toMoveValueRelatively(value);
    }

    /**
     * Sets the fill status of the visual object.
     *
     * @param noFill The fill status to set.
     * @throws Exception If setting the fill status fails for some reason.
     */
    public void setNoFill(boolean noFill) throws Exception {
        this.noFill = noFill;
    }

    /**
     * Sets the red component of the stroke color for the visual object with a Variable instance.
     *
     * @param stroR The red component to set.
     * @throws Exception If setting the red component fails for some reason.
     */
    public void setStroR(Variable stroR) throws Exception {
        this.stroR = stroR;
    }

    /**
     * Sets the red component of the stroke color for the visual object with a float value.
     *
     * @param value The red component to set.
     * @throws Exception If setting the red component fails for some reason.
     */
    public void setStroR(float value) throws Exception {
        stroR.setActualValue(value);
    }

    /**
     * Moves the red component of the stroke color for the visual object by a float value.
     *
     * @param value The amount by which to move the red component of the stroke color.
     * @throws Exception If moving the red component fails for some reason.
     */
    public void toMoveStroR(float value) throws Exception {
        stroR.toMoveValue(value);
    }

    /**
     * Moves the red component of the stroke color for the visual object by a relative float value.
     *
     * @param value The relative amount by which to move the red component of the stroke color.
     * @throws Exception If moving the red component fails for some reason.
     */
    public void toMoveStroRRelatively(float value) throws Exception {
        stroR.toMoveValueRelatively(value);
    }

    /**
     * Sets the green component of the stroke color for the visual object with a Variable instance.
     *
     * @param stroG The green component to set.
     * @throws Exception If setting the green component fails for some reason.
     */
    public void setStroG(Variable stroG) throws Exception {
        this.stroG = stroG;
    }

    /**
     * Sets the green component of the stroke color for the visual object with a float value.
     *
     * @param value The green component to set.
     * @throws Exception If setting the green component fails for some reason.
     */
    public void setStroG(float value) throws Exception {
        stroG.setActualValue(value);
    }

    /**
     * Moves the green component of the stroke color for the visual object by a float value.
     *
     * @param value The amount by which to move the green component of the stroke color.
     * @throws Exception If moving the green component fails for some reason.
     */
    public void toMoveStroG(float value) throws Exception {
        stroG.toMoveValue(value);
    }

    /**
     * Moves the green component of the stroke color for the visual object by a relative float value.
     *
     * @param value The relative amount by which to move the green component of the stroke color.
     * @throws Exception If moving the green component fails for some reason.
     */
    public void toMoveStroGRelatively(float value) throws Exception {
        stroG.toMoveValueRelatively(value);
    }

    /**
     * Sets the blue component of the stroke color for the visual object with a Variable instance.
     *
     * @param stroB The blue component to set.
     * @throws Exception If setting the blue component fails for some reason.
     */
    public void setStroB(Variable stroB) throws Exception {
        this.stroB = stroB;
    }

    /**
     * Sets the blue component of the stroke color for the visual object with a float value.
     *
     * @param value The blue component to set.
     * @throws Exception If setting the blue component fails for some reason.
     */
    public void setStroB(float value) throws Exception {
        stroB.setActualValue(value);
    }

    /**
     * Moves the blue component of the stroke color for the visual object by a float value.
     *
     * @param value The amount by which to move the blue component of the stroke color.
     * @throws Exception If moving the blue component fails for some reason.
     */
    public void toMoveStroB(float value) throws Exception {
        stroB.toMoveValue(value);
    }

    /**
     * Moves the blue component of the stroke color for the visual object by a relative float value.
     *
     * @param value The relative amount by which to move the blue component of the stroke color.
     * @throws Exception If moving the blue component fails for some reason.
     */
    public void toMoveStroBRelatively(float value) throws Exception {
        stroB.toMoveValueRelatively(value);
    }

    /**
     * Sets the alpha component of the stroke color for the visual object with a Variable instance.
     *
     * @param stroA The alpha component to set.
     * @throws Exception If setting the alpha component fails for some reason.
     */
    public void setStroA(Variable stroA) throws Exception {
        this.stroA = stroA;
    }

    /**
     * Sets the alpha component of the stroke color for the visual object with a float value.
     *
     * @param value The alpha component to set.
     * @throws Exception If setting the alpha component fails for some reason.
     */
    public void setStroA(float value) throws Exception {
        stroA.setActualValue(value);
    }

    /**
     * Moves the alpha component of the stroke color for the visual object by a float value.
     *
     * @param value The amount by which to move the alpha component of the stroke color.
     * @throws Exception If moving the alpha component fails for some reason.
     */
    public void toMoveStroA(float value) throws Exception {
        stroA.toMoveValue(value);
    }

    /**
     * Moves the alpha component of the stroke color for the visual object by a relative float value.
     *
     * @param value The relative amount by which to move the alpha component of the stroke color.
     * @throws Exception If moving the alpha component fails for some reason.
     */
    public void toMoveStroARelatively(float value) throws Exception {
        stroA.toMoveValueRelatively(value);
    }

    /**
     * Sets the stroke status of the visual object.
     *
     * @param noStro The stroke status to set.
     * @throws Exception If setting the stroke status fails for some reason.
     */
    public void setNoStro(boolean noStro) throws Exception {
        this.noStro = noStro;
    }

    /**
     * Sets the stroke weight for the visual object with a Variable instance.
     *
     * @param stroWei The stroke weight to set.
     * @throws Exception If setting the stroke weight fails for some reason.
     */
    public void setStroWei(Variable stroWei) throws Exception {
        this.stroWei = stroWei;
    }

    /**
     * Sets the stroke weight for the visual object with a float value.
     *
     * @param value The stroke weight to set.
     * @throws Exception If setting the stroke weight fails for some reason.
     */
    public void setStroWei(float value) throws Exception {
        stroWei.setActualValue(value);
    }

    /**
     * Moves the stroke weight for the visual object by a float value.
     *
     * @param value The amount by which to move the stroke weight.
     * @throws Exception If moving the stroke weight fails for some reason.
     */
    public void toMoveStroWei(float value) throws Exception {
        stroWei.toMoveValue(value);
    }

    /**
     * Moves the stroke weight for the visual object by a relative float value.
     *
     * @param value The relative amount by which to move the stroke weight.
     * @throws Exception If moving the stroke weight fails for some reason.
     */
    public void toMoveStroWeiRelatively(float value) throws Exception {
        stroWei.toMoveValueRelatively(value);
    }

    /**
     * Sets the fill color for the visual object using the alpha, red, green, and blue components.
     *
     * @param a The alpha component of the fill color.
     * @param r The red component of the fill color.
     * @param g The green component of the fill color.
     * @param b The blue component of the fill color.
     * @throws Exception If setting the fill color fails for some reason.
     */
    public void setFillARGB(float a, float r, float g, float b) throws Exception {
        fillA = new Variable(a);
        fillR = new Variable(r);
        fillG = new Variable(g);
        fillB = new Variable(b);
    }

    /**
     * Sets the fill color for the visual object using the red, green, and blue components.
     *
     * @param r The red component of the fill color.
     * @param g The green component of the fill color.
     * @param b The blue component of the fill color.
     * @throws Exception If setting the fill color fails for some reason.
     */
    public void setFillRGB(float r, float g, float b) throws Exception {
        fillR = new Variable(r);
        fillG = new Variable(g);
        fillB = new Variable(b);
    }

    /**
     * Sets the fill color for the visual object using a single brightness value.
     *
     * @param brightness The brightness value for the fill color.
     * @throws Exception If setting the fill color fails for some reason.
     */
    public void setFill(float brightness) throws Exception {
        fillR = new Variable(brightness);
        fillG = new Variable(brightness);
        fillB = new Variable(brightness);
    }

    /**
     * Checks if the animation for the visual object has finished.
     *
     * @return True if all frames of the animation are finished;
     *         false otherwise.
     */
    public boolean isAnimationFinish() {
        boolean allFramesAreMinusOne = true;

        if (Posi != null && Posi.x.requestedFrame >-1) {
            return false;
        }
        if (Posi != null && Posi.y.requestedFrame >-1) {
            return false;
        }
        if (Widt != null && Widt.requestedFrame >-1) {
            return false;
        }
        if (Heit != null && Heit.requestedFrame >-1) {
            return false;
        }
        if (fillR != null && fillR.requestedFrame >-1) {
            return false;
        }
        if (fillG != null && fillG.requestedFrame >-1) {
            return false;
        }
        if (fillB != null && fillB.requestedFrame >-1) {
            return false;
        }
        if (fillA != null && fillA.requestedFrame >-1) {
            return false;
        }
        if (stroR != null && stroR.requestedFrame >-1) {
            return false;
        }
        if (stroG != null && stroG.requestedFrame >-1) {
            return false;
        }
        if (stroB != null && stroB.requestedFrame >-1) {
            return false;
        }
        if (stroA != null && stroA.requestedFrame >-1) {
            return false;
        }
        if (stroWei != null && stroWei.requestedFrame >-1) {
            return false;
        }
        return allFramesAreMinusOne;
    }

    /**
     * Makes all the properties of this VObj change to the status of next frame.
     *
     * @throws Exception If moving the visual object fails for some reason.
     */
    public void actualMove() throws Exception {
        Posi.x.actualMove();
        Posi.y.actualMove();
        Widt.actualMove();
        Heit.actualMove();
        fillA.actualMove();
        fillR.actualMove();
        fillG.actualMove();
        fillB.actualMove();
        stroB.actualMove();
        stroA.actualMove();
        stroG.actualMove();
        stroR.actualMove();
        stroWei.actualMove();
    }

    public abstract void unlockAllVariable();
}
