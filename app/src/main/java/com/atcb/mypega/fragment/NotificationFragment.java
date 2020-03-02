package com.atcb.mypega.fragment;

import androidx.fragment.app.Fragment;

public class NotificationFragment extends Fragment {
    public static NotificationFragment INSTANCE;
    public static NotificationFragment getInstance(){
        if(INSTANCE == null){
            INSTANCE = new NotificationFragment();
        }
        return INSTANCE;
    }
}
