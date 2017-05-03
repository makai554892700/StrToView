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
import com.mayousheng.www.strtoview.pojo.ImageViewDesc;
import com.mayousheng.www.strtoview.pojo.LayoutParamsDesc;
import com.mayousheng.www.strtoview.pojo.LayoutDesc;
import com.mayousheng.www.strtoview.pojo.OnClickDesc;
import com.mayousheng.www.strtoview.pojo.RuleDesc;
import com.mayousheng.www.strtoview.pojo.TextViewDesc;
import com.mayousheng.www.strtoview.pojo.VideoDesc;
import com.mayousheng.www.strtoview.utils.CommonViewUtils;
import com.mayousheng.www.strtoview.utils.DescUtils;

import java.util.ArrayList;

public class MainActivity extends Activity {

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long start = System.currentTimeMillis();
//        test1();
//        test2();
//        test3();
        test4();
        Log.e("-----1", "time=" + (System.currentTimeMillis() - start));
    }

    public void test4() {
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        ArrayList<RuleDesc> ruleDescs = new ArrayList<RuleDesc>();
        ruleDescs.add(new RuleDesc(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE));
//        VideoDesc videoDesc = new VideoDesc(0, "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"
        VideoDesc videoDesc = new VideoDesc(0, "http://www.shandao.space/test.mp4"
                , null, new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE, RelativeLayout.LayoutParams.WRAP_CONTENT
                , RelativeLayout.LayoutParams.WRAP_CONTENT, 0, 0, ruleDescs, null), null);
        ArrayList<ChildDesc> rChildDescs = new ArrayList<>();
        rChildDescs.add(new ChildDesc(videoDesc.toString(), ChildDesc.TYPE_VIDEO));
        LayoutDesc layoutDesc1 = new LayoutDesc(0, LayoutDesc.TYPE_RELATIVE, 0, 0
                , "#ffffffff", new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                , RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
                , 0, 0, null, null), rChildDescs, null);

        Log.e("-----1", "layoutDesc1=" + layoutDesc1);
        View bannerView = CommonViewUtils.getInstance().getViewByStr(this, layoutDesc1.toString());
        relativeLayout.addView(bannerView);
    }

    public void test3() {
        setContentView(R.layout.item_video);
        final VideoView videoView = (VideoView) findViewById(R.id.video);

//        String sdCard = Environment.getExternalStorageDirectory().getAbsolutePath();
//        String path = sdCard + File.separator + "test2.mp4";
//        Log.e("-----1", "path=" + path + ";exists=" + new File(path).exists());
//        videoView.setVideoPath(path);

        videoView.setVideoURI(Uri.parse("http://www.shandao.space/test.mp4"));

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

        ButtonDesc buttonDesc = new ButtonDesc(2, "button", 0, DescUtils.getInstance()
                .getLayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE, RelativeLayout.LayoutParams.WRAP_CONTENT
                        , RelativeLayout.LayoutParams.WRAP_CONTENT, 0, 0, ruleDescs, DescUtils.getInstance()
                                .getMarginsDesc(0, 0, 40, 0)), null, null);
        ArrayList<RuleDesc> ruleDescs2 = new ArrayList<RuleDesc>();
        ruleDescs2.add(new RuleDesc(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE));
        ImageViewDesc imageViewDesc = new ImageViewDesc(1, null
                , "http://inews.gtimg.com/newsapp_bt/0/1467710683/641"
                , new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                , 200, 200, 0, 0, ruleDescs2, DescUtils.getInstance()
                .getMarginsDesc(40, 0, 0, 0)), null, null);

        TextViewDesc textViewDesc1 = new TextViewDesc(0, "this is top text"
                , "#ffffff00", 10, "#ffff00ff", 1, Gravity.CENTER, "END"
                , new LayoutParamsDesc(LayoutParamsDesc.TYPE_LINEAR
                , LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                , 0, 1, null, null), null, null);
        TextViewDesc textViewDesc2 = new TextViewDesc(0, "this is bottom text"
                , "#ff00ff00", 10, "#ffff0000", 1, Gravity.CENTER, "END"
                , new LayoutParamsDesc(LayoutParamsDesc.TYPE_LINEAR
                , LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                , 0, 1, null, null), null, null);
        ArrayList<ChildDesc> lChildDesc = new ArrayList<>();
        lChildDesc.add(new ChildDesc(textViewDesc1.toString(), ChildDesc.TYPE_TEXT));
        lChildDesc.add(new ChildDesc(textViewDesc2.toString(), ChildDesc.TYPE_TEXT));
        ArrayList<RuleDesc> lRuleDescs = new ArrayList<RuleDesc>();
        lRuleDescs.add(new RuleDesc(RelativeLayout.RIGHT_OF, 1));
        lRuleDescs.add(new RuleDesc(RelativeLayout.LEFT_OF, 2));
        LayoutDesc layoutDesc = new LayoutDesc(0, LayoutDesc.TYPE_LINEAR, 0
                , LinearLayout.VERTICAL, null, new LayoutParamsDesc(
                LayoutDesc.TYPE_RELATIVE, RelativeLayout.LayoutParams.MATCH_PARENT
                , RelativeLayout.LayoutParams.MATCH_PARENT, 0, 0, lRuleDescs, null), lChildDesc, null);

        ArrayList<ChildDesc> rChildDescs = new ArrayList<>();
        rChildDescs.add(new ChildDesc(imageViewDesc.toString(), ChildDesc.TYPE_IMG));
        rChildDescs.add(new ChildDesc(buttonDesc.toString(), ChildDesc.TYPE_BUTTON));
        rChildDescs.add(new ChildDesc(layoutDesc.toString(), ChildDesc.TYPE_LINEAR));

        ButtonDesc buttonDesc1 = new ButtonDesc(0, "click1", 0, new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                , RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT
                , 0, 0, null, null), null, null);
        ButtonDesc buttonDesc2 = new ButtonDesc(0, "click2", 0, new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                , RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT
                , 0, 0, null, null), null, null);
        ArrayList<ChildDesc> rChildDescs1 = new ArrayList<>();
        rChildDescs1.add(new ChildDesc(buttonDesc1.toString(), ChildDesc.TYPE_BUTTON));
        rChildDescs1.add(new ChildDesc(buttonDesc2.toString(), ChildDesc.TYPE_BUTTON));
        LayoutDesc layoutDesc2 = new LayoutDesc(0, LayoutDesc.TYPE_LINEAR, 0, LinearLayout.VERTICAL, "#00000000"
                , new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                , RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
                , 0, 0, null, null), rChildDescs1, null);
        ArrayList<ChildDesc> rChildDescs2 = new ArrayList<>();
        rChildDescs2.add(new ChildDesc(layoutDesc2.toString(), ChildDesc.TYPE_RELATIVE));
        LayoutDesc layoutDesc3 = new LayoutDesc(0, LayoutDesc.TYPE_RELATIVE, 0, 0, "#55000000"
                , new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                , RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
                , 0, 0, null, null), rChildDescs2, null);

        LayoutDesc layoutDesc1 = new LayoutDesc(0, LayoutDesc.TYPE_RELATIVE, 0, 0
                , "#ffffffff", new LayoutParamsDesc(LayoutParamsDesc.TYPE_RELATIVE
                , RelativeLayout.LayoutParams.MATCH_PARENT, 280, 0, 0, null, null), rChildDescs
                , new OnClickDesc(OnClickDesc.TYPE_DIALOG, layoutDesc3.toString()));
//                , new OnClickDesc(OnClickDesc.TYPE_DIALOG2, layoutDesc3.toString()));
//                , new OnClickDesc(OnClickDesc.TYPE_ACTIVITY, "www.markingyun.cn"));
//                , new OnClickDesc(OnClickDesc.TYPE_WEB, "http://www.markingyun.cn"));

        Log.e("-----1", "layoutDesc1=" + layoutDesc1);
        View bannerView = CommonViewUtils.getInstance().getViewByStr(this, layoutDesc1.toString());
        relativeLayout.addView(bannerView);
    }

    public void test1() {
        setContentView(R.layout.item_banner);
    }

}