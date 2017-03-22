package com.whitelabel.app.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.whitelabel.app.bean.Wishlist;
import com.whitelabel.app.model.AddToCartEntity;
import com.whitelabel.app.model.AddToWishlistEntity;
import com.whitelabel.app.model.AddressBook;
import com.whitelabel.app.model.AddressDeleteCellEntity;
import com.whitelabel.app.model.AddresslistReslut;
import com.whitelabel.app.model.CheckoutDefaultShippingAddressEntity;
import com.whitelabel.app.model.CheckoutGetPaymentListEntity;
import com.whitelabel.app.model.CheckoutOrderStatusEntity;
import com.whitelabel.app.model.CheckoutPaymentCreditCardType;
import com.whitelabel.app.model.CheckoutPaymentIssuerBankListEntity;
import com.whitelabel.app.model.CheckoutPaymentSaveReturnEntity;
import com.whitelabel.app.model.CheckoutSelectShippingAddressEntity;
import com.whitelabel.app.model.CustomAnimEntity;
import com.whitelabel.app.model.FBGraphAPIUserEntity;
import com.whitelabel.app.model.FavoriteEntity;
import com.whitelabel.app.model.GOUserEntity;
import com.whitelabel.app.model.GetAnimCodeEntity;
import com.whitelabel.app.model.MarketingLayersEntity;
import com.whitelabel.app.model.MyAccountOrderDetailEntityResult;
import com.whitelabel.app.model.MyAccountOrderListEntityResult;
import com.whitelabel.app.model.MyAccountOrderOuter;
import com.whitelabel.app.model.NotificationAppOpenReturnEntity;
import com.whitelabel.app.model.NotificationCountReturnEntity;
import com.whitelabel.app.model.SVRAddAddress;
import com.whitelabel.app.model.SVRAppServiceCustomSplashScreen;
import com.whitelabel.app.model.SVRAppServiceCustomerAddAddress;
import com.whitelabel.app.model.SVRAppServiceCustomerCountry;
import com.whitelabel.app.model.SVRAppServiceCustomerGetFavorite;
import com.whitelabel.app.model.SVRAppServiceCustomerLoginReturnEntity;
import com.whitelabel.app.model.SVRAppServiceCustomerMonthlyIncom;
import com.whitelabel.app.model.SVRAppServiceCustomerMyAccount;
import com.whitelabel.app.model.SVRAppServiceCustomerMyAccountUpdate;
import com.whitelabel.app.model.SVRAppServiceCustomerPhoneNumber;
import com.whitelabel.app.model.SVRAppServiceCustomerRegister;
import com.whitelabel.app.model.SVRAppServiceCustomerResetpass;
import com.whitelabel.app.model.SVRAppServiceCustomerSendEmail;
import com.whitelabel.app.model.SVRAppServiceCustomerSignOut;
import com.whitelabel.app.model.SVRAppServiceCustomerSubscribed;
import com.whitelabel.app.model.SVRAppServiceCustomerVersionCheck;
import com.whitelabel.app.model.SVRAppServiceCustomerchangepass;
import com.whitelabel.app.model.SVRAppserviceCatalogSearchReturnEntity;
import com.whitelabel.app.model.SVRAppserviceCmsCmsPageReturnEntity;
import com.whitelabel.app.model.SVRAppserviceCmsStaticBlocksReturnEntity;
import com.whitelabel.app.model.SVRAppserviceCustomerFbLoginReturnEntity;
import com.whitelabel.app.model.SVRAppserviceCustomerUploadHeadImageAndroidReturnEntity;
import com.whitelabel.app.model.SVRAppserviceLandingPagesDetailReturnEntity;
import com.whitelabel.app.model.SVRAppserviceLandingPagesListLandingPageItemReturnEntity;
import com.whitelabel.app.model.SVRAppserviceLandingPagesListReturnEntity;
import com.whitelabel.app.model.SVRAppserviceNotificationListReturnEntity;
import com.whitelabel.app.model.SVRAppserviceProductDetailReturnEntity;
import com.whitelabel.app.model.SVRAppserviceProductSearchReturnEntity;
import com.whitelabel.app.model.SVRAppserviceRecoverOrderReturnEntity;
import com.whitelabel.app.model.SVRAppserviceSaveBillingEntity;
import com.whitelabel.app.model.SVRAppserviceSaveOrderReturnEntity;
import com.whitelabel.app.model.SVRAppserviceWishlistIslikeReturnEntity;
import com.whitelabel.app.model.SVREditAddress;
import com.whitelabel.app.model.SVRExceptionReturnEntity;
import com.whitelabel.app.model.SVRGetCityANdStateByPostCodeEntity;
import com.whitelabel.app.model.ShoppingCarCheckStockBean;
import com.whitelabel.app.model.ShoppingCartCampaignListEntityReturn;
import com.whitelabel.app.model.ShoppingCartDeleteCellEntity;
import com.whitelabel.app.model.ShoppingCartListEntityResult;
import com.whitelabel.app.model.ShoppingCartVoucherApplyEntity;
import com.whitelabel.app.model.UpdateFavoriteEntity;
import com.whitelabel.app.model.WishlistDelteCellEntity;
import com.whitelabel.app.model.WishlistEntityResult;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imaginato on 2015/6/11.
 */
