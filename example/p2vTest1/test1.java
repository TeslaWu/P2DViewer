import processing.core.PApplet;
import processing.event.MouseEvent;
import P2V.*;
public class test1 extends PApplet
{
    private final int WIDTH=1400;
    private final int HEIGHT=900;

    public void settings()
    {
        size(WIDTH, HEIGHT);
    }

    public void setup()
    {
        P2DViewer.init(this); //always write this to enable P2DViewer
        P2DViewer.defaultAnimationMode=2; //Mode 2 means bouncing animation effect. default mode is 1 (ease in and out)
        P2DViewer.setFill(200); //when calling setFill() of P2DViewer, it equals to calling background().
        try
        {
            for(int ct=0;ct<100;ct++)
            {
                VRect r=new VRect(); //generate 100 rectangle objects and give each of them random properties
                r.setPosi(random(-WIDTH,WIDTH),random(-HEIGHT,HEIGHT));
                r.setWidt(random(WIDTH/10,WIDTH/3));
                r.setHeit(random(HEIGHT/10,HEIGHT/3));
                r.setNoStro(false);
                r.setFillARGB(255,random(255),random(255),random(255));
                r.setStroR(random(255));
                r.setStroG(random(255));
                r.setStroB(random(255));
                r.setStroA(255);
                r.setStroWei(random(34));
                P2DViewer.addVObj(r);//add the rectangle in to P2DViewer, or it will not be displayed
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
    public void mouseClicked()
    {

    }
    public void mouseWheel(MouseEvent event)
    {
        float e = event.getCount();
        if(e>0)
        {
            try
            {
                // toMoveScaleRelatively allows you to add a value to the
                // current scaling degree of P2DViewer.
                // This will make you take a "closer/farther look" to objects in P2DViewer
                P2DViewer.toMoveScaleRelatively(0.1f);

            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
        }
        else
        {
            try
            {
                P2DViewer.toMoveScaleRelatively(-0.1f);
            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
        }
    }
    public void draw()
    {
        try
        {
            // This method is usually called at draw() in processing.
            // By calling this, the value of all the objects in P2DViewer
            // will be drawn and updated to the status of next frame.
            P2DViewer.drawObj();

            for(int ct=0;ct<100;ct++)
            {
                if(random(1000)<=1)
                {
                    VRect temp= (VRect) P2DViewer.getVObjByIndex(ct);

                    //use methods start with "toMove" will allow you to change the value gradually with animation
                    temp.toMovePosi(random(-WIDTH,WIDTH),random(-HEIGHT,HEIGHT));
                    temp.toMoveWidt(random(WIDTH/10,WIDTH/3));
                    temp.toMoveHeit(random(HEIGHT/10,HEIGHT/3));
                    temp.toMoveFillR(random(255));
                    temp.toMoveFillG(random(255));
                    temp.toMoveFillB(random(255));
                    temp.toMoveStroR(random(255));
                    temp.toMoveStroG(random(255));
                    temp.toMoveStroB(random(255));
                    temp.toMoveStroWei(random(34));
                }
            }

            //"Variable" is an exclusive class of P2DViewer.
            // It is essentially a re-encapsulated float variable,
            // which also has animation control capabilities.
            // This allows the value to change frame by frame, forming a continuous animation.
            // VXy is essentially a combination of two Variable objects,
            // which can be used to represent coordinates and the like.
            P2DViewer.setPosi(new VXy( mouseX-WIDTH/2,mouseY-HEIGHT/2));

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args)
    {
        PApplet.main("test1");
    }
}
