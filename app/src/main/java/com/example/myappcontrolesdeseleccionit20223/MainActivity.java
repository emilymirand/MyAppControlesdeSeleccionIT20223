package com.example.myappcontrolesdeseleccionit20223;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,  AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //datos
        final String[] datos =
                new
                        String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        final String[] listaAmigos =
                new
                        String[]{"ANGIE CORTEZ CHINCHADE","KEVIN LOZA YANEZ","WILSON PEREZ GARCIA","KEYBILLIN CAÑA ZAMORA","KEVIN BELTRAN ESPINOZA"};
        //adaptador
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);
        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, listaAmigos);
        //asignar el adpatador a la vista
       Spinner cmbOpciones =(Spinner)findViewById(R.id.cbLista);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);
        cmbOpciones.setOnItemSelectedListener(this);
        ListView lstOpciones=(ListView) findViewById(R.id.lsLista);
        lstOpciones.setAdapter(adaptador2);
        lstOpciones.setOnItemClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView txtItem = (TextView)findViewById(R.id.txtItem);
        txtItem.setText("Seleccionado: " + adapterView.getItemAtPosition(i));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView txtItem = (TextView)findViewById(R.id.txtItem);
        txtItem.setText("Click ListView: " + adapterView.getItemAtPosition(i));

    }
}