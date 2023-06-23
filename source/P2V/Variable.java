package P2V;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Variable} class is an extension of the {@code float} class and is key to the animation effects within the P2DViewer library.
 * A {@code Variable} object has an animation effect intrinsic to it, allowing it to gradually approach a target value over time.
 * This enables easy creation of linear, easing, and rebounding animation effects when drawing graphics.
 * @author Telsa
 */
public class Variable {
    /**
     * The target value for the animation effect.
     */
    float value;

    /**
     * The actual value of the {@code Variable}, computed automatically by the P2DViewer.
     */
    float actualValue;

    /**
     * The current frame number in a set of animation frames.
     */
    int requestedFrame;

    /**
     * The total number of frames in the animation.
     */
    int maxFrame;

    /**
     * An {@code AnimationController} object responsible for calculating the current frame value based on the initial and target values.
     */
    AnimationController ac;

    /**
     * A map storing the animation information.
     */
    Map<Integer,aniInfo> aniMap;

    /**
     * The type of animation. Default is 1.
     * 0 for linear, 1 for ease in and out, 2 for rebound, 3 for fast to slow, 4 for slow to fast.
     */
    int animationMode;

    boolean actualMoveLock=false;

    /**
     * Constructs a {@code Variable} with the given actual value.
     *
     * @param actualValue the actual value of the {@code Variable}
     */
    public Variable(float actualValue) {
        this.actualValue = actualValue;
        this.value = actualValue;
        requestedFrame = -1;
        maxFrame = P2DViewer.frameCountOfOneMove;
        animationMode = P2DViewer.defaultAnimationMode;
        aniMap = new HashMap<>();
    }

    /**
     * Constructs a {@code Variable} with the given actual value and animation mode.
     *
     * @param actualValue the actual value of the {@code Variable}
     * @param animationMode the animation mode of the {@code Variable}
     */
    public Variable(float actualValue, int animationMode) {
        this.actualValue = actualValue;
        this.value = actualValue;
        requestedFrame = -1;
        maxFrame = P2DViewer.frameCountOfOneMove;
        this.animationMode = animationMode;
        aniMap = new HashMap<>();
    }

    /**
     * Creates and returns a copy of this {@code Variable}.
     *
     * @return a copy of this {@code Variable}
     */
    public Variable copy() {
        Variable rtn = new Variable(actualValue, animationMode);
        rtn.requestedFrame = requestedFrame;
        rtn.maxFrame = maxFrame;
        rtn.value = value;
        if (ac != null) {
            rtn.ac = new AnimationController(actualValue, value, maxFrame, animationMode);
        }
        rtn.aniMap = new HashMap<>();
        return rtn;
    }

    /**
     * Sets the actual value of this {@code Variable}.
     *
     * @param actualValue the new actual value
     */
    public void setActualValue(float actualValue) {
        this.actualValue = actualValue;
        this.value = actualValue;
    }

    /**
     * Modifies the target value of this {@code Variable} and triggers the {@code AnimationController}.
     *
     * @param value the new target value
     * @param frame the total frame count for the animation
     */
    public void toMoveValue(float value, int frame) {
        this.value = value;
        requestedFrame = 1;
        maxFrame = frame;
        ac = new AnimationController(actualValue, value, maxFrame, animationMode);
    }

    /**
     * Modifies the target value of this {@code Variable} and triggers the {@code AnimationController} with the default frame count.
     *
     * @param value the new target value
     */
    public void toMoveValue(float value) {
        toMoveValue(value, maxFrame);
    }

    /**
     * Modifies the target value of this {@code Variable} based on the old value and triggers the {@code AnimationController}.
     *
     * @param value the offset value based on the old value
     */
    public void toMoveValueRelatively(float value) {
        toMoveValue(this.value + value, maxFrame);
    }

    /**
     * Sets the total frame count for the animation.
     *
     * @param frame the new total frame count for the animation
     */
    public void setMaxFrame(int frame) {
        maxFrame = frame;
    }

    /**
     * Returns the animation mode of this {@code Variable}.
     *
     * @return the animation mode of this {@code Variable}
     */
    public int getAnimationMode() {
        return animationMode;
    }

    /**
     * Sets the animation mode of this {@code Variable}.
     *
     * @param animationMode the new animation mode of this {@code Variable}
     */
    public void setAnimationMode(int animationMode) {
        this.animationMode = animationMode;
    }

    /**
     * Moves the actual value of this {@code Variable} to the next frame.
     */
    public void actualMove() throws Exception
    {
        if(requestedFrame==-1 || actualMoveLock)
        {
            return;
        }
        if(requestedFrame==-2)
        {
            aniInfo ai=aniMap.get(P2DViewer.sendAnimationOrderForPlaying);
            if(ai!=null)
            {
                requestedFrame=1;
                ac=new AnimationController(actualValue,ai.value,ai.maxFrame,ai.animationMode);
            }
            else
            {
                return;
            }
        }
        if(requestedFrame<=maxFrame)
        {
            actualValue=ac.getValue(requestedFrame);
            requestedFrame++;
            if(P2DViewer.sharedVariableMode==true)
            {
                actualMoveLock=true;
            }
        }
        else
        {
            aniMap.remove(P2DViewer.sendAnimationOrderForPlaying);
            requestedFrame=-1;
        }
    }

    /**
     * Returns the target value of this {@code Variable}.
     *
     * @return the target value of this {@code Variable}
     */
    public float getValue() {
        return value;
    }

    /**
     * Returns the actual value of this {@code Variable}.
     *
     * @return the actual value of this {@code Variable}
     */
    public float getActualValue() {
        return actualValue;
    }

    /**
     * Prints the target value of this {@code Variable} to the console.
     */
    public void printValue() {
        System.out.println(value);
    }

    /**
     * Prints the actual value of this {@code Variable} to the console.
     */
    public void printActualValue() {
        System.out.println(actualValue);
    }

    /**
     * Prints all details of this {@code Variable} to the console.
     */
    public void printWhole() {
        System.out.println("ActualValue: " + actualValue);
        System.out.println("TargetValue: " + value);
        System.out.println("RequestedFrame: " + requestedFrame);
        System.out.println("MaxFrame: " + maxFrame);
        System.out.println("AnimationMode: " + animationMode);
    }
}

class aniInfo
{
        float value;
        int maxFrame;
        int animationMode;
        aniInfo(float v,int m,int a)
        {
            value=v;
            maxFrame=m;
            animationMode=a;
        }
}
