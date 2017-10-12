package com.example.diamond.dbcon.Adaptador;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.diamond.dbcon.R;
import com.example.diamond.dbcon.Modelo.Contacto;
import java.util.List;

/**
 * Created by Diamond on 11/10/2017.
 */

public class AdapterContacto extends BaseAdapter {

    private List<Contacto> list;
    private Activity activity;

    public AdapterContacto(Activity activity, List<Contacto> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.detalles_contacto, null);


        }

        Contacto movimiento = list.get(position);
        TextView tvNombreV = (TextView) v.findViewById(R.id.tvNombre);
        tvNombreV.setText(movimiento.getUsuario().toString());
        TextView tvEmailV = (TextView) v.findViewById(R.id.tvEmail);
        tvEmailV.setText(movimiento.getEmail());

        return v;

    }

}