package P2V;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import java.util.ArrayList;

/**
 * SubViewer is a class that represents PGraphics class in the P2DViewer.
 * It extends the VObj abstract class and inherits its properties and methods.
 * However, it also can render VObjs just like P2DViewer class.
 * Using SubViewer might cause performance problems.
 * @author Telsa
 */
public class SubViewer extends VObj
{
    /**
     * This property contains all the VObjs to render.
     */
    protected ArrayList<VObj> objs;

    /**
     * This property determines the degree of magnification of the field of view in the SubViewer.
     */
    protected Variable scale;

    /**
     * This property determines the position at which the current SubViewer is
     * displayed within its parent viewer (such as a higher-level SubViewer or P2DViewer).
     */
    protected VXy MotherViewerPosi;
    protected PGraphics pg;
    /**
     * This property determines whether the background() method should be applied during rendering to override the background.
     */
    protected boolean noFill;
    /**
     * Constructs a SubViewer object with the specified PGraphics object.
     *
     * @param pg The PGraphics object associated with the SubViewer.
     */
    public SubViewer(PGraphics pg)
    {
        Posi=new VXy(0,0);
        MotherViewerPosi=new VXy(0,0);
        scale=new Variable(1);
        fillR=new Variable(255);
        fillG=new Variable(255);
        fillB=new Variable(255);
        Widt=new Variable(pg.width);
        Heit=new Variable(pg.height);
        objs=new ArrayList<>();
        id=VObj.idct;
        VObj.idct++;
    }
    /**
     * Constructs a SubViewer object with the specified width and height.
     *
     * @param w The width of the SubViewer.
     * @param h The height of the SubViewer.
     */
    public SubViewer(float w,float h)
    {
        Posi=new VXy(0,0);
        MotherViewerPosi=new VXy(0,0);
        scale=new Variable(1);
        fillR=new Variable(255);
        fillG=new Variable(255);
        fillB=new Variable(255);
        Widt=new Variable(w);
        Heit=new Variable(h);
        objs=new ArrayList<>();
        id=VObj.idct;
        VObj.idct++;
    }

    /**
     * Constructs a SubViewer object with the specified position, width, and height.
     *
     * @param x The x-coordinate of the SubViewer's position.
     * @param y The y-coordinate of the SubViewer's position.
     * @param w The width of the SubViewer.
     * @param h The height of the SubViewer.
     */
    public SubViewer(float x,float y,float w,float h)
    {
        Posi=new VXy(0,0);
        MotherViewerPosi=new VXy(x,y);
        scale=new Variable(1);
        fillR=new Variable(255);
        fillG=new Variable(255);
        fillB=new Variable(255);
        Widt=new Variable(w);
        Heit=new Variable(h);
        objs=new ArrayList<>();
        id=VObj.idct;
        VObj.idct++;
    }
    private void realInitialization()
    {
        if(Widt==null)
        {
            Widt=new Variable(P2DViewer.pa.width);
            Heit=new Variable(P2DViewer.pa.height);
        }
        try {
            pg = P2DViewer.pa.createGraphics((int) Widt.actualValue, (int) Heit.actualValue);
        }
        catch(Exception E)
        {
            System.out.println("This SubViewer is being forced to initialized in setup.");
        }
    }

    /**
     * Gets the position of the SubViewer within its parent viewer.
     *
     * @return The position of the SubViewer.
     */
    public VXy getMotherViewerPosi() {
        return MotherViewerPosi;
    }

    /**
     * Checks if the SubViewer has noFill enabled.
     *
     * @return true if noFill is enabled, false otherwise.
     */
    @Override
    public boolean isNoFill() {
        return noFill;
    }

    /**
     * Sets the noFill property of the SubViewer.
     *
     * @param noFill The value to set for noFill.
     */
    @Override
    public void setNoFill(boolean noFill) {
        this.noFill = noFill;
    }

