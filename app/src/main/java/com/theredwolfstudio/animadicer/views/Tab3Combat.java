package com.theredwolfstudio.animadicer.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.theredwolfstudio.animadicer.R;


/**
 * Created by Koldur on 15/12/2017.
 */

public class Tab3Combat extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3combat, container, false);
        return rootView;
    }
}