public class JJsonUtils {
    private static final String TAG = "JJsonUtils";

    public static SVRExceptionReturnEntity getSVRExceptionReturnEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRExceptionReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRExceptionReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "SVRExceptionReturnEntity", ex);
        }
        return entity;
    }


    public static <T> T parseJsonObj(String jsonString, Class<T> cls) {
                T t = null;
                 try {
                         Gson gson = new Gson();
                         t = gson.fromJson(jsonString, cls);
                     } catch (Exception e) {
                        e.getStackTrace();
                     }
                 return t;
    }



    public static <T> List<T> parseJsonList(String jsonString, Class<T> cls) {
                 List<T> list = new ArrayList<>();
                 try {
                         Gson gson = new Gson();
                         list = gson.fromJson(jsonString, new TypeToken<List<T>>() {}.getType());
                     } catch (Exception e) {
                      JLogUtils.i("exception", "========" + e.getStackTrace().toString());
                     }
                 return list;
    }


    public static  List<SVRAppserviceLandingPagesListLandingPageItemReturnEntity>  parseJsonList1(String jsonString){
        List<SVRAppserviceLandingPagesListLandingPageItemReturnEntity> beans=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(jsonString);
            for(int i=0;i<jsonArray.length();i++){
                beans.add(JJsonUtils.parseJsonObj(jsonArray.getJSONObject(i).toString(), SVRAppserviceLandingPagesListLandingPageItemReturnEntity.class));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beans;
    }



    public static List<MyAccountOrderOuter> parseOrderList(String jsonString){
        List<MyAccountOrderOuter> beans=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(jsonString);
            for(int i=0;i<jsonArray.length();i++){
                beans.add(JJsonUtils.parseJsonObj(jsonArray.getJSONObject(i).toString(), MyAccountOrderOuter.class));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beans;
    }


    public static List<AddressBook> parseAddressList(String jsonString){
        List<AddressBook> beans=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(jsonString);
            for(int i=0;i<jsonArray.length();i++){
                beans.add(JJsonUtils.parseJsonObj(jsonArray.getJSONObject(i).toString(), AddressBook.class));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beans;
    }




    public static List<com.whitelabel.app.model.Wishlist> parseWishlist(String jsonString){
        List<com.whitelabel.app.model.Wishlist> beans=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(jsonString);
            for(int i=0;i<jsonArray.length();i++){
                beans.add(JJsonUtils.parseJsonObj(jsonArray.getJSONObject(i).toString(), com.whitelabel.app.model.Wishlist.class));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beans;
    }

    public static SVRAppServiceCustomerLoginReturnEntity getSVRAPPSvrAppServiceCustomerLoginFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerLoginReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerLoginReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomerRegister getSVRAPPSvrAppServiceCustomerRegisterFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerRegister entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerRegister.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomerResetpass getSVRAPPSvrAppServiceCustomerResetpassFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerResetpass entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerResetpass.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomerMyAccount getSVRAPPSvrAppServiceCustomerMyAccountFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerMyAccount entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerMyAccount.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }


    public static SVRAppServiceCustomerSendEmail getSVRAPPSvrAppServiceCustomerSendEmailFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerSendEmail entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerSendEmail.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static SVRAppserviceCmsCmsPageReturnEntity getAppserviceCmsCmsPageFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppserviceCmsCmsPageReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceCmsCmsPageReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAppserviceCmsCmsPagesFromJson", ex);
        }
        return entity;
    }


    public static SVRAppServiceCustomerchangepass getSVRAPPSvrAppServiceCustomerChangepassFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerchangepass entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerchangepass.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }


    public static SVRAppserviceCmsStaticBlocksReturnEntity getSVRAppserviceCmsStaticBlocksReturnEntityFromJson(String jsonStr) {

        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppserviceCmsStaticBlocksReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceCmsStaticBlocksReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAppserviceCmsStaticBlocksReturnEntityFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomerCountry getSVRAPPSvrAppServiceCustomerCountryFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }
        SVRAppServiceCustomerCountry entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerCountry.class);
        } catch (Exception ex) {

            JLogUtils.e(TAG, "getSVRAppserviceCmsStaticBlocksReturnEntityFromJson", ex);

        }
        return entity;
    }

    public static SVRAddAddress getSVRAddAddressFromJson(String jsonStr) {

        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAddAddress entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAddAddress.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAppserviceCmsStaticBlocksReturnEntityFromJson", ex);


            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    /**
     * Parse ShoppingCartListEntityResult
     *
     * @param jsonStr
     * @return
     */
    public static ShoppingCartListEntityResult getSVRAPPServiceShoppingCartListEntityResultFromJson(String jsonStr) {
        ShoppingCartListEntityResult entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, ShoppingCartListEntityResult.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceShoppingCartListEntityResultFromJson", ex);
        }
        return entity;
    }

    /**
     * Parse ShoppingCartListEntityResult
     *
     * @param jsonStr
     * @return
     */
    public static ShoppingCartCampaignListEntityReturn getSVRAPPServiceShoppingCartCampaignListEntityResultFromJson(String jsonStr) {
        ShoppingCartCampaignListEntityReturn entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, ShoppingCartCampaignListEntityReturn.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceShoppingCartCampaignListEntityResultFromJson", ex);
        }
        return entity;
    }

    public static ShoppingCarCheckStockBean  getCheckStockBean(String jsonStr){
        ShoppingCarCheckStockBean entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, ShoppingCarCheckStockBean.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceShoppingCartListEntityResultFromJson", ex);
        }
        return entity;
    }

    /**
     * Parse ShoppingCartListEntityResult
     *
     * @param jsonStr
     * @return
     */
    public static MyAccountOrderListEntityResult getSVRAPPServiceMyAccountOrderListEntiryResultFromJson(String jsonStr) {
        MyAccountOrderListEntityResult entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, MyAccountOrderListEntityResult.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceShoppingCartListEntityResultFromJson", ex);

        }
        return entity;
    }

    /**
     * Parse ShoppingCartDetailEntityResult
     *
     * @param jsonStr
     * @return
     */
    public static MyAccountOrderDetailEntityResult getSVRAPPServiceMyAccountOrderDetailEntiryResultFromJson(String jsonStr) {
        MyAccountOrderDetailEntityResult entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, MyAccountOrderDetailEntityResult.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceShoppingCartListEntityResultFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomerMonthlyIncom getSVRAPPSvrAppServiceCustomerMonthlyIncomFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerMonthlyIncom entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerMonthlyIncom.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }


    public static MarketingLayersEntity getMarketingLayersEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        MarketingLayersEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, MarketingLayersEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    /**
     * Parse CheckoutDefaultShippingAddressEntity
     *
     * @param jsonStr
     * @return
     */
    public static CheckoutDefaultShippingAddressEntity getSVRAPPServiceCheckoutDefaultShippingAddressEntityFromJson(String jsonStr) {
        CheckoutDefaultShippingAddressEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, CheckoutDefaultShippingAddressEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutDefaultShippingAddressEntityFromJson", ex);
        }
        return entity;
    }

    /**
     * Parse CheckoutSelectShippingAddressEntity
     *
     * @param jsonStr
     * @return
     */
    public static CheckoutSelectShippingAddressEntity getSVRAPPServiceCheckoutSelectShippingAddressEntityFromJson(String jsonStr) {
        CheckoutSelectShippingAddressEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, CheckoutSelectShippingAddressEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutSelectShippingAddressEntityFromJson", ex);
        }
        return entity;
    }

    /**
     * Parse SVRAppserviceSaveBillingEntity
     *
     * @param jsonStr
     * @return
     */
    public static SVRAppserviceSaveBillingEntity getSVRAPPServiceCheckoutSaveBillingEntityFromJson(String jsonStr) {
        SVRAppserviceSaveBillingEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceSaveBillingEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutSaveBillingEntityFromJson", ex);
        }
        return entity;
    }

    /**
     * Parse SVRAppserviceSaveOrderReturnEntity
     *
     * @param jsonStr
     * @return
     */
    public static SVRAppserviceSaveOrderReturnEntity getSVRAPPServiceCheckoutSaveOrderReturnEntityFromJson(String jsonStr) {
        SVRAppserviceSaveOrderReturnEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceSaveOrderReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutSaveBillingEntityFromJson", ex);
        }
        return entity;
    }

    /**
     * Parse SVRAppserviceNotificationListReturnEntity
     *
     * @param jsonStr
     * @return
     */
    public static SVRAppserviceNotificationListReturnEntity getSVRAppserviceNotificationListReturnEntityFromJson(String jsonStr) {
        SVRAppserviceNotificationListReturnEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceNotificationListReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "SVRAppserviceNotificationListReturnEntity", ex);
        }
        return entity;
    }

    /**
     * Parse SVRAppserviceRecoverOrderReturnEntity
     *
     * @param jsonStr
     * @return
     */
    public static SVRAppserviceRecoverOrderReturnEntity getSVRAPPServiceCheckoutRecoverOrderReturnEntityFromJson(String jsonStr) {
        SVRAppserviceRecoverOrderReturnEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceRecoverOrderReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutSaveBillingEntityFromJson", ex);
        }
        return entity;
    }

    /**
     * Parse CheckoutPaymentIssuerBankListEntity
     *
     * @param jsonStr
     * @return
     */
    public static CheckoutPaymentIssuerBankListEntity getSVRAPPServiceCheckoutPaymentissuerBankListEntiryResultFromJson(String jsonStr) {
        CheckoutPaymentIssuerBankListEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, CheckoutPaymentIssuerBankListEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutPaymentissuerBankListEntiryResultFromJson", ex);

        }
        return entity;
    }

    /**
     * Parse SVRGetCityANdStateByPostCodeEntity
     *
     * @param jsonStr
     * @return
     */
    public static SVRGetCityANdStateByPostCodeEntity getSVRAPPServiceCheckoutGetCityANdStateByPostCodeEntiryResultFromJson(String jsonStr) {
        SVRGetCityANdStateByPostCodeEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRGetCityANdStateByPostCodeEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutGetCityANdStateByPostCodeEntiryResultFromJson", ex);

        }
        return entity;
    }

    /**
     * Parse CheckoutPaymentCreditCardType
     *
     * @param jsonStr
     * @return
     */
    public static CheckoutPaymentCreditCardType getSVRAPPServiceCheckoutPaymentCreditCartTypeFromJson(String jsonStr) {
        CheckoutPaymentCreditCardType entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, CheckoutPaymentCreditCardType.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutPaymenSavingEntiryResultFromJson", ex);

        }
        return entity;
    }

    /**
     * Parse CheckoutPaymentSaveReturnEntity
     *
     * @param jsonStr
     * @return
     */
    public static CheckoutPaymentSaveReturnEntity getSVRAPPServiceCheckoutPaymentSavingEntiryResultFromJson(String jsonStr) {
        CheckoutPaymentSaveReturnEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, CheckoutPaymentSaveReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutPaymenSavingEntiryResultFromJson", ex);

        }
        return entity;
    }

    /**
     * Parse NotificationAppOpenReturnEntity
     *
     * @param jsonStr
     * @return
     */
    public static NotificationAppOpenReturnEntity getSVRAPPServiceNotificationAppOpenEntiryResultFromJson(String jsonStr) {
        NotificationAppOpenReturnEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, NotificationAppOpenReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutPaymenSavingEntiryResultFromJson", ex);

        }
        return entity;
    }

    /**
     * Parse NotificationCountReturnEntity
     *
     * @param jsonStr
     * @return
     */
    public static NotificationCountReturnEntity getSVRAPPServiceNotificationCountEntiryResultFromJson(String jsonStr) {
        NotificationCountReturnEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, NotificationCountReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceNotificationCountEntiryResultFromJson", ex);

        }
        return entity;
    }

    /**
     * Parse CheckoutPaymentSaveReturnEntity
     *
     * @param jsonStr
     * @return
     */
    public static CheckoutGetPaymentListEntity getSVRAPPServiceCheckoutGetPaymentListEntityFromJson(String jsonStr) {
        CheckoutGetPaymentListEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, CheckoutGetPaymentListEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutPaymenSavingEntiryResultFromJson", ex);

        }
        return entity;
    }

    /**
     * Parse CheckoutOrderStatusEntity
     *
     * @param jsonStr
     * @return
     */
    public static CheckoutOrderStatusEntity getSVRAPPServiceCheckoutOrderStatusFromJson(String jsonStr) {
        CheckoutOrderStatusEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, CheckoutOrderStatusEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceCheckoutOrderStatusFromJson", ex);

        }
        return entity;
    }

    /**
     * Parse ShoppingCartDeleteCellEntity
     *
     * @param jsonStr
     * @return
     */
    public static ShoppingCartDeleteCellEntity getSVRAPPServiceShoppingcartDeleteCellEntityFromJson(String jsonStr) {
        ShoppingCartDeleteCellEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, ShoppingCartDeleteCellEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceShoppingcartDeleteCellEntityFromJson", ex);
        }
        return entity;
    }

    /**
     * Parse ShoppingCartVoucherApplyEntity
     *
     * @param jsonStr
     * @return
     */
    public static ShoppingCartVoucherApplyEntity getSVRAPPServiceShoppingcartVoucherApplyEntityFromJson(String jsonStr) {
        ShoppingCartVoucherApplyEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, ShoppingCartVoucherApplyEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceShoppingcartVoucherApplyEntityFromJson", ex);
        }
        return entity;
    }

    public static SVRAppserviceProductSearchReturnEntity getSVRAppserviceProductSearchReturnEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppserviceProductSearchReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceProductSearchReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAppserviceProductSearchReturnEntityFromJson", ex);
        }

        return entity;
    }

    public static SVRAppserviceCatalogSearchReturnEntity getSVRAppserviceCatalogSearchReturnEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppserviceCatalogSearchReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceCatalogSearchReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAppserviceCatalogSearchReturnEntityFromJson", ex);
        }
        return entity;
    }

    public static SVRAppserviceCustomerFbLoginReturnEntity getSVRAppserviceCustomerFbLoginReturnEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppserviceCustomerFbLoginReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceCustomerFbLoginReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAppserviceCustomerFbLoginReturnEntityFromJson", ex);
        }
        return entity;
    }

    public static FBGraphAPIUserEntity getFBGraphAPIUserEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        FBGraphAPIUserEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, FBGraphAPIUserEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getFBGraphAPIUserEntityFromJson", ex);
        }
        return entity;
    }


    public static WishlistDelteCellEntity getSVRAPPServiceWishlistDelteCellEntityFromJson(String jsonStr) {
        WishlistDelteCellEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, WishlistDelteCellEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceWishlistDelteCellEntityFromJson", ex);
        }
        return entity;
    }

    public static AddressDeleteCellEntity getSVRAPPServiceAddressDeleteCellEntityFromJson(String jsonStr) {
        AddressDeleteCellEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, AddressDeleteCellEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceAddressDeleteCellEntityFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomerSignOut getSVRAPPSvrAppServiceCustomerSignOutFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerSignOut entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerSignOut.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomerSubscribed getSVRAPPSvrAppServiceCustomerSubScribedFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerSubscribed entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerSubscribed.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomerPhoneNumber getSVRAPPSvrAppServiceCustomerPhoneNumberFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerPhoneNumber entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerPhoneNumber.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomerMyAccountUpdate getSVRAPPSvrAppServiceCustomerMyAccountUpdateFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerMyAccountUpdate entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerMyAccountUpdate.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);

        }
        return entity;
    }

    public static WishlistEntityResult getSVRAPPServiceWishlistEntityResultFromJson(String jsonStr) {
        WishlistEntityResult entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, WishlistEntityResult.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceWishlistEntityResultFromJson", ex);
        }
        return entity;
    }

    public static AddresslistReslut getSVRAPPServiceAddresslistReslutFromJson(String jsonStr) {
        AddresslistReslut entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, AddresslistReslut.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceAddresslistReslutFromJson", ex);
        }
        return entity;
    }

    public static SVRAppserviceProductDetailReturnEntity getSVRAPPServiceProductDetailEntityFromJson(String jsonStr) {
        SVRAppserviceProductDetailReturnEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceProductDetailReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceAddresslistReslutFromJson", ex);
        }
        return entity;
    }

    public static SVRAppserviceCustomerUploadHeadImageAndroidReturnEntity getSVRAppserviceCustomerUploadHeadImageAndroidReturnEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppserviceCustomerUploadHeadImageAndroidReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceCustomerUploadHeadImageAndroidReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAppserviceCustomerUploadHeadImageAndroidReturnEntityFromJson", ex);
        }
        return entity;
    }

    public static SVREditAddress getSVREditAddressFromJson(String jsonStr) {

        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVREditAddress entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVREditAddress.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRASVREditAddressFromJson", ex);


            JLogUtils.e(TAG, "getSVRSVREditAddressFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomerAddAddress getSVRAPPSvrAppServiceCustomerAddAdderssFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerAddAddress entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerAddAddress.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static SVRAppserviceLandingPagesDetailReturnEntity getSVRAppserviceLandingPagesDetailReturnEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppserviceLandingPagesDetailReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceLandingPagesDetailReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAppserviceLandingPagesDetailReturnEntityFromJson", ex);
        }
        return entity;
    }

    public static SVRAppserviceLandingPagesListReturnEntity getSVRAppserviceLandingPagesListReturnEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppserviceLandingPagesListReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceLandingPagesListReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static AddToCartEntity getSVRAPPServiceAddToCartEntityFromJson(String jsonStr) {
        AddToCartEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, AddToCartEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceAddToCartEntityFromJson", ex);
        }
        return entity;
    }

    public static AddToWishlistEntity getSVRAPPServiceAddToWishlistEntityFromJson(String jsonStr) {
        AddToWishlistEntity entity = null;

        if (JDataUtils.isEmpty(jsonStr)) {
            return entity;
        }

        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, AddToWishlistEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPServiceAddToWishlistEntityFromJson", ex);
        }
        return entity;
    }

    public static GOUserEntity getUserEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        GOUserEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, GOUserEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static SVRAppserviceWishlistIslikeReturnEntity getSVRAppserviceWishlistIslikeReturnEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppserviceWishlistIslikeReturnEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppserviceWishlistIslikeReturnEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAppserviceWishlistIslikeReturnEntityFromJson", ex);
        }
        return entity;
    }
    public static FavoriteEntity getSVRAppserviceFavoriteEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        FavoriteEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, FavoriteEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }
    public static UpdateFavoriteEntity getSVRAppserviceUpdateFavoriteEntityFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }
        UpdateFavoriteEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, UpdateFavoriteEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static SVRAppServiceCustomSplashScreen getSVRAPPSvrAppServiceCustomerSplashScreenFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }
        SVRAppServiceCustomSplashScreen entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomSplashScreen.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }
    public static SVRAppServiceCustomerGetFavorite getSVRAPPSvrAppServiceCustomerGetFavoriteFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }
        SVRAppServiceCustomerGetFavorite entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerGetFavorite.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }
    public static SVRAppServiceCustomerVersionCheck getSVRAPPSvrAppServiceCustomerVersionCheckFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        SVRAppServiceCustomerVersionCheck entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, SVRAppServiceCustomerVersionCheck.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }
    public static CustomAnimEntity getSVRAPPSvrAppServiceCustomerAnimFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        CustomAnimEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, CustomAnimEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }

    public static GetAnimCodeEntity getSVRAPPSvrAppServiceCustomerGetAnimCodrFromJson(String jsonStr) {
        if (JDataUtils.isEmpty(jsonStr)) {
            return null;
        }

        GetAnimCodeEntity entity = null;
        try {
            Gson gson = new Gson();
            entity = gson.fromJson(jsonStr, GetAnimCodeEntity.class);
        } catch (Exception ex) {
            JLogUtils.e(TAG, "getSVRAPPSvrAppServiceCustomerLoginFromJson", ex);
        }
        return entity;
    }
}