package com.whitelabel.app;

import android.content.Context;

import com.whitelabel.app.utils.JToolUtils;


/**
 * Created by Administrator on 2016/12/20.
 */

public class GlobalData {
    public static String appVersion = "";
    public static String serviceVersion = "";
    public static String appName;
    public static String jumpMarketUrl;
    public static String authName;
    public static String authPwd;
    public static String gcmSendId;
    public static String checkoutHashKey;
    public static String gaTrackId;
    public static String facebookId;
    public static String serviceRequestUrl;
    public static String downloadImageUrl;
    public static String upLoadFileUrl;
    public static String downloadImagePath;
    public static String uploadFilePath;
    // if true, all https connections are valid regardless of certificate validity
    public static boolean allowInvalidSSLTLS = false;
    private final static String pathSeparator = "/";
    public static String useHlb = "1";  //1  userHlb
    public static void init(Context context) {
        serviceVersion = context.getResources().getString(R.string.service_version);
        appName = context.getResources().getString(R.string.app_name);
        jumpMarketUrl = context.getResources().getString(R.string.jump_market_uri);
        authName = context.getResources().getString(R.string.auth_name);
        authPwd = context.getResources().getString(R.string.auth_pwd);
        gcmSendId = context.getResources().getString(R.string.gcm_sender_id);
        appVersion = JToolUtils.getAppVersion();

        checkoutHashKey = BuildConfig.HASH_KEY;
        gaTrackId = BuildConfig.GA_TRACK_ID;
        facebookId = BuildConfig.FACEBOOK_ID;
        if (BuildConfig.REQUEST_URL.indexOf("www.") == -1) {
            serviceRequestUrl = getAuthorizationUrl(BuildConfig.REQUEST_URL);
        }else{
            serviceRequestUrl = BuildConfig.REQUEST_URL;
        }
        downloadImagePath = context.getString(R.string.download_image_path);
        uploadFilePath =context.getString(R.string.upload_file_path);
        downloadImageUrl = serviceRequestUrl + pathSeparator + downloadImagePath;
        upLoadFileUrl = serviceRequestUrl + pathSeparator + uploadFilePath;
    }

    /**
     * add Authorization ,Does not contain a live environment
     */
    private static String getAuthorizationUrl(String requestUrl) {
        int firstEndIndex = requestUrl.indexOf("://") + 3;
        String firstPart = requestUrl.substring(0, firstEndIndex);
        String lastPart = requestUrl.substring(firstEndIndex, requestUrl.length());
        requestUrl = firstPart + authName + ":" + authPwd + "@" + lastPart;
        return requestUrl;
    }

    public static void updateGlobalData(String serviceAddress, String downloadImageUrl, String updateLoadImage, String hashKey) {
        serviceRequestUrl = serviceAddress;
        GlobalData.downloadImageUrl = downloadImageUrl;
        upLoadFileUrl = updateLoadImage + pathSeparator + uploadFilePath;
        checkoutHashKey = hashKey;
    }
}