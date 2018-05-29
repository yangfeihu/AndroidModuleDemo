package com.guiying.module.girls.main;

import com.guiying.module.common.base.BasePresenter;
import com.guiying.module.common.base.BaseView;
import com.guiying.module.girls.data.bean.Movie;

import java.util.List;

/**
 * <p>类说明</p>
 *
 * @author yangfeihu 2017/2/22 20:33
 * @version V1.2.0
 * @name GirlsContract
 */
public interface MovieContract {

    interface View extends BaseView<Presenter> {

        /**
         * View 的存活状态
         *
         * @return true or false
         */
        boolean isActive();

        void refresh(List<Movie> data);

        void load(List<Movie> data);

        void showError();

        void showNormal();

    }

    interface Presenter extends BasePresenter {

        void getGirls(int page, int size, boolean isRefresh);

    }


}
