package wenke.makelove.bottomtabexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    String [] titles={"love","make","have"};
        public MyFragmentAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
            super(fm);
            this.fragments=fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {

            return 3;
        }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}