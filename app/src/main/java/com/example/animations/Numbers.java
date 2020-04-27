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
    public static final int offsetX = 100;
    public static final int offsetY = 100;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setTextSize(80);
        paint.setColor(Color.GRAY);
        canvas.drawText(numStash[0], offsetX, offsetY, paint);
        canvas.drawText(numStash[1], offsetX + NUMBER_WIDTH, offsetY - moveUpY, paint);
        canvas.drawText(numStash[2], offsetX + NUMBER_WIDTH, offsetY + numHeight - moveUpY, paint);
    }

    // TODO: 2020-04-27 多次点击处理

    public int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    public int mCount = 10;

    public void calculateNum(int count) {
        numStash[0] = String.valueOf(mCount);
        numStash[1] = String.valueOf(mCount);
        numStash[2] = "";

        String unchanged = String.valueOf(mCount);
        String changed = String.valueOf(mCount + count);
        int len = Math.min(unchanged.length(), changed.length());
        for (int i = 0; i < len; i++) {
            char a = unchanged.charAt(i);
            char b = changed.charAt(i);
            if (a != b) {
                numStash[0] = i == 0 ? "" : unchanged.substring(0, i);
                if (count == 1) {
                    numStash[1] = unchanged.substring(i);
                    numStash[2] = changed.substring(i);
                } else {
                    numStash[1] = changed.substring(i);
                    numStash[2] = unchanged.substring(i);
                }

            }
        }
        mCount += count;
    }

}
