package com.theredwolfstudio.animadicer.views;

/**
 * Created by Koldur on 15/12/2017.
 */
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.theredwolfstudio.animadicer.R;

public class Tab1Main extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1main, container, false);
        // Get the Drawable custom_progressbar
        Drawable life= rootView.getResources().getDrawable(R.drawable.customprogressbar_life);
        Drawable zeon= rootView.getResources().getDrawable(R.drawable.customprogressbar_zeon);
        Drawable ki= rootView.getResources().getDrawable(R.drawable.customprogressbar_ki);
        Drawable tir= rootView.getResources().getDrawable(R.drawable.customprogressbar_tired);
        // set the drawable as progress drawable
        ProgressBar vida = rootView.findViewById(R.id.progressBar5LIFE);
        vida.setProgressDrawable(life);
        ProgressBar elki = rootView.findViewById(R.id.progressBarKi);
        elki.setProgressDrawable(ki);
        ProgressBar zen = rootView.findViewById(R.id.progressBarZeon);
        zen.setProgressDrawable(zeon);
        ProgressBar tired = rootView.findViewById(R.id.progressBarCans);
        tired.setProgressDrawable(tir);
        return rootView;
    }
}

