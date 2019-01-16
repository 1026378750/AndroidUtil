package com.zxin.marry.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.UserCommon;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import java.util.ArrayList;
import java.util.List;

/*****
 * 欢迎页
 */
public class MarryGuideActivity extends BaseActivity {
    ViewPager mViewPager;
    Button btnStartExperience;
    RadioGroup pointGroup;

    private List<ImageView> imageViewList;

    /**
     * TODO：初始化ViewPager数据
     */
    @Override
    public void initData() {
        mViewPager = getViewById(R.id.vp_guide);
        pointGroup = getViewById(R.id.rg_guide_point);
        btnStartExperience = getViewById(R.id.btn_guide_start_experience);
        btnStartExperience.setOnClickListener(this);

        int[] imageResIDs = {R.drawable.wel1, R.drawable.wel2,R.drawable.wel3,R.drawable.wel4};
        imageViewList = new ArrayList<>();
        for (int i = 0; i < imageResIDs.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setBackgroundResource(imageResIDs[i]);
            imageViewList.add(iv);
            // 根据图片的个数, 每循环一次向LinearLayout中添加一个点
            View view = new View(this);
            view.setBackgroundResource(R.drawable.point_normal);
            // 设置参数
            LayoutParams params = new LayoutParams(10, 10);
            if (i != 0) {
                params.leftMargin = 10;
            }
            view.setLayoutParams(params);// 添加参数
        }

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViewList.size();
            }
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
            /*
             * 删除元素
             */
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView iv = imageViewList.get(position);
                container.addView(iv);// 1. 向ViewPager中添加一个view对象
                return iv; // 2. 返回当前添加的view对象
            }
        });

        // 设置监听器
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             * 当页面正在滚动时 position 当前选中的是哪个页面 positionOffset 比例 positionOffsetPixels 偏移像素
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            /**
             * 当页面被选中
             */
            @Override
            public void onPageSelected(int position) {
                // 显示体验按钮
                if (position == imageViewList.size() - 1) {
                    btnStartExperience.setVisibility(View.VISIBLE);// 显示
                } else {
                    btnStartExperience.setVisibility(View.GONE);// 隐藏
                }
                ((RadioButton) pointGroup.getChildAt(position)).setChecked(true);
            }

            /**
             * 当页面滚动状态改变
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pointGroup.setEnabled(false);
        pointGroup.removeAllViews();
        for (int i = 0; i < imageResIDs.length; i++){
            RadioButton radioButton = new RadioButton(mContext);
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundResource(R.drawable.point_marrybtn);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(20,20);
            params.setMargins(5,0,5,0);
            radioButton.setLayoutParams(params);
            radioButton.setEnabled(false);
            pointGroup.addView(radioButton,i);
        }
        if (imageResIDs!=null&&imageResIDs.length>0)
            ((RadioButton) pointGroup.getChildAt(0)).setChecked(true);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_marryguide;
    }

    /**
     * 打开新的界面
     */
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_guide_start_experience) {
            SharedPreferencesManager.setIsMarryEnter(false);
            SharedPreferencesManager.setMarryVersionName("3.4.6");
            UserCommon user = SharedPreferencesManager.getMarryUserInfo(UserCommon.class);
            if (user != null) {
                startActivity(new Intent(mContext, MarryMainActivity.class));
                return;
            }
            startActivity(new Intent(mContext, MarryLoginActivity.class));
            onBackPressed();
        }
    }

}
