package com.example.administrator.OurPersion.SelfView;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by Administrator on 2017/5/25 0025.
 */
public class MyHorizontalScrollView extends HorizontalScrollView {
    //--屏幕宽度
    int ScreenWidth;
    private LinearLayout horizontal_linearlayout;
    private ViewGroup menu;
    private ViewGroup content;
    int mMenuRightPadding = 50;
    //--菜单宽度
    int menuwidth;
    //--是否是第一次执行onmeasure
    boolean isfirst;
    //---是否打开菜单
    public static boolean isopen;
    //当前状态（0代表正常状态,1代表正在向右滑动,2显示菜单页面）
    int state;
    int mTouchSlop;
    float mPrevX;
    float mPrevY;

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        ScreenWidth = displayMetrics.widthPixels;
        //---把dp转换为px
        mMenuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics());

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (!isfirst) {
            horizontal_linearlayout = (LinearLayout) getChildAt(0);
            menu = (ViewGroup) horizontal_linearlayout.getChildAt(0);
            content = (ViewGroup) horizontal_linearlayout.getChildAt(1);
            menuwidth = menu.getLayoutParams().width = ScreenWidth - mMenuRightPadding;
            content.getLayoutParams().width = ScreenWidth;
            isfirst = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            this.scrollTo(menuwidth, 0);

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:

                int scrollx = getScrollX();
                if (scrollx - menuwidth / 3 * 2 >= 0) {
                    this.scrollTo(menuwidth, 0);
                    isopen = false;

                } else {
                    this.scrollTo(0, 0);
                    isopen = true;
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }

    //--打开菜单
    public void openmenu() {
        if (isopen) {
            return;
        } else {
            this.smoothScrollTo(0, 0);
            isopen = true;
        }
    }

    //--关闭菜单
    public void closemenu() {
        if (!isopen) {

            return;
        } else {
            isopen = false;
            this.smoothScrollTo(menuwidth, 0);
        }
    }
    //--判断是否打开菜单

    public boolean isopen() {
        if (isopen) {
            return true;

        } else {
            return false;
        }
    }


    //---view事件分发处理（重点知识）
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPrevX = MotionEvent.obtain(event).getX();
                mPrevY = MotionEvent.obtain(event).getY();
                if (mPrevX > menuwidth && isopen) {
                    this.scrollTo(menuwidth, 0);
                    //---当关闭菜单时，必须return否则horizontalscrollview不能滑动
                    return true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                final float eventX = event.getX();
                final float eventY = event.getY();
                float xDiff = Math.abs(eventX - mPrevX);
                float yDiff = Math.abs(eventY - mPrevY);
                //--当竖向移动小于20并且横线移动大于一定数时horizontalscrollview滑动
                if (yDiff < 20 && xDiff > mTouchSlop) {
                    return true;
                }
                //--反之禁止horizontalscrollview滑动，让子view滑动
                else {
                    return false;
                }

        }

        return super.onInterceptTouchEvent(event);
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        float scale = l * 1.0f / menuwidth;
        ViewHelper.setTranslationX(menu, menuwidth * scale);
    }


}
