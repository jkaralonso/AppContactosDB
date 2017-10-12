package com.example.diamond.dbcon.Actividades;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.diamond.dbcon.Dao.DaoContacto;
import com.example.diamond.dbcon.Modelo.Contacto;
import com.example.diamond.dbcon.R;

/**
 * Created by Diamond on 11/10/2017.
 */

public class Main2Activity extends AppCompatActivity {

    EditText txtUsuario;
    EditText txtEmail;
    EditText txtTwitter;
    EditText txtTelefono;
    EditText txtFecha;
    String patronemail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String patronfecha = "^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$";
    String patrontelefono = "^[0-9]{10}$";
    DaoContacto daocontacto;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        daocontacto = new DaoContacto(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtTwitter = (EditText) findViewById(R.id.txtTwitter);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(txtUsuario.getText().toString().equals("")|txtEmail.getText().toString().equals("")
                        |txtTwitter.getText().toString().equals("")|txtTelefono.getText().toString().equals("")|
                        txtFecha.getText().toString().equals("")) {
                    Toast.makeText(getApplication(), "Falta información", Toast.LENGTH_SHORT).show();


                }else if(!txtEmail.getText().toString().matches(patronemail)){
                    Toast.makeText(getApplication(), "Email incorrecto", Toast.LENGTH_SHORT).show();
                }else if(!txtFecha.getText().toString().matches(patronfecha)){

                    Toast.makeText(getApplication(), "Fecha incorrecto", Toast.LENGTH_SHORT).show();

                }else if(!txtTelefono.getText().toString().matches(patrontelefono)){
                    Toast.makeText(getApplication(), "Telefono incorrecto", Toast.LENGTH_SHORT).show();
                }


                else{
                    Contacto contacto = new Contacto(txtUsuario.getText().toString(),
                            txtEmail.getText().toString(), txtTwitter.getText().toString(),
                            txtTelefono.getText().toString(), txtFecha.getText().toString());
                    daocontacto.Insertar(contacto);
                    Intent a = new Intent(getApplication(),MainActivity.class);
                    startActivity(a);

                }


            }
        });


    }


}
