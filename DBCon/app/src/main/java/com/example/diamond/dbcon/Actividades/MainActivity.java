package com.example.diamond.dbcon.Actividades;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.diamond.dbcon.R;

import com.example.diamond.dbcon.Adaptador.AdapterContacto;
import com.example.diamond.dbcon.Dao.DaoContacto;
import com.example.diamond.dbcon.Modelo.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewContactos ;
    List<Contacto> contactos;
    DaoContacto daocontacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();
        daocontacto = new DaoContacto(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        listViewContactos = (ListView) findViewById(R.id.listViewContactos);
        listViewContactos.setLongClickable(true);
        Listar();

        listViewContactos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int pos, long arg3) {
                AlertDialog.Builder menu = new AlertDialog.Builder(MainActivity.this);
                CharSequence[] opciones={"Borrar","Modificar"};
                menu.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int opcion) {
                        switch (opcion){
                            case 0:
                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("Eliminar")
                                        .setMessage("¿Desea eliminar este contacto?")
                                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Contacto contacto = (Contacto) listViewContactos.getItemAtPosition(pos);
                                                daocontacto.Eliminar(contacto.getId());
                                                Listar();
                                            }
                                        })
                                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                            }
                                        })
                                        .setIcon(R.drawable.alert)
                                        .show();


                                break;

                            case 1:


                                break;
                        }

                    }
                });

                menu.create().show();

                return true;
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplication(), Main2Activity.class);
                startActivity(i);

            }
        });

    }

    public void Listar() {
        contactos = daocontacto.getAll();
        AdapterContacto adapterMovimiento = new AdapterContacto(MainActivity.this, contactos);
        listViewContactos.setAdapter(adapterMovimiento);
    }
}
