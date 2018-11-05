package net.juanxxiii.ejemplobbdd;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.juanxxiii.ejemplobbdd.model.Modulo;
import net.juanxxiii.ejemplobbdd.persistence.DB_Manager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INSERTAR
        DB_Manager dbm = new DB_Manager(this);
        dbm.insertarModulo("Programacion de Servicios y Procesos");
        dbm.insertarModulo("Programacion Multimedia y Dispositivos Moviles");
        //CONSULTAR
        ArrayList<Modulo> alm = dbm.getModulos();
        for (Modulo m: alm) {
            Log.d("EJERCICIO", m.nombre);
        }
    }
}
