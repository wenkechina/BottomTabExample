package wenke.makelove.bottomtabexample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import wenke.makelove.bottomtabexample.fragment.Fragment1;
import wenke.makelove.bottomtabexample.fragment.Fragment2;
import wenke.makelove.bottomtabexample.fragment.Fragment3;

public class TabLayoutAsBottomBar extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_as_bottom_bar);
        initFragments();

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundResource(R.color.colorPrimary);
        tabLayout.setTabTextColors(getResources().getColor(R.color.textColor), getResources().getColor(R.color.textColorH));
        tabLayout.getTabAt(0).setIcon(R.drawable.tab_home_selector_homepage);
        tabLayout.getTabAt(1).setIcon(R.drawable.tab_home_selector_account);
        tabLayout.getTabAt(2).setIcon(R.drawable.tab_home_selector_more);
    }
    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
    }
}
