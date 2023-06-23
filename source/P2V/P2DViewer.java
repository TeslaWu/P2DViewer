package P2V;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

/**
 * P2DViewer is the very main class of P2DViewer library.
 * This class is in charge of rendering any visual objects.
 * @author Telsa
 */
public class P2DViewer
{
    /**

     If this value is set non-0, all the toMove animation will not be triggered until sendAnimationOrderForPlaying equals to this value.
     */
    public static int sendAnimationOrderForEditing = 0;
    /**

     If sendAnimationOrderForEditing is set non-0, all the toMove animation will not be triggered until this value equals to sendAnimationOrderForEditing.
     */
    public static int sendAnimationOrderForPlaying = 0;

    /**

     If sharedVariableMode is set false, a Variable could be actualMove() multiple times during a drawObj().
     */
    public static boolean sharedVariableMode=true;
    /**

     The PApplet instance associated with the P2DViewer.
     */
    protected static PApplet pa;
    /**

     The list of VObjs in the P2DViewer.
     */
    protected static ArrayList<VObj> objs = new ArrayList<>();
    /**

     The position of the P2DViewer.
     */
    protected static VXy Posi;
    /**

     The scale of the P2DViewer.
     */
    protected static Variable scale;
    /**

     A flag indicating whether to fill shapes in the P2DViewer.
     */
    public static boolean noFill;
    /**

     The red component of the fill color in the P2DViewer.
     */
    protected static Variable fillR;
    /**

     The green component of the fill color in the P2DViewer.
     */
    protected static Variable fillG;
    /**

     The blue component of the fill color in the P2DViewer.
     */
    protected static Variable fillB;
    /**

     The frame count for one move in the P2DViewer.
     */
    public static int frameCountOfOneMove = 60;
    /**

     The default animation mode for the P2DViewer.
     */
    public static int defaultAnimationMode = 1;

    /**
     * Use P2DViewer.init(this); to make P2DViewer able to control Processing PApplet.
     * @param p the PApplet you want to control.
     */
    public static void init(PApplet p)
    {
        pa =p;
        Posi=new VXy(0,0);
        scale=new Variable(1);
        fillR=new Variable(47);
        fillG=new Variable(47);
        fillB=new Variable(47);
        noFill=false;
    }
    // For Posi
    /**
     * Moves the viewer to the specified position using animation.
     *
     * @param x the x-coordinate of the position
     * @param y the y-coordinate of the position
     * @throws Exception if an error occurs during the move
     */
    public static void toMovePosi(float x, float y) throws Exception {
        Posi.x.toMoveValue(x);
        Posi.y.toMoveValue(y);
    }

    /**
     * Moves the viewer to the specified position using animation.
     *
     * @param xy the position as a VXy object
     * @throws Exception if an error occurs during the move
     */
    public static void toMovePosi(VXy xy) throws Exception {
        Posi.x.toMoveValue(xy.x.actualValue);
        Posi.y.toMoveValue(xy.y.actualValue);
    }

    /**
     * Moves the viewer to the specified position relative to its current position using animation.
     *
     * @param x the amount to move along the x-axis
     * @param y the amount to move along the y-axis
     * @throws Exception if an error occurs during the move
     */
    public static void toMovePosiRelatively(float x, float y) throws Exception {
        Posi.x.toMoveValueRelatively(x);
        Posi.y.toMoveValueRelatively(y);
    }

    /**
     * Moves the viewer by the specified scale value using animation.
     *
     * @param value the scale value
     * @throws Exception if an error occurs during the move
     */
    public static void toMoveScale(float value) throws Exception {
        scale.toMoveValue(value);
    }

    /**
     * Moves the viewer by the specified scale value relative to its current scale using animation.
     *
     * @param value the relative scale value
     * @throws Exception if an error occurs during the move
     */
    public static void toMoveScaleRelatively(float value) throws Exception {
        scale.toMoveValueRelatively(value);
    }

    /**
     * Moves the viewer's fill color to the specified red value using animation.
     *
     * @param value the red component of the fill color
     * @throws Exception if an error occurs during the move
     */
    public static void toMoveFillR(float value) throws Exception {
        fillR.toMoveValue(value);
    }

