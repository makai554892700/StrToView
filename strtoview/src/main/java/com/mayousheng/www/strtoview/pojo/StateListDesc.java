package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class StateListDesc extends BasePoJo {

    @FieldDesc(key = "pressed")
    public GradientDesc pressed;
    @FieldDesc(key = "selected")
    public GradientDesc selected;
    @FieldDesc(key = "normal")
    public GradientDesc normal;

    public StateListDesc(String jsonStr) {
        super(jsonStr);
    }

}
