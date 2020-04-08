package com.example.animations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice08ObjectAnimatorView extends View {
//    final float radius = dpToPixel(80);

    RectF arcRectF = new RectF();
//    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint = new Paint();

    // TODO 为 progress 添加 getter 和 setter 方法（setter 方法记得加 invalidate()）
    int progress = Color.LTGRAY;

    public float getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public Practice08ObjectAnimatorView(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
//        paint.setTextSize(dpToPixel(40));
//        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        float centerX = getWidth() / 2;
//        float centerY = getHeight() / 2;
//
//        paint.setColor(Color.parseColor("#E91E63"));
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeCap(Paint.Cap.ROUND);
//        paint.setStrokeWidth(dpToPixel(15));
//        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
//        canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);
//
//        paint.setColor(Color.WHITE);
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawText((int) progress + "%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
//        paint.setColor(Color.LTGRAY);
        paint.setColor(progress);

        Path p = new Path();
        p.addRect(100, 150, 150, 300, Path.Direction.CW);
        p.addRect(151, 150, 350, 300, Path.Direction.CW);
        p.addRect(250, 100, 300, 150, Path.Direction.CW);
//        p.moveTo(150, 150);
//        p.rLineTo(0, 150);
        canvas.drawPath(p, paint);

//        canvas.drawRect(100, 150, 150, 300, paint);
//        canvas.drawRect(150, 150, 350, 300, paint);
//        canvas.drawRect(250, 100, 300, 150, paint);
    }
}