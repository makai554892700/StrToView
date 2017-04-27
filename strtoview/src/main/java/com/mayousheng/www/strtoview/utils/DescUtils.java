package com.mayousheng.www.strtoview.utils;

import com.mayousheng.www.strtoview.pojo.ButtonDesc;
import com.mayousheng.www.strtoview.pojo.ChildDesc;
import com.mayousheng.www.strtoview.pojo.ImageViewDesc;
import com.mayousheng.www.strtoview.pojo.LayoutParamsDesc;
import com.mayousheng.www.strtoview.pojo.MarginsDesc;
import com.mayousheng.www.strtoview.pojo.PaddingDesc;
import com.mayousheng.www.strtoview.pojo.LayoutDesc;
import com.mayousheng.www.strtoview.pojo.RuleDesc;
import com.mayousheng.www.strtoview.pojo.TextViewDesc;

import java.util.ArrayList;

/**
 * Created by marking on 2017/4/27.
 */

public class DescUtils {

    private static DescUtils descUtils;

    private DescUtils() {
    }

    public static DescUtils getInstance() {
        if (descUtils == null) {
            descUtils = new DescUtils();
        }
        return descUtils;
    }

    public LayoutDesc getLayoutDesc(int type, int gravity, int orientation, String color
            , LayoutParamsDesc layoutParamsDesc, ArrayList<ChildDesc> childDescs) {
        LayoutDesc layoutDesc = new LayoutDesc(null);
        layoutDesc.type = type;
        layoutDesc.gravity = gravity;
        layoutDesc.orientation = orientation;
        layoutDesc.color = color;
        layoutDesc.params = layoutParamsDesc;
        layoutDesc.children = childDescs;
        return layoutDesc;
    }

    public MarginsDesc getMarginsDesc(int left, int top, int right, int bottom) {
        MarginsDesc marginsDesc = new MarginsDesc(null);
        marginsDesc.left = left;
        marginsDesc.top = top;
        marginsDesc.right = right;
        marginsDesc.bottom = bottom;
        return marginsDesc;
    }

    public RuleDesc getRuleDesc(int key, int value) {
        RuleDesc ruleDesc = new RuleDesc(null);
        ruleDesc.key = key;
        ruleDesc.value = value;
        return ruleDesc;
    }

    public ChildDesc getChildDesc(String str, int type) {
        ChildDesc childDesc = new ChildDesc(null);
        childDesc.str = str;
        childDesc.type = type;
        return childDesc;
    }

    public LayoutParamsDesc getLayoutParamsDesc(int type, int width, int height, int gravity, int weight
            , ArrayList<RuleDesc> ruleDescs, MarginsDesc marginsDesc) {
        LayoutParamsDesc layoutParamsDesc = new LayoutParamsDesc(null);
        layoutParamsDesc.gravity = gravity;
        layoutParamsDesc.weight = weight;
        layoutParamsDesc.type = type;
        layoutParamsDesc.margins = marginsDesc;
        layoutParamsDesc.rules = ruleDescs;
        layoutParamsDesc.width = width;
        layoutParamsDesc.height = height;
        return layoutParamsDesc;
    }

    public ImageViewDesc getImageViewDesc(String color, String url
            , LayoutParamsDesc layoutParamsDesc, PaddingDesc paddingDesc) {
        ImageViewDesc imageViewDesc = new ImageViewDesc(null);
        imageViewDesc.url = url;
        imageViewDesc.color = color;
        imageViewDesc.params = layoutParamsDesc;
        imageViewDesc.padding = paddingDesc;
        return imageViewDesc;
    }

    public TextViewDesc getTextViewDesc(String text, String color, float size, String backColor
            , int maxLine, int gravity, String ellipsize, LayoutParamsDesc params, PaddingDesc padding) {
        TextViewDesc textViewDesc = new TextViewDesc(null);
        textViewDesc.text = text;
        textViewDesc.color = color;
        textViewDesc.size = size;
        textViewDesc.backColor = backColor;
        textViewDesc.maxLine = maxLine;
        textViewDesc.gravity = gravity;
        textViewDesc.ellipsize = ellipsize;
        textViewDesc.params = params;
        textViewDesc.padding = padding;
        return textViewDesc;
    }

    public ButtonDesc getButtonDesc(String text, int gravity, LayoutParamsDesc params, PaddingDesc padding) {
        ButtonDesc buttonDesc = new ButtonDesc(null);
        buttonDesc.text = text;
        buttonDesc.gravity = gravity;
        buttonDesc.params = params;
        buttonDesc.padding = padding;
        return buttonDesc;
    }

}