    /**
     * Gets the width variable of the SubViewer.
     *
     * @return The width variable.
     */
    public Variable getWidt()
    {
        return Widt;
    }

    /**
     * Sets the width variable of the SubViewer.
     *
     * @param widt The width variable to set.
     */
    public void setWidt(Variable widt)
    {
        Widt = widt;
        realInitialization();
    }

    /**
     * Gets the height variable of the SubViewer.
     *
     * @return The height variable.
     */
    public Variable getHeit()
    {
        return Heit;
    }

    /**
     * Sets the height variable of the SubViewer.
     *
     * @param heit The height variable to set.
     */
    public void setHeit(Variable heit)
    {
        Heit = heit;
        realInitialization();
    }

    /**
     * Gets the list of VObjs contained in the SubViewer.
     *
     * @return The list of VObjs.
     */
    public  ArrayList<VObj> getObjs() {
        return objs;
    }

    /**
     * Sets the list of VObjs for the SubViewer.
     *
     * @param objs The list of VObjs to set.
     */
    public  void setObjs(ArrayList<VObj> objs) {
        this.objs = objs;
    }

    /**
     * Gets the position the SubViewer is "looking" at.
     *
     * @return The position variable.
     */
    public  VXy getPosi() {
        return Posi;
    }

    /**
     * Sets the position the SubViewer is "looking" at.
     *
     * @param posi The position variable to set.
     */
    public  void setPosi(VXy posi) {
        Posi = posi;
    }

    /**
     * Gets the scale variable of the SubViewer.
     *
     * @return The scale variable.
     */
    public  Variable getScale() {
        return scale;
    }

    /**
     * Sets the scale variable of the SubViewer.
     *
     * @param scale The scale variable to set.
     */
    public  void setScale(Variable scale)
    {
        this.scale = scale;
    }

    /**
     * Sets the position of the SubViewer within its parent viewer using a VXy object.
     *
     * @param motherViewerPosi The position of the SubViewer within its parent viewer.
     * @throws Exception If an error occurs while setting the position.
     */
    public void setMotherViewerPosi(VXy motherViewerPosi) throws Exception {
        this.MotherViewerPosi = motherViewerPosi;
    }

    /**
     * Sets the position of the SubViewer within its parent viewer using x and y coordinates.
     *
     * @param x The x-coordinate of the SubViewer's position.
     * @param y The y-coordinate of the SubViewer's position.
     * @throws Exception If an error occurs while setting the position.
     */
    public void setMotherViewerPosi(float x, float y) throws Exception {
        MotherViewerPosi.x.setActualValue(x);
        MotherViewerPosi.y.setActualValue(y);
    }

    /**
     * Moves the position of the SubViewer within its parent viewer by the specified amount using x and y coordinates using animation.
     *
     * @param x The amount to move the SubViewer in the x-axis.
     * @param y The amount to move the SubViewer in the y-axis.
     * @throws Exception If an error occurs while moving the position.
     */
    public void toMoveMotherViewerPosi(float x, float y) throws Exception {
        MotherViewerPosi.x.toMoveValue(x);
        MotherViewerPosi.y.toMoveValue(y);
    }

    /**
     * Moves the position of the SubViewer within its parent viewer by the specified amount using animation.
     *
     * @param xy The amount to move the SubViewer in the x and y axes.
     * @throws Exception If an error occurs while moving the position.
     */
    public void toMoveMotherViewerPosi(VXy xy) throws Exception {
        MotherViewerPosi.x.toMoveValue(xy.x.actualValue);
        MotherViewerPosi.y.toMoveValue(xy.y.actualValue);
    }

    /**
     * Moves the position of the SubViewer within its parent viewer relatively by the specified amount using animation.
     *
     * @param x The relative amount to move the SubViewer in the x-axis.
     * @param y The relative amount to move the SubViewer in the y-axis.
     * @throws Exception If an error occurs while moving the position.
     */
    public void toMoveMotherViewerPosiRelatively(float x, float y) throws Exception {
        MotherViewerPosi.x.toMoveValueRelatively(x);
        MotherViewerPosi.y.toMoveValueRelatively(y);
    }

