package com.guiying.module.girls.main;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guiying.module.common.base.BaseActionBarActivity;
import com.guiying.module.common.utils.Path;
import com.guiying.module.girls.R;

@Route(path = Path.PAHT_MOVIE)
public class MovieActivity extends BaseActionBarActivity {

    private MovieView mView;
    private MovieContract.Presenter mPresenter;

    @Override
    protected int setTitleId() {
        return R.string.movie_activity_title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new MovieView(this);
        setContentView(mView);
        mPresenter = new MoviePresenter(mView);
        mPresenter.start();
    }


}
