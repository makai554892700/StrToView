package com.mayousheng.www.strtoview.utils;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.mayousheng.www.strtoview.pojo.LayoutDesc;
import com.mayousheng.www.strtoview.pojo.OnClickDesc;
import com.shandao.www.strtoview.R;

/**
 * Created by marking on 2017/5/2.
 */

public class OnClickUtils {

    private static OnClickUtils onClickUtils;

    private OnClickUtils() {
    }

    public static OnClickUtils getInstance() {
        if (onClickUtils == null) {
            onClickUtils = new OnClickUtils();
        }
        return onClickUtils;
    }

    public View.OnTouchListener getOnClickListener(final Context context, final OnClickDesc onClickDesc) {
        if (onClickDesc != null) {
            return new View.OnTouchListener() {
                private int downX;
                private int downY;
                private long downTime;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    switch (action) {
                        case MotionEvent.ACTION_DOWN:
                            downX = (int) event.getX();
                            downY = (int) event.getY();
                            downTime = System.currentTimeMillis();
                            break;
                        case MotionEvent.ACTION_UP:
                            int x = (int) event.getX();
                            int y = (int) event.getY();
                            if (System.currentTimeMillis() - downTime < 1000
                                    && Math.abs(x - downX) < 10
                                    && Math.abs(y - downY) < 10) {
                                onClick(context, onClickDesc, x, y);
                            }
                            break;
                    }
                    return true;
                }
            };
        }
        return null;
    }

    public void onClick(Context context, OnClickDesc onClickDesc, int x, int y) {
        if (onClickDesc != null) {
            switch (onClickDesc.type) {
                case OnClickDesc.TYPE_ACTIVITY:
                    break;
                case OnClickDesc.TYPE_DIALOG2:
                    x = 0;
                    y = 0;
                case OnClickDesc.TYPE_DIALOG:
                    showMyDialog(context, x, y, onClickDesc.desc);
                    break;
                case OnClickDesc.TYPE_WEB:
                    break;
            }
        }
    }


    public void showMyDialog(Context context, int x, int y, String desc) {
        if (desc == null || desc.isEmpty()) {
            return;
        }
        LayoutDesc layoutDesc = new LayoutDesc(desc);
        View view = LayoutUtils.getInstance().getLayout(context, layoutDesc);
        if (((ViewGroup) view).getChildCount() > 0) {
            View childView = ((ViewGroup) view).getChildAt(0);
            if (childView instanceof ViewGroup) {
                if (childView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams =
                            (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                    int maxX = windowManager.getDefaultDisplay().getWidth();
                    int maxY = windowManager.getDefaultDisplay().getHeight();
                    int left = marginLayoutParams.leftMargin;
                    int top = marginLayoutParams.topMargin;
                    int right = marginLayoutParams.rightMargin;
                    int bottom = marginLayoutParams.bottomMargin;
                    if (x > maxX / 2) {
                        right = right + (maxX - x);
                    } else {
                        left = left + x;
                    }
                    if (y > maxY / 2) {
                        bottom = bottom + (maxY - y);
                    } else {
                        top = top + y;
                    }
                    marginLayoutParams.setMargins(left, top, right, bottom);
                    childView.setLayoutParams(marginLayoutParams);
                }
            }
        }
        final Dialog dialog = new Dialog(context, R.style.dialog_fullscreen);
        dialog.setContentView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

}