package P2V;

import processing.core.PGraphics;
import processing.core.PImage;

/**
 * VImg is a class that represents an image visual object in the application.
 * It extends the VObj abstract class and inherits its properties and methods.
 * However, some methods or properties are not available or readonly in VImg, such as Fill, Stro and so on.
 * @author Telsa
 */
public class VImg extends VObj
{
    /**
     * The tint* property represents the tint of the image.
     */
    Variable tintA;
    /**
     * The tint* property represents the tint of the image.
     */
    Variable tintR;
    /**
     * The tint* property represents the tint of the image.
     */
    Variable tintG;
    /**
     * The tint* property represents the tint of the image.
     */
    Variable tintB;

    /**
     * The image property represents the PImage you want to display.
     */
    PImage image;

    /**
     * The mask property represents the mask you want to apply on the image.
     */
    SubViewer mask;

    /**
     * The noMask property represents if you want to use the mask or not.
     */
    boolean noMask;

    /**
     * Constructs a new VImg object with default properties.
     */
    public VImg()
    {
        Posi=new VXy(0,0);
        tintA=new Variable(255);
        tintR=new Variable(255);
        tintG=new Variable(255);
        tintB=new Variable(255);
        image= P2DViewer.pa.createGraphics(740,470);
        Heit=new Variable(image.height);
        Widt=new Variable(image.width);
        id=VObj.idct;
        mask=new SubViewer(image.height,image.height);
        noMask=true;
        VObj.idct++;
    }

