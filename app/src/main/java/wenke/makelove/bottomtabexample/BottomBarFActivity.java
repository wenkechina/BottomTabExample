package wenke.makelove.bottomtabexample;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationBar.SimpleOnTabSelectedListener;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

import wenke.makelove.bottomtabexample.fragment.Fragment1;
import wenke.makelove.bottomtabexample.fragment.Fragment2;
import wenke.makelove.bottomtabexample.fragment.Fragment3;

public class BottomBarFActivity extends AppCompatActivity {
    private ArrayList<Fragment> fragments;
    private BottomNavigationItem item1;
    private BottomNavigationItem item2;
    private BottomNavigationItem item3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_barf);
        initFragments();
        setDefaultFragment();
        initBottomNaviationItem();

        BottomNavigationBar navigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        navigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        navigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        navigationBar
                .addItems(item1,item2,item3)
                .setBarBackgroundColor(android.R.color.black)
                .setFirstSelectedPosition(0)
                .initialise();

        navigationBar.setTabSelectedListener(new SimpleOnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                if (fragments!=null){
                    if (position<fragments.size()){
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.layFrame,fragments.get(position));
                        ft.commit();
                    }
                }
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


    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, new Fragment1());
        transaction.commit();
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
    }
}
