package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/5/5.
 */

public class WebViewDesc extends BaseViewDesc {

    @FieldDesc(key = "url")
    public String url;
    @FieldDesc(key = "out")
    public boolean out;

    public WebViewDesc(String jsonStr) {
        super(jsonStr);
    }

}
