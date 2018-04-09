package com.whitelabel.app.ui.search;

import com.whitelabel.app.model.SVRAppserviceProductSearchReturnEntity;
import com.whitelabel.app.model.SearchFilterResponse;
import com.whitelabel.app.ui.BasePresenter;
import com.whitelabel.app.ui.BaseView;

import java.util.List;
import java.util.Map;

/**
 * Created by img on 2018/1/26.
 */

public class SearchContract {
    public interface View extends BaseView{
        public void showErrorMsg(String errorMsg);
        public void loadAutoHintSearchData(List<SearchFilterResponse.SuggestsBean.ItemsBean> itemsBeans);
    }

    public interface Presenter extends BasePresenter<View>{
        public void  autoSearch(String keyword);
    }
}