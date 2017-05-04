package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class ImageViewDesc extends BaseViewDesc {

    @FieldDesc(key = "url")
    public String url;

    public ImageViewDesc(String jsonStr) {
        super(jsonStr);
    }

}
