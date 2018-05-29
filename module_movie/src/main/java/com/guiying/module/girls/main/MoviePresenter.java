package com.guiying.module.girls.main;

import com.guiying.module.girls.data.MovieDataSource;
import com.guiying.module.girls.data.bean.MovieParser;
import com.guiying.module.girls.data.source.RemoteGirlsDataSource;

/**
 * <p>类说明</p>
 *
 * @author yangfeihu 2017/2/22 20:33
 * @version V1.2.0
 * @name GirlsPresenter
 */
public class MoviePresenter implements MovieContract.Presenter {

    private MovieContract.View mView;
    private MovieDataSource mDataSource;

    public MoviePresenter(MovieContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mDataSource = new RemoteGirlsDataSource();
    }

    @Override
    public void getGirls(int size, int page, final boolean isRefresh) {
        mDataSource.getGirls(size, page, new MovieDataSource.LoadGirlsCallback() {
            @Override
            public void onGirlsLoaded(MovieParser girlsParser) {
                if (isRefresh) {
                    mView.refresh(girlsParser.getResults());
                } else {
                    mView.load(girlsParser.getResults());
                }
                mView.showNormal();
            }

            @Override
            public void onDataNotAvailable() {
                if (isRefresh) {
                    mView.showError();
                }
            }
        });
    }

    @Override
    public void start() {
        getGirls(20, 1, true);
    }
}
