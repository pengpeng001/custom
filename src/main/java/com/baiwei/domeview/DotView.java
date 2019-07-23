package com.baiwei.domeview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DotView extends View {

    private List<Point> list;
    private Paint mPaintX;
    private Paint mPantY;
    private Paint mPaintXLine;
    private Paint mTextPaintX;

    private Paint mPaintDot;

    private  int x,y;
    private int destX,destY;

    private List<String> xList ;

    private List<Point> mPointList = new ArrayList<>();

    public DotView(Context context) {
        this(context , null);
    }

    public DotView(Context context,  AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public DotView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        mPaintX = new Paint();
        mPaintX.setAntiAlias(true);
        mPaintX.setDither(true);
        mPaintX.setStrokeWidth(10);
        mPaintX.setStyle(Paint.Style.FILL);
        mPaintX.setColor(Color.BLACK);

        mPaintXLine = new Paint();
        mPaintXLine.setAntiAlias(true);
        mPaintXLine.setDither(true);
        mPaintXLine.setStrokeWidth(10);
        mPaintXLine.setStyle(Paint.Style.FILL);
        mPaintXLine.setColor(Color.BLACK);

        mPantY = new Paint();
        mPantY.setAntiAlias(true);
        mPantY.setDither(true);
        mPantY.setStrokeWidth(10);
        mPantY.setStyle(Paint.Style.FILL);
        mPantY.setColor(Color.GREEN);

        mPaintDot = new Paint();
        mPaintDot.setAntiAlias(true);
        mPaintDot.setDither(true);
        mPaintDot.setStrokeWidth(10);
        mPaintDot.setStyle(Paint.Style.FILL);
        mPaintDot.setColor(Color.GREEN);

        mTextPaintX = new Paint();
        mTextPaintX.setAntiAlias(true);
        mTextPaintX.setDither(true);
        mTextPaintX.setTextSize(50);
        mTextPaintX.setTextAlign(Paint.Align.CENTER);
        mTextPaintX.setStyle(Paint.Style.FILL);
        mTextPaintX.setColor(Color.BLACK);

        xList = new ArrayList<>();
        xList.add("22");
        xList.add("23");
        xList.add("24");
        xList.add("25");
        xList.add("26");
        xList.add("27");


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(40 , 1000 , getScreenWidthOrHeight(true)- 40 , 1000 , mPaintX);
        canvas.drawLine(40 , 40 , 40 , 1000 , mPantY);

        int x = (getScreenWidthOrHeight(true)- 40) / 7;

        for (String s : xList){
            Point point = new Point();
            point.x = 40 + x;
            point.y = new Random().nextInt(600);
            mPointList.add(point);

            canvas.drawText(s,50+x,1050,mTextPaintX);
            x+=(getScreenWidthOrHeight(true)- 40) / 7;

        }
        for (int i = 0; i < mPointList.size(); i++) {
            canvas.drawCircle(mPointList.get(i).x,mPointList.get(i).y,20,mPaintDot);

            if (i<mPointList.size()-1)
                canvas.drawLine(mPointList.get(i).x,mPointList.get(i).y,mPointList.get(i+1).x,mPointList.get(i+1).y,mPaintXLine);
        }



    }


    public void addDot(){
        int cx = new Random().nextInt(getScreenWidthOrHeight(true));
        int cy = new Random().nextInt(getScreenWidthOrHeight(false));
        Point point = new Point();
        point.x = cx;
        point.y = cy;
        list.add(point);
        invalidate();
    }

    public int getScreenWidthOrHeight(boolean width){
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (width){
            return dm.widthPixels;
        }else{
            return dm.heightPixels;
        }

    }
}
