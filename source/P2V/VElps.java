package P2V;

/**
 * VElps is a class that represents an ellipse visual object in the application.
 * It extends the VObj abstract class and inherits its properties and methods.
 * @author Telsa
 */
public class VElps extends VObj {
    /**
     * The spin property represents the rotation angle of the VElps object.
     * Note: The spin property is not available in most VObj classes.
     */
    protected Variable spin;

    /**
     * Constructs a VElps object with default values.
     */
    public VElps() {
        Posi = new VXy(0, 0);
        Widt = new Variable(100);
        Heit = new Variable(100);
        noStro = true;
        fillA = new Variable(255);
        fillR = new Variable(0);
        fillG = new Variable(0);
        fillB = new Variable(0);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        spin = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a VElps object with the specified width and height.
     *
     * @param w The width of the ellipse.
     * @param h The height of the ellipse.
     */
    public VElps(float w, float h) {
        Posi = new VXy(0, 0);
        Widt = new Variable(w);
        Heit = new Variable(h);
        noStro = true;
        fillA = new Variable(255);
        fillR = new Variable(0);
        fillG = new Variable(0);
        fillB = new Variable(0);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        spin = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a VElps object with the specified position, width, and height.
     *
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     * @param w The width of the ellipse.
     * @param h The height of the ellipse.
     */
    public VElps(float x, float y, float w, float h) {
        Posi = new VXy(x, y);
        Widt = new Variable(w);
        Heit = new Variable(h);
        noStro = true;
        fillA = new Variable(255);
        fillR = new Variable(0);
        fillG = new Variable(0);
        fillB = new Variable(0);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        spin = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a VElps object with the specified position, width, height, and fill color.
     *
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     * @param w The width of the ellipse.
     * @param h The height of the ellipse.
     * @param a The alpha component of the fill color.
     * @param r The red component of the fill color.
     * @param g The green component of the fill color.
     * @param b The blue component of the fill color.
     */
    public VElps(float x, float y, float w, float h, int a, int r, int g, int b) {
        Posi = new VXy(x, y);
        Widt = new Variable(w);
        Heit = new Variable(h);
        noStro = true;
        fillA = new Variable(a);
        fillR = new Variable(r);
        fillG = new Variable(g);
        fillB = new Variable(b);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        spin = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a VElps object with the specified position and size represented by Variable instances.
     *
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     * @param w The width of the ellipse.
     * @param h The height of the ellipse.
     */
    public VElps(Variable x, Variable y, Variable w, Variable h) {
        Posi = new VXy(x, y);
        Widt = w;
        Heit = h;
        noStro = true;
        fillA = new Variable(255);
        fillR = new Variable(0);
        fillG = new Variable(0);
        fillB = new Variable(0);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        spin = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a VElps object with the specified position and size represented by VXy instances.
     *
     * @param xy The position of the ellipse.
     * @param wh The size of the ellipse.
     */
    public VElps(VXy xy, VXy wh) {
        Posi = xy;
        Widt = wh.x;
        Heit = wh.y;
        noStro = true;
        fillA = new Variable(255);
        fillR = new Variable(0);
        fillG = new Variable(0);
        fillB = new Variable(0);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        spin = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Retrieves the spin property of the ellipse.
     *
     * @return The spin Variable instance.
     * @throws Exception If retrieving the spin property fails.
     */
    public Variable getSpin() throws Exception {
        return spin;
    }

    /**
     * Sets the spin property of the ellipse with a Variable instance.
     *
     * @param spin The spin Variable instance to set.
     * @throws Exception If setting the spin property fails.
     */
    public void setSpin(Variable spin) throws Exception {
        this.spin = spin;
    }

    /**
     * Sets the spin property of the ellipse with a float value.
     *
     * @param value The spin value to set.
     * @throws Exception If setting the spin property fails.
     */
    public void setSpin(float value) throws Exception {
        spin.setActualValue(value);
    }

    /**
     * Moves the spin property of the ellipse by a certain amount.
     *
     * @param value The amount by which to move the spin property.
     * @throws Exception If moving the spin property fails.
     */
    public void toMoveSpin(float value) throws Exception {
        spin.toMoveValue(value);
    }

    /**
     * Moves the spin property of the ellipse by a certain amount relatively.
     *
     * @param value The relative amount by which to move the spin property.
     * @throws Exception If moving the spin property fails.
     */
    public void toMoveSpinRelatively(float value) throws Exception {
        spin.toMoveValueRelatively(value);
    }

    /**
     * Checks if the animation for the ellipse is finished.
     *
     * @return True if all animation frames are set to -1, indicating the animation is finished.
     */
    @Override
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
        if (spin != null && spin.requestedFrame >-1) {
            return false;
        }
        return allFramesAreMinusOne;
    }

    /**
     * Makes all the properties of this VObj change to the status of next frame.
     *
     * @throws Exception If moving the visual object fails for some reason.
     */
    @Override
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
        spin.actualMove();
    }

    /**
     * Sets the animation mode for the properties of this VObj.
     *
     * @param animationMode The animation mode to set.
     */
    public void setAnimationMode(int animationMode) {
        Posi.x.setAnimationMode(animationMode);
        Posi.y.setAnimationMode(animationMode);
        Widt.setAnimationMode(animationMode);
        Heit.setAnimationMode(animationMode);
        fillA.setAnimationMode(animationMode);
        fillR.setAnimationMode(animationMode);
        fillG.setAnimationMode(animationMode);
        fillB.setAnimationMode(animationMode);
        stroB.setAnimationMode(animationMode);
        stroA.setAnimationMode(animationMode);
        stroG.setAnimationMode(animationMode);
        stroR.setAnimationMode(animationMode);
        stroWei.setAnimationMode(animationMode);
        spin.setAnimationMode(animationMode);
    }

    @Override
    public void unlockAllVariable()
    {
        Posi.x.actualMoveLock=false;
        Posi.y.actualMoveLock=false;
        Widt.actualMoveLock=false;
        Heit.actualMoveLock=false;
        fillA.actualMoveLock=false;
        fillR.actualMoveLock=false;
        fillG.actualMoveLock=false;
        fillB.actualMoveLock=false;
        stroB.actualMoveLock=false;
        stroA.actualMoveLock=false;
        stroG.actualMoveLock=false;
        stroR.actualMoveLock=false;
        stroWei.actualMoveLock=false;
        spin.actualMoveLock=false;
    }
}
