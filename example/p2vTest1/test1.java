import processing.core.PApplet;
import processing.event.MouseEvent;
import P2V.*;
public class test1 extends PApplet
{
    VRect r,r2;
    VLine l;
    private final int WIDTH=1400;
    private final int HEIGHT=900;

    public void settings()
    {
        size(WIDTH, HEIGHT);
    }

    public void setup()
    {
        P2DViewer.init(this);
        P2DViewer.defaultAnimationMode=2;
        P2DViewer.setFill(200);
        try
        {
            for(int ct=0;ct<100;ct++)
            {
                VRect r=new VRect();
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
                P2DViewer.addVObj(r);
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
            try {
                P2DViewer.toMoveScaleRelatively(0.1f);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        else
        {
            try {
                P2DViewer.toMoveScaleRelatively(-0.1f);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public void draw()
    {
        try
        {
            P2DViewer.drawObj();
            for(int ct=0;ct<100;ct++)
            {
                if(random(1000)<=1)
                {
                    VRect temp= (VRect) P2DViewer.getVObjByIndex(ct);
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
