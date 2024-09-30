package com.example.tabswithfragmentstateadapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

/**
 * Override getItemCount() instead of getCount()
 * Override createFragment() instead of getItem() in fragment-based adapter classes.
 */

public class ViewPagerAdapter extends FragmentStateAdapter { //Switching to ViewPager2 & FragmentStateAdapter deprecated library: https://stackoverflow.com/questions/51131172/fragmentstatepageradapter-is-deprecated-from-api-27
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabTitles = new ArrayList<>();
    /*public ViewPagerAdapter(FragmentManager fm){ //ViewPager
        super(fm);
    }*/
    public ViewPagerAdapter(FragmentActivity fa){ //ViewPager2.
        super(fa);
    }

    public void addFragments(Fragment fragments, String titles){
        this.fragments.add(fragments);
        this.tabTitles.add(titles);
    }

    public void removeFragments(Fragment fragments, String titles){
        this.fragments.clear();
    }

    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }

    /*@Override
    public Fragment getItem(int position) { //ViewPager
        return fragments.get(position);
    }*/

    @NonNull
    @Override
    public Fragment createFragment(int position) { //ViewPager2
        //return null;
        return fragments.get(position);
    }

    /*@Override
    public int getCount() { //ViewPager
        return fragments.size();
    }*/

    @Override
    public int getItemCount() { //ViewPager2
        //return 0;
        return fragments.size();
    }

    /*
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) { //ViewPager
        return tabTitles.get(position);
    }*/
}
