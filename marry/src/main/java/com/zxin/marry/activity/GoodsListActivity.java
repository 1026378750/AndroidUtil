package com.zxin.marry.activity;

import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.ShopPresenter;
import com.zxin.marry.mvp.view.ShopContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/7/4.
 */

public class GoodsListActivity extends BaseActivity implements ShopContract.GoodsListView {
    private String store_id;

    @InjectPresenter
    ShopPresenter presenter;

    @Override
    public void initData() {
        store_id = getIntent().getStringExtra("store_id");
        presenter.initGoodsListDatas(this,store_id);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        presenter.getStoreGoodsList(store_id);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_set_meal;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_comment_commonlayout);
    }
}
