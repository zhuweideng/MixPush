package com.mixpush.honor;

import com.hihonor.push.sdk.HonorMessageService;
import com.hihonor.push.sdk.HonorPushDataMsg;
import com.mixpush.core.MixPushClient;
import com.mixpush.core.MixPushHandler;

public class EuHonorMsgService extends HonorMessageService {

    public static final String TAG = "HonorPushProvider";
    MixPushHandler handler = MixPushClient.getInstance().getHandler();
    @Override
    public void onNewToken(String token) {
        super.onNewToken(token); // PushToken
    }

    @Override
    public void onMessageReceived(HonorPushDataMsg honorPushDataMsg) {
        super.onMessageReceived(honorPushDataMsg); // 透传消息

    }
}
