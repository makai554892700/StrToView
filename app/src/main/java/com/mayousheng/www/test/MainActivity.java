package com.mayousheng.www.test;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mayousheng.www.strtoview.pojo.ButtonDesc;
import com.mayousheng.www.strtoview.pojo.ChildDesc;
import com.mayousheng.www.strtoview.pojo.ImageViewDesc;
import com.mayousheng.www.strtoview.pojo.LayoutParamsDesc;
import com.mayousheng.www.strtoview.pojo.LayoutDesc;
import com.mayousheng.www.strtoview.pojo.MarginsDesc;
import com.mayousheng.www.strtoview.pojo.RuleDesc;
import com.mayousheng.www.strtoview.pojo.TextViewDesc;
import com.mayousheng.www.strtoview.utils.CommonViewUtils;
import com.mayousheng.www.strtoview.utils.DescUtils;

import java.util.ArrayList;

import com.mayousheng.www.imgcache.ImageCacheUtils;

public class MainActivity extends Activity {

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long start = System.currentTimeMillis();
//        setContentView(R.layout.item_banner);
//        test1();
        test2();
        Log.e("-----1", "time=" + (System.currentTimeMillis() - start));




//        StateListDrawable drawable = new StateListDrawable();
//        Drawable selected = getResources().getDrawable(R.drawable.woman_icon_select);
//        Drawable unSelected = getResources().getDrawable(R.drawable.woman_icon_default);
//        drawable.addState(new int[]{android.R.attr.state_pressed},
//                selected);
//        drawable.addState(new int[]{-android.R.attr.state_pressed},
//                unSelected);
//        tv.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);

    }

    public void test1() {
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        ImageCacheUtils.getInstance().init(this);
        ArrayList<RuleDesc> ruleDescs = new ArrayList<RuleDesc>();
        ruleDescs.add(new RuleDesc(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE));
        LayoutParamsDesc imgLayoutParamsDesc = DescUtils.getInstance()
                .getLayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE, 200, 200, 0, 0, ruleDescs
                        , new MarginsDesc(50, 0, 0, 0));
        ImageViewDesc imageViewDesc = new ImageViewDesc(0, "#ff000000"
                , "http://inews.gtimg.com/newsapp_bt/0/1467710683/641", imgLayoutParamsDesc, null);
        TextViewDesc textViewDesc = DescUtils.getInstance()
                .getTextViewDesc("this is top text.", "#ff000000", 10, "#ffff00ff", 1, Gravity.CENTER, "END"
                        , new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                                , RelativeLayout.LayoutParams.MATCH_PARENT, 150
                                , 0, 0, null, new MarginsDesc(300, 0, 0, 0)), null);
        TextViewDesc textViewDesc2 = DescUtils.getInstance()
                .getTextViewDesc("this is bottom text.", "#ff000000", 10, "#ffffff00", 1, Gravity.CENTER, "END"
                        , new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                                , RelativeLayout.LayoutParams.MATCH_PARENT, 150
                                , 0, 0, null, new MarginsDesc(300, 150, 0, 0)), null);
        ArrayList<ChildDesc> childDescs = new ArrayList<ChildDesc>();
        ChildDesc childDesc = new ChildDesc(imageViewDesc.toString(), ChildDesc.TYPE_IMG);
        ChildDesc childDesc2 = new ChildDesc(textViewDesc.toString(), ChildDesc.TYPE_TEXT);
        ChildDesc childDesc3 = new ChildDesc(textViewDesc2.toString(), ChildDesc.TYPE_TEXT);
        childDescs.add(childDesc);
        childDescs.add(childDesc2);
        childDescs.add(childDesc3);
        LayoutParamsDesc layoutParamsDesc = DescUtils.getInstance()
                .getLayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE, -1, 300, 0, 0, null, null);
        LayoutDesc layoutDesc = DescUtils.getInstance()
                .getLayoutDesc(LayoutDesc.TYPE_RELATIVE, 0, 0, "#ffffffff", layoutParamsDesc, childDescs);
        Log.e("-----1", "relativeLayoutDesc=" + layoutDesc);
        View bannerView = CommonViewUtils.getInstance().getViewByStr(this, layoutDesc.toString());
        relativeLayout.addView(bannerView);
    }

    public void test2() {
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        ImageCacheUtils.getInstance().init(this);

        ArrayList<RuleDesc> ruleDescs = new ArrayList<RuleDesc>();
        ruleDescs.add(new RuleDesc(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE));
        ruleDescs.add(new RuleDesc(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE));

        ButtonDesc buttonDesc = new ButtonDesc(2, "button", 0, DescUtils.getInstance()
                .getLayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE, RelativeLayout.LayoutParams.WRAP_CONTENT
                        , RelativeLayout.LayoutParams.WRAP_CONTENT, 0, 0, ruleDescs, DescUtils.getInstance()
                                .getMarginsDesc(0, 0, 40, 0)), null);
        ArrayList<RuleDesc> ruleDescs2 = new ArrayList<RuleDesc>();
        ruleDescs2.add(new RuleDesc(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE));
        ImageViewDesc imageViewDesc = new ImageViewDesc(1, null
                , "http://inews.gtimg.com/newsapp_bt/0/1467710683/641"
                , new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                , 200, 200, 0, 0, ruleDescs2, DescUtils.getInstance()
                .getMarginsDesc(40, 0, 0, 0)), null);

        TextViewDesc textViewDesc1 = new TextViewDesc(0, "this is top text"
                , "#ffffff00", 10, "#ffff00ff", 1, Gravity.CENTER, "END"
                , new LayoutParamsDesc(LayoutParamsDesc.TYPE_LINEAR
                , LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                , 0, 1, null, null), null);
        TextViewDesc textViewDesc2 = new TextViewDesc(0, "this is bottom text"
                , "#ff00ff00", 10, "#ffff0000", 1, Gravity.CENTER, "END"
                , new LayoutParamsDesc(LayoutParamsDesc.TYPE_LINEAR
                , LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                , 0, 1, null, null), null);
        ArrayList<ChildDesc> lChildDesc = new ArrayList<>();
        lChildDesc.add(new ChildDesc(textViewDesc1.toString(), ChildDesc.TYPE_TEXT));
        lChildDesc.add(new ChildDesc(textViewDesc2.toString(), ChildDesc.TYPE_TEXT));
        ArrayList<RuleDesc> lRuleDescs = new ArrayList<RuleDesc>();
        lRuleDescs.add(new RuleDesc(RelativeLayout.RIGHT_OF, 1));
        lRuleDescs.add(new RuleDesc(RelativeLayout.LEFT_OF, 2));
        LayoutDesc layoutDesc = new LayoutDesc(0, LayoutDesc.TYPE_LINEAR, 0
                , LinearLayout.VERTICAL, null, new LayoutParamsDesc(
                LayoutDesc.TYPE_RELATIVE, RelativeLayout.LayoutParams.MATCH_PARENT
                , RelativeLayout.LayoutParams.MATCH_PARENT, 0, 0, lRuleDescs, null), lChildDesc);

        ArrayList<ChildDesc> rChildDescs = new ArrayList<>();
        rChildDescs.add(new ChildDesc(imageViewDesc.toString(), ChildDesc.TYPE_IMG));
        rChildDescs.add(new ChildDesc(buttonDesc.toString(), ChildDesc.TYPE_BUTTON));
        rChildDescs.add(new ChildDesc(layoutDesc.toString(), ChildDesc.TYPE_LINEAR));

        LayoutDesc layoutDesc1 = new LayoutDesc(0, LayoutDesc.TYPE_RELATIVE, 0, 0
                , "#ffffffff", new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                , RelativeLayout.LayoutParams.MATCH_PARENT, 280, 0, 0, null, null), rChildDescs);

        Log.e("-----1", "layoutDesc1=" + layoutDesc1);
        View bannerView = CommonViewUtils.getInstance().getViewByStr(this, layoutDesc1.toString());
        relativeLayout.addView(bannerView);

    }

}
