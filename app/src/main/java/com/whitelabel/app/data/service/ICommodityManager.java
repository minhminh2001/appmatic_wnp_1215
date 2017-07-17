package com.whitelabel.app.data.service;

import com.whitelabel.app.model.AddressBook;
import com.whitelabel.app.model.CategoryDetailModel;
import com.whitelabel.app.model.ProductDetailModel;
import com.whitelabel.app.model.ResponseModel;
import com.whitelabel.app.model.SVRAppserviceCatalogSearchReturnEntity;
import com.whitelabel.app.model.ShoppingCartListEntityCell;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface ICommodityManager {
    public Observable<SVRAppserviceCatalogSearchReturnEntity> getAllCategoryManager();
    public Observable<Integer> getLocalShoppingProductCount();
    public Observable<List<AddressBook>> getAddressListCache(String userId);
    public Observable<CategoryDetailModel> getCategoryDetail(boolean isCache,String category,String sessionKey);
    public Observable<ProductDetailModel> getProductDetail(String sessionKey,String productId);

}