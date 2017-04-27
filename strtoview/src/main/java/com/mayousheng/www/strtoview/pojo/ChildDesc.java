package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class ChildDesc extends BasePoJo {

    public static final int TYPE_TEXT = 1;
    public static final int TYPE_RELATIVE = 2;
    public static final int TYPE_LINEAR = 3;
    public static final int TYPE_FRAME = 4;
    public static final int TYPE_IMG = 5;
    public static final int TYPE_BUTTON = 6;

    @FieldDesc(key = "type")
    public int type;
    @FieldDesc(key = "str")
    public String str;

    public ChildDesc(String jsonStr) {
        super(jsonStr);
    }

    public ChildDesc(String str, int type) {
        super(null);
        this.type = type;
        this.str = str;
    }
}
