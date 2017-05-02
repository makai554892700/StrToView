package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

import java.util.ArrayList;

/**
 * Created by marking on 2017/4/27.
 */

public class LayoutDesc extends BasePoJo {

    public static final int TYPE_RELATIVE = 1;
    public static final int TYPE_LINEAR = 2;
    public static final int TYPE_FRAME = 3;

    @FieldDesc(key = "id")
    public int id;
    @FieldDesc(key = "type")
    public int type;
    @FieldDesc(key = "orientation")
    public int orientation;
    @FieldDesc(key = "gravity")
    public int gravity;
    @FieldDesc(key = "params")
    public LayoutParamsDesc params;
    @FieldDesc(key = "color")
    public String color;
    @FieldDesc(key = "children", arrayType = ChildDesc.class)
    public ArrayList<ChildDesc> children;
    @FieldDesc(key = "onClick")
    public OnClickDesc onClick;

    public LayoutDesc(String jsonStr) {
        super(jsonStr);
    }

    public LayoutDesc(int id,int type, int gravity, int orientation, String color
            , LayoutParamsDesc layoutParamsDesc, ArrayList<ChildDesc> childDescs
            , OnClickDesc onClick) {
        super(null);
        this.id = id;
        this.type = type;
        this.orientation = orientation;
        this.gravity = gravity;
        this.params = layoutParamsDesc;
        this.color = color;
        this.children = childDescs;
        this.onClick = onClick;
    }
}
