package com.example.animations;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Practice08ObjectAnimatorLayout extends RelativeLayout {
    Practice08ObjectAnimatorView view;
    Button animateBt;

    public Practice08ObjectAnimatorLayout(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Practice08ObjectAnimatorView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，用 ObjectAnimator 播放动画
                // 1. 用 ObjectAnimator 创建 Animator 对象
                // 2. 用 start() 执行动画
                // *. 记得在 Practice08ObjectAnimatorView 中为 progress 添加 setter/ getter 方法！
//                Animator a = ObjectAnimator.ofFloat(view, "progress", 0, 65);
                if (on) {
//                    ObjectAnimator a = ObjectAnimator.ofInt(view, "progress", Color.LTGRAY, Color.RED);
                    ObjectAnimator a = ObjectAnimator.ofFloat(view, "progress", 1f, 1.2f, 1f);
                    a.setInterpolator(new OvershootInterpolator());
//                    a.setEvaluator(new ArgbEvaluator());
//                    a.setEvaluator(new HsvEvaluator());
                    a.setDuration(500);
                    a.start();
                    view.isClick = true;
                } else {
                    ObjectAnimator a = ObjectAnimator.ofFloat(view, "progress", 1f, 0.8f, 1f);
                    a.setInterpolator(new OvershootInterpolator());
//                    a.setInterpolator(new LinearInterpolator());
//                    a.setEvaluator(new HsvEvaluator());
                    a.setDuration(500);
                    a.start();
                    view.isClick = false;
                }
                on = !on;
            }
        });
    }

    private boolean on = true;

    private class HsvEvaluator implements TypeEvaluator<Integer> {

        float[] startHsv = new float[3];
        float[] endHsv = new float[3];
        float[] outHsv = new float[3];

        // 重写 evaluate() 方法，让颜色按照 HSV 来变化
        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            // 把 ARGB 转换成 HSV
            Color.colorToHSV(startValue, startHsv);
            Color.colorToHSV(endValue, endHsv);

            // 计算当前动画完成度（fraction）所对应的颜色值
            if (endHsv[0] - startHsv[0] > 180) {
                endHsv[0] -= 360;
            } else if (endHsv[0] - startHsv[0] < -180) {
                endHsv[0] += 360;
            }
            outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction;
            if (outHsv[0] > 360) {
                outHsv[0] -= 360;
            } else if (outHsv[0] < 0) {
                outHsv[0] += 360;
            }
            outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction;
            outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction;

            // 计算当前动画完成度（fraction）所对应的透明度
            int alpha = startValue >> 24 + (int) ((endValue >> 24 - startValue >> 24) * fraction);

            // 把 HSV 转换回 ARGB 返回
            return Color.HSVToColor(alpha, outHsv);
        }

    }
}
