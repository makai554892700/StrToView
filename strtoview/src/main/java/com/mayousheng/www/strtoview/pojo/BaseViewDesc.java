package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/5/4.
 */

public class BaseViewDesc extends BasePoJo {

    @FieldDesc(key = "id")
    public int id;
    @FieldDesc(key = "backColor")
    public String backColor;
    @FieldDesc(key = "params")
    public LayoutParamsDesc params;
    @FieldDesc(key = "padding")
    public PaddingDesc padding;
    @FieldDesc(key = "mmDesc")
    public MMDesc mmDesc;
    @FieldDesc(key = "onClick")
    public OnClickDesc onClick;

    public BaseViewDesc(String jsonStr) {
        super(jsonStr);
    }

}
