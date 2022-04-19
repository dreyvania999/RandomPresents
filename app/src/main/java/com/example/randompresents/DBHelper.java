package com.example.randompresents;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DBVersion =1;
    public static final String DBName = "contactDb";
    public static final String Name = "name";
    public static final String KEY_ID = "_id";
    public static final String Phone = "phone";
    public static final String Surname = "surname";
    public static final String Address = "address";
    public static final String People = "people";
    public static final String Birtday = "birthday";
    public static final String Login = "login";
    public static final String Password = "password";

    public static final String Presnts = "presents";
    public static final String PresentName = "namePresentt";
    public static final String Silka = "silka";
    public static final String pol = "pol";
    public static final String coast = "coast";
    public static final String Congratulation = "congratulation";
    public static final String CongratulationM = "congratulationM";
    public static final String CongratulationT = "congratulationT";
    public static final String CongratulationMassage = "congratulationMassage";
    public static final String Toct = "toct";



    public DBHelper(Context context) {
        super(context, DBName, null, DBVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + People + "(" + KEY_ID
                + " integer primary key," + Name + " text," + Phone + " text,"+ Birtday+ " date,"+ pol +"  TEXT CHECK( pol IN ('М','Ж') )   NOT NULL DEFAULT 'М'," + Surname + " text," +
                Address + " text," + Login + " text," + Password + " text" + ")");
        sqLiteDatabase.execSQL("create table " + Presnts + "(" + KEY_ID
                + " integer primary key," + PresentName + " text," + Silka + " text,"+ coast+ " REAL,"+ pol +"  TEXT CHECK( pol IN ('М','Ж','Нет') )   NOT NULL DEFAULT 'Нет'" + ")");
        sqLiteDatabase.execSQL("create table " + CongratulationM + "(" + KEY_ID
                + " integer primary key," + CongratulationMassage + " text" + ")");
        sqLiteDatabase.execSQL("create table " + CongratulationT + "(" + KEY_ID
                + " integer primary key," + Toct + " text" + ")");
        sqLiteDatabase.execSQL( "CREATE VIEW " + Congratulation + " AS SELECT " + " * "  +  " FROM "+ CongratulationT  + " CROSS JOIN "+  CongratulationM + ";");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + People);
        sqLiteDatabase.execSQL("drop table if exists " + Presnts);

        onCreate(sqLiteDatabase);
    }
}
