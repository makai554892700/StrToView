package com.mayousheng.www.strtoview.pojo;

import com.mayousheng.www.basepojo.BasePoJo;
import com.mayousheng.www.basepojo.FieldDesc;

/**
 * Created by marking on 2017/4/26.
 */

public class RuleDesc extends BasePoJo {

    @FieldDesc(key = "key")
    public int key;
    @FieldDesc(key = "value")
    public int value;

    public RuleDesc(String jsonStr) {
        super(jsonStr);
    }

    public RuleDesc(int key, int value) {
        super(null);
        this.key = key;
        this.value = value;
    }
}
