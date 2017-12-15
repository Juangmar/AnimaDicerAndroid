package com.theredwolfstudio.animadicer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Koldur on 15/12/2017.
 */

public class Tab5Notes extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab5notes, container, false);
        EditText editText = (EditText) rootView.findViewById(R.id.editText2);
        editText.setText("Google is your friend.", TextView.BufferType.EDITABLE);
        return rootView;
    }
}