    /**
     * Sets the width of the SubViewer.
     *
     * @param x The width value to set.
     * @throws Exception If an error occurs while setting the width.
     */
    @Override
    public void setWidt(float x) throws Exception {
        super.setWidt(x);
        realInitialization();
    }

    /**
     * Moves the width of the SubViewer relatively by the specified amount using animation.
     *
     * @param x The relative amount to move the width.
     * @throws Exception If an error occurs while moving the width.
     */
    @Override
    public void toMoveWidtRelatively(float x) throws Exception {
        super.toMoveWidtRelatively(x);
        realInitialization();
    }

    /**
     * Moves the width of the SubViewer by the specified amount using animation.
     *
     * @param x The amount to move the width.
     * @throws Exception If an error occurs while moving the width.
     */
    @Override
    public void toMoveWidt(float x) throws Exception {
        super.toMoveWidt(x);
        realInitialization();
    }


    /**
     * Sets the height of the SubViewer.
     *
     * @param value The height value to set.
     * @throws Exception If an error occurs while setting the height.
     */
    @Override
    public void setHeit(float value) throws Exception {
        super.setHeit(value);
        realInitialization();
    }

    /**
     * Moves the height of the SubViewer by the specified amount using animation.
     *
     * @param value The amount to move the height.
     * @throws Exception If an error occurs while moving the height.
     */
    @Override
    public void toMoveHeit(float value) throws Exception {
        super.toMoveHeit(value);
        realInitialization();
    }

    /**
     * Moves the height of the SubViewer relatively by the specified amount using animation.
     *
     * @param value The relative amount to move the height.
     * @throws Exception If an error occurs while moving the height.
     */
    @Override
    public void toMoveHeitRelatively(float value) throws Exception {
        super.toMoveHeitRelatively(value);
        realInitialization();
    }

    /**
     * Checks if the animation of the SubViewer has finished.
     *
     * @return true if the animation has finished, false otherwise.
     */
    public  boolean isAnimationFinish()
    {
        boolean allFramesAreMinusOne = true;
        if (Posi != null && Posi.x.requestedFrame != -1) {
            return false;
        }
        if (Posi != null && Posi.y.requestedFrame != -1) {
            return false;
        }
        if (MotherViewerPosi != null && MotherViewerPosi.x.requestedFrame != -1) {
            return false;
        }
        if (MotherViewerPosi != null && MotherViewerPosi.y.requestedFrame != -1) {
            return false;
        }
        if (fillR != null && fillR.requestedFrame != -1) {
            return false;
        }
        if (fillG != null && fillG.requestedFrame != -1) {
            return false;
        }
        if (fillB != null && fillB.requestedFrame != -1) {
            return false;
        }
        if (scale!=null && scale.requestedFrame!=-1)
        {
            return false;
        }
        if (Widt!=null && Widt.requestedFrame!=-1)
        {
            return false;
        }
        if (Heit!=null && Heit.requestedFrame!=-1)
        {
            return false;
        }
        return allFramesAreMinusOne;
    }
    /**
     * Adds a VObj to the SubViewer.
     *
     * @param v The VObj to add.
     */
    public  void addVObj(VObj v)
    {
        objs.add(v);
    }

    /**
     * Retrieves the VObj at the specified index from the SubViewer's list of VObjs.
     *
     * @param index The index of the VObj to retrieve.
     * @return The VObj at the specified index, or null if not found.
     */
    public  VObj getVObjByIndex(int index)
    {
        return objs.get(index);
    }

    /**
     * Retrieves the VObj with the specified ID from the SubViewer's list of VObjs.
     *
     * @param id The ID of the VObj to retrieve.
     * @return The VObj with the specified ID, or null if not found.
     */
    public  VObj getVObjById(int id)
    {
        for (int ct=0;ct<objs.size();ct++)
        {
            if (objs.get(ct).getId()==id)
            {
                return objs.get(ct);
            }
        }
        return null;
    }

