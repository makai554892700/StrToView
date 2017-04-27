package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class ImageViewDesc extends BasePoJo {

    @FieldDesc(key = "id")
    public int id;
    @FieldDesc(key = "url")
    public String url;
    @FieldDesc(key = "color")
    public String color;
    @FieldDesc(key = "params")
    public LayoutParamsDesc params;
    @FieldDesc(key = "padding")
    public PaddingDesc padding;

    public ImageViewDesc(String jsonStr) {
        super(jsonStr);
    }

    public ImageViewDesc(int id,String color, String url
            , LayoutParamsDesc layoutParamsDesc, PaddingDesc paddingDesc) {
        super(null);
        this.id = id;
        this.url = url;
        this.color = color;
        this.params = layoutParamsDesc;
        this.padding = paddingDesc;
    }
}
