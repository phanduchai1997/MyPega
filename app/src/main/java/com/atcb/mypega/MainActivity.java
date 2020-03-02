package com.atcb.mypega;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.atcb.mypega.adapter.PagerAdapterMain;
import com.atcb.mypega.databinding.ActivityMainBinding;
import com.atcb.mypega.fragment.NewFeedFragment;
import com.atcb.mypega.model.News;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PagerAdapterMain mPagerAdapterMain;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPagerAdapterMain = new PagerAdapterMain(getSupportFragmentManager());
        customNavigationButton();
        mainBinding.vpMain.setAdapter(mPagerAdapterMain);
    }

    private void customNavigationButton() {
        mainBinding.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigative_news_feed:
                        mainBinding.vpMain.setCurrentItem(0);
                        NewFeedFragment fragment = (NewFeedFragment) mPagerAdapterMain.getItem(0);
                        fragment.refreshNews();
                        return true;
                    case R.id.navigative_hot_news:
                        mainBinding.vpMain.setCurrentItem(1);
                        return true;
                    case R.id.navigative_discover:
                        mainBinding.vpMain.setCurrentItem(2);
                        return true;
                    case R.id.navigative_notification:
                        mainBinding.vpMain.setCurrentItem(3);
                        return true;
                    case R.id.navigative_personal:
                        mainBinding.vpMain.setCurrentItem(4);
                        return true;
                }
                return false;
            }
        });
        mainBinding.vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mainBinding.navigation.getMenu().getItem(0).setChecked(true);
                        break;
                    case 1:
                        mainBinding.navigation.getMenu().getItem(1).setChecked(true);
                        break;
                    case 2:
                        mainBinding.navigation.getMenu().getItem(2).setChecked(true);
                        break;
                    case 3:
                        mainBinding.navigation.getMenu().getItem(3).setChecked(true);
                        break;
                    case 4:
                        mainBinding.navigation.getMenu().getItem(4).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
