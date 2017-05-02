package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/5/2.
 */

public class OnClickDesc extends BasePoJo {

    //如果是对话框，默认全屏，且记得多套一层viewGroup
    public static final int TYPE_DIALOG = 1;//点击弹对话框且与点击坐标相关
    public static final int TYPE_ACTIVITY = 2;//点击打开activity
    public static final int TYPE_WEB = 3;//点击打开网页
    public static final int TYPE_DIALOG2 = 4;//点击弹对话框

    @FieldDesc(key = "type")
    public int type;
    @FieldDesc(key = "desc")
    public String desc;

    public OnClickDesc(String jsonStr) {
        super(jsonStr);
    }

    public OnClickDesc(int type, String desc) {
        super(null);
        this.type = type;
        this.desc = desc;
    }
}
