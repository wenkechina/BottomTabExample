package wenke.makelove.bottomtabexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.radioViewPager).setOnClickListener(this);
        findViewById(R.id.bottomNavigationBarV).setOnClickListener(this);
        findViewById(R.id.bottomNavigationBarF).setOnClickListener(this);
        findViewById(R.id.fragmentTabHostF).setOnClickListener(this);
        findViewById(R.id.radioFrameLayout).setOnClickListener(this);
        findViewById(R.id.fragmentTabHostV).setOnClickListener(this);
        findViewById(R.id.tabLayoutAsIndicator).setOnClickListener(this);
        findViewById(R.id.tabLayoutAsBottomBar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bottomNavigationBarF:
                startActivity(new Intent(MainActivity.this,BottomBarFActivity.class));
                break;
            case R.id.bottomNavigationBarV:
                startActivity(new Intent(MainActivity.this,BottomBarVActivity.class));
                break;
            case R.id.radioViewPager:
                startActivity(new Intent(MainActivity.this,RadioViewPager.class));
                break;
            case R.id.radioFrameLayout:
                startActivity(new Intent(MainActivity.this,RadioFrameLayout.class));
                break;
            case R.id.fragmentTabHostF:
                startActivity(new Intent(MainActivity.this,FragmentTabHostF.class));
                break;
            case R.id.fragmentTabHostV:
                startActivity(new Intent(MainActivity.this,FragmentTabHostV.class));
                break;
            case R.id.tabLayoutAsIndicator:

                startActivity(new Intent(MainActivity.this,TabLayoutAsIndicator.class));
                break;
            case R.id.tabLayoutAsBottomBar:
                startActivity(new Intent(MainActivity.this,TabLayoutAsBottomBar.class));
                break;


        }
        }
    }
