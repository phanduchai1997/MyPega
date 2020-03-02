package com.atcb.mypega.fragment;

import androidx.fragment.app.Fragment;

public class DiscoveryFragment extends Fragment {
    public static DiscoveryFragment INSTANCE;
    public static DiscoveryFragment getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DiscoveryFragment();
        }
        return INSTANCE;
    }
}
