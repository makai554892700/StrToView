package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/28.
 */

public class VideoDesc extends BasePoJo {

    @FieldDesc(key = "id")
    public int id;
    @FieldDesc(key = "url")
    public String url;
    @FieldDesc(key = "padding")
    public PaddingDesc padding;
    @FieldDesc(key = "params")
    public LayoutParamsDesc params;

    public VideoDesc(String jsonStr) {
        super(jsonStr);
    }


    public VideoDesc(int id, String url, PaddingDesc padding, LayoutParamsDesc params) {
        super(null);
        this.id = id;
        this.url = url;
        this.padding = padding;
        this.params = params;
    }
}
