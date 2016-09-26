package wenke.makelove.bottomtabexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;

import wenke.makelove.bottomtabexample.fragment.Fragment1;
import wenke.makelove.bottomtabexample.fragment.Fragment2;
import wenke.makelove.bottomtabexample.fragment.Fragment3;

public class FragmentTabHostV extends AppCompatActivity {
    private int mImageViewArray[] = {R.drawable.tab_home_selector_homepage, R.drawable.tab_home_selector_account, R.drawable.tab_home_selector_more,
    };
    private Class fragmentArray[] = {Fragment1.class, Fragment2.class, Fragment3.class};
    private String mTextViewArray[] = {"首页", "产品", "更多"};
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab_host_v);
        initFragments();
        initViewPager();
        mTabHost = (FragmentTabHost) findViewById(R.id.fragmentTabHost);
        mTabHost.setup(FragmentTabHostV.this, getSupportFragmentManager(), R.id.viewPager);
        mTabHost.setBackgroundResource(android.R.color.holo_blue_bright);

        for (int i = 0; i < fragments.size(); i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextViewArray[i]).setIndicator(getIndicatorView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec,fragmentArray[i],null);
            //去除中间的分割线
            mTabHost.getTabWidget().setDividerDrawable(null);
            //设置Tab按钮的背景
           /* mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);*/
        }
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int position = mTabHost.getCurrentTab();
                viewPager.setCurrentItem(position, false);
            }
        });
    }

    private View getIndicatorView(int index) {
        View view = View.inflate(getApplicationContext(), R.layout.fragment_tabhost_tab_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        imageView.setImageResource(mImageViewArray[index]);
        textView.setText(mTextViewArray[index]);
        return view;
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TabWidget widget = mTabHost.getTabWidget();
                int oldFocusability = widget.getDescendantFocusability();
                widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
                mTabHost.setCurrentTab(position);
                widget.setDescendantFocusability(oldFocusability);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
