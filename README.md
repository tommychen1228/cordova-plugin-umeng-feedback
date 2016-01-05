# cordova-plugin-umeng-feedback
cordova友盟用户反馈插件

目前使用的是umeng用户反馈的5.4.0版本

#安装
cordova plugin add https://github.com/tommychen1228/cordova-plugin-umeng-feedback.git --variable API_KEY=YOUR_UMENG_APP_KEY --variable MESSAGE_SECRET=YOUR_MESSAGE_SECRET

YOUR_MESSAGE_SECRET是umeng推送使用的，需要给应用开通umeng推送后，填写message secret

#使用
##初始化
在页面js开始能执行的地方
```
UMengFeedback.init(function () {
    console.log('UMengFeedback init success');
});
```

##进入反馈界面
```
 UMengFeedback.feedback();
```