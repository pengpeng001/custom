package com.baiwei.domeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CricleView extends View {


    private Paint mPaint;

    private float x , y;

    public CricleView(Context context) {
        this(context , null);
    }
    public CricleView(Context context,  AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public CricleView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x + 100 , y + 100 , 100 , mPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch  (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX()-100;
                y = event.getY()-100;
                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX()-100;
                y = event.getY()-100;
                break;
            case MotionEvent.ACTION_UP:
                x = 0;
                y = 0;
                break;


        }
        postInvalidate();
        return true;
    }
}
