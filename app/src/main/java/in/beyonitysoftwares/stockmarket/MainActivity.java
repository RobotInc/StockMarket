package in.beyonitysoftwares.stockmarket;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import in.beyonitysoftwares.stockmarket.Fragments.live;
import in.beyonitysoftwares.stockmarket.Fragments.profile;
import in.beyonitysoftwares.stockmarket.Fragments.search;
import in.beyonitysoftwares.stockmarket.Fragments.watchlist;
import in.beyonitysoftwares.stockmarket.customviews.CustomViewPager;
import io.multimoon.colorful.BaseTheme;
import io.multimoon.colorful.CAppCompatActivity;
import io.multimoon.colorful.ColorfulKt;
import io.multimoon.colorful.ThemeColor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

import static io.multimoon.colorful.ColorfulKt.Colorful;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    CustomViewPager vg;
    live fragmentlive;
    profile fragmentprofile;
    search fragmentsearch;
    watchlist fragmentwatchlist;
    private BottomNavigationView.OnNavigationItemSelectedListener bgvselected = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.live:{
                    vg.setCurrentItem(0);
                    return true;
                }
                case R.id.watchlist:{
                    vg.setCurrentItem(1);
                    return true;
                }
                case R.id.search:{
                    vg.setCurrentItem(2);
                    return true;
                }
                case R.id.profile:{
                    vg.setCurrentItem(3);
                    return true;
                }

            }

            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorfulKt.Colorful().apply(this,true, BaseTheme.THEME_MATERIAL);

        setContentView(R.layout.activity_main);

        bottomNavigationView =  (BottomNavigationView) findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(bgvselected);
        vg = (CustomViewPager) findViewById(R.id.vg);
        fragmentlive = new live();
        fragmentprofile = new profile();
        fragmentsearch = new search();
        fragmentwatchlist = new watchlist();
        navPageAdpater navPageAdpater = new navPageAdpater(getSupportFragmentManager());
        navPageAdpater.addFragment(fragmentlive,"");
        navPageAdpater.addFragment(fragmentwatchlist,"");
        navPageAdpater.addFragment(fragmentsearch,"");
        navPageAdpater.addFragment(fragmentprofile,"");

        vg.setAdapter(navPageAdpater);
        vg.setPagingEnabled(false);
    }


    public class navPageAdpater extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public navPageAdpater(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
}