package P2V;
/**
 * VLine is a class that represents a line visual object in the application.
 * It extends the VObj abstract class and inherits its properties and methods.
 * However, some methods or properties are not available or readonly in VImg, such as Fill, Widt, Heit and so on.
 * @author Telsa
 */
public class VLine extends VObj
{
    /**
     * Represents the position of the second point (end point) of the VLine object.
     * This point defines the other end of the line.
     * In VLine, Posi represents the first end of the line.
     */
    protected VXy PosiE;
    int PosiERotateRequestedFrame=-1,PosiRotateRequestedFrame=-1;
    VXy fixedStartPoint,toRotateStartPoint;
    AnimationController acPosiRotate,acPosiERotate;
    /**
     * Returns the position of the end point of the VLine object.
     *
     * @return The position of the end point.
     */
    public VXy getPosiE() {
        return PosiE;
    }

    /**
     * Sets the position of the end point of the VLine object.
     *
     * @param posi The new position of the end point.
     */
    public void setPosiE(VXy posi) {
        PosiE = posi;
    }

    /**
     * Sets the position of the end point of the VLine object using the specified coordinates.
     *
     * @param x The x-coordinate of the new position.
     * @param y The y-coordinate of the new position.
     */
    public void setPosiE(float x, float y) {
        PosiE.x.setActualValue(x);
        PosiE.y.setActualValue(y);
    }

    /**
     * Moves the position of the end point of the VLine object by the specified offsets.
     *
     * @param x The amount to move the position along the x-axis.
     * @param y The amount to move the position along the y-axis.
     */
    public void toMovePosiE(float x, float y) {
        PosiE.x.toMoveValue(x);
        PosiE.y.toMoveValue(y);
    }

    /**
     * Moves the position of the end point of the VLine object relative to its current position
     * by the specified offsets.
     *
     * @param x The amount to move the position along the x-axis relative to its current position.
     * @param y The amount to move the position along the y-axis relative to its current position.
     */
    public void toMovePosiERelatively(float x, float y) {
        PosiE.x.toMoveValueRelatively(x);
        PosiE.y.toMoveValueRelatively(y);
    }

