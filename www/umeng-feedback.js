module.exports = {
    init: function (successHandler, errorHandler) {
        cordova.exec(successHandler, errorHandler, "UMengFeedbackPlugin", "init", []);
    },
    feedback:function(successHandler, errorHandler){
		cordova.exec(successHandler, errorHandler, "UMengFeedbackPlugin", "feedback", []);
	}
};