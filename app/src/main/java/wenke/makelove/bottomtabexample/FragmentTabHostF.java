package wenke.makelove.bottomtabexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import wenke.makelove.bottomtabexample.fragment.Fragment1;
import wenke.makelove.bottomtabexample.fragment.Fragment2;
import wenke.makelove.bottomtabexample.fragment.Fragment3;

public class FragmentTabHostF extends AppCompatActivity {

    private CustomFragmentTabHost mTabHost;
    //定义数组来存放Fragment界面
    private Class fragmentArray[] = {Fragment1.class, Fragment2.class, Fragment3.class};
    private int mImageViewArray[] = {R.drawable.tab_home_selector_homepage, R.drawable.tab_home_selector_account, R.drawable.tab_home_selector_more,
    };
    private String mTextViewArray[] = {"首页", "产品", "更多"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab_host_f);

        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        mTabHost = (CustomFragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.setBackgroundResource(android.R.color.holo_blue_bright);


        for (int i = 0; i < fragmentArray.length; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextViewArray[i]).setIndicator(getIndicatorView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            //去除中间的分割线
            mTabHost.getTabWidget().setDividerDrawable(null);
            //设置Tab按钮的背景
           /* mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);*/
        }
    }

    private View getIndicatorView(int index) {
        View view = View.inflate(getApplicationContext(), R.layout.fragment_tabhost_tab_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        imageView.setImageResource(mImageViewArray[index]);
        textView.setText(mTextViewArray[index]);
        return view;
    }

}
