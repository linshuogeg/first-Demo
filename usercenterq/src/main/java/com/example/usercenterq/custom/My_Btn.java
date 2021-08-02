package com.example.usercenterq.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class My_Btn extends View {
    //画笔
    private Paint paint;

    //历史记录文字
    private String texts="";


    private String paintColor="#DCDBD1";


    public My_Btn(Context context) {
        super(context);
        init();
        setLayoutParams(new ViewGroup.LayoutParams(90,30));
    }

    public My_Btn(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public My_Btn(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initPaint();
    }

    //初始化画笔
    private void initPaint() {
        if (paint==null){
            paint=new Paint();
        }
        paint.setTextSize(30f);
        paint.setColor(Color.parseColor(paintColor));
        paint.setStrokeWidth(50f);
    }

    //提供入参
    public My_Btn setTexts(String text){
        texts=text;
        return this;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.parseColor(paintColor));
        canvas.drawRoundRect(new RectF(0, 0, 200, 50), 80, 70, paint);
        paint.setColor(Color.RED);
        canvas.drawText(texts,80,35,paint);
    }
    public void Build(){
        requestLayout();
    }
}
