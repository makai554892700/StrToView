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
    @FieldDesc(key = "onClick")
    public OnClickDesc onClick;

    public VideoDesc(String jsonStr) {
        super(jsonStr);
    }


    public VideoDesc(int id, String url, PaddingDesc padding, LayoutParamsDesc params
            , OnClickDesc onClick) {
        super(null);
        this.id = id;
        this.url = url;
        this.padding = padding;
        this.params = params;
        this.onClick = onClick;
    }
}
