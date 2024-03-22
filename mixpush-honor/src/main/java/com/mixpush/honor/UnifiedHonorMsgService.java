package com.mixpush.honor;

import com.hihonor.push.sdk.HonorMessageService;
import com.hihonor.push.sdk.HonorPushDataMsg;
import com.mixpush.core.MixPushClient;
import com.mixpush.core.MixPushHandler;
import com.mixpush.core.MixPushMessage;
import com.mixpush.core.MixPushPlatform;

public class UnifiedHonorMsgService extends HonorMessageService {

    public static final String TAG = "HonorPushProvider";
    MixPushHandler handler = MixPushClient.getInstance().getHandler();

    @Override
    public void onNewToken(String token) {
//        super.onNewToken(s);
        MixPushPlatform mixPushPlatform = new MixPushPlatform(HonorPushProvider.HONOR,token);
        handler.getPushReceiver().onRegisterSucceed(this, mixPushPlatform);
    }


    @Override
    public void onMessageReceived(HonorPushDataMsg honorPushDataMsg) {
//        super.onMessageReceived(honorPushDataMsg);
        String content = honorPushDataMsg.getData();
        MixPushMessage mixPushMessage = new MixPushMessage();
        mixPushMessage.setPlatform(HonorPushProvider.HONOR);
        mixPushMessage.setPayload(content);
        mixPushMessage.setPassThrough(true);
        handler.getPassThroughReceiver().onReceiveMessage(this, mixPushMessage);
    }
}
