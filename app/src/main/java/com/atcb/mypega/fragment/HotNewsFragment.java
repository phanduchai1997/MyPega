package com.atcb.mypega.fragment;

import androidx.fragment.app.Fragment;

public class HotNewsFragment extends Fragment {
    public static HotNewsFragment INSTANCE;
    public static HotNewsFragment getInstance(){
        if(INSTANCE == null){
            INSTANCE = new HotNewsFragment();
        }
        return INSTANCE;
    }
}