    /**
     * Constructs a new VImg object with the specified image file or URL.
     *
     * @param path The path to the image file.
     */
    public VImg(String path)
    {
        Posi=new VXy(0,0);
        tintA=new Variable(255);
        tintR=new Variable(255);
        tintG=new Variable(255);
        tintB=new Variable(255);
        image= P2DViewer.pa.loadImage(path);
        Heit=new Variable(image.height);
        Widt=new Variable(image.width);
        mask=new SubViewer(image.width,image.height);
        noMask=true;
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VImg object with the specified PGraphics object.
     *
     * @param pg The PGraphics object representing the image.
     */
    public VImg(PGraphics pg)
    {
        Posi=new VXy(0,0);
        tintA=new Variable(255);
        tintR=new Variable(255);
        tintG=new Variable(255);
        tintB=new Variable(255);
        image=pg.get();
        Heit=new Variable(image.height);
        Widt=new Variable(image.width);
        mask=new SubViewer(image.height,image.height);
        noMask=true;
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a new VImg object with the specified PImage object.
     *
     * @param pi The PImage object representing the image.
     */
    public VImg(PImage pi)
    {
        Posi=new VXy(0,0);
        tintA=new Variable(255);
        tintR=new Variable(255);
        tintG=new Variable(255);
        tintB=new Variable(255);
        image=pi;
        Heit=new Variable(image.height);
        Widt=new Variable(image.width);
        mask=new SubViewer(image.height,image.height);
        noMask=true;
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Makes all the properties of this VObj change to the status of next frame.
     *
     * @throws Exception If moving the visual object fails for some reason.
     */
    public void actualMove() throws Exception
    {
        Posi.x.actualMove();
        Posi.y.actualMove();
        tintR.actualMove();
        tintG.actualMove();
        tintB.actualMove();
        tintA.actualMove();
        if(!noMask)
            mask.actualMove();
    }

    /**
     * Returns the alpha component of the image tint color.
     *
     * @return The alpha component of the tint color.
     */
    public Variable getTintA() {
        return tintA;
    }

    /**
     * Sets the alpha component of the image tint color.
     *
     * @param tintA The alpha component of the tint color.
     */
    public void setTintA(Variable tintA) {
        this.tintA = tintA;
    }

    /**
     * Returns the red component of the image tint color.
     *
     * @return The red component of the tint color.
     */
    public Variable getTintR() {
        return tintR;
    }

    /**
     * Sets the red component of the image tint color.
     *
     * @param tintR The red component of the tint color.
     */
    public void setTintR(Variable tintR) {
        this.tintR = tintR;
    }

    /**
     * Returns the green component of the image tint color.
     *
     * @return The green component of the tint color.
     */
    public Variable getTintG() {
        return tintG;
    }

    /**
     * Sets the green component of the image tint color.
     *
     * @param tintG The green component of the tint color.
     */
    public void setTintG(Variable tintG) {
        this.tintG = tintG;
    }
    /**
     * Returns the blue component of the image tint color.
     *
     * @return The blue component of the tint color.
     */
    public Variable getTintB() {
        return tintB;
    }

    /**
     * Sets the blue component of the image tint color.
     *
     * @param tintB The blue component of the tint color.
     */
    public void setTintB(Variable tintB) {
        this.tintB = tintB;
    }


    /**
     * Throws an exception indicating that the fill red component is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public Variable getFillR() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that the fill green component is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public Variable getFillG() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that the fill blue component is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public Variable getFillB() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that the fill alpha component is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public Variable getFillA() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that the fill property is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public boolean isNoFill() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that the stroke red component is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public Variable getStroR() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that the stroke green component is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public Variable getStroG() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that the stroke blue component is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public Variable getStroB() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that the stroke alpha component is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public Variable getStroA() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that the stroke property is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public boolean isNoStro() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that the stroke weight is not available in VImg.
     *
     * @return This method always throws an exception.
     * @throws Exception Always throws an exception.
     */
    @Override
    public Variable getStroWei() throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the fill red component is not available in VImg.
     *
     * @param fillR The fill red component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFillR(Variable fillR) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the fill red component is not available in VImg.
     *
     * @param value The fill red value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFillR(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the fill red component is not available in VImg.
     *
     * @param value The amount to move the fill red component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveFillR(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the fill red component relatively is not available in VImg.
     *
     * @param value The relative amount to move the fill red component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveFillRRelatively(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the fill green component is not available in VImg.
     *
     * @param fillG The fill green component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFillG(Variable fillG) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the fill green component is not available in VImg.
     *
     * @param value The fill green value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFillG(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the fill green component is not available in VImg.
     *
     * @param value The amount to move the fill green component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveFillG(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the fill green component relatively is not available in VImg.
     *
     * @param value The relative amount to move the fill green component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveFillGRelatively(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the fill blue component is not available in VImg.
     *
     * @param fillB The fill blue component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFillB(Variable fillB) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the fill blue component is not available in VImg.
     *
     * @param value The fill blue value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFillB(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the fill blue component is not available in VImg.
     *
     * @param value The amount to move the fill blue component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveFillB(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the fill blue component relatively is not available in VImg.
     *
     * @param value The relative amount to move the fill blue component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveFillBRelatively(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the fill alpha component is not available in VImg.
     *
     * @param fillA The fill alpha component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFillA(Variable fillA) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the fill alpha component is not available in VImg.
     *
     * @param value The fill alpha value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFillA(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the fill alpha component is not available in VImg.
     *
     * @param value The amount to move the fill alpha component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveFillA(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the fill alpha component relatively is not available in VImg.
     *
     * @param value The relative amount to move the fill alpha component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveFillARelatively(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the noFill property is not available in VImg.
     *
     * @param noFill The noFill property value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setNoFill(boolean noFill) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the stroke red component is not available in VImg.
     *
     * @param stroR The stroke red component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setStroR(Variable stroR) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the stroke red component is not available in VImg.
     *
     * @param value The stroke red value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setStroR(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the stroke red component is not available in VImg.
     *
     * @param value The amount to move the stroke red component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveStroR(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the stroke red component relatively is not available in VImg.
     *
     * @param value The relative amount to move the stroke red component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveStroRRelatively(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the stroke green component is not available in VImg.
     *
     * @param stroG The stroke green component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setStroG(Variable stroG) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the stroke green component is not available in VImg.
     *
     * @param value The stroke green value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setStroG(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the stroke green component is not available in VImg.
     *
     * @param value The amount to move the stroke green component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveStroG(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the stroke green component relatively is not available in VImg.
     *
     * @param value The relative amount to move the stroke green component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveStroGRelatively(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the stroke blue component is not available in VImg.
     *
     * @param stroB The stroke blue component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setStroB(Variable stroB) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the stroke blue component is not available in VImg.
     *
     * @param value The stroke blue value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setStroB(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the stroke blue component is not available in VImg.
     *
     * @param value The amount to move the stroke blue component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveStroB(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the stroke blue component relatively is not available in VImg.
     *
     * @param value The relative amount to move the stroke blue component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveStroBRelatively(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the stroke alpha component is not available in VImg.
     *
     * @param stroA The stroke alpha component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setStroA(Variable stroA) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the stroke alpha component is not available in VImg.
     *
     * @param value The stroke alpha value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setStroA(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the stroke alpha component is not available in VImg.
     *
     * @param value The amount to move the stroke alpha component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveStroA(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the stroke alpha component relatively is not available in VImg.
     *
     * @param value The relative amount to move the stroke alpha component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveStroARelatively(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the noStro property is not available in VImg.
     *
     * @param noStro The noStro property value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setNoStro(boolean noStro) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the stroke weight is not available in VImg.
     *
     * @param stroWei The stroke weight.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setStroWei(Variable stroWei) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the stroke weight is not available in VImg.
     *
     * @param value The stroke weight value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setStroWei(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the stroke weight is not available in VImg.
     *
     * @param value The amount to move the stroke weight.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveStroWei(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that moving the stroke weight relatively is not available in VImg.
     *
     * @param value The relative amount to move the stroke weight.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void toMoveStroWeiRelatively(float value) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the fill ARGB values is not available in VImg.
     *
     * @param a The fill alpha component.
     * @param r The fill red component.
     * @param g The fill green component.
     * @param b The fill blue component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFillARGB(float a, float r, float g, float b) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Throws an exception indicating that setting the fill RGB values is not available in VImg.
     *
     * @param r The fill red component.
     * @param g The fill green component.
     * @param b The fill blue component.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFillRGB(float r, float g, float b) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }
    /**
     * Throws an exception indicating that setting the fill brightness is not available in VImg.
     *
     * @param brightness The fill brightness value.
     * @throws Exception Always throws an exception.
     */
    @Override
    public void setFill(float brightness) throws Exception {
        throw new Exception("Fill and Stroke is not available in VImg.");
    }

    /**
     * Retrieves the mask used by the VImg object.
     *
     * @return The mask used by the VImg object.
     */
    public SubViewer getMask() {
        return mask;
    }

    /**
     * Sets the mask for the VImg object.
     *
     * @param mask The mask to be set for the VImg object.
     */
    public void setMask(SubViewer mask) {
        this.mask = mask;
    }

    /**
     * Checks if the VImg object has no mask.
     *
     * @return {@code true} if the VImg object has no mask, {@code false} otherwise.
     */
    public boolean isNoMask() {
        return noMask;
    }

    /**
     * Sets whether the VImg object uses a mask or not.
     *
     * @param noMask {@code true} if the VImg object has no mask, {@code false} otherwise.
     */
    public void setNoMask(boolean noMask) {
        this.noMask = noMask;
    }

    /**
     * Checks if the animation for the VObj has finished.
     *
     * @return True if all frames of the animation are finished;
     *         false otherwise.
     */
    public boolean isAnimationFinish()
    {
        boolean allFramesAreMinusOne = true;
        if (Posi != null && Posi.x.requestedFrame >-1) {
            return false;
        }
        if (Posi != null && Posi.y.requestedFrame >-1) {
            return false;
        }
        if (tintR != null && tintR.requestedFrame >-1) {
            return false;
        }
        if (tintG != null && tintG.requestedFrame >-1) {
            return false;
        }
        if (tintB != null && tintB.requestedFrame >-1) {
            return false;
        }
        if (tintA != null && tintA.requestedFrame >-1) {
            return false;
        }
        if (Widt != null && Widt.requestedFrame >-1) {
            return false;
        }
        if (Heit != null && Heit.requestedFrame >-1) {
            return false;
        }
        return allFramesAreMinusOne;
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
        tintR.setAnimationMode(animationMode);
        tintG.setAnimationMode(animationMode);
        tintB.setAnimationMode(animationMode);
        tintA.setAnimationMode(animationMode);
        Widt.setAnimationMode(animationMode);
        Heit.setAnimationMode(animationMode);
    }

    /**
     * Applies the current mask to the VImg object.
     * This method sets the mask of the image and resets the mask properties to their initial values.
     */
    public void applyMask()
    {
        image.mask( mask.toPImage() );
        mask=new SubViewer(image.width,image.height);
        noMask=true;
    }

    @Override
    public void unlockAllVariable()
    {
        Posi.x.actualMoveLock=false;
        Posi.y.actualMoveLock=false;
        Widt.actualMoveLock=false;
        Heit.actualMoveLock=false;
        tintA.actualMoveLock=false;
        tintR.actualMoveLock=false;
        tintG.actualMoveLock=false;
        tintB.actualMoveLock=false;
    }
}
