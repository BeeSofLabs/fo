package core.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import core.fragments.IncomingFragment;

/**
 * Created by ary on 6/19/17.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> titles;

    public TabPagerAdapter(ArrayList<String> titles, FragmentManager fm) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.titles.get(position);
    }

    @Override
    public int getCount() {
        return this.titles.size();
    }

    @Override
    public Fragment getItem(int position) {
        return new IncomingFragment();
    }

    @Override
    public int getItemPosition(Object object) {
        return 2;
    }

}
