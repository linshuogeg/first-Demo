package com.example.usercenterq.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class My_Edit extends androidx.appcompat.widget.AppCompatEditText {
    private String my_Text;
    private Paint paint;
    private boolean have=true;


    public My_Edit(Context context) {
        super(context);
        init();
    }

    public My_Edit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public My_Edit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        MyPaint(Color.GRAY);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                have=true;
                requestLayout();
            }
        });
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (!TextUtils.isEmpty(getText().toString().trim())){
            if (focused){
                my_Text=getText().toString();
                have=true;
                requestLayout();
            }else{
                my_Text=getText().toString();
                have=false;
                setText(" ");
                requestLayout();
            }
        }else{
            have=true;
            requestLayout();
        }
    }



    private void changed() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!have){
            paint.setColor(Color.GRAY);
            //第一种：rx 80 ry 70
            canvas.drawRoundRect(new RectF(90, 0, 600, 100), 80, 70, paint);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!have){
            paint.setColor(Color.WHITE);
            canvas.drawText(my_Text,170,60,paint);
            paint.setColor(Color.BLACK);
            canvas.drawCircle(550,50,40,paint);
            paint.setColor(Color.WHITE);
            canvas.drawLine(570,30,530,70,paint);
            canvas.drawLine(570,70,530,30,paint);
        }
    }

    private void MyPaint(int color) {
        if (paint==null){
            paint=new Paint();
        }
        paint.setColor(color);
        paint.setStrokeWidth(10f);
        paint.setTextSize(50);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }
    public void build_Edit(){
        my_Text=getText().toString();
        have=false;
        setText(" ");
        requestLayout();
    }
}
