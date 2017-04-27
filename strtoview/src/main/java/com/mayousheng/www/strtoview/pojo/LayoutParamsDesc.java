package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

import java.util.ArrayList;

/**
 * Created by marking on 2017/4/26.
 */

public class LayoutParamsDesc extends BasePoJo {

    public static final int TYPE_RELATIVE = 1;
    public static final int TYPE_LINEAR = 2;
    public static final int TYPE_FRAME = 3;

    @FieldDesc(key = "type")
    public int type;
    @FieldDesc(key = "width")
    public int width;
    @FieldDesc(key = "weight")
    public int weight;
    @FieldDesc(key = "height")
    public int height;
    @FieldDesc(key = "gravity")
    public int gravity;
    @FieldDesc(key = "rules", arrayType = RuleDesc.class)
    public ArrayList<RuleDesc> rules;
    @FieldDesc(key = "margins")
    public MarginsDesc margins;

    public LayoutParamsDesc(String jsonStr) {
        super(jsonStr);
    }

    public LayoutParamsDesc(int type, int width, int height, int gravity, int weight
            , ArrayList<RuleDesc> ruleDescs, MarginsDesc marginsDesc) {
        super(null);
        this.type = type;
        this.width = width;
        this.weight = weight;
        this.height = height;
        this.gravity = gravity;
        this.rules = ruleDescs;
        this.margins = marginsDesc;
    }
}
