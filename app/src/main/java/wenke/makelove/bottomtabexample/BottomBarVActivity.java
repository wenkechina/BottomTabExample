package wenke.makelove.bottomtabexample;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

import wenke.makelove.bottomtabexample.fragment.Fragment1;
import wenke.makelove.bottomtabexample.fragment.Fragment2;
import wenke.makelove.bottomtabexample.fragment.Fragment3;

public class BottomBarVActivity extends AppCompatActivity {
    private ArrayList<Fragment> fragments;
    private BottomNavigationItem item1;
    private BottomNavigationItem item2;
    private BottomNavigationItem item3;
    private ViewPager bottomBarViewPager;
    private BottomNavigationBar navigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar_v);
        initFragments();
        initBottomNaviationItem();
        bottomBarViewPager = (ViewPager) findViewById(R.id.bottomBarViewPager);
        bottomBarViewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));
        bottomBarViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                navigationBar.selectTab(position);
            }
        });
        navigationBar = (BottomNavigationBar) findViewById(R.id.bottomBarV);
        navigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        navigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        navigationBar
                .addItems(item1, item2, item3)
                .setBarBackgroundColor(android.R.color.white)
                .setFirstSelectedPosition(0)
                .initialise();

        navigationBar.setTabSelectedListener(new BottomNavigationBar.SimpleOnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                bottomBarViewPager.setCurrentItem(position,false);
            }
        });
    }

    private void initBottomNaviationItem() {
        BadgeItem numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColor(Color.RED)
                .setText("5")
                .setHideOnSelect(true);
        item1 = new BottomNavigationItem(R.mipmap.home_white, "Home")
                .setActiveColorResource(R.color.orange)
                .setInActiveColorResource(R.color.colorAccent)
                .setBadgeItem(numberBadgeItem);
        item2 = new BottomNavigationItem(R.mipmap.book_white, "Books")
                .setActiveColorResource(R.color.teal)
                .setInActiveColorResource(R.color.colorAccent);
        item3 = new BottomNavigationItem(R.mipmap.music_white, "Music")
                .setActiveColorResource(R.color.brown)
                .setInActiveColorResource(R.color.colorAccent);
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
    }

}
