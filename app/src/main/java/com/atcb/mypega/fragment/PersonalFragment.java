package com.atcb.mypega.fragment;

import androidx.fragment.app.Fragment;

public class PersonalFragment extends Fragment {
    public static PersonalFragment INSTANCE;
    public static PersonalFragment getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PersonalFragment();
        }
        return INSTANCE;
    }
}
