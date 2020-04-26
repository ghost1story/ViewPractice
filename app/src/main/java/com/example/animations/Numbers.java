package com.example.animations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
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

    private String[] numStash = {"1", "0", "1"};

    public void setPaintColor(int color) {
        paint.setColor(color);
    }

    public final int numHeight = getResources().getDimensionPixelOffset(R.dimen.number_height);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        float alphaPercent = moveUpY / 100f;

        paint.setTextSize(80);
        canvas.drawText(numStash[0], 100, 100, paint);
//        paint.setAlpha((int) (255 * (1 - alphaPercent)));
        canvas.drawText(numStash[1], 100 + NUMBER_WIDTH, 100 - moveUpY, paint);
//        paint.setAlpha((int) (255 * alphaPercent));
        canvas.drawText(numStash[2], 100 + NUMBER_WIDTH, 100 + numHeight - moveUpY, paint);
    }

    public int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

}
