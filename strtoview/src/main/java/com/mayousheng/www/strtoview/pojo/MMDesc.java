package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/5/4.
 */

public class MMDesc extends BasePoJo {

    @FieldDesc(key = "minWidth")
    public int minWidth;
    @FieldDesc(key = "minHeight")
    public int minHeight;
    @FieldDesc(key = "maxWidth")
    public int maxWidth;
    @FieldDesc(key = "maxHeight")
    public int maxHeight;

    public MMDesc(String jsonStr) {
        super(jsonStr);
    }

}
