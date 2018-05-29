package com.guiying.module.girls.data.source;


import com.guiying.module.common.http.DataType;
import com.guiying.module.common.http.HttpClient;
import com.guiying.module.common.http.OnResultListener;
import com.guiying.module.girls.Constants;
import com.guiying.module.girls.data.MovieDataSource;
import com.guiying.module.girls.data.bean.MovieParser;



public class RemoteGirlsDataSource implements MovieDataSource {

    @Override
    public void getGirls(int size, int page, final LoadGirlsCallback callback) {
        HttpClient client = new HttpClient.Builder()
                .baseUrl(Constants.GAN_HUO_API)
                .url("福利/" + size + "/" + page)
                .bodyType(DataType.JSON_OBJECT, MovieParser.class)
                .build();
        client.get(new OnResultListener<MovieParser>() {

            @Override
            public void onSuccess(MovieParser result) {
                callback.onGirlsLoaded(result);
            }

            @Override
            public void onError(int code, String message) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onFailure(String message) {
                callback.onDataNotAvailable();
            }
        });
    }

}
