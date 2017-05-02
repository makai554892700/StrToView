package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class ButtonDesc extends BasePoJo {

    @FieldDesc(key = "id")
    public int id;
    @FieldDesc(key = "text")
    public String text;
    @FieldDesc(key = "gravity")
    public int gravity;
    @FieldDesc(key = "params")
    public LayoutParamsDesc params;
    @FieldDesc(key = "padding")
    public PaddingDesc padding;
    @FieldDesc(key = "onClick")
    public OnClickDesc onClick;

    public ButtonDesc(String jsonStr) {
        super(jsonStr);
    }

    public ButtonDesc(int id, String text, int gravity, LayoutParamsDesc params
            , PaddingDesc padding, OnClickDesc onClick) {
        super(null);
        this.id = id;
        this.text = text;
        this.gravity = gravity;
        this.params = params;
        this.padding = padding;
        this.onClick = onClick;
    }
}