    /**
     * Moves the viewer's fill color to the specified red value relative to its current red value using animation.
     *
     * @param value the relative red component of the fill color
     * @throws Exception if an error occurs during the move
     */
    public static void toMoveFillRRelatively(float value) throws Exception {
        fillR.toMoveValueRelatively(value);
    }

    /**
     * Moves the viewer's fill color to the specified green value using animation.
     *
     * @param value the green component of the fill color
     * @throws Exception if an error occurs during the move
     */
    public static void toMoveFillG(float value) throws Exception {
        fillG.toMoveValue(value);
    }

    /**
     * Moves the viewer's fill color to the specified green value relative to its current green value using animation.
     *
     * @param value the relative green component of the fill color
     * @throws Exception if an error occurs during the move
     */
    public static void toMoveFillGRelatively(float value) throws Exception {
        fillG.toMoveValueRelatively(value);
    }

    /**
     * Moves the viewer's fill color to the specified blue value using animation.
     *
     * @param value the blue component of the fill color
     * @throws Exception if an error occurs during the move
     */
    public static void toMoveFillB(float value) throws Exception {
        fillB.toMoveValue(value);
    }

    /**
     * Moves the viewer's fill color to the specified blue value relative to its current blue value using animation.
     *
     * @param value the relative blue component of the fill color
     * @throws Exception if an error occurs during the move
     */
    public static void toMoveFillBRelatively(float value) throws Exception {
        fillB.toMoveValueRelatively(value);
    }

    /**
     * Returns the list of VObj objects in the viewer.
     *
     * @return the list of VObj objects
     */
    public static ArrayList<VObj> getObjs() {
        return objs;
    }

    /**
     * Sets the list of VObj objects in the viewer.
     *
     * @param objs the list of VObj objects
     */
    public static void setObjs(ArrayList<VObj> objs) {
        P2DViewer.objs = objs;
    }

    /**
     * Returns the current position the viewer is "looking" at.
     *
     * @return the position as a VXy object
     */
    public static VXy getPosi() {
        return Posi;
    }

    /**
     * Sets the position the viewer is "looking" at.
     *
     * @param posi the position as a VXy object
     */
    public static void setPosi(VXy posi) {
        Posi = posi;
    }

    /**
     * Returns the current scale of the viewer.
     *
     * @return the scale as a Variable object
     */
    public static Variable getScale() {
        return scale;
    }

    /**
     * Sets the scale of the viewer.
     *
     * @param scale the scale as a Variable object
     */
    public static void setScale(Variable scale) {
        P2DViewer.scale = scale;
    }

    /**
     * Returns the current red component of the fill color.
     *
     * @return the red component of the fill color
     */
    public static Variable getFillR() {
        return fillR;
    }

    /**
     * Sets the red component of the fill color.
     *
     * @param fillR the red component of the fill color
     */
    public static void setFillR(Variable fillR) {
        P2DViewer.fillR = fillR;
    }

    /**
     * Returns the current green component of the fill color.
     *
     * @return the green component of the fill color
     */
    public static Variable getFillG() {
        return fillG;
    }

    /**
     * Sets the green component of the fill color.
     *
     * @param fillG the green component of the fill color
     */
    public static void setFillG(Variable fillG) {
        P2DViewer.fillG = fillG;
    }

    /**
     * Returns the current blue component of the fill color.
     *
     * @return the blue component of the fill color
     */
    public static Variable getFillB() {
        return fillB;
    }

    /**
     * Sets the blue component of the fill color.
     *
     * @param fillB the blue component of the fill color
     */
    public static void setFillB(Variable fillB) {
        P2DViewer.fillB = fillB;
    }

