package com.example.usercenterq.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class My_Rela extends LinearLayout {
    private List<My_Btn> my_btnList=new ArrayList<>();

    public My_Rela(Context context) {
        super(context);
        init();
    }

    public My_Rela(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public My_Rela(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
    }

    public void btuInit(String history) {
        My_Btn my_btn=new My_Btn(getContext());
        my_btn.setTexts(history).Build();
        my_btnList.add(my_btn);
    }
    public void btu_Build(){
        removeAllViews();
        for (My_Btn my_btn : my_btnList) {
            my_btn.setLayoutParams(new RelativeLayout.LayoutParams(200,300));
            addView(my_btn);

            requestLayout();

        }
    }
}
