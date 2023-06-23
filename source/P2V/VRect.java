package P2V;

/**
 * VRect is a class that represents a rectangle visual object in the application.
 * It extends the VObj abstract class and inherits its properties and methods.
 * @author Telsa
 */
public class VRect extends VObj
{
    /**
     * The rounded corner radius of four corners.
     * [0] for top-left, [1] for top-right, [2] for bottom-left, [3] for bottom-right
     */
    protected Variable[] roundedCorner;

    /**
     * The spin property represents the rotation angle of the VRect object.
     * Note: The spin property is not available in most VObj classes.
     */
    protected Variable spin;

    /**
     * Constructs a new VRect object with default values.
     * The position is set to (0, 0), width and height are set to 100, and other properties have default values.
     */
    public VRect()
    {
        Posi=new VXy(0,0);
        Widt=new Variable(100);
        Heit=new Variable(100);
        noStro=true;
        fillA=new Variable(255);
        fillR=new Variable(0);
        fillG=new Variable(0);
        fillB=new Variable(0);
        stroA=new Variable(0);
        stroR=new Variable(0);
        stroG=new Variable(0);
        stroB=new Variable(0);
        stroWei=new Variable(0);
        spin=new Variable(0);
        roundedCorner=new Variable[]{new Variable(0),new Variable(0),new Variable(0),new Variable(0)};
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VRect object with the specified width and height.
     * The position is set to (0, 0), and other properties have default values.
     *
     * @param w The width of the rectangle.
     * @param h The height of the rectangle.
     */
    public VRect(float w,float h) {
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
        roundedCorner = new Variable[]{new Variable(0), new Variable(0), new Variable(0), new Variable(0)};
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VRect object with the specified position, width, and height.
     * Other properties have default values.
     *
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     * @param w The width of the rectangle.
     * @param h The height of the rectangle.
     */
    public VRect(float x,float y,float w,float h)
    {
        Posi=new VXy(x,y);
        Widt=new Variable(w);
        Heit=new Variable(h);
        noStro=true;
        fillA=new Variable(255);
        fillR=new Variable(0);
        fillG=new Variable(0);
        fillB=new Variable(0);
        stroA=new Variable(0);
        stroR=new Variable(0);
        stroG=new Variable(0);
        stroB=new Variable(0);
        stroWei=new Variable(0);
        spin=new Variable(0);
        roundedCorner=new Variable[]{new Variable(0),new Variable(0),new Variable(0),new Variable(0)};
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VRect object with the specified position, width, height, and corner radius.
     *
     * @param x     The x-coordinate of the position.
     * @param y     The y-coordinate of the position.
     * @param w     The width of the rectangle.
     * @param h     The height of the rectangle.
     * @param round The corner radius of the rectangle.
     */
    public VRect(float x,float y,float w,float h,float round)
    {
        Posi=new VXy(x,y);
        Widt=new Variable(w);
        Heit=new Variable(h);
        noStro=true;
        fillA=new Variable(255);
        fillR=new Variable(0);
        fillG=new Variable(0);
        fillB=new Variable(0);
        roundedCorner=new Variable[]{new Variable(round),new Variable(round),new Variable(round),new Variable(round)};
        stroA=new Variable(0);
        stroR=new Variable(0);
        stroG=new Variable(0);
        stroB=new Variable(0);
        stroWei=new Variable(0);
        spin=new Variable(0);
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VRect object with the specified position, width, height, and corner radius.
     *
     * @param x     The x-coordinate of the position.
     * @param y     The y-coordinate of the position.
     * @param w     The width of the rectangle.
     * @param h     The height of the rectangle.
     * @param r1 The radius for the top-left corner.
     * @param r2 The radius for the top-right corner.
     * @param r3 The radius for the bottom-left corner.
     * @param r4 The radius for the bottom-right corner.
     */
    public VRect(float x,float y,float w,float h,float r1,float r2,float r3,float r4)
    {
        Posi=new VXy(x,y);
        Widt=new Variable(w);
        Heit=new Variable(h);
        noStro=true;
        fillA=new Variable(255);
        fillR=new Variable(0);
        fillG=new Variable(0);
        fillB=new Variable(0);
        roundedCorner=new Variable[]{new Variable(r1),new Variable(r2),new Variable(r3),new Variable(r4)};
        stroA=new Variable(0);
        stroR=new Variable(0);
        stroG=new Variable(0);
        stroB=new Variable(0);
        stroWei=new Variable(0);
        spin=new Variable(0);
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VRect object with the specified position, width, and height.
     * Other properties have default values.
     *
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     * @param w The width of the rectangle.
     * @param h The height of the rectangle.
     */
    public VRect(Variable x,Variable y,Variable w,Variable h)
    {
        Posi=new VXy(x,y);
        Widt= w;
        Heit= h;
        noStro=true;
        fillA=new Variable(255);
        fillR=new Variable(0);
        fillG=new Variable(0);
        fillB=new Variable(0);
        roundedCorner=new Variable[]{new Variable(0),new Variable(0),new Variable(0),new Variable(0)};
        stroA=new Variable(0);
        stroR=new Variable(0);
        stroG=new Variable(0);
        stroB=new Variable(0);
        stroWei=new Variable(0);
        spin=new Variable(0);
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VRect object with the specified position, width, and height.
     * Other properties have default values.
     *
     * @param xy The position.
     * @param wh The size.
     */
    public VRect(VXy xy,VXy wh)
    {
        Posi=xy;
        Widt= wh.x;
        Heit= wh.y;
        noStro=true;
        fillA=new Variable(255);
        fillR=new Variable(0);
        fillG=new Variable(0);
        fillB=new Variable(0);
        roundedCorner=new Variable[]{new Variable(0),new Variable(0),new Variable(0),new Variable(0)};
        stroA=new Variable(0);
        stroR=new Variable(0);
        stroG=new Variable(0);
        stroB=new Variable(0);
        stroWei=new Variable(0);
        spin=new Variable(0);
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VRect object with the specified position, width, height, and fill color.
     *
     * @param x     The x-coordinate of the position.
     * @param y     The y-coordinate of the position.
     * @param w     The width of the rectangle.
     * @param h     The height of the rectangle.
     * @param a     The alpha of the rectangle fill.
     * @param r     The red of the rectangle fill.
     * @param g     The green of the rectangle fill.
     * @param b     The blue of the rectangle fill.
     */
    public VRect(float x,float y,float w,float h,int a,int r,int g,int b)
    {
        Posi=new VXy(x,y);
        Widt=new Variable(w);
        Heit=new Variable(h);
        noStro=true;
        fillA=new Variable(a);
        fillR=new Variable(r);
        fillG=new Variable(g);
        fillB=new Variable(b);
        roundedCorner=new Variable[]{new Variable(0),new Variable(0),new Variable(0),new Variable(0)};
        stroA=new Variable(0);
        stroR=new Variable(0);
        stroG=new Variable(0);
        stroB=new Variable(0);
        stroWei=new Variable(0);
        spin=new Variable(0);
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Sets the rounded corner radius of the rectangle for each corner.
     *
     * @param tl The radius for the top-left corner.
     * @param tr The radius for the top-right corner.
     * @param bl The radius for the bottom-left corner.
     * @param br The radius for the bottom-right corner.
     */
    public void setRoundedCorner(float tl,float tr,float bl, float br)
    {
        roundedCorner[0]=new Variable(tl);
        roundedCorner[1]=new Variable(tr);
        roundedCorner[2]=new Variable(bl);
        roundedCorner[3]=new Variable(br);
    }

    /**
     * Sets the same rounded corner radius for all corners of the rectangle.
     *
     * @param r The radius for all corners.
     */
    public void setRoundedCorner(float r)
    {
        roundedCorner[0]=new Variable(r);
        roundedCorner[1]=new Variable(r);
        roundedCorner[2]=new Variable(r);
        roundedCorner[3]=new Variable(r);
    }

    /**
     * Gets the rounded corner radius for the specified corner of the rectangle.
     *
     * @param index The index of the corner (0 for top-left, 1 for top-right, 2 for bottom-left, 3 for bottom-right).
     * @return The rounded corner radius for the specified corner.
     * @throws Exception If the index is not a valid corner index (0, 1, 2, or 3).
     */
    public Variable getRoundedCorner(int index) throws Exception
    {
        if (index>3 || index<0)
        {
            throw  new Exception("Only 0, 1, 2 and 3 are legal for parameter \"int index\"");
        }
        return roundedCorner[index];
    }

    /**
     * Moves the specified corner of the rectangle to the specified position.
     *
     * @param index The index of the corner (0 for top-left, 1 for top-right, 2 for bottom-left, 3 for bottom-right).
     * @param x     The x-coordinate of the new position.
     * @param y     The y-coordinate of the new position.
     * @throws Exception If the index is not a valid corner index (0, 1, 2, or 3).
     */
    public void pullCorner(int index, float x, float y) throws Exception {
        float l=Posi.x.actualValue-Widt.actualValue/2;
        float r=Posi.x.actualValue+Widt.actualValue/2;
        float t=Posi.y.actualValue-Heit.actualValue/2;
        float b=Posi.y.actualValue+Heit.actualValue/2;
        if(index==0)
        {
            Posi.x.setActualValue((x-l)/2);
            Posi.y.setActualValue((y-t)/2);
            Widt.setActualValue(Widt.actualValue-(x-l));
            Heit.setActualValue(Heit.actualValue-(y-t));
        }
        else if(index == 1) {
            Posi.x.setActualValue((x + r) / 2);
            Posi.y.setActualValue((y + t) / 2);
            Widt.setActualValue(r - x);
            Heit.setActualValue(y - t);
        } else if(index == 2) {
            Posi.x.setActualValue((x + l) / 2);
            Posi.y.setActualValue((y + b) / 2);
            Widt.setActualValue(x - l);
            Heit.setActualValue(b - y);
        } else if(index == 3) {
            Posi.x.setActualValue((x + l) / 2);
            Posi.y.setActualValue((y + t) / 2);
            Widt.setActualValue(x - l);
            Heit.setActualValue(y - t);
        } else {
            throw new Exception("Only 0, 1, 2 and 3 are legal for parameter \"int index\"");
        }
    }

    /**
     * Moves the specified corner of the rectangle relative to its current position.
     *
     * @param index The index of the corner (0 for top-left, 1 for top-right, 2 for bottom-left, 3 for bottom-right).
     * @param x     The amount to move the corner along the x-axis.
     * @param y     The amount to move the corner along the y-axis.
     * @throws Exception If the index is not a valid corner index (0, 1, 2, or 3).
     */
    public void pullCornerRelatively(int index, float x, float y) throws Exception {
        if(index == 0) {
            Posi.x.setActualValue(Posi.x.actualValue + x / 2);
            Posi.y.setActualValue(Posi.y.actualValue + y / 2);
            Widt.setActualValue(Widt.actualValue - x);
            Heit.setActualValue(Heit.actualValue - y);
        } else if(index == 1) {
            Posi.x.setActualValue(Posi.x.actualValue + x / 2);
            Posi.y.setActualValue(Posi.y.actualValue + y / 2);
            Widt.setActualValue(Widt.actualValue + x);
            Heit.setActualValue(Heit.actualValue - y);
        } else if(index == 2) {
            Posi.x.setActualValue(Posi.x.actualValue + x / 2);
            Posi.y.setActualValue(Posi.y.actualValue + y / 2);
            Widt.setActualValue(Widt.actualValue - x);
            Heit.setActualValue(Heit.actualValue + y);
        } else if(index == 3) {
            Posi.x.setActualValue(Posi.x.actualValue + x / 2);
            Posi.y.setActualValue(Posi.y.actualValue + y / 2);
            Widt.setActualValue(Widt.actualValue + x);
            Heit.setActualValue(Heit.actualValue + y);
        } else {
            throw new Exception("Only 0, 1, 2 and 3 are legal for parameter \"int index\"");
        }
    }

    /**
     * Moves the specified corner of the rectangle to the specified position using animation.
     *
     * @param index The index of the corner (0 for top-left, 1 for top-right, 2 for bottom-left, 3 for bottom-right).
     * @param x     The x-coordinate of the new position.
     * @param y     The y-coordinate of the new position.
     * @throws Exception If the index is not a valid corner index (0, 1, 2, or 3).
     */
    public void toPullCorner(int index, float x, float y) throws Exception {
        float l=Posi.x.actualValue-Widt.actualValue/2;
        float r=Posi.x.actualValue+Widt.actualValue/2;
        float t=Posi.y.actualValue-Heit.actualValue/2;
        float b=Posi.y.actualValue+Heit.actualValue/2;
        if(index==0)
        {
            Posi.x.toMoveValue((x-l)/2);
            Posi.y.toMoveValue((y-t)/2);
            Widt.toMoveValue(Widt.actualValue-(x-l));
            Heit.toMoveValue(Heit.actualValue-(y-t));
        }
        else if(index == 1) {
            Posi.x.toMoveValue((x + r) / 2);
            Posi.y.toMoveValue((y + t) / 2);
            Widt.toMoveValue(r - x);
            Heit.toMoveValue(y - t);
        } else if(index == 2) {
            Posi.x.toMoveValue((x + l) / 2);
            Posi.y.toMoveValue((y + b) / 2);
            Widt.toMoveValue(x - l);
            Heit.toMoveValue(b - y);
        } else if(index == 3) {
            Posi.x.toMoveValue((x + l) / 2);
            Posi.y.toMoveValue((y + t) / 2);
            Widt.toMoveValue(x - l);
            Heit.toMoveValue(y - t);
        } else {
            throw new Exception("Only 0, 1, 2 and 3 are legal for parameter \"int index\"");
        }
    }

    /**
     * Moves the specified corner of the rectangle relative to its current position using animation.
     *
     * @param index The index of the corner (0 for top-left, 1 for top-right, 2 for bottom-left, 3 for bottom-right).
     * @param x     The amount to move the corner along the x-axis.
     * @param y     The amount to move the corner along the y-axis.
     * @throws Exception If the index is not a valid corner index (0, 1, 2, or 3).
     */
    public void toPullCornerRelatively(int index, float x, float y) throws Exception {
        if(index == 0) {
            Posi.x.toMoveValue(Posi.x.actualValue + x / 2);
            Posi.y.toMoveValue(Posi.y.actualValue + y / 2);
            Widt.toMoveValue(Widt.actualValue - x);
            Heit.toMoveValue(Heit.actualValue - y);
        } else if(index == 1) {
            Posi.x.toMoveValue(Posi.x.actualValue + x / 2);
            Posi.y.toMoveValue(Posi.y.actualValue + y / 2);
            Widt.toMoveValue(Widt.actualValue + x);
            Heit.toMoveValue(Heit.actualValue - y);
        } else if(index == 2) {
            Posi.x.toMoveValue(Posi.x.actualValue + x / 2);
            Posi.y.toMoveValue(Posi.y.actualValue + y / 2);
            Widt.toMoveValue(Widt.actualValue - x);
            Heit.toMoveValue(Heit.actualValue + y);
        } else if(index == 3) {
            Posi.x.toMoveValue(Posi.x.actualValue + x / 2);
            Posi.y.toMoveValue(Posi.y.actualValue + y / 2);
            Widt.toMoveValue(Widt.actualValue + x);
            Heit.toMoveValue(Heit.actualValue + y);
        } else {
            throw new Exception("Only 0, 1, 2 and 3 are legal for parameter \"int index\"");
        }
    }

    /**
     * Gets the spin property of the VRect object.
     *
     * @return The spin property.
     * @throws Exception If an error occurs while accessing the spin property.
     */
    public Variable getSpin() throws Exception {
        return spin;
    }

    /**
     * Sets the spin property of the VRect object.
     *
     * @param spin The spin property to set.
     * @throws Exception If an error occurs while setting the spin property.
     */
    public void setSpin(Variable spin) throws Exception {
        this.spin = spin;
    }

    /**
     * Sets the spin property of the VRect object.
     *
     * @param value The spin property to set.
     * @throws Exception If an error occurs while setting the spin property.
     */
    public void setSpin(float value) throws Exception {
        spin.setActualValue(value);
    }

    /**
     * Moves the spin property of the VRect object by the specified value using animation.
     *
     * @param value The value to move the spin property by.
     * @throws Exception If an error occurs while moving the spin property.
     */
    public void toMoveSpin(float value) throws Exception {
        spin.toMoveValue(value);
    }

    /**
     * Moves the spin property of the VRect object relative to its current value by the specified value using animation.
     *
     * @param value The value to move the spin property by.
     * @throws Exception If an error occurs while moving the spin property.
     */
    public void toMoveSpinRelatively(float value) throws Exception {
        spin.toMoveValueRelatively(value);
    }

    /**
     * Checks if the animation for the visual object has finished.
     *
     * @return True if all frames of the animation are finished;
     *         false otherwise.
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
        if (spin != null && spin.requestedFrame >-1)
        {
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
    public void actualMove() throws Exception
    {
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
        roundedCorner[0].actualMove();
        roundedCorner[1].actualMove();
        roundedCorner[2].actualMove();
        roundedCorner[3].actualMove();
        spin.actualMove();
    }

    /**
     * Sets the animation mode for the properties of this VObj.
     *
     * @param animationMode The animation mode to set.
     */
    public void setAnimationMode(int animationMode)
    {
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
        roundedCorner[0].setAnimationMode(animationMode);
        roundedCorner[1].setAnimationMode(animationMode);
        roundedCorner[2].setAnimationMode(animationMode);
        roundedCorner[3].setAnimationMode(animationMode);

    }

    @Override
    public void unlockAllVariable()
    {
        Posi.x.actualMoveLock=false;
        Posi.y.actualMoveLock=false;
        Widt.actualMoveLock=false;
        Heit.actualMoveLock=false;
        stroB.actualMoveLock=false;
        stroA.actualMoveLock=false;
        stroG.actualMoveLock=false;
        stroR.actualMoveLock=false;
        fillB.actualMoveLock=false;
        fillA.actualMoveLock=false;
        fillG.actualMoveLock=false;
        fillR.actualMoveLock=false;
        stroWei.actualMoveLock=false;
        spin.actualMoveLock=false;
        roundedCorner[0].actualMoveLock=false;
        roundedCorner[1].actualMoveLock=false;
        roundedCorner[2].actualMoveLock=false;
        roundedCorner[3].actualMoveLock=false;
    }
}
