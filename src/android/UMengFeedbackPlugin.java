package com.myideaway.cordova.umeng.share;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by cdm on 1/5/16.
 */
public class UMengSharePlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            init(args, callbackContext);
        } else if (action.equals("share")) {
            share(args, callbackContext);
        }

        return false;
    }

    private void init(JSONArray args, CallbackContext callbackContext) {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        //微信 appid appsecret
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        //新浪微博 appkey appsecret
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

        callbackContext.success();
    }

    private void share(JSONArray args, CallbackContext callbackContext) {
        String text = args.optString(0);
        String title = args.optString(1);
        String url = args.optString(2);

        final SHARE_MEDIA[] displaylist = new SHARE_MEDIA[]
                {
                        SHARE_MEDIA.WEIXIN,
                        SHARE_MEDIA.WEIXIN_CIRCLE,
                        SHARE_MEDIA.SINA,
                        SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                };
        new ShareAction(cordova.getActivity()).setDisplayList(displaylist)
                .withText(text)
                .withTitle(title)
                .withTargetUrl(url)
                .open();

        callbackContext.success();
    }
}
