package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class TextViewDesc extends BaseViewDesc {

    @FieldDesc(key = "text")
    public String text;
    @FieldDesc(key = "textColor")
    public String textColor;
    @FieldDesc(key = "textSize")
    public float textSize;
    @FieldDesc(key = "gravity")
    public int gravity;
    @FieldDesc(key = "maxLine")
    public int maxLine;
    @FieldDesc(key = "minLine")
    public int minLine;
    @FieldDesc(key = "ellipsize")
    public String ellipsize;//END MIDDLE START
    @FieldDesc(key = "stateListDesc")
    public StateListDesc stateListDesc;

    public TextViewDesc(String jsonStr) {
        super(jsonStr);
    }

}
