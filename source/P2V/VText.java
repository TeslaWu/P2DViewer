package P2V;

import processing.core.PFont;

/**
 * VText is a class that represents a text visual object in the application.
 * It extends the VObj abstract class and inherits its properties and methods.
 * However, some methods or properties are not available or read-only in VText, such as Stro, Widt, Heit, and so on.
 * @author Telsa
 */
public class VText extends VObj {

    /**
     * Represents the text you want to display.
     */
    String text;

    /**
     * Represents the font you want to apply to the text.
     */
    PFont font;

    /**
     * Represents the text size.
     */
    Variable size;

    /**
     * Constructs a new VText object with default values.
     */
    public VText() {
        text = "向您问好！ Greetings!";
        size = new Variable(47);
        fillA = new Variable(255);
        fillR = new Variable(0);
        fillG = new Variable(0);
        fillB = new Variable(0);
        Posi = new VXy(0, 0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VText object with the specified text.
     *
     * @param text The text to be displayed.
     */
    public VText(String text) {
        this.text = text;
        size = new Variable(47);
        fillA = new Variable(255);
        fillR = new Variable(0);
        fillG = new Variable(0);
        fillB = new Variable(0);
        Posi = new VXy(0, 0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VText object with the specified text and size.
     *
     * @param text The text to be displayed.
     * @param size The size of the text.
     */
    public VText(String text, float size) {
        this.text = text;
        this.size = new Variable(size);
        fillA = new Variable(255);
        fillR = new Variable(0);
        fillG = new Variable(0);
        fillB = new Variable(0);
        Posi = new VXy(0, 0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VText object with the specified text and size.
     *
     * @param text The text to be displayed.
     * @param size The size of the text.
     */
    public VText(String text, Variable size) {
        this.text = text;
        this.size = size;
        fillA = new Variable(255);
        fillR = new Variable(0);
        fillG = new Variable(0);
        fillB = new Variable(0);
        Posi = new VXy(0, 0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VText object with the specified text, size, and font.
     *
     * @param text The text to be displayed.
     * @param size The size of the text.
     * @param font The font to be applied to the text.
     */
    public VText(String text, float size, PFont font) {
        this.text = text;
        this.size = new Variable(size);
        this.font = font;
        fillA = new Variable(255);
        fillR = new Variable(0);
        fillG = new Variable(0);
        fillB = new Variable(0);
        Posi = new VXy(0, 0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VText object with the specified text, size, font, and fill color.
     *
     * @param text The text to be displayed.
     * @param size The size of the text.
     * @param font The font to be applied to the text.
     * @param a The alpha value of the fill color.
     * @param r The red value of the fill color.
     * @param g The green value of the fill color.
     * @param b The blue value of the fill color.
     */
    public VText(String text, float size, PFont font, float a, float r, float g, float b) {
        this.text = text;
        this.size = new Variable(size);
        this.font = font;
        fillA = new Variable(a);
        fillR = new Variable(r);
        fillG = new Variable(g);
        fillB = new Variable(b);
        Posi = new VXy(0, 0);
        id = VObj.idct;
        VObj.idct++;
    }

    /**
     * Gets the width of the text.
     *
     * @return The width of the text.
     * @throws Exception If the width is not available in VText.
     */
    @Override
    public Variable getWidt() throws Exception {
        throw new Exception("Please call getWidtFloat() instead.");
    }

    /**
     * Gets the width of the text as a floating-point value.
     *
     * @return The width of the text.
     */
    public float getWidtFloat() {
        return P2DViewer.pa.textWidth(text);
    }

    /**
     * Sets the width of the text.
     *
     * @param widt The width of the text.
     * @throws Exception Attribute Widt is read-only in VText.
     */
    @Override
    public void setWidt(Variable widt) throws Exception {
        throw new Exception("Attribute Widt is read-only in VText.");
    }

    /**
     * Sets the width of the text.
     *
     * @param x The width of the text.
     * @throws Exception Attribute Widt is read-only in VText.
     */
    @Override
    public void setWidt(float x) throws Exception {
        throw new Exception("Attribute Widt is read-only in VText.");
    }

    /**
     * Moves the width of the text by a relative value.
     *
     * @param x The relative value to move the width.
     * @throws Exception Attribute Widt is read-only in VText.
     */
    @Override
    public void toMoveWidtRelatively(float x) throws Exception {
        throw new Exception("Attribute Widt is read-only in VText.");
    }

    /**
     * Moves the width of the text.
     *
     * @param x The value to move the width.
     * @throws Exception Attribute Widt is read-only in VText.
     */
    @Override
    public void toMoveWidt(float x) throws Exception {
        throw new Exception("Attribute Widt is read-only in VText.");
    }

    /**
     * Gets the height of the text.
     *
     * @return The height of the text.
     * @throws Exception Attribute Heit is not available in VText.
     */
    @Override
    public Variable getHeit() throws Exception {
        throw new Exception("Attribute Heit is not available in VText.");
    }

    /**
     * Gets the red value of the stroke color.
     *
     * @return The red value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public Variable getStroR() throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Gets the green value of the stroke color.
     *
     * @return The green value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public Variable getStroG() throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Gets the blue value of the stroke color.
     *
     * @return The blue value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public Variable getStroB() throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Gets the alpha value of the stroke color.
     *
     * @return The alpha value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public Variable getStroA() throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Checks if no stroke is applied.
     *
     * @return true if no stroke is applied, false otherwise.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public boolean isNoStro() throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Gets the stroke weight.
     *
     * @return The stroke weight.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public Variable getStroWei() throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets the height of the text.
     *
     * @param heit The height of the text.
     * @throws Exception Attribute Heit is not available in VText.
     */
    @Override
    public void setHeit(Variable heit) throws Exception {
        throw new Exception("Attribute Heit is not available in VText.");
    }

    /**
     * Sets the height of the text.
     *
     * @param value The height of the text.
     * @throws Exception Attribute Heit is not available in VText.
     */
    @Override
    public void setHeit(float value) throws Exception {
        throw new Exception("Attribute Heit is not available in VText.");
    }

    /**
     * Moves the height of the text.
     *
     * @param value The value to move the height.
     * @throws Exception Attribute Heit is not available in VText.
     */
    @Override
    public void toMoveHeit(float value) throws Exception {
        throw new Exception("Attribute Heit is not available in VText.");
    }

    /**
     * Moves the height of the text by a relative value.
     *
     * @param value The relative value to move the height.
     * @throws Exception Attribute Heit is not available in VText.
     */
    @Override
    public void toMoveHeitRelatively(float value) throws Exception {
        throw new Exception("Attribute Heit is not available in VText.");
    }

    /**
     * Sets the red value of the stroke color.
     *
     * @param stroR The red value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setStroR(Variable stroR) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets the red value of the stroke color.
     *
     * @param value The red value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setStroR(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Moves the red value of the stroke color.
     *
     * @param value The value to move the red value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void toMoveStroR(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Moves the red value of the stroke color by a relative value.
     *
     * @param value The relative value to move the red value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void toMoveStroRRelatively(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets the green value of the stroke color.
     *
     * @param stroG The green value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setStroG(Variable stroG) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets the green value of the stroke color.
     *
     * @param value The green value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setStroG(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Moves the green value of the stroke color.
     *
     * @param value The value to move the green value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void toMoveStroG(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Moves the green value of the stroke color by a relative value.
     *
     * @param value The relative value to move the green value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void toMoveStroGRelatively(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets the blue value of the stroke color.
     *
     * @param stroB The blue value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setStroB(Variable stroB) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets the blue value of the stroke color.
     *
     * @param value The blue value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setStroB(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Moves the blue value of the stroke color.
     *
     * @param value The value to move the blue value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void toMoveStroB(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Moves the blue value of the stroke color by a relative value.
     *
     * @param value The relative value to move the blue value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void toMoveStroBRelatively(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets the alpha value of the stroke color.
     *
     * @param stroA The alpha value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setStroA(Variable stroA) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets the alpha value of the stroke color.
     *
     * @param value The alpha value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setStroA(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Moves the alpha value of the stroke color.
     *
     * @param value The value to move the alpha value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void toMoveStroA(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Moves the alpha value of the stroke color by a relative value.
     *
     * @param value The relative value to move the alpha value of the stroke color.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void toMoveStroARelatively(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets whether to apply stroke or not.
     *
     * @param noStro true to not apply stroke, false otherwise.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setNoStro(boolean noStro) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets the stroke weight.
     *
     * @param stroWei The stroke weight.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setStroWei(Variable stroWei) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Sets the stroke weight.
     *
     * @param value The stroke weight.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void setStroWei(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Moves the stroke weight.
     *
     * @param value The value to move the stroke weight.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void toMoveStroWei(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Moves the stroke weight by a relative value.
     *
     * @param value The relative value to move the stroke weight.
     * @throws Exception Stroking is not available in VText.
     */
    @Override
    public void toMoveStroWeiRelatively(float value) throws Exception {
        throw new Exception("Stroking is not available in VText.");
    }

    /**
     * Performs the actual movement of the VText object.
     *
     * @throws Exception If any of the attributes cannot be moved.
     */
    @Override
    public void actualMove() throws Exception {
        Posi.x.actualMove();
        Posi.y.actualMove();
        fillA.actualMove();
        fillR.actualMove();
        fillG.actualMove();
        fillB.actualMove();
    }

    /**
     * Sets the animation mode for all attributes of the VText object.
     *
     * @param animationMode The animation mode to be set.
     */
    public void setAnimationMode(int animationMode) {
        Posi.x.setAnimationMode(animationMode);
        Posi.y.setAnimationMode(animationMode);
        fillA.setAnimationMode(animationMode);
        fillR.setAnimationMode(animationMode);
        fillG.setAnimationMode(animationMode);
        fillB.setAnimationMode(animationMode);
        size.setAnimationMode(animationMode);
    }

    /**
     * Checks if the animation of the VText object has finished.
     *
     * @return true if all frames are minus one, false otherwise.
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
        if (size != null && size.requestedFrame >-1) {
            return false;
        }
        return allFramesAreMinusOne;
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
    }
}