    /**
     * Creates a new VLine object with default values.
     */
    public VLine() {
        Posi = new VXy(0, 0);
        PosiE = new VXy(100, 100);
        stroA = new Variable(255);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(1);
        noStro = false;
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Creates a new VLine object with the specified start and end points.
     *
     * @param s The position of the start point.
     * @param e The position of the end point.
     */
    public VLine(VXy s, VXy e) {
        Posi = s;
        PosiE = e;
        stroA = new Variable(255);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(1);
        noStro = false;
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Creates a new VLine object with the specified start and end points represented by the given variables.
     *
     * @param sx The x-coordinate of the start point.
     * @param sy The y-coordinate of the start point.
     * @param ex The x-coordinate of the end point.
     * @param ey The y-coordinate of the end point.
     */
    public VLine(Variable sx, Variable sy, Variable ex, Variable ey) {
        Posi = new VXy(sx, sy);
        PosiE = new VXy(ex, ey);
        stroA = new Variable(255);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(1);
        noStro = false;
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Creates a new VLine object with the specified start and end points represented by the given coordinates.
     *
     * @param sx The x-coordinate of the start point.
     * @param sy The y-coordinate of the start point.
     * @param ex The x-coordinate of the end point.
     * @param ey The y-coordinate of the end point.
     */
    public VLine(float sx, float sy, float ex, float ey) {
        Posi = new VXy(sx, sy);
        PosiE = new VXy(ex, ey);
        stroA = new Variable(255);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(1);
        noStro = false;
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Creates a new VLine object with the specified start and end points represented by the given coordinates,
     * stroke weight, and stroke color.
     *
     * @param sx       The x-coordinate of the start point.
     * @param sy       The y-coordinate of the start point.
     * @param ex       The x-coordinate of the end point.
     * @param ey       The y-coordinate of the end point.
     * @param stroWei  The stroke weight of the line.
     * @param a        The alpha value of the stroke color.
     * @param r        The red value of the stroke color.
     * @param g        The green value of the stroke color.
     * @param b        The blue value of the stroke color.
     */
    public VLine(float sx, float sy, float ex, float ey, float stroWei, int a, int r, int g, int b) {
        Posi = new VXy(sx, sy);
        PosiE = new VXy(ex, ey);
        stroA = new Variable(a);
        stroR = new Variable(r);
        stroG = new Variable(g);
        stroB = new Variable(b);
        this.stroWei = new Variable(stroWei);
        noStro = false;
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Moves the VLine object by the specified offsets.
     *
     * @param x The amount to move the line along the x-axis.
     * @param y The amount to move the line along the y-axis.
     */
    public void moveLine(float x, float y) {
        Posi.toMoveXY(x, y);
        PosiE.toMoveXY(x - Posi.x.getActualValue() + PosiE.x.getActualValue(),
                y - Posi.y.getActualValue() + PosiE.y.getActualValue());
    }

    /**
     * Moves the VLine object by the specified offsets represented by the VXy object.
     *
     * @param xy The amount to move the line along the x-axis and y-axis represented by the VXy object.
     */
    public void moveLine(VXy xy) {
        Posi.toMoveXY(xy.x.getActualValue(), xy.y.getActualValue());
        PosiE.toMoveXY(xy.x.getActualValue() - Posi.x.getActualValue() + PosiE.x.getActualValue(),
                xy.y.getActualValue() - Posi.y.getActualValue() + PosiE.y.getActualValue());
    }

    /**
     * Moves the VLine object by the specified relative offsets.
     *
     * @param x The amount to move the line along the x-axis relative to its current position.
     * @param y The amount to move the line along the y-axis relative to its current position.
     */
    public void moveLineRelatively(float x, float y) {
        Posi.toMoveXYRelatively(x, y);
        PosiE.toMoveXYRelatively(x, y);
    }

    /**
     * Returns a new VXy object representing the coordinates of a point obtained by rotating
     * the toMovePoint around the fixedPoint by the specified angle.
     *
     * @param fixedPoint   The fixed point around which the toMovePoint is rotated.
     * @param toMovePoint  The point to be rotated.
     * @param angle        The angle of rotation in radians.
     * @return The new VXy object representing the rotated point.
     */
    public VXy getVXyValueByRotating(VXy fixedPoint, VXy toMovePoint, float angle) {
        float dx = toMovePoint.x.getActualValue() - fixedPoint.x.getActualValue();
        float dy = toMovePoint.y.getActualValue() - fixedPoint.y.getActualValue();

        float newX = dx * P2DViewer.pa.cos(angle) - dy * P2DViewer.pa.sin(angle);
        float newY = dx * P2DViewer.pa.sin(angle) + dy * P2DViewer.pa.cos(angle);

        float rotatedX = newX + fixedPoint.x.getActualValue();
        float rotatedY = newY + fixedPoint.y.getActualValue();

        return new VXy(rotatedX, rotatedY);
    }

    /**
     * Moves the position of the end point of the VLine object by rotating it by the specified angle.
     *
     * @param f The angle of rotation in radians.
     */
    public void toMovePosiEByRotating(float f) {
        if (PosiRotateRequestedFrame != -1)
            return;
        acPosiERotate = new AnimationController(0, f, PosiE.x.maxFrame,P2DViewer.defaultAnimationMode);
        PosiERotateRequestedFrame = 1;
        toRotateStartPoint = PosiE;
        fixedStartPoint = Posi;
    }

    /**
     * Moves the position of the start point of the VLine object by rotating it by the specified angle.
     *
     * @param f The angle of rotation in radians.
     */
    public void toMovePosiByRotating(float f) {
        if (PosiERotateRequestedFrame != -1)
            return;
        acPosiRotate = new AnimationController(0, f, Posi.x.maxFrame,P2DViewer.defaultAnimationMode);
        PosiRotateRequestedFrame = 1;
        toRotateStartPoint = Posi;
        fixedStartPoint = PosiE;
    }

    /**
     * Sets the position of the start point of the VLine object by rotating it by the specified angle.
     *
     * @param f The angle of rotation in radians.
     */
    public void setPosiByRotating(float f) {
        Posi = getVXyValueByRotating(PosiE, Posi, f);
    }

    /**
     * Sets the position of the end point of the VLine object by rotating it by the specified angle.
     *
     * @param f The angle of rotation in radians.
     */
    public void setPosiEByRotating(float f) {
        Posi = getVXyValueByRotating(Posi, PosiE, f);
    }

    /**
     * Moves the VLine object by updating the actual values of its position, end position,
     * stroke color, stroke weight, and alpha values.
     *
     * @throws Exception If an error occurs during the actual movement.
     */
    @Override
    public void actualMove() throws Exception {
        Posi.x.actualMove();
        Posi.y.actualMove();
        PosiE.x.actualMove();
        PosiE.y.actualMove();
        actualMovePosiEByRotating();
        actualMovePosiByRotating();
        stroB.actualMove();
        stroA.actualMove();
        stroG.actualMove();
        stroR.actualMove();
        stroWei.actualMove();
    }

    protected void actualMovePosiEByRotating() throws Exception
    {
        if(PosiERotateRequestedFrame==-1)
        {
            return;
        }
        if(PosiERotateRequestedFrame<=PosiE.x.maxFrame)
        {
            PosiE=getVXyValueByRotating(fixedStartPoint,toRotateStartPoint,acPosiERotate.getValue(PosiERotateRequestedFrame));
            PosiERotateRequestedFrame++;
        }
        else
        {
            PosiERotateRequestedFrame=-1;
        }
    }
    protected void actualMovePosiByRotating() throws Exception
    {
        if(PosiRotateRequestedFrame==-1)
        {
            return;
        }
        if(PosiRotateRequestedFrame<=Posi.x.maxFrame)
        {
            Posi=getVXyValueByRotating(fixedStartPoint,toRotateStartPoint,acPosiRotate.getValue(PosiRotateRequestedFrame));
            PosiRotateRequestedFrame++;
        }
        else
        {
            PosiRotateRequestedFrame=-1;
        }
    }

    /**
     * Checks if the animation for the VObj has finished.
     *
     * @return True if all frames of the animation are finished;
     *         false otherwise.
     */
    @Override
    public boolean isAnimationFinish()
    {
        boolean allFramesAreMinusOne = true;

        if (Posi != null && Posi.x.requestedFrame >-1) {
            return false;
        }
        if (Posi != null && Posi.y.requestedFrame >-1) {
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
        if(PosiERotateRequestedFrame<=-1)
        {
            return false;
        }
        if(PosiRotateRequestedFrame<=-1)
        {
            return false;
        }
        return allFramesAreMinusOne;
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @return This method does not return any value.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public Variable getFillR() throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @return This method does not return any value.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public Variable getFillG() throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @return This method does not return any value.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public Variable getFillB() throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @return This method does not return any value.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public Variable getFillA() throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @return This method does not return any value.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public boolean isNoFill() throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param fillR The Variable object representing the red component of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFillR(Variable fillR) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The value of the red component of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFillR(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The value to move the red component of the fill color by.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void toMoveFillR(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The relative value to move the red component of the fill color by.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void toMoveFillRRelatively(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param fillG The Variable object representing the green component of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFillG(Variable fillG) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The value of the green component of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFillG(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param a The alpha value of the fill color.
     * @param r The red component of the fill color.
     * @param g The green component of the fill color.
     * @param b The blue component of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFillARGB(float a, float r, float g, float b) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param r The red component of the fill color.
     * @param g The green component of the fill color.
     * @param b The blue component of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFillRGB(float r, float g, float b) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param brightness The brightness value of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFill(float brightness) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The value to move the green component of the fill color by.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void toMoveFillG(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The relative value to move the green component of the fill color by.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void toMoveFillGRelatively(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param fillB The Variable object representing the blue component of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFillB(Variable fillB) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The value of the blue component of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFillB(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The value to move the blue component of the fill color by.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void toMoveFillB(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The relative value to move the blue component of the fill color by.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void toMoveFillBRelatively(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param fillA The Variable object representing the alpha value of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFillA(Variable fillA) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The value of the alpha component of the fill color.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setFillA(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The value to move the alpha component of the fill color by.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void toMoveFillA(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param value The relative value to move the alpha component of the fill color by.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void toMoveFillARelatively(float value) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
    }

    /**
     * Throws an exception indicating that the VLine cannot use the attribute Fill.
     *
     * @param noFill The boolean value indicating whether to use fill or not.
     * @throws Exception Always throws an exception with the message "VLine cannot use attribute Fill".
     */
    @Override
    public void setNoFill(boolean noFill) throws Exception {
        throw new Exception("VLine cannot use attribute Fill");
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
        PosiE.x.setAnimationMode(animationMode);
        PosiE.y.setAnimationMode(animationMode);
        stroB.setAnimationMode(animationMode);
        stroA.setAnimationMode(animationMode);
        stroG.setAnimationMode(animationMode);
        stroR.setAnimationMode(animationMode);
        stroWei.setAnimationMode(animationMode);
    }
    @Override
    public void unlockAllVariable()
    {
        Posi.x.actualMoveLock=false;
        Posi.y.actualMoveLock=false;
        PosiE.x.actualMoveLock=false;
        PosiE.y.actualMoveLock=false;
        stroB.actualMoveLock=false;
        stroA.actualMoveLock=false;
        stroG.actualMoveLock=false;
        stroR.actualMoveLock=false;
        stroWei.actualMoveLock=false;
    }
}
