package wenke.makelove.bottomtabexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;

import wenke.makelove.bottomtabexample.fragment.Fragment1;
import wenke.makelove.bottomtabexample.fragment.Fragment2;
import wenke.makelove.bottomtabexample.fragment.Fragment3;

public class RadioFrameLayout extends AppCompatActivity {
    private RadioGroup radioGroup;
    private FragmentManager supportFragmentManager;
    private Fragment lastFrag;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_frame_layout);
        supportFragmentManager = getSupportFragmentManager();
        fragment = new Fragment1();
        lastFrag = fragment;
        supportFragmentManager.beginTransaction().add(R.id.frameLayout, fragment, "tag0").commit();
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupBar);
        radioGroup.check(R.id.rb_homepage);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_homepage:
                        changeFragment(0,"tag0");
                        break;
                    case R.id.rb_acount:
                        changeFragment(1,"tag1");
                        break;
                    case R.id.rb_more:
                        changeFragment(2,"tag2");
                        break;
                }
            }
        });
    }
    public void changeFragment(int position,String tag) {
        Fragment mFragment = supportFragmentManager.findFragmentByTag(tag);
        if (null == mFragment) {
            switch (position) {
                case 0:
                    mFragment=new Fragment1();
                    break;
                case 1:
                    mFragment = new Fragment2();
                    break;
                case 2:
                    mFragment = new Fragment3();
                    break;
            }
            supportFragmentManager.beginTransaction().add(R.id.frameLayout, mFragment, tag).hide(lastFrag).commit();
        } else {
            supportFragmentManager.beginTransaction().hide(lastFrag).show(mFragment).commit();
        }
        lastFrag = mFragment;
    }
}
