package com.mayousheng.www.strtoview.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.mayousheng.www.strtoview.pojo.LayoutDesc;
import com.mayousheng.www.strtoview.pojo.OnClickDesc;
import com.shandao.www.strtoview.R;

import java.lang.reflect.Field;

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
            final GestureDetector mGestureDetector = new GestureDetector(context
                    , new MyOnGestureListener(context, onClickDesc));
            return new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    mGestureDetector.onTouchEvent(event);
                    return false;
                }
            };
        }
        return null;
    }

    private void onClick(Context context, OnClickDesc onClickDesc, int x, int y) {
        if (onClickDesc != null) {
            switch (onClickDesc.type) {
                case OnClickDesc.TYPE_ACTIVITY:
                    if (onClickDesc.desc != null && !onClickDesc.desc.isEmpty()) {
                        Intent intent = new Intent(onClickDesc.desc);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            context.startActivity(intent);
                        } catch (Exception e) {
                        }
                    }
                    break;
                case OnClickDesc.TYPE_DIALOG2:
                    x = 0;
                    y = 0;
                case OnClickDesc.TYPE_DIALOG:
                    showMyDialog(context, x, y, onClickDesc.desc);
                    break;
                case OnClickDesc.TYPE_WEB:
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(onClickDesc.desc));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    try {
                        context.startActivity(intent);
                    } catch (Exception e) {
                    }
                    break;
            }
        }
    }

    private void showMyDialog(Context context, int x, int y, String desc) {
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

    private class MyOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        private Context context;
        private OnClickDesc onClickDesc;

        public MyOnGestureListener(Context context, OnClickDesc onClickDesc) {
            this.context = context;
            this.onClickDesc = onClickDesc;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            onClick(context, onClickDesc, (int) e.getRawX(), (int) e.getRawY() - getStatusBarHeight(context));
            return super.onSingleTapUp(e);
        }
    }

    private int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
        }
        return statusBarHeight;
    }

}
