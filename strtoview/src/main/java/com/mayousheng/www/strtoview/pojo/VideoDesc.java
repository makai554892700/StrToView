package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/28.
 */

public class VideoDesc extends BaseViewDesc {

    @FieldDesc(key = "url")
    public String url;

    public VideoDesc(String jsonStr) {
        super(jsonStr);
    }

}
