package support.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import support.fragments.MessageIncomingFragment;
import support.fragments.MessageOutcomingFragment;
import support.fragments.MessageProcessFragment;

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
        switch (position){
            case 0:
                return new MessageIncomingFragment();
            case 1:
                return new MessageProcessFragment();
            case 2:
                return new MessageOutcomingFragment();
        }

        return null;

    }

    @Override
    public int getItemPosition(Object object) {
        return 2;
    }

}
