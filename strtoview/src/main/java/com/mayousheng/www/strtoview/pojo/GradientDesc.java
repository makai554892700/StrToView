package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class GradientDesc extends BasePoJo {

    @FieldDesc(key = "strokeWidth")
    public int strokeWidth;//边框宽度
    @FieldDesc(key = "roundRadius")
    public int roundRadius;//圆角半径
    @FieldDesc(key = "strokeColor")
    public String strokeColor;//边框颜色
    @FieldDesc(key = "fillColor")
    public String fillColor;//内部填充色

    public GradientDesc(String jsonStr) {
        super(jsonStr);
    }

}