    /**
     * Removes the VObj at the specified index from the SubViewer's list of VObjs.
     *
     * @param index The index of the VObj to remove.
     */
    public  void removeVObjByIndex(int index)
    {
        objs.remove(index);
    }

    /**
     * Removes the VObj with the specified ID from the SubViewer's list of VObjs.
     *
     * @param id The ID of the VObj to remove.
     * @return The index of the removed VObj if found, or -1 if the VObj with the specified ID was not found.
     */
    public  int removeVObjById(int id)
    {
        for (int ct=0;ct<objs.size();ct++)
        {
            if (objs.get(ct).getId()==id)
            {
                objs.remove(ct);
                return ct;
            }
        }
        return -1;
    }

    /**
     * Move the VObj with the specified index to the end of the objs list.
     *
     * Attention, SubViewer renders graphics in the order specified by the
     * objs list, so the graphics that are placed towards the end of the
     * list will be less likely to be obscured. This is also why the
     * function "putVObjToTopByIndex()" actually puts the VObj object
     * at the end of the objs list.
     * @param index The ID of the VObj to remove.
     */
    public  void putVObjToTopByIndex(int index)
    {
        VObj i=objs.get(index);
        objs.remove(index);
        objs.add(i);
    }

    /**
     * Move the VObj with the specified ID to the end of the objs list.
     *
     * Attention, SubViewer renders graphics in the order specified by the
     * objs list, so the graphics that are placed towards the end of the
     * list will be less likely to be obscured. This is also why the
     * function "putVObjToTopByIndex()" actually puts the VObj object
     * at the end of the objs list.
     * @param id The ID of the VObj to remove.
     * @return The index of the moved VObj if found, or -1 if the VObj with the specified ID was not found.
     */
    public  int putVObjToTopById(int id)
    {
        VObj i;
        for (int ct=0;ct<objs.size();ct++)
        {
            if (objs.get(ct).getId()==id)
            {
                i=objs.get(ct);
                objs.remove(ct);
                objs.add(i);
                return ct;
            }
        }
        return -1;
    }

    /**
     * Move the VObj with the specified index to the head of the objs list.
     *
     * Attention, SubViewer renders graphics in the order specified by the
     * objs list, so the graphics that are placed towards the end of the
     * list will be less likely to be obscured. This is also why the
     * function "putVObjToBottomByIndex()" actually puts the VObj object
     * at the head of the objs list.
     * @param index The ID of the VObj to remove.
     */
    public  void putVObjToBottomByIndex(int index)
    {
        VObj i=objs.get(index);
        objs.remove(index);
        objs.add(0,i);
    }

    /**
     * Moves the VObj at the specified index to a new position in the objs list.
     *
     * Attention, SubViewer renders graphics in the order specified by the
     * objs list, so the graphics that are placed towards the end of the
     * list will be less likely to be obscured. This is also why the
     * function "putVObjToBottomByIndex()" actually puts the VObj object
     * at the head of the objs list.
     *
     * @param index The index of the VObj to move.
     * @param pos The new position in the objs list where the VObj will be placed.
     */
    public  void putVObjToSomewhereByIndex(int index,int pos)
    {
        VObj i=objs.get(index);
        objs.remove(index);
        objs.add(pos,i);
    }

    /**
     * Move the VObj with the specified index to the head of the objs list.
     *
     * Attention, SubViewer renders graphics in the order specified by the
     * objs list, so the graphics that are placed towards the end of the
     * list will be less likely to be obscured. This is also why the
     * function "putVObjToBottomByIndex()" actually puts the VObj object
     * at the head of the objs list.
     * @param id The ID of the VObj to remove.
     * @return The index of the moved VObj if found, or -1 if the VObj with the specified ID was not found.
     */
    public  int putVObjToBottomById(int id)
    {
        VObj i;
        for (int ct=0;ct<objs.size();ct++)
        {
            if (objs.get(ct).getId()==id)
            {
                i=objs.get(ct);
                objs.remove(ct);
                objs.add(0,i);
                return ct;
            }
        }
        return -1;
    }