    /**
     * Checks if the animation is finished.
     *
     * @return true if the animation is finished, false otherwise
     */
    public static boolean isAnimationFinish()
    {
        boolean allFramesAreMinusOne = true;
        if (Posi != null && Posi.x.requestedFrame != -1) {
            return false;
        }
        if (Posi != null && Posi.y.requestedFrame != -1) {
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
        return allFramesAreMinusOne;
    }

    /**
     * Adds a VObj object to the viewer.
     *
     * @param v the VObj object to add
     */
    public static void addVObj(VObj v)
    {
        objs.add(v);
    }
    /**
     * Adds an array of VObj objects to the viewer.
     *
     * @param v the array of VObj objects to add
     */
    public static void addVObj(VObj... v)
    {
        for(int ct=0;ct<v.length;ct++)
        {
            objs.add(v[ct]);
        }
    }

    /**
     * Returns the VObj object at the specified index in the viewer's list of objects.
     *
     * @param index the index of the VObj object
     * @return the VObj object
     */
    public static VObj getVObjByIndex(int index)
    {
        return objs.get(index);
    }

    /**
     * Returns the VObj object with the specified ID in the viewer's list of objects.
     *
     * @param id the ID of the VObj object
     * @return the VObj object
     */
    public static VObj getVObjById(int id)
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
     * Removes the VObj object at the specified index from the viewer's list of objects.
     *
     * @param index the index of the VObj object to remove
     */
    public static void removeVObjByIndex(int index)
    {
        objs.remove(index);
    }

    /**
     * Removes the VObj object with the specified ID from the viewer's list of objects.
     *
     * @param id the ID of the VObj object to remove
     * @return the index of the removed VObj object, or -1 if the object was not found
     */
    public static int removeVObjById(int id)
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
     * Returns the number of VObj objects in the viewer's list of objects.
     *
     * @return the number of VObj objects
     */
    public static int getVObjCount()
    {
        return objs.size();
    }

    /**
     * Moves the VObj object at the specified index to the top of the viewer's list of objects.
     *
     * @param index the index of the VObj object
     */
    public static void putVObjToTopByIndex(int index)
    {
        VObj i=objs.get(index);
        objs.remove(index);
        objs.add(i);
    }

    /**
     * Move the VObj with the specified ID to the end of the objs list.
     *
     * Attention, P2DViewer renders graphics in the order specified by the
     * objs list, so the graphics that are placed towards the end of the
     * list will be less likely to be obscured. This is also why the
     * function "putVObjToTopByIndex()" actually puts the VObj object
     * at the end of the objs list.
     * @param id The ID of the VObj to remove.
     * @return The index of the moved VObj if found, or -1 if the VObj with the specified ID was not found.
     */
    public static int putVObjToTopById(int id)
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
     * Attention, P2DViewer renders graphics in the order specified by the
     * objs list, so the graphics that are placed towards the end of the
     * list will be less likely to be obscured. This is also why the
     * function "putVObjToBottomByIndex()" actually puts the VObj object
     * at the head of the objs list.
     * @param index The ID of the VObj to remove.
     */
    public static void putVObjToBottomByIndex(int index)
    {
        VObj i=objs.get(index);
        objs.remove(index);
        objs.add(0,i);
    }

    /**

     Moves the VObj at the specified index to a new position in the P2DViewer's list of VObjs.
     The order of rendering in P2DViewer is based on the order of VObjs in the list.
     VObjs placed towards the end of the list will be less likely to be obscured.
     @param index The index of the VObj to move.
     @param pos The new position in the P2DViewer's list where the VObj will be placed.
     */
    public static void putVObjToSomewhereByIndex(int index,int pos)
    {
        VObj i=objs.get(index);
        objs.remove(index);
        objs.add(pos,i);
    }

    /**

     Moves the VObj at the specified index to the beginning of the P2DViewer's list of VObjs.
     The order of rendering in P2DViewer is based on the order of VObjs in the list.
     VObjs placed towards the beginning of the list will be less likely to be obscured.
     @param id The id of the VObj to move.
     */
    public static int putVObjToBottomById(int id)
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

     Moves the VObj at the specified index to a new position in the P2DViewer's list of VObjs.
     The order of rendering in P2DViewer is based on the order of VObjs in the list.
     VObjs placed towards the end of the list will be less likely to be obscured.
     @param id The id of the VObj to move.
     @param pos The new position in the P2DViewer's list where the VObj will be placed.
     */
    public static int putVObjToSomewhereById(int id,int pos)
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
     * Makes all the properties of P2DViewer change to the status of next frame.
     *
     * @throws Exception If moving the visual object fails for some reason.
     */
    public static void actualMove() throws Exception
    {
        Posi.x.actualMove();
        Posi.y.actualMove();
        fillR.actualMove();
        fillG.actualMove();
        fillB.actualMove();
        scale.actualMove();
    }

    /**
     * Sets the fill color of the viewer using RGB values.
     *
     * @param r the red component of the fill color
     * @param g the green component of the fill color
     * @param b the blue component of the fill color
     */
    public static void setFillRGB(float r,float g,float b)
    {
        fillR=new Variable(b);
        fillG=new Variable(g);
        fillB=new Variable(b);
    }

    /**
     * Sets the fill color of the viewer using a brightness value.
     *
     * @param brightness the brightness of the fill color (0-255)
     */
    public static void setFill(float brightness)
    {
        fillR=new Variable(brightness);
        fillG=new Variable(brightness);
        fillB=new Variable(brightness);
    }

    /**

     Draws the objects contained in the P2DViewer.
     This method is responsible for rendering the objects within the P2DViewer onto the associated PGraphics instance.
     This method calls the actualMove() method of each object to update its movement.
     This method is recommended to be put in draw() of Processing.
     @throws Exception if an exception occurs during the rendering process.
     */
    public static void drawObj() throws Exception {
        for(int ct=0;ct<objs.size();ct++)
        {
            objs.get(ct).unlockAllVariable();
        }
        scale.actualMoveLock = false;
        Posi.x.actualMoveLock=false;
        Posi.y.actualMoveLock=false;
        fillB.actualMoveLock=false;
        fillR.actualMoveLock=false;
        fillG.actualMoveLock=false;
        pa.translate(pa.width/2,pa.height/2);
        pa.textAlign(PApplet.CENTER,PApplet.CENTER);
        pa.rectMode(PApplet.CENTER);
        pa.ellipseMode(PApplet.CENTER);
        if(!noFill)
            pa.background(fillR.actualValue,fillG.actualValue,fillB.actualValue);
        pa.imageMode(PApplet.CENTER);
        for(int ct=0;ct<objs.size();ct++)
        {
            VObj ao=objs.get(ct);
            try{pa.fill(ao.fillR.actualValue,ao.fillG.actualValue,ao.fillB.actualValue,ao.fillA.actualValue);
            }catch(Exception e){}
            try{pa.stroke(ao.stroR.actualValue,ao.stroG.actualValue,ao.stroB.actualValue,ao.stroA.actualValue);
            }catch (Exception e){}
            try{pa.strokeWeight(ao.stroWei.actualValue* scale.actualValue);
            }catch (Exception e){}
            try{if(ao.noFill)
            {
                pa. noFill();
            }}catch (Exception e){}
            try{if(ao.noStro)
            {
                pa. noStroke();
            }}catch (Exception e){}
            if(ao instanceof VText)
            {   if (((VText) ao).font!=null)
                {
                    pa.textFont(((VText) ao).font);
                }
                if(((VText) ao).size!=null)
                {
                    pa.textSize(((VText) ao).size.actualValue*scale.actualValue);
                }
                else
                {
                    pa.textSize(47* scale.actualValue);
                }
                pa.text(((VText) ao).text,(ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue ,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue );
            }
            else if(ao instanceof VPoly)
            {
                pa.beginShape();
                for(VXy p:((VPoly) ao).v)
                {
                    pa.vertex((p.x.actualValue-Posi.x.actualValue)*scale.actualValue,(p.y.actualValue-Posi.y.actualValue)* scale.actualValue);
                }
                pa.endShape(PApplet.CLOSE);
            }
            else if(ao instanceof VElps)
            {
                if(((VElps)ao).spin.actualValue==0 || ((VElps)ao).spin.actualValue %(2*PApplet.PI)==0)
                    pa.ellipse((ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue,ao.Widt.actualValue*scale.actualValue,ao.Heit.actualValue*scale.actualValue);
                else
                {
                    float x= (ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue;
                    float y=(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue;
                    float w=ao.Widt.actualValue*scale.actualValue;
                    float h=ao.Heit.actualValue*scale.actualValue;
                    float angle=((VElps)ao).spin.actualValue;
                    float step = PApplet.TWO_PI / 100;  // 分割椭圆，取足够多的点
                    pa.beginShape();
                    for (float theta = 0; theta < PApplet.TWO_PI; theta += step) {
                        // 计算椭圆上的点的坐标
                        float ex = x + w / 2 * PApplet.cos(theta);
                        float ey = y + h / 2 * PApplet.sin(theta);
                        // 将这些点旋转特定的角度
                        float rx = x + (ex - x) * PApplet.cos(angle) - (ey - y) * PApplet.sin(angle);
                        float ry = y + (ex - x) * PApplet.sin(angle) + (ey - y) * PApplet.cos(angle);
                        // 画出旋转后的点
                        pa.vertex(rx, ry);
                    }
                    pa.endShape(PApplet.CLOSE);
                }
            }
            else if(ao instanceof VRect)
            {
                if(((VRect)ao).spin.actualValue==0 || ((VRect)ao).spin.actualValue %(2*PApplet.PI)==0)
                pa.rect((ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue,ao.Widt.actualValue*scale.actualValue,ao.Heit.actualValue*scale.actualValue,((VRect)ao).getRoundedCorner(0).actualValue,((VRect)ao).getRoundedCorner(1).actualValue,((VRect)ao).getRoundedCorner(2).actualValue,((VRect)ao).getRoundedCorner(3).actualValue);
                else
                {
                    float x= (ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue;
                    float y=(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue;
                    float w=ao.Widt.actualValue*scale.actualValue;
                    float h=ao.Heit.actualValue*scale.actualValue;
                    float a=((VRect)ao).spin.actualValue;
                    // 矩形的四个顶点相对于中心点的坐标
                    float x1 = -w/2;
                    float y1 = -h/2;
                    float x2 = w/2;
                    float y2 = -h/2;
                    float x3 = -w/2;
                    float y3 = h/2;
                    float x4 = w/2;
                    float y4 = h/2;

                    // 旋转矩形的四个顶点
                    float newX1 = x + x1 * PApplet.cos(a) - y1 * PApplet.sin(a);
                    float newY1 = y + x1 * PApplet.sin(a) + y1 * PApplet.cos(a);
                    float newX2 = x + x2 * PApplet.cos(a) - y2 * PApplet.sin(a);
                    float newY2 = y + x2 * PApplet.sin(a) + y2 * PApplet.cos(a);
                    float newX3 = x + x3 * PApplet.cos(a) - y3 * PApplet.sin(a);
                    float newY3 = y + x3 * PApplet.sin(a) + y3 * PApplet.cos(a);
                    float newX4 = x + x4 * PApplet.cos(a) - y4 * PApplet.sin(a);
                    float newY4 = y + x4 * PApplet.sin(a) + y4 * PApplet.cos(a);

                    // 使用新的坐标画矩形
                    pa.beginShape();
                    pa.vertex(newX1, newY1);
                    pa. vertex(newX2, newY2);
                    pa.vertex(newX4, newY4);
                    pa.vertex(newX3, newY3);
                    pa. endShape(PApplet.CLOSE);
                }
            }
            else if(ao instanceof VLine)
            {
                pa.line((ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue, (((VLine) ao).PosiE.x.actualValue-Posi.x.actualValue)*scale.actualValue,(((VLine) ao).PosiE.y.actualValue-Posi.y.actualValue)*scale.actualValue);
            }
            else if(ao instanceof VImg)
            {
                pa.tint(((VImg) ao).tintR.actualValue,((VImg) ao).tintG.actualValue,((VImg) ao).tintB.actualValue,((VImg) ao).tintA.actualValue);
                if(!((VImg) ao).noMask)
                {
                    PImage t=((VImg) ao).image;
                    ((VImg) ao).mask.drawObj();
                    t.mask(((VImg) ao).mask.toPImage());
                    pa.image(t,(ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue,ao.Widt.actualValue*scale.actualValue,ao.Heit.actualValue*scale.actualValue);
                }
                else
                {
                    pa.image(((VImg) ao).image,(ao.Posi.x.actualValue-Posi.x.actualValue)*scale.actualValue,(ao.Posi.y.actualValue-Posi.y.actualValue)*scale.actualValue,ao.Widt.actualValue*scale.actualValue,ao.Heit.actualValue*scale.actualValue);
                }
            }
            else if(ao instanceof SubViewer)
            {
                ((SubViewer) ao).drawObj();
                pa.image(((SubViewer) ao).pg,((SubViewer) ao).MotherViewerPosi.x.actualValue,((SubViewer) ao).MotherViewerPosi.y.actualValue,ao.Widt.actualValue,ao.Heit.actualValue);
            }
            //pa.popMatrix();
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
        try
        {
            actualMove();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}
