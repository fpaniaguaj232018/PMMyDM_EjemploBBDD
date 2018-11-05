package net.juanxxiii.ejemplobbdd.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.juanxxiii.ejemplobbdd.model.Modulo;

import java.util.ArrayList;

public class DB_Manager {
    Context c;
    public DB_Manager(Context c){
        this.c = c;
    }
    public void insertarModulo(String nombre){
        DataBaseHelper dbh = new DataBaseHelper(
            c,
            DataBaseHelper.NOMBRE_BBDD,
            null,
            DataBaseHelper.VERSION
        );
        SQLiteDatabase sqldb = dbh.getWritableDatabase();

        //CODIGO DE INSERCIÓN
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COLUMNAS[1],nombre);
        cv.put(DataBaseHelper.COLUMNAS[2],"En curso");
        sqldb.insert(DataBaseHelper.NOMBRE_TABLA,null,cv);
        sqldb.close();
    }
    public ArrayList<Modulo> getModulos() {
        ArrayList<Modulo> alm = new ArrayList<>();

        DataBaseHelper dbh = new DataBaseHelper(
                c,
                DataBaseHelper.NOMBRE_BBDD,
                null,
                DataBaseHelper.VERSION
        );
        SQLiteDatabase sqldb = dbh.getReadableDatabase();
        Cursor cursor = sqldb.rawQuery("SELECT * FROM " + DataBaseHelper.NOMBRE_TABLA,
                new String[]{});
        while(cursor.moveToNext()){
            Modulo nuevoModulo = new Modulo(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            alm.add(nuevoModulo);
        }

        sqldb.close();
        return alm;
    }

}