    /**
     * Moves the VObj with the specified ID to a new position in the objs list.
     *
     * Attention, SubViewer renders graphics in the order specified by the
     * objs list, so the graphics that are placed towards the end of the
     * list will be less likely to be obscured. This is also why the
     * function "putVObjToBottomByIndex()" actually puts the VObj object
     * at the head of the objs list.
     *
     * @param id The ID of the VObj to move.
     * @param pos The new position in the objs list where the VObj will be placed.
     * @return The index of the moved VObj if found, or -1 if the VObj with the specified ID was not found.
     */
    public int putVObjToSomewhereById(int id,int pos)
    {
        VObj i;
        for (int ct=0;ct<objs.size();ct++)
        {
            if (objs.get(ct).getId()==id)
            {
                i=objs.get(ct);
                objs.remove(ct);
                objs.add(pos,i);
                return ct;
            }
        }
        return -1;
    }

    /**

     Draws the objects contained in the SubViewer.
     This method is responsible for rendering the objects within the SubViewer onto the associated PGraphics instance.
     This method calls the actualMove() method of each object to update its movement.
     If you add SubViewer into P2DViewer, when you call P2DViewer.drawObj(), this method will be automatically called too.
     @throws Exception if an exception occurs during the rendering process.
     */
    public void drawObj() throws Exception
    {
        if(pg==null)
        {
            realInitialization();
        }
        try
        {
            actualMove();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        pg.smooth();
        pg.beginDraw();
        pg.translate(pg.width/2,pg.height/2);
        pg.textAlign(PApplet.CENTER,PApplet.CENTER);
        pg.rectMode(PApplet.CENTER);
        pg.ellipseMode(PApplet.CENTER);
        if(!noFill)
            pg.background(fillR.actualValue,fillG.actualValue,fillB.actualValue);
        pg.imageMode(PApplet.CENTER);
        for(int ct=0;ct<objs.size();ct++)
        {
            VObj ao=objs.get(ct);
            try{pg.fill(ao.fillR.actualValue,ao.fillG.actualValue,ao.fillB.actualValue,ao.fillA.actualValue);
            }catch(Exception e){}
            try{pg.stroke(ao.stroR.actualValue,ao.stroG.actualValue,ao.stroB.actualValue,ao.stroA.actualValue);
            }catch (Exception e){}
            try{pg.strokeWeight(ao.stroWei.actualValue* scale.actualValue);
            }catch (Exception e){}
            try{if(ao.noFill)
            {
                pg. noFill();
            }}catch (Exception e){}
            try{if(ao.noStro)
            {
                pg. noStroke();
            }}catch (Exception e){}
            if(ao instanceof VText)
            {   if (((VText) ao).font!=null)
            {
                pg.textFont(((VText) ao).font);
            }
                if(((VText) ao).size!=null)
                {
                    pg.textSize(((VText) ao).size.actualValue*scale.actualValue);
                }
                else
                {
                    pg.textSize(47* scale.actualValue);
                }
                pg.text(((VText) ao).text,(ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue ,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue );
            }
            else if(ao instanceof VPoly)
            {
                pg.beginShape();
                for(VXy p:((VPoly) ao).v)
                {
                    pg.vertex((p.x.actualValue-Posi.x.actualValue)*scale.actualValue,(p.y.actualValue-Posi.y.actualValue)* scale.actualValue);
                }
                pg.endShape(PApplet.CLOSE);
            }
            else if(ao instanceof VElps)
            {
                if(((VElps)ao).spin.actualValue==0 || ((VElps)ao).spin.actualValue %(2*PApplet.PI)==0)
                    pg.ellipse((ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue,ao.Widt.actualValue*scale.actualValue,ao.Heit.actualValue*scale.actualValue);
                else
                {
                    float x= (ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue;
                    float y=(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue;
                    float w=ao.Widt.actualValue*scale.actualValue;
                    float h=ao.Heit.actualValue*scale.actualValue;
                    float angle=((VElps)ao).spin.actualValue;
                    float step = PApplet.TWO_PI / 100;
                    pg.beginShape();
                    for (float theta = 0; theta < PApplet.TWO_PI; theta += step) {
                        float ex = x + w / 2 * PApplet.cos(theta);
                        float ey = y + h / 2 * PApplet.sin(theta);
                        float rx = x + (ex - x) * PApplet.cos(angle) - (ey - y) * PApplet.sin(angle);
                        float ry = y + (ex - x) * PApplet.sin(angle) + (ey - y) * PApplet.cos(angle);
                        pg.vertex(rx, ry);
                    }
                    pg.endShape(PApplet.CLOSE);
                }
            }
            else if(ao instanceof VRect)
            {
                if(((VRect)ao).spin.actualValue==0 || ((VRect)ao).spin.actualValue %(2*PApplet.PI)==0)
                    pg.rect((ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue,ao.Widt.actualValue*scale.actualValue,ao.Heit.actualValue*scale.actualValue,((VRect)ao).getRoundedCorner(0).actualValue,((VRect)ao).getRoundedCorner(1).actualValue,((VRect)ao).getRoundedCorner(2).actualValue,((VRect)ao).getRoundedCorner(3).actualValue);
                else
                {
                    float x= (ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue;
                    float y=(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue;
                    float w=ao.Widt.actualValue*scale.actualValue;
                    float h=ao.Heit.actualValue*scale.actualValue;
                    float a=((VRect)ao).spin.actualValue;
                    float x1 = -w/2;
                    float y1 = -h/2;
                    float x2 = w/2;
                    float y2 = -h/2;
                    float x3 = -w/2;
                    float y3 = h/2;
                    float x4 = w/2;
                    float y4 = h/2;
                    float newX1 = x + x1 * PApplet.cos(a) - y1 * PApplet.sin(a);
                    float newY1 = y + x1 * PApplet.sin(a) + y1 * PApplet.cos(a);
                    float newX2 = x + x2 * PApplet.cos(a) - y2 * PApplet.sin(a);
                    float newY2 = y + x2 * PApplet.sin(a) + y2 * PApplet.cos(a);
                    float newX3 = x + x3 * PApplet.cos(a) - y3 * PApplet.sin(a);
                    float newY3 = y + x3 * PApplet.sin(a) + y3 * PApplet.cos(a);
                    float newX4 = x + x4 * PApplet.cos(a) - y4 * PApplet.sin(a);
                    float newY4 = y + x4 * PApplet.sin(a) + y4 * PApplet.cos(a);
                    pg.beginShape();
                    pg.vertex(newX1, newY1);
                    pg. vertex(newX2, newY2);
                    pg.vertex(newX4, newY4);
                    pg.vertex(newX3, newY3);
                    pg. endShape(PApplet.CLOSE);
                }
            }
            else if(ao instanceof VLine)
            {
                pg.line((ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue, (((VLine) ao).PosiE.x.actualValue-Posi.x.actualValue)*scale.actualValue,(((VLine) ao).PosiE.y.actualValue-Posi.y.actualValue)*scale.actualValue);
            }
            else if(ao instanceof VImg)
            {
                pg.tint(((VImg) ao).tintR.actualValue,((VImg) ao).tintG.actualValue,((VImg) ao).tintB.actualValue,((VImg) ao).tintA.actualValue);
                if(!((VImg) ao).noMask)
                {
                    PImage t=((VImg) ao).image;
                    ((VImg) ao).mask.drawObj();
                    t.mask(((VImg) ao).mask.toPImage());
                    pg.image(t,(ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue,ao.Widt.actualValue*scale.actualValue,ao.Heit.actualValue*scale.actualValue);
                }
                else
                {
                    pg.image(((VImg) ao).image,(ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue,ao.Widt.actualValue*scale.actualValue,ao.Heit.actualValue*scale.actualValue);
                }
            }
            else if(ao instanceof SubViewer)
            {
                ((SubViewer) ao).drawObj();
                pg.image(((SubViewer) ao).pg,(((SubViewer) ao).MotherViewerPosi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(((SubViewer) ao).MotherViewerPosi.y.actualValue-Posi.y.actualValue)*scale.actualValue,ao.Widt.actualValue*scale.actualValue,ao.Heit.actualValue*scale.actualValue);
            }
            //pg.popMatrix();
            try
            {
                if(ao instanceof VElps)
                {
                    ((VElps)ao).actualMove();
                }
                else if(ao instanceof VLine)
                {
                    ((VLine)ao).actualMove();
                }
                else if(ao instanceof VPoly)
                {
                    ((VPoly)ao).actualMove();
                }
                else if(ao instanceof VRect)
                {
                    ((VRect)ao).actualMove();
                }
                else if(ao instanceof VText)
                {
                    ((VText)ao).actualMove();
                }
                else if(ao instanceof VImg)
                {
                    ((VImg)ao).actualMove();
                }
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }

        pg.endDraw();
    }

    /**
     * Makes all the properties of this VObj change to the status of next frame.
     *
     * @throws Exception If moving the visual object fails for some reason.
     */
    public  void actualMove() throws Exception
    {
        Posi.x.actualMove();
        Posi.y.actualMove();
        MotherViewerPosi.x.actualMove();
        MotherViewerPosi.y.actualMove();
        Widt.actualMove();
        Heit.actualMove();
        if(Widt.actualValue!=pg.width || Heit.actualValue!=pg.height)
        {
            realInitialization();
        }
        fillR.actualMove();
        fillG.actualMove();
        fillB.actualMove();
        scale.actualMove();
    }

    /**

     Sets the fill color of the SubViewer using RGB values.
     @param r the red component of the fill color (0-255)
     @param g the green component of the fill color (0-255)
     @param b the blue component of the fill color (0-255)
     */
    public void setFillRGB(float r,float g,float b)
    {
        fillR=new Variable(r);
        fillG=new Variable(g);
        fillB=new Variable(b);
    }

    /**

     Sets the fill color of the SubViewer using a single brightness value.
     @param brightness the brightness component of the fill color (0-255)
     */
    public void setFill(float brightness)
    {
        fillR=new Variable(brightness);
        fillG=new Variable(brightness);
        fillB=new Variable(brightness);
    }

    /**

     Returns the underlying PGraphics instance of the SubViewer.
     @return the PGraphics instance associated with the SubViewer
     */
    public PGraphics toPGraphics()
    {
        return pg;
    }

    /**

     Converts the SubViewer to a PImage by capturing the current state of the PGraphics instance.
     @return a PImage representation of the SubViewer
     */
    public PImage toPImage()
    {
        return pg.get();
    }

    /**

     Converts the SubViewer to a VImg object by capturing the current state of the PGraphics instance.
     If the PGraphics instance is not initialized, it will be initialized before creating the VImg object.
     @return a VImg object representing the SubViewer
     */
    public VImg toVImg()
    {
        if(pg==null)
        {
            realInitialization();
        }
        return new VImg(pg.get());
    };

    @Override
    public void unlockAllVariable()
    {
        Posi.x.actualMoveLock=false;
        Posi.y.actualMoveLock=false;
        MotherViewerPosi.x.actualMoveLock=false;
        MotherViewerPosi.y.actualMoveLock=false;

        Widt.actualMoveLock=false;
        Heit.actualMoveLock=false;
        fillB.actualMoveLock=false;
        fillG.actualMoveLock=false;
        fillR.actualMoveLock=false;
        scale.actualMoveLock=false;
    }
}
