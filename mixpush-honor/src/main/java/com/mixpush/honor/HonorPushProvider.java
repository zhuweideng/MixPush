package com.mixpush.honor;

import static com.mixpush.honor.UnifiedHonorMsgService.TAG;

import android.content.Context;
import android.os.Build;

import com.hihonor.push.sdk.HonorPushCallback;
import com.hihonor.push.sdk.HonorPushClient;
import com.mixpush.core.BaseMixPushProvider;
import com.mixpush.core.MixPushClient;
import com.mixpush.core.MixPushHandler;
import com.mixpush.core.RegisterType;

public class HonorPushProvider extends BaseMixPushProvider {

    public static final String HONOR = "honor";
    public static String regId;

    MixPushHandler handler = MixPushClient.getInstance().getHandler();
    @Override
    public void register(Context context, RegisterType type) {
        HonorPushClient.getInstance().init(context, true);

    }

    @Override
    public void unRegister(Context context) {

    }

    @Override
    public String getRegisterId(Context context) {
        HonorPushClient.getInstance().getPushToken(new HonorPushCallback<String>() {
            @Override
            public void onSuccess(String s) {
                regId = s;
            }

            @Override
            public void onFailure(int i, String s) {
                handler.getLogger().log(TAG, "hms get token failed " + s);
            }
        });
        return null;
    }

    @Override
    public boolean isSupport(Context context) {

        String manufacturer = Build.MANUFACTURER.toLowerCase();
        if (!manufacturer.equals("honor")) {
            return false;
        }
        boolean isSupport = HonorPushClient.getInstance().checkSupportHonorPush(context);
        if (!isSupport) {
            handler.getLogger().log(TAG, "华为推送不可用 ErrorCode = " );
            return false;
        }
        return true;
    }

    @Override
    public String getPlatformName() {
        return HonorPushProvider.HONOR;
    }

    private void syncGetToken(final Context context) {
        new Thread() {
            @Override
            public void run() {

            }
        }.start();
    }
}
