package P2V;

import processing.core.PApplet;

/**
 * AnimationController is in charge of calculating animation.
 * @author Telsa
 */
public class AnimationController
{
    protected float startValue;     // 起始值
    protected float targetValue;    // 目标值
    protected float duration;       // 动画持续时间
    protected int mode;

    /**
     * The animation mode that eases both in and out.
     */
    public static final int EASE=1;

    /**
     * The animation mode that moves linearly.
     */
    public static final int LINEAR=0;

    /**
     * The animation mode that bounces.
     */
    public static final int BOUNCE=2;

    /**
     * The animation mode that eases in.
     */
    public static final int EASEIN=3;

    /**
     * The animation mode that eases out.
     */
    public static final int EASEOUT=4;

    /**
     * Constructs an {@code AnimationController} with the given start value, target value, and duration.
     *
     * @param startValue the start value of the animation
     * @param targetValue the target value of the animation
     * @param duration the duration of the animation
     */
    public AnimationController(float startValue, float targetValue, float duration)
    {
        this.startValue = startValue;
        this.targetValue = targetValue;
        this.duration = duration;
        mode=1;
    }

    /**
     * Constructs an {@code AnimationController} with the given start value, target value, duration, and animation mode.
     *
     * @param startValue the start value of the animation
     * @param targetValue the target value of the animation
     * @param duration the duration of the animation
     * @param mode the animation mode
     */
    public AnimationController(float startValue, float targetValue, float duration,int mode)
    {
        this.startValue = startValue;
        this.targetValue = targetValue;
        this.duration = duration;
        this.mode=mode;
    }

    // 缓动函数示例：缓入缓出（Ease In Out）
    private float easeInOut(float t, float b, float c, float d)
    {
        t /= d / 2;
        if (t < 1) {
            return c / 2 * t * t * t + b;
        } else {
            t -= 2;
            return c / 2 * (t * t * t + 2) + b;
        }
    }
    private float linear(float t, float b, float c, float d) {
        return c * t / d + b;
    }

    private float easeIn(float t, float b, float c, float d) {
        t /= d;
        return c * t * t * t + b;
    }

    private float easeOut(float t, float b, float c, float d) {
        t /= d;
        t = 1 - t;
        return c * (1 - t * t * t) + b;
    }


    private float bounce(float t) {
        return (float) Math.sin(3.5 * Math.PI * t);
    }
    protected float getValue(int currentFrame) throws Exception {
        float t = (float) currentFrame / duration;
        t =PApplet. constrain(t, 0, 1); // 确保 t 的值在 0 到 1 之间

        float interpolatedValue;

        switch (mode)
        {
            case 0: // 线性（匀速）
                interpolatedValue = linear(t, startValue, targetValue - startValue, 1);
                break;
            case 1: // 缓动
                interpolatedValue = easeInOut(t, startValue, targetValue - startValue, 1);
                break;
            case 2: // 缓动回弹
                if (t < 0.7)
                {
                    float value = easeInOut(t / 0.7f, startValue, (targetValue - startValue)*1.2f, 1);
                    interpolatedValue = value ;//* (targetValue - startValue) + startValue;
                }
                else
                {
                    float value = easeOut((t - 0.7f) / 0.3f, (targetValue - startValue)*1.2f+startValue, targetValue-((targetValue - startValue)*1.2f+startValue), 1);
                    interpolatedValue = value; //* (targetValue - startValue) + startValue;
                }
                break;
            case 3://由快到慢
                interpolatedValue = easeIn(t, startValue, targetValue - startValue, 1);
                break;
            case 4://由慢到快
                interpolatedValue =  easeOut(t, startValue, targetValue - startValue, 1);
                break;
            default:
                throw new Exception("Wrong animation mode");
        }
        return interpolatedValue;
    }

}