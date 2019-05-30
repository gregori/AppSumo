package com.example.sumo.ui.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sumo.ConnectionTab;
import com.example.sumo.IOsTap;
import com.example.sumo.ParametersTap;
import com.example.sumo.R;
import com.example.sumo.SetCaseTab;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ParametersTap tab1 = new ParametersTap();
                return tab1;
            case 1:
                IOsTap tab2 = new IOsTap();
                return tab2;
            case 2:
                SetCaseTab tab3 = new SetCaseTab();
                return tab3;
            case 3:
                ConnectionTab tab4 = new ConnectionTab();
                return tab4;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}