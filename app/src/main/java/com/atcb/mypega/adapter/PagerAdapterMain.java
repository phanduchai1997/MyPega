package com.atcb.mypega.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.atcb.mypega.fragment.DiscoveryFragment;
import com.atcb.mypega.fragment.HotNewsFragment;
import com.atcb.mypega.fragment.NewFeedFragment;
import com.atcb.mypega.fragment.NotificationFragment;
import com.atcb.mypega.fragment.PersonalFragment;

public class PagerAdapterMain extends FragmentPagerAdapter {
    public PagerAdapterMain(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return NewFeedFragment.getInstance();
            case 1:
                return HotNewsFragment.getInstance();
            case 2:
                return DiscoveryFragment.getInstance();
            case 3:
                return NotificationFragment.getInstance();
            case 4:
                return PersonalFragment.getInstance();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 5;
    }
}
