package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.FieldDesc;

import java.util.ArrayList;

/**
 * Created by marking on 2017/4/27.
 */

public class LayoutDesc extends BaseViewDesc {

    public static final int TYPE_RELATIVE = 1;
    public static final int TYPE_LINEAR = 2;
    public static final int TYPE_FRAME = 3;

    @FieldDesc(key = "type")
    public int type;
    @FieldDesc(key = "orientation")
    public int orientation;
    @FieldDesc(key = "gravity")
    public int gravity;
    @FieldDesc(key = "children", arrayType = ChildDesc.class)
    public ArrayList<ChildDesc> children;

    public LayoutDesc(String jsonStr) {
        super(jsonStr);
    }

}
