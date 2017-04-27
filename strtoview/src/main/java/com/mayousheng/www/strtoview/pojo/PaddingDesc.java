package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class PaddingDesc extends BasePoJo {

    @FieldDesc(key = "left")
    public int left;
    @FieldDesc(key = "top")
    public int top;
    @FieldDesc(key = "right")
    public int right;
    @FieldDesc(key = "bottom")
    public int bottom;

    public PaddingDesc(String jsonStr){
        super(jsonStr);
    }

    public PaddingDesc(String jsonStr, int left, int top, int right, int bottom) {
        super(jsonStr);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }
}
