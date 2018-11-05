package net.juanxxiii.ejemplobbdd.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String NOMBRE_BBDD = "bbdd_modulos";
    public static final String NOMBRE_TABLA = "t_modulos";
    public static final int VERSION = 1;
    public static String[] COLUMNAS = new String[3];

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        COLUMNAS[0] = "id";
        COLUMNAS[1] = "nombre";
        COLUMNAS[2] = "estado";
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + NOMBRE_TABLA + " (" +
                COLUMNAS[0] + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMNAS[1] + " TEXT, " +
                COLUMNAS[2] + " TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //NADA
    }
}
