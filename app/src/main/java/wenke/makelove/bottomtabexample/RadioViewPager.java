package wenke.makelove.bottomtabexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.ArrayList;

import wenke.makelove.bottomtabexample.fragment.Fragment1;
import wenke.makelove.bottomtabexample.fragment.Fragment2;
import wenke.makelove.bottomtabexample.fragment.Fragment3;

public class RadioViewPager extends AppCompatActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_view_pager);
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupBar);
        radioGroup.check(R.id.rb_homepage);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_homepage:
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_acount:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_more:
                        viewPager.setCurrentItem(2, false);
                        break;
                }

            }
        });
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.rb_homepage);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_acount);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_more);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

}
