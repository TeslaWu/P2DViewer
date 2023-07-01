package P2V;

import java.util.ArrayList;

/**
 * VPoly is a class that represents a polygon visual object in the application.
 * It extends the VObj abstract class and inherits its properties and methods.
 * However, some methods or properties are not available or readonly in VPoly, such as Posi, Widt, Heit.
 * @author Telsa
 */
public class VPoly extends VObj
{
    /**
     * The v property represents every vertex of this polygon.
     */
    protected ArrayList<VXy> v=new ArrayList<>();
    protected ArrayList<VXy> beforeRotating=new ArrayList<>();
    protected int VertexesRotateRequestedFrame=-1;
    protected AnimationController acVertexesRotate;

    /**
     * Default constructor for VPoly.
     * Creates a VPoly object with default vertex positions and color settings.
     */
    public VPoly() {
        v.add(new VXy(0, 0));
        v.add(new VXy(100, 0));
        v.add(new VXy(0, 100));
        noStro = true;
        fillA = new Variable(255);
        fillB = new Variable(0);
        fillG = new Variable(0);
        fillR = new Variable(0);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructor for VPoly that allows specifying the vertex positions.
     *
     * @param p Array of VXy objects representing the vertex positions.
     * @throws Exception If the number of parameters is odd.
     */
    public VPoly(VXy... p) throws Exception {
        for (VXy ap : p) {
            v.add(ap.copy());
        }
        noStro = true;
        fillA = new Variable(255);
        fillB = new Variable(0);
        fillG = new Variable(0);
        fillR = new Variable(0);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructor for VPoly that allows specifying the vertex positions.
     *
     * @param p Array of float values representing the vertex positions.
     * @throws Exception If the number of parameters is odd.
     */
    public VPoly(float... p) throws Exception {
        float x = 0;
        for (int ct = 0; ct < p.length; ct++) {
            if (ct % 2 == 1) {
                x = p[ct];
            } else {
                v.add(new VXy(x, p[ct]));
            }
        }
        noStro = true;
        fillA = new Variable(255);
        fillB = new Variable(0);
        fillG = new Variable(0);
        fillR = new Variable(0);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
        if (p.length % 2 != 0) {
            throw new Exception("VPoly(float... p) does not accept an odd number of parameters.");
        }
    }

    /**
     * Constructor for VPoly that allows specifying the vertex positions.
     *
     * @param p Array of Variable objects representing the vertex positions.
     * @throws Exception If the number of parameters is odd.
     */
    public VPoly(Variable... p) throws Exception {
        Variable x = null;
        for (int ct = 0; ct < p.length; ct++) {
            if (ct % 2 == 1) {
                x = p[ct];
            } else {
                v.add(new VXy(x, p[ct]));
            }
        }
        noStro = true;
        fillA = new Variable(255);
        fillB = new Variable(0);
        fillG = new Variable(0);
        fillR = new Variable(0);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
        if (p.length % 2 != 0) {
            throw new Exception("VPoly(Variable... p) does not accept an odd number of parameters.");
        }
    }

    /**
     * Constructor for VPoly that allows specifying the vertex positions and color.
     *
     * @param a Alpha value of the fill color.
     * @param r Red value of the fill color.
     * @param g Green value of the fill color.
     * @param b Blue value of the fill color.
     * @param p Array of VXy objects representing the vertex positions.
     */
    public VPoly(int a, int r, int g, int b, VXy... p) {
        for (VXy ap : p) {
            v.add(ap.copy());
        }
        noStro = true;
        fillA = new Variable(a);
        fillB = new Variable(b);
        fillG = new Variable(g);
        fillR = new Variable(r);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructor for VPoly that allows specifying the vertex positions and color.
     *
     * @param a Alpha value of the fill color.
     * @param r Red value of the fill color.
     * @param g Green value of the fill color.
     * @param b Blue value of the fill color.
     * @param p Array of float values representing the vertex positions.
     * @throws Exception If the number of parameters is odd.
     */
    public VPoly(int a, int r, int g, int b, float... p) throws Exception {
        float x = 0;
        for (int ct = 0; ct < p.length; ct++) {
            if (ct % 2 == 1) {
                x = p[ct];
            } else {
                v.add(new VXy(x, p[ct]));
            }
        }
        noStro = true;
        fillA = new Variable(a);
        fillB = new Variable(b);
        fillG = new Variable(g);
        fillR = new Variable(r);
        stroA = new Variable(0);
        stroR = new Variable(0);
        stroG = new Variable(0);
        stroB = new Variable(0);
        stroWei = new Variable(0);
        id = VObj.idct;
        VObj.idct++;
        if (p.length % 2 != 0) {
            throw new Exception("VPoly(float... p) does not accept an odd number of parameters.");
        }
    }

    /**
     * Removes a vertex at the specified index.
     *
     * @param index The index of the vertex to remove.
     */
    public void removeVertex(int index) {
        v.remove(index);
    }

    /**
     * Removes the specified vertex.
     *
     * @param v The vertex to remove.
     */
    public void removeVertex(VXy v) {
        this.v.remove(v);
    }

    /**
     * Removes a vertex at the specified coordinates.
     *
     * @param x The x-coordinate of the vertex to remove.
     * @param y The y-coordinate of the vertex to remove.
     */
    public void removeVertex(float x, float y) {
        for (VXy p : v) {
            if (p.x.actualValue == x && p.y.actualValue == y) {
                v.remove(p);
            }
        }
    }

    /**
     * Appends a vertex to the VPoly.
     *
     * @param v The vertex to append.
     */
    public void appendVertex(VXy v) {
        this.v.add(v);
    }

    /**
     * Appends a vertex to the VPoly with the specified coordinates.
     *
     * @param x The x-coordinate of the vertex.
     * @param y The y-coordinate of the vertex.
     */
    public void appendVertex(float x, float y) {
        this.v.add(new VXy(x, y));
    }

    /**
     * Appends a vertex to the VPoly with the specified Variable objects representing the coordinates.
     *
     * @param x The Variable object representing the x-coordinate of the vertex.
     * @param y The Variable object representing the y-coordinate of the vertex.
     */
    public void appendVertex(Variable x, Variable y) {
        this.v.add(new VXy(x, y));
    }

    /**
     * Inserts a vertex at the specified index.
     *
     * @param index The index at which to insert the vertex.
     * @param v     The vertex to insert.
     */
    public void insertVertex(int index, VXy v) {
        this.v.add(index, v);
    }

    /**
     * Inserts a vertex at the specified index with the specified coordinates.
     *
     * @param index The index at which to insert the vertex.
     * @param x     The x-coordinate of the vertex.
     * @param y     The y-coordinate of the vertex.
     */
    public void insertVertex(int index, float x, float y) {
        this.v.add(index, new VXy(x, y));
    }

    /**
     * Inserts a vertex at the specified index with the specified Variable objects representing the coordinates.
     *
     * @param index The index at which to insert the vertex.
     * @param x     The Variable object representing the x-coordinate of the vertex.
     * @param y     The Variable object representing the y-coordinate of the vertex.
     */
    public void insertVertex(int index, Variable x, Variable y) {
        this.v.add(index, new VXy(x, y));
    }

    /**
     * Returns the number of vertices in the VPoly.
     *
     * @return The number of vertices.
     */
    public int getVertexCount() {
        return v.size();
    }

    /**
     * Clears all the vertices from the VPoly.
     */
    public void clearVertex() {
        v.clear();
    }

    /**
     * Returns the height of the VPoly.
     * Note: This method is not available for VPoly. Call getFloatHeit() instead.
     *
     * @return The height variable.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public Variable getHeit() throws Exception {
        throw new Exception("getHeit() is not available for VPoly. Call getFloatHeit() instead.");
    }

    /**
     * Returns the height of the VPoly as a float value.
     *
     * @return The height of the VPoly.
     */
    public float getFloatHeit() {
        float minY = Float.MAX_VALUE;
        float maxY = Float.MIN_VALUE;
        for (int i = 0; i < v.size(); i++) {
            float y = v.get(i).y.actualValue;
            minY = P2DViewer.pa.min(minY, y);
            maxY = P2DViewer.pa.max(maxY, y);
        }
        return maxY - minY;
    }

    /**
     * Returns the width of the VPoly.
     * Note: This method is not available for VPoly. Call getFloatWidt() instead.
     *
     * @return The width variable.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public Variable getWidt() throws Exception {
        throw new Exception("getWidt() is not available for VPoly. Call getFloatWidt() instead.");
    }

    /**
     * Sets the width of the VPoly.
     * Note: This method is not available for VPoly.
     *
     * @param widt The width variable to set.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void setWidt(Variable widt) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Sets the width of the VPoly.
     * Note: This method is not available for VPoly.
     *
     * @param x The width value to set.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void setWidt(float x) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Moves the VPoly horizontally by the specified amount.
     * Note: This method is not available for VPoly.
     *
     * @param x The amount to move the VPoly horizontally.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void toMoveWidt(float x) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Moves the VPoly horizontally by the specified amount relative to its current position.
     * Note: This method is not available for VPoly.
     *
     * @param x The amount to move the VPoly horizontally.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void toMoveWidtRelatively(float x) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Sets the height of the VPoly.
     * Note: This method is not available for VPoly.
     *
     * @param heit The height variable to set.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void setHeit(Variable heit) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Sets the height of the VPoly.
     * Note: This method is not available for VPoly.
     *
     * @param value The height value to set.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void setHeit(float value) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Moves the VPoly vertically by the specified amount.
     * Note: This method is not available for VPoly.
     *
     * @param value The amount to move the VPoly vertically.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void toMoveHeit(float value) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Moves the VPoly vertically by the specified amount relative to its current position.
     * Note: This method is not available for VPoly.
     *
     * @param value The amount to move the VPoly vertically.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void toMoveHeitRelatively(float value) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Returns the width of the VPoly as a float value.
     *
     * @return The width of the VPoly.
     */
    public float getFloatWidt() {
        float minX = Float.MAX_VALUE;
        float maxX = Float.MIN_VALUE;
        for (int i = 0; i < v.size(); i++) {
            float x = v.get(i).x.actualValue;
            minX = P2DViewer.pa.min(minX, x);
            maxX = P2DViewer.pa.max(maxX, x);
        }
        return maxX - minX;
    }

    /**
     * Returns the vertex at the specified index.
     *
     * @param index The index of the vertex to retrieve.
     * @return The vertex at the specified index.
     */
    public VXy getVertex(int index) {
        return v.get(index);
    }

    /**
     * Sets the vertex at the specified index.
     *
     * @param index The index of the vertex to set.
     * @param v     The vertex to set.
     * @return The previous vertex at the specified index.
     */
    public VXy setVertex(int index, VXy v) {
        return this.v.set(index, v);
    }

    /**
     * Sets the vertex at the specified index with the specified coordinates.
     *
     * @param index The index of the vertex to set.
     * @param x     The x-coordinate of the vertex.
     * @param y     The y-coordinate of the vertex.
     * @return The previous vertex at the specified index.
     */
    public VXy setVertex(int index, float x, float y) {
        return this.v.set(index, new VXy(x, y));
    }

    /**
     * Moves the VPoly relative to its current position by the specified amount.
     * Please note that this method directly changes position of each coordinate.
     *
     * @param x The amount to move the VPoly horizontally.
     * @param y The amount to move the VPoly vertically.
     */
    public void toMovePolyRela(float x, float y) {
        for (int ct = 0; ct < v.size(); ct++) {
            v.get(ct).toMoveXYRelatively(x, y);
        }
    }

    /**
     * Returns the center vertex of the VPoly.
     *
     * @return The center vertex of the VPoly.
     */
    public VXy getCenter() {
        float sumX = 0;
        float sumY = 0;

        for (VXy vertex : v) {
            sumX += vertex.x.getActualValue();
            sumY += vertex.y.getActualValue();
        }

        float centerX = sumX / v.size();
        float centerY = sumY / v.size();

        return new VXy(centerX, centerY);
    }

    /**
     * Moves the VPoly to the specified position.
     * Please note that this method directly changes position of each coordinate.
     * @param x The x-coordinate of the new position.
     * @param y The y-coordinate of the new position.
     */
    public void toMovePoly(float x, float y) {
        VXy c = getCenter();
        toMovePolyRela(x - c.x.actualValue, y - c.y.actualValue);
    }

    /**
     * Moves the VPoly to the specified position using animation.
     * Please note that this method directly changes position of each coordinate
     * @param xy The new position as a VXy object.
     */
    public void toMovePoly(VXy xy) {
        VXy c = getCenter();
        toMovePolyRela(xy.x.actualValue - c.x.actualValue, xy.y.actualValue - c.y.actualValue);
    }

    /**
     * Move the vertexes of the VPoly by rotating using animation.
     * Please note that this method directly modifies the position of each coordinate.
     * @param f The angle by which to rotate the vertexes.
     */
    public void toMoveVertexesByRotating(float f) {
        acVertexesRotate = new AnimationController(0, f, v.get(0).x.maxFrame);
        VertexesRotateRequestedFrame = 1;
        beforeRotating.clear();
        for (VXy vertex : v) {
            beforeRotating.add(new VXy(vertex.x, vertex.y));
        }
    }

    /**
     * Moves the vertexes of the VPoly by rotating.
     *
     * @throws Exception If an error occurs while performing the rotation.
     */
    protected void actualMoveVertexesByRotating() throws Exception {
        if (VertexesRotateRequestedFrame == -1) {
            return;
        }
        if (VertexesRotateRequestedFrame <= v.get(0).x.maxFrame) {
            setVertexesByRotatingForAnimation(acVertexesRotate.getValue(VertexesRotateRequestedFrame));
            VertexesRotateRequestedFrame++;
        } else {
            VertexesRotateRequestedFrame = -1;
        }
    }

    /**
     * Sets the vertexes of the VPoly by rotating the specified angle.
     *
     * @param angle The angle by which to rotate the vertexes.
     */
    public void setVertexesByRotating(float angle) {
        VXy center = getCenter();
        VXy vertex;
        for (int ct = 0; ct < v.size(); ct++) {
            vertex = v.get(ct);
            float x = vertex.x.getActualValue();
            float y = vertex.y.getActualValue();

            // Calculate the coordinates relative to the center point
            float relativeX = x - center.x.getActualValue();
            float relativeY = y - center.y.getActualValue();

            // Apply the rotation transformation
            float rotatedX = relativeX * P2DViewer.pa.cos(angle) - relativeY * P2DViewer.pa.sin(angle);
            float rotatedY = relativeX * P2DViewer.pa.sin(angle) + relativeY * P2DViewer.pa.cos(angle);

            // Update the coordinates of the vertex
            vertex.x.setActualValue(rotatedX + center.x.getActualValue());
            vertex.y.setActualValue(rotatedY + center.y.getActualValue());
        }
    }

    /**
     * Sets the vertexes of the VPoly by rotating the specified angle for animation purposes.
     *
     * @param angle The angle by which to rotate the vertexes.
     */
    protected void setVertexesByRotatingForAnimation(float angle) {
        float sumX = 0;
        float sumY = 0;

        for (VXy vertex : beforeRotating) {
            sumX += vertex.x.getActualValue();
            sumY += vertex.y.getActualValue();
        }

        float centerX = sumX / beforeRotating.size();
        float centerY = sumY / beforeRotating.size();

        VXy center = new VXy(centerX, centerY);
        VXy vertex;
        for (int ct = 0; ct < beforeRotating.size(); ct++) {
            vertex = beforeRotating.get(ct);
            float x = vertex.x.getActualValue();
            float y = vertex.y.getActualValue();

            // Calculate the coordinates relative to the center point
            float relativeX = x - center.x.getActualValue();
            float relativeY = y - center.y.getActualValue();

            // Apply the rotation transformation
            float rotatedX = relativeX * P2DViewer.pa.cos(angle) - relativeY * P2DViewer.pa.sin(angle);
            float rotatedY = relativeX * P2DViewer.pa.sin(angle) + relativeY * P2DViewer.pa.cos(angle);

            // Update the coordinates of the vertex
            v.get(ct).x.setActualValue(rotatedX + center.x.getActualValue());
            v.get(ct).y.setActualValue(rotatedY + center.y.getActualValue());
        }
    }

    /**
     * Sets the position of the VPoly.
     * Note: This method is not available for VPoly.
     *
     * @param posi The position as a VXy object.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void setPosi(VXy posi) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Sets the position of the VPoly.
     * Note: This method is not available for VPoly.
     *
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void setPosi(float x, float y) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Moves the VPoly to the specified position.
     * Note: This method is not available for VPoly.
     *
     * @param x The x-coordinate of the new position.
     * @param y The y-coordinate of the new position.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void toMovePosi(float x, float y) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Moves the VPoly to the specified position relative to its current position.
     * Note: This method is not available for VPoly.
     *
     * @param x The amount to move the VPoly horizontally.
     * @param y The amount to move the VPoly vertically.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public void toMovePosiRelatively(float x, float y) throws Exception {
        throw new Exception("This method is not available for VPoly.");
    }

    /**
     * Returns the position of the VPoly as a VXy object.
     * Note: This method is not available for VPoly. Call getCenter() instead to get the middle point of VPoly.
     *
     * @return The position of the VPoly.
     * @throws Exception This method is not available for VPoly.
     */
    @Override
    public VXy getPosi() throws Exception {
        throw new Exception("This method is not available for VPoly. To check the middle point of VPoly, call getCenter() instead.");
    }

    /**
     * Checks if the animation for the VObj has finished.
     *
     * @return True if all frames of the animation are finished;
     *         false otherwise.
     */
    @Override
    public boolean isAnimationFinish() {
        boolean allFramesAreMinusOne = true;
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
        for (VXy v : this.v) {
            if (v.y.requestedFrame >-1) {
                return false;
            }
        }
        if (VertexesRotateRequestedFrame >-1) {
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
        fillA.actualMove();
        fillR.actualMove();
        fillG.actualMove();
        fillB.actualMove();
        stroB.actualMove();
        stroA.actualMove();
        stroG.actualMove();
        stroR.actualMove();
        stroWei.actualMove();
        actualMoveVertexesByRotating();
        for (int ct = 0; ct < v.size(); ct++) {
            v.get(ct).x.actualMove();
            v.get(ct).y.actualMove();
        }
    }

    /**
     * Sets the animation mode for the properties of this VObj.
     *
     * @param animationMode The animation mode to set.
     */
    public void setAnimationMode(int animationMode) {
        fillA.setAnimationMode(animationMode);
        fillR.setAnimationMode(animationMode);
        fillG.setAnimationMode(animationMode);
        fillB.setAnimationMode(animationMode);
        stroB.setAnimationMode(animationMode);
        stroA.setAnimationMode(animationMode);
        stroG.setAnimationMode(animationMode);
        stroR.setAnimationMode(animationMode);
        stroWei.setAnimationMode(animationMode);
        for (int ct = 0; ct < v.size(); ct++) {
            v.get(ct).setAnimationMode(animationMode);
        }
    }
    @Override
    public void unlockAllVariable()
    {
        stroB.actualMoveLock=false;
        stroA.actualMoveLock=false;
        stroG.actualMoveLock=false;
        stroR.actualMoveLock=false;
        fillB.actualMoveLock=false;
        fillA.actualMoveLock=false;
        fillG.actualMoveLock=false;
        fillR.actualMoveLock=false;
        stroWei.actualMoveLock=false;
        for (int ct = 0; ct < v.size(); ct++) {
            v.get(ct).x.actualMoveLock=false;
            v.get(ct).y.actualMoveLock=false;
        }
    }
}
