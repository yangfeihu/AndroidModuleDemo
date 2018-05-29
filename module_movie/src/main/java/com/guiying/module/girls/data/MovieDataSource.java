package com.guiying.module.girls.data;

import com.guiying.module.girls.data.bean.MovieParser;

public interface MovieDataSource {

    interface LoadGirlsCallback {

        void onGirlsLoaded(MovieParser girlsParser);

        void onDataNotAvailable();
    }

    void getGirls(int size, int page, LoadGirlsCallback callback);

}
