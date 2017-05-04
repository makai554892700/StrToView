package com.mayousheng.www.test;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.mayousheng.www.strtoview.pojo.ButtonDesc;
import com.mayousheng.www.strtoview.pojo.ChildDesc;
import com.mayousheng.www.strtoview.pojo.GradientDesc;
import com.mayousheng.www.strtoview.pojo.ImageViewDesc;
import com.mayousheng.www.strtoview.pojo.LayoutParamsDesc;
import com.mayousheng.www.strtoview.pojo.LayoutDesc;
import com.mayousheng.www.strtoview.pojo.MarginsDesc;
import com.mayousheng.www.strtoview.pojo.OnClickDesc;
import com.mayousheng.www.strtoview.pojo.RuleDesc;
import com.mayousheng.www.strtoview.pojo.StateListDesc;
import com.mayousheng.www.strtoview.pojo.TextViewDesc;
import com.mayousheng.www.strtoview.pojo.VideoDesc;
import com.mayousheng.www.strtoview.utils.CommonViewUtils;

import java.util.ArrayList;

public class MainActivity extends Activity {

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long start = System.currentTimeMillis();
//        test1();
        test2();
//        test3();
//        test4();
        Log.e("-----1", "time=" + (System.currentTimeMillis() - start));
    }

    public void test4() {
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        ArrayList<RuleDesc> ruleDescs = new ArrayList<RuleDesc>();
        ruleDescs.add(new RuleDesc(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE));
        VideoDesc videoDesc = new VideoDesc(null);
        videoDesc.url = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
        LayoutParamsDesc videoLayoutParamsDesc = new LayoutParamsDesc(null);
        videoLayoutParamsDesc.type = LayoutParamsDesc.TYPE_RELATIVE;
        videoLayoutParamsDesc.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        videoLayoutParamsDesc.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        videoLayoutParamsDesc.rules = ruleDescs;
        videoDesc.params = videoLayoutParamsDesc;
        ArrayList<ChildDesc> rChildDescs = new ArrayList<>();
        rChildDescs.add(new ChildDesc(videoDesc.toString(), ChildDesc.TYPE_VIDEO));
        LayoutDesc layoutDesc1 = new LayoutDesc(null);
        layoutDesc1.type = LayoutDesc.TYPE_RELATIVE;
        layoutDesc1.backColor = "#ffffffff";
        LayoutParamsDesc layoutLayoutParamsDesc = new LayoutParamsDesc(null);
        layoutLayoutParamsDesc.type = LayoutParamsDesc.TYPE_RELATIVE;
        layoutLayoutParamsDesc.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutLayoutParamsDesc.height = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutDesc1.params = layoutLayoutParamsDesc;
        layoutDesc1.children = rChildDescs;

        Log.e("-----1", "layoutDesc1=" + layoutDesc1);
        View bannerView = CommonViewUtils.getInstance().getViewByStr(this, layoutDesc1.toString());
        relativeLayout.addView(bannerView);
    }

    public void test3() {
        setContentView(R.layout.item_video);
        final VideoView videoView = (VideoView) findViewById(R.id.video);
        videoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.e("-----1", "onPrepared,资源加载ok");
                videoView.start();
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.e("-----1", "setOnCompletionListener，播放ok");
            }
        });
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.e("-----1", "onErrorListener，错误");
                videoView.stopPlayback();
                return true;
            }
        });
    }


    public void test2() {
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        ArrayList<RuleDesc> ruleDescs = new ArrayList<RuleDesc>();
        ruleDescs.add(new RuleDesc(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE));
        ruleDescs.add(new RuleDesc(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE));
        ButtonDesc buttonDesc = new ButtonDesc(null);
        buttonDesc.id = 2;
        buttonDesc.text = "button";
        LayoutParamsDesc buttonLayoutParamsDesc = new LayoutParamsDesc(null);
        buttonLayoutParamsDesc.type = LayoutParamsDesc.TYPE_RELATIVE;
        buttonLayoutParamsDesc.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        buttonLayoutParamsDesc.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        buttonLayoutParamsDesc.rules = ruleDescs;
        MarginsDesc buttonMarginsDesc = new MarginsDesc(null);
        buttonMarginsDesc.right = 40;
        buttonMarginsDesc.left = 40;
        buttonLayoutParamsDesc.margins = buttonMarginsDesc;
        buttonDesc.params = buttonLayoutParamsDesc;
        GradientDesc pressedGradientDesc = new GradientDesc(null);
        pressedGradientDesc.strokeColor = "#FFFFFFFF";
        pressedGradientDesc.fillColor = "#FFFF0000";
        pressedGradientDesc.strokeWidth = 5;
        pressedGradientDesc.roundRadius = 15;
        GradientDesc selectedGradientDesc = new GradientDesc(null);
        selectedGradientDesc.strokeColor = "#FFFFFFFF";
        selectedGradientDesc.fillColor = "#FF00FF00";
        selectedGradientDesc.strokeWidth = 5;
        selectedGradientDesc.roundRadius = 15;
        GradientDesc normalGradientDesc = new GradientDesc(null);
        normalGradientDesc.strokeColor = "#FFFFFFFF";
        normalGradientDesc.fillColor = "#FF0000FF";
        normalGradientDesc.strokeWidth = 5;
        normalGradientDesc.roundRadius = 15;
        StateListDesc stateListDesc = new StateListDesc(null);
        stateListDesc.normal = normalGradientDesc;
        stateListDesc.pressed = pressedGradientDesc;
        stateListDesc.selected = selectedGradientDesc;
        buttonDesc.stateListDesc = stateListDesc;
        OnClickDesc onClickDesc = new OnClickDesc(null);
        ArrayList<ChildDesc> rChildDescs2 = new ArrayList<>();
        ButtonDesc buttonDesc1 = new ButtonDesc(null);
        buttonDesc1.text = "click1";
        LayoutParamsDesc buttonLayoutParamsDesc1 = new LayoutParamsDesc(null);
        buttonLayoutParamsDesc1.type = LayoutParamsDesc.TYPE_RELATIVE;
        buttonLayoutParamsDesc1.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        buttonLayoutParamsDesc1.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        buttonDesc1.params = buttonLayoutParamsDesc1;
        ButtonDesc buttonDesc2 = new ButtonDesc(null);
        buttonDesc2.text = "click2";
        LayoutParamsDesc buttonLayoutParamsDesc2 = new LayoutParamsDesc(null);
        buttonLayoutParamsDesc2.type = LayoutParamsDesc.TYPE_RELATIVE;
        buttonLayoutParamsDesc2.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        buttonLayoutParamsDesc2.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        buttonDesc2.params = buttonLayoutParamsDesc2;
        ArrayList<ChildDesc> rChildDescs1 = new ArrayList<>();
        rChildDescs1.add(new ChildDesc(buttonDesc1.toString(), ChildDesc.TYPE_BUTTON));
        rChildDescs1.add(new ChildDesc(buttonDesc2.toString(), ChildDesc.TYPE_BUTTON));
        LayoutDesc layoutDesc2 = new LayoutDesc(null);
        layoutDesc2.type = LayoutDesc.TYPE_LINEAR;
        layoutDesc2.backColor = "#00000000";
        layoutDesc2.orientation = LinearLayout.VERTICAL;
        LayoutParamsDesc layoutParamsDesc2 = new LayoutParamsDesc(null);
        layoutParamsDesc2.type = LayoutParamsDesc.TYPE_RELATIVE;
        layoutParamsDesc2.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutParamsDesc2.height = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutDesc2.params = layoutParamsDesc2;
        layoutDesc2.children = rChildDescs1;
        rChildDescs2.add(new ChildDesc(layoutDesc2.toString(), ChildDesc.TYPE_RELATIVE));
        LayoutDesc layoutDesc3 = new LayoutDesc(null);
        layoutDesc3.type = LayoutDesc.TYPE_RELATIVE;
        layoutDesc3.backColor = "#55000000";
        LayoutParamsDesc layoutParamsDesc3 = new LayoutParamsDesc(null);
        layoutParamsDesc3.type = LayoutParamsDesc.TYPE_RELATIVE;
        layoutParamsDesc3.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutParamsDesc3.height = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutDesc3.params = layoutParamsDesc3;
        layoutDesc3.children = rChildDescs2;
        onClickDesc.type = OnClickDesc.TYPE_DIALOG;
        onClickDesc.desc = layoutDesc3.toString();
//        onClickDesc.type = OnClickDesc.TYPE_DIALOG2;
//        onClickDesc.desc = layoutDesc3.toString();
//        onClickDesc.type = OnClickDesc.TYPE_ACTIVITY;
//        onClickDesc.desc = "www.markingyun.cn";
//        onClickDesc.type = OnClickDesc.TYPE_WEB;
//        onClickDesc.desc = "http://www.markingyun.cn";
        buttonDesc.onClick = onClickDesc;

        ImageViewDesc imageViewDesc = new ImageViewDesc(null);
        imageViewDesc.id = 1;
        imageViewDesc.url = "http://inews.gtimg.com/newsapp_bt/0/1467710683/641";
        LayoutParamsDesc imgLayoutParamsDesc = new LayoutParamsDesc(null);
        imgLayoutParamsDesc.type = LayoutParamsDesc.TYPE_RELATIVE;
        imgLayoutParamsDesc.width = 200;
        imgLayoutParamsDesc.height = 200;
        MarginsDesc imgMarginsDesc = new MarginsDesc(null);
        imgMarginsDesc.left = 40;
        imgMarginsDesc.right = 40;
        imgLayoutParamsDesc.margins = imgMarginsDesc;
        ArrayList<RuleDesc> ruleDescs2 = new ArrayList<RuleDesc>();
        ruleDescs2.add(new RuleDesc(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE));
        imgLayoutParamsDesc.rules = ruleDescs2;
        imageViewDesc.params = imgLayoutParamsDesc;

        TextViewDesc textViewDesc1 = new TextViewDesc(null);
        textViewDesc1.text = "this is top text";
        textViewDesc1.textColor = "#ffffff00";
        textViewDesc1.textSize = 10;
        textViewDesc1.backColor = "#ffff00ff";
        textViewDesc1.maxLine = 1;
        textViewDesc1.gravity = Gravity.CENTER;
        textViewDesc1.ellipsize = "END";
        LayoutParamsDesc textLayoutParamsDesc1 = new LayoutParamsDesc(null);
        textLayoutParamsDesc1.type = LayoutParamsDesc.TYPE_LINEAR;
        textLayoutParamsDesc1.width = LinearLayout.LayoutParams.MATCH_PARENT;
        textLayoutParamsDesc1.height = LinearLayout.LayoutParams.MATCH_PARENT;
        textLayoutParamsDesc1.weight = 1;
        textViewDesc1.params = textLayoutParamsDesc1;
        TextViewDesc textViewDesc2 = new TextViewDesc(null);
        textViewDesc2.text = "this is bottom text";
        textViewDesc2.textColor = "#ff00ff00";
        textViewDesc2.textSize = 10;
        textViewDesc2.backColor = "#ffff0000";
        textViewDesc2.maxLine = 1;
        textViewDesc2.gravity = Gravity.CENTER;
        textViewDesc2.ellipsize = "END";
        LayoutParamsDesc textLayoutParamsDesc2 = new LayoutParamsDesc(null);
        textLayoutParamsDesc2.type = LayoutParamsDesc.TYPE_LINEAR;
        textLayoutParamsDesc2.width = LinearLayout.LayoutParams.MATCH_PARENT;
        textLayoutParamsDesc2.height = LinearLayout.LayoutParams.MATCH_PARENT;
        textLayoutParamsDesc2.weight = 1;
        textViewDesc2.params = textLayoutParamsDesc2;

        ArrayList<ChildDesc> lChildDesc = new ArrayList<>();
        lChildDesc.add(new ChildDesc(textViewDesc1.toString(), ChildDesc.TYPE_TEXT));
        lChildDesc.add(new ChildDesc(textViewDesc2.toString(), ChildDesc.TYPE_TEXT));
        ArrayList<RuleDesc> lRuleDescs = new ArrayList<RuleDesc>();
        lRuleDescs.add(new RuleDesc(RelativeLayout.RIGHT_OF, 1));
        lRuleDescs.add(new RuleDesc(RelativeLayout.LEFT_OF, 2));
        LayoutDesc layoutDesc = new LayoutDesc(null);
        layoutDesc.type = LayoutDesc.TYPE_LINEAR;
        LayoutParamsDesc layoutLayoutParamsDesc = new LayoutParamsDesc(null);
        layoutLayoutParamsDesc.type = LayoutParamsDesc.TYPE_RELATIVE;
        layoutLayoutParamsDesc.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutLayoutParamsDesc.height = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutLayoutParamsDesc.rules = lRuleDescs;
        layoutDesc.params = layoutLayoutParamsDesc;
        layoutDesc.children = lChildDesc;
        layoutDesc.orientation = LinearLayout.VERTICAL;

        ArrayList<ChildDesc> rChildDescs = new ArrayList<>();
        rChildDescs.add(new ChildDesc(imageViewDesc.toString(), ChildDesc.TYPE_IMG));
        rChildDescs.add(new ChildDesc(buttonDesc.toString(), ChildDesc.TYPE_BUTTON));
        rChildDescs.add(new ChildDesc(layoutDesc.toString(), ChildDesc.TYPE_LINEAR));

        LayoutDesc layoutDesc1 = new LayoutDesc(null);
        layoutDesc1.type = LayoutDesc.TYPE_RELATIVE;
        layoutDesc1.backColor = "#ffffffff";
        LayoutParamsDesc layoutParamsDesc1 = new LayoutParamsDesc(null);
        layoutParamsDesc1.type = LayoutParamsDesc.TYPE_RELATIVE;
        layoutParamsDesc1.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutParamsDesc1.height = 280;
        layoutDesc1.params = layoutParamsDesc1;
        layoutDesc1.children = rChildDescs;
//        layoutDesc1.onClick = onClickDesc;

        Log.e("-----1", "layoutDesc1=" + layoutDesc1);
        View bannerView = CommonViewUtils.getInstance().getViewByStr(this, layoutDesc1.toString());
        relativeLayout.addView(bannerView);
    }

    public void test1() {
        setContentView(R.layout.item_banner);
    }

}