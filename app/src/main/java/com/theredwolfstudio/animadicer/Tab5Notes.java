package com.theredwolfstudio.animadicer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Koldur on 15/12/2017.
 */

public class Tab5Notes extends Fragment {

    Button borrar;
    Button guardar;
    EditText cuad;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab5notes, container, false);

        SharedPreferences sp = rootView.getContext().getSharedPreferences("notas", Context.MODE_PRIVATE);

        cuad = rootView.findViewById(R.id.editText2);
        cuad.setText(sp.getString("not", ""), TextView.BufferType.EDITABLE);

        borrar = rootView.findViewById(R.id.buttonDeleteNote);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(rootView.getContext())
                        .setTitle("Borrar las notas")
                        .setMessage("¿Estás seguro de que quieres borrar las notas?")
                        .setPositiveButton(
                                "Sí",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        cuad.setText("");
                                    }
                                }
                        )
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        guardar = rootView.findViewById(R.id.buttonSaveNote);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = rootView.getContext().getSharedPreferences("notas", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("not", cuad.getText().toString());
                Toast t = Toast.makeText(rootView.getContext(), "Se ha guardado correctamente: ", Toast.LENGTH_SHORT);
                editor.commit();
                t.show();
            }
        });
        return rootView;
    }
}