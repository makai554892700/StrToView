package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mayousheng.www.strtoview.pojo.WebViewDesc;

/**
 * Created by marking on 2017/5/5.
 */

public class WebViewUtils {

    private static WebViewUtils webViewUtils;

    private WebViewUtils() {
    }

    public static WebViewUtils getInstance() {
        if (webViewUtils == null) {
            webViewUtils = new WebViewUtils();
        }
        return webViewUtils;
    }

    public WebView getWebView(Context context, final WebViewDesc webViewDesc) {
        if (webViewDesc != null && webViewDesc.url != null && !webViewDesc.url.isEmpty()) {
            WebView webView = CommonViewUtils.getInstance().updateView(context, new WebView(context), webViewDesc);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return webViewDesc.out;
                }
            });
            webView.loadUrl(webViewDesc.url);
            return webView;
        }
        return null;
    }

}
