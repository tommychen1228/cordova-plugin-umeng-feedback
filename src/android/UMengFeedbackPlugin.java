package com.myideaway.cordova.umeng.feedback;

import com.umeng.fb.FeedbackAgent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by cdm on 1/5/16.
 */
public class UMengFeedbackPlugin extends CordovaPlugin {
    private FeedbackAgent fb;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            init(args, callbackContext);
        } else if (action.equals("feedback")) {
            feedback(args, callbackContext);
        }

        return false;
    }

    private void init(JSONArray args, CallbackContext callbackContext) {
        fb = new FeedbackAgent(cordova.getActivity());
        // check if the app developer has replied to the feedback or not.
        fb.sync();
        fb.openAudioFeedback();
        fb.openFeedbackPush();

        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = fb.updateUserInfo();
            }
        }).start();

        callbackContext.success();
    }

    private void feedback(JSONArray args, CallbackContext callbackContext) {
        fb.startFeedbackActivity();

        callbackContext.success();
    }
}
