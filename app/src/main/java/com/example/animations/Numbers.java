package com.example.animations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Numbers extends View {

    public Numbers(Context context) {
        super(context);
    }

    public Numbers(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Numbers(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int moveUpY;

    public int getMoveUpY() {
        return moveUpY;
    }

    public void setMoveUpY(int moveUpY) {
        this.moveUpY = moveUpY;
        invalidate();
    }

    private Paint paint = new Paint();

    private static final int NUMBER_WIDTH = 50;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setTextSize(80);
        canvas.drawText("1", 100, 100, paint);
        canvas.drawText("0", 100 + NUMBER_WIDTH, 100 - moveUpY, paint);
        canvas.drawText("1", 100 + NUMBER_WIDTH, 100 + 100 - moveUpY, paint);
    }
}
