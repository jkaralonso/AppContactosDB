package com.example.diamond.dbcon.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.diamond.dbcon.Modelo.Contacto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diamond on 11/10/2017.
 */

public class DaoContacto extends SQLiteOpenHelper {



    public static final String  TABLA="contactos";
    public static String DATABASE = "DBContactos";
    public static final String[] COLUMNAS_TABLA = {"_id", "nombre","correo_electronico"
            , "twitter","telefono","fecha_nacimiento"};

    private  final String SCRIPT="create table " + TABLA + "(" +
            COLUMNAS_TABLA[0] + " integer primary key autoincrement, " +
            COLUMNAS_TABLA[1] + " varchar(100) not null, " +
            COLUMNAS_TABLA[2] + " varchar(200) not null, " +
            COLUMNAS_TABLA[3] + " varchar(100) null, " +
            COLUMNAS_TABLA[4] + " varchar(20) null, " +
            COLUMNAS_TABLA[5] + " varchar(20)null " +
            ");";
    private static final int VERSION_DB = 1;


    public DaoContacto(Context contexto){

        super(contexto, DATABASE, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long Insertar(Contacto contacto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMNAS_TABLA[1], contacto.getUsuario());
        values.put(COLUMNAS_TABLA[2], contacto.getEmail());
        values.put(COLUMNAS_TABLA[3], contacto.getTwitter());
        values.put(COLUMNAS_TABLA[4], contacto.getTelefono());
        values.put(COLUMNAS_TABLA[5], contacto.getFecha());
        long insert = db.insert(TABLA, null, values);
        return insert;
    }

    public void Eliminar(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLA,COLUMNAS_TABLA[0] + " = ?",
                new String[]{String.valueOf(id)});
    }


    public List<Contacto> getAll() {
        List<Contacto> ContactoList = new ArrayList<Contacto>();
        String selectQuery = "SELECT  * FROM " + TABLA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Contacto contact = new Contacto();
                contact.setId(cursor.getLong (0));
                contact.setUsuario(cursor.getString (1));
                contact.setEmail(cursor.getString (2));
                contact.setTwitter(cursor.getString (3));
                contact.setTwitter(cursor.getString (4));
                contact.setFecha(cursor.getString (5));
                ContactoList.add(contact);
            } while (cursor.moveToNext());
        }
        return ContactoList;
    }
}