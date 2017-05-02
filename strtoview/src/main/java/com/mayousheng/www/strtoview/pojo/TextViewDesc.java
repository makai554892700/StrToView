package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class TextViewDesc extends BasePoJo {

    @FieldDesc(key = "id")
    public int id;
    @FieldDesc(key = "text")
    public String text;
    @FieldDesc(key = "color")
    public String color;
    @FieldDesc(key = "backColor")
    public String backColor;
    @FieldDesc(key = "size")
    public float size;
    @FieldDesc(key = "gravity")
    public int gravity;
    @FieldDesc(key = "params")
    public LayoutParamsDesc params;
    @FieldDesc(key = "maxLine")
    public int maxLine;
    @FieldDesc(key = "padding")
    public PaddingDesc padding;
    @FieldDesc(key = "ellipsize")
    public String ellipsize;//END MIDDLE START
    @FieldDesc(key = "onClick")
    public OnClickDesc onClick;

    public TextViewDesc(String jsonStr) {
        super(jsonStr);
    }

    public TextViewDesc(int id, String text, String color, float size, String backColor
            , int maxLine, int gravity, String ellipsize, LayoutParamsDesc params
            , OnClickDesc onClick, PaddingDesc padding) {
        super(null);
        this.id = id;
        this.text = text;
        this.color = color;
        this.backColor = backColor;
        this.size = size;
        this.gravity = gravity;
        this.params = params;
        this.maxLine = maxLine;
        this.padding = padding;
        this.ellipsize = ellipsize;
        this.onClick = onClick;
    }
